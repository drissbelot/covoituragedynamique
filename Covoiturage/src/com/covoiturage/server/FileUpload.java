package com.covoiturage.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.covoiturage.server.domain.UserInfoDetails;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class FileUpload extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload();

		try {
			FileItemIterator iter = upload.getItemIterator(request);

			while (iter.hasNext()) {
				FileItemStream item = iter.next();

				InputStream stream = item.openStream();

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int len;
				byte[] buffer = new byte[8192];
				while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
					out.write(buffer, 0, len);
				}
				Logger.getLogger("").warning(String.valueOf(out.size()));
				int maxFileSize = 10 * 1024 * 1024;
				if (out.size() > maxFileSize) {

					return;
				} else {
					Objectify ofy = ObjectifyService.begin();
					UserInfoDetails userDetails = ofy
							.query(UserInfoDetails.class)
							.filter("user",
									Long.valueOf(request.getParameter("id")))
							.get();
					userDetails.setPersonalPictureType(item.getContentType());
					userDetails.setPersonalPicture(out.toByteArray());
					ofy.put(userDetails);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
