/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatePassengersViewImpl.
 */
public class ValidatePassengersViewImpl extends Composite implements
		ValidatePassengersView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends
			UiBinder<ContentPanel, ValidatePassengersViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	/** The list grid. */
	@UiField
	Grid<BaseModelData> listGrid;

	/** The expander. */
	WidgetExpander<BaseModelData> expander;

	/**
	 * Instantiates a new validate passengers view impl.
	 */
	public ValidatePassengersViewImpl() {

		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);

		expander = new WidgetExpander<BaseModelData>();

		initWidget(binder.createAndBindUi(this));

		listGrid.addPlugin(expander);
		listGrid.getColumnModel().getColumns().add(0, check.getColumn());
		listGrid.getColumnModel().getColumns().add(1, expander);
		listGrid.setSelectionModel(check);
		listGrid.getView().setAutoFill(true);

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ValidatePassengersView#setPresenter(com.covoiturage.client.activity.ValidatePassengersActivity)
	 */
	@Override
	public void setPresenter(
			ValidatePassengersActivity validatePassengersActivity) {
		this.presenter = validatePassengersActivity;

	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ValidatePassengersView#getListGrid()
	 */
	@Override
	public Grid<BaseModelData> getListGrid() {

		return listGrid;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ValidatePassengersView#getExpander()
	 */
	@Override
	public WidgetExpander<BaseModelData> getExpander() {
		return expander;
	}

}