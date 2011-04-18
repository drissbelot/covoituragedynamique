package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class HistoryViewImpl extends Composite implements HistoryView {

	interface MyUiBinder extends UiBinder<FlowPanel, HistoryViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	@SuppressWarnings("unused")
	private Presenter presenter;

	@UiField
	Grid<BaseModelData> listGrid;

	public HistoryViewImpl() {
		initWidget(binder.createAndBindUi(this));
		listGrid.getView().setAutoFill(true);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public Grid<BaseModelData> getListGrid() {
		return listGrid;
	}
}
