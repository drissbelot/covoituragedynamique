/*
 * 
 */
package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Class LicenceViewImpl.
 */
public class LicenceViewImpl extends Composite implements LicenceView{
	
	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<FlowPanel, LicenceViewImpl> {}
	
	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	/** The Radio denied. */
	@UiField
	RadioButton RadioAccpeted,RadioDenied;
	
	/** The next button. */
	@UiField
	Button nextButton;
	
	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	/**
	 * Instantiates a new licence view impl.
	 */
	public LicenceViewImpl() {
		
		initWidget(binder.createAndBindUi(this));
	}
	
	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LicenceView#getRadioAccepted()
	 */
	public RadioButton getRadioAccepted(){
		return RadioAccpeted;
	}
	
	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LicenceView#getRadioDenied()
	 */
	public RadioButton getRadioDenied(){
		return RadioDenied;
	}
	

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LicenceView#setPresenter(com.covoiturage.client.view.LicenceView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#asWidget()
	 */
	public Widget asWidget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LicenceView#getNext()
	 */
	@Override
	public HasClickHandlers getNext() {
		return nextButton;
	}
}
