package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class LoginViewImpl extends Composite implements LoginView {
	
	interface MyUiBinder extends UiBinder<FlowPanel, LoginViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	@UiField TextBox nameField ;
	@UiField PasswordTextBox passField ;
	@UiField Button addUserButton,sendButton;
	@UiField Image image,image2;
	@UiField Label name,pass,log,titre;
	@UiField Anchor anchorfr,anchornl,anchoren,anchorit,anchorch;
    @SuppressWarnings("unused")
	private Presenter presenter;
    private Image imagefr,imagenl,imageen,imageit,imagech;
    
    private LoginViewConstants constants=(LoginViewConstants)GWT.create(LoginViewConstants.class);
	
	public LoginViewImpl(){
		
		initWidget(binder.createAndBindUi(this)); 
		titre.setText(constants.titre());
		log.setText(constants.login());
		name.setText(constants.username());
		pass.setText(constants.password());
		addUserButton.setText(constants.newuser());
		sendButton.setText(constants.submit());
		
		imagefr=new Image();
		imagenl=new Image();
		imageen=new Image();
		imageit=new Image();
		imagech=new Image();
		image.setUrl("http://www.cijoint.fr/cj201103/cijYu4R0h9.png");
		image2.setUrl("http://www.cijoint.fr/cj201103/cijYu4R0h9.png");
		imagefr.setUrl("http://www.pubfoot.com/blog/wp-content/uploads/2009/09/france-drapeau.jpg");
		imagefr.setSize("30px","25px");
		imagenl.setUrl("http://www.studentsoftheworld.info/infopays/flagsmax/NED_lgflag.gif");
		imagenl.setSize("30px","25px");
		imageen.setUrl("http://www.c3r.fr/images/drapeau_en.jpg");
		imageen.setSize("30px","25px");
		imageit.setUrl("http://www.dinosoria.com/pays/drapeaux/italie.jpg");
		imageit.setSize("30px","25px");
		imagech.setUrl("http://paysetleurvilledumonde.p.a.pic.centerblog.net/njhnr4lz.png");
		imagech.setSize("30px","25px");
		
		anchorfr.setHref(GWT.getHostPageBaseURL()+"?locale=fr");
		anchorfr.getElement().appendChild(imagefr.getElement());
		anchornl.setHref(GWT.getHostPageBaseURL()+"?locale=nl");
		anchornl.getElement().appendChild(imagenl.getElement());
		anchoren.setHref(GWT.getHostPageBaseURL()+"?locale=en");
		anchoren.getElement().appendChild(imageen.getElement());
		anchorit.setHref(GWT.getHostPageBaseURL()+"?locale=it");
		anchorit.getElement().appendChild(imageit.getElement());
		anchorch.setHref(GWT.getHostPageBaseURL()+"?locale=ch");
		anchorch.getElement().appendChild(imagech.getElement());
	}

	public HasClickHandlers getSendLoginButton() {
		return sendButton;
	}

	public HasClickHandlers getAddUserButton(){
		return addUserButton;
	}

	public  String getPassword() {
		return passField.getText();
	}
	public String getLogin() {
		return nameField.getText();
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	@UiHandler("addUserButton")
	void onAddUserButtonClick(ClickEvent event) {
	}
}