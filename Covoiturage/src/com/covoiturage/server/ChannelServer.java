/*
 * 
 */
package com.covoiturage.server;

import com.covoiturage.server.domain.UserInfoDetails;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ChannelServer.
 */
public class ChannelServer {

	/**
	 * Creates the channel.
	 *
	 * @param uniqueId the unique id
	 * @return the string
	 */
	public static String createChannel(String uniqueId) {
		String channelId = getChannelService().createChannel(
				"Covoiturage" + uniqueId);
		return channelId;
	}

	/**
	 * Gets the channel service.
	 *
	 * @return the channel service
	 */
	private static ChannelService getChannelService() {
		return ChannelServiceFactory.getChannelService();
	}

	/**
	 * Send message.
	 *
	 * @param user the user
	 * @param text the text
	 */
	public static void sendMessage(UserInfoDetails user, String text) {
		try {
			getChannelService().sendMessage(
					new ChannelMessage("Covoiturage" + user.getId(), text));
		} catch (Exception e) {

		}

	}

}
