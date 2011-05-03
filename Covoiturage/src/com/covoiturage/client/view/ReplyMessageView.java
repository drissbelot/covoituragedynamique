package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;


public interface ReplyMessageView extends IsWidget {
	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public Label getSubjectLabel();

	public Label getFromLabel();

	public Label getDateLabel();

	public HtmlEditor getMessageText();

	public Button getAnswerButton();
}
