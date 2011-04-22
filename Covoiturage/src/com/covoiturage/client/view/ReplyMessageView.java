package com.covoiturage.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

public interface ReplyMessageView extends IsWidget {
	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public Label getSubjectLabel();

	public Label getFromLabel();

	public Label getDateLabel();

	public TextArea getMessageText();

	public Button getAnswerButton();
}
