package com.covoiturage.server;

import com.covoiturage.server.domain.UserInfoDetails;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class ChannelServer {

	public static String createChannel(String uniqueId) {
		String channelId = getChannelService().createChannel(
				"Covoiturage" + uniqueId);
		return channelId;
	}

	private static ChannelService getChannelService() {
		return ChannelServiceFactory.getChannelService();
	}

	public static void sendMessage(UserInfoDetails user, String text) {
		try {
			getChannelService().sendMessage(
					new ChannelMessage("Covoiturage" + user.getId(), text));
		} catch (Exception e) {

		}

	}

}
