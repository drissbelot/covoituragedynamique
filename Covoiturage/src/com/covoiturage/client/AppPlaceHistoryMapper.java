package com.covoiturage.client;

import com.covoiturage.client.place.AddUserPlace;
import com.covoiturage.client.place.HistoryPlace;
import com.covoiturage.client.place.LicencePlace;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.place.MessagesListPlace;
import com.covoiturage.client.place.ReplyMessagePlace;
import com.covoiturage.client.place.SettingsPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ LoginPlace.Tokenizer.class, MapPlace.Tokenizer.class,
		AddUserPlace.Tokenizer.class, ValidatePassengersPlace.Tokenizer.class,
		SettingsPlace.Tokenizer.class, HistoryPlace.Tokenizer.class,
		MessagesListPlace.Tokenizer.class, MessageDetailsPlace.Tokenizer.class,
		ReplyMessagePlace.Tokenizer.class,LicencePlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}