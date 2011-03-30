package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class FooterViewImpl extends Composite implements FooterView{
	
	private HorizontalPanel panel;
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	public FooterViewImpl(){
	
	panel = new HorizontalPanel();
	Anchor en=new Anchor("English",GWT.getHostPageBaseURL()+"?locale=en");
	Anchor fr=new Anchor("Français",GWT.getHostPageBaseURL()+"?locale=fr");
	Anchor it=new Anchor("It",GWT.getHostPageBaseURL()+"?locale=it");
	Anchor nl=new Anchor("Neederlands",GWT.getHostPageBaseURL()+"?locale=nl");
	Anchor ch=new Anchor("ch",GWT.getHostPageBaseURL()+"?locale=ch");
	panel.add(en);panel.add(fr);panel.add(nl);panel.add(it);panel.add(ch);


	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	
	
}
