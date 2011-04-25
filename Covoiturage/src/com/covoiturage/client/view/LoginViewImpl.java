package com.covoiturage.client.view;

import com.covoiturage.client.gwtanimation.AnimationVoiture;
import com.covoiturage.client.gwtanimation.Resources;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class LoginViewImpl extends Composite implements LoginView {

	interface MyUiBinder extends UiBinder<AbsolutePanel, LoginViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	TextField<String> loginField, passwordField;
	@UiField
	Label title;
	@UiField
	Button addUserButton, sendButton;
	@UiField
	Image image, image2;
	@UiField
	AbsolutePanel flowpanel;
	@UiField
	FormPanel header;

	@SuppressWarnings("unused")
	private Presenter presenter;

	public LoginViewImpl() {

		initWidget(binder.createAndBindUi(this));
		passwordField.setPassword(true);
		// TODO ça non plus ça marchera pas mais ça va disparaitre donc ce n'est
		// rien
		image.setUrl("LocalPictures/car.png");
		image2.setUrl("LocalPictures/car.png");

		// TODO l'idée est bonne mais la voiture qui bouge m'énerve quand je
		// fais des tests... on doit pouvoir faire plus subtil (genre une
		// voiture qui change de couleur)
		final Image img = new Image(Resources.INSTANCE.gwtLogo());
		flowpanel.add(img, 000, 000);
		AnimationVoiture animation = new AnimationVoiture(img.getElement(),
				40000);
		animation.scrollTo();

	}

	@Override
	public HasClickHandlers getSendLoginButton() {
		return sendButton;
	}

	@Override
	public HasClickHandlers getAddUserButton() {
		return addUserButton;
	}

	@Override
	public TextField<String> getPassword() {
		return passwordField;
	}

	@Override
	public TextField<String> getLogin() {
		return loginField;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("addUserButton")
	void onAddUserButtonClick(ClickEvent event) {
	}
}