/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class HistoryViewImpl.
 */
public class HistoryViewImpl extends Composite implements HistoryView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<FlowPanel, HistoryViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/** The list grid. */
	@UiField
	Grid<BaseModelData> listGrid;

	/**
	 * Instantiates a new history view impl.
	 */
	public HistoryViewImpl() {
		initWidget(binder.createAndBindUi(this));
		listGrid.getView().setAutoFill(true);
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HistoryView#setPresenter(com.covoiturage.client.view.HistoryView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HistoryView#getListGrid()
	 */
	public Grid<BaseModelData> getListGrid() {
		return listGrid;
	}
}
