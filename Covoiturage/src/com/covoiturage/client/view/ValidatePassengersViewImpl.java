package com.covoiturage.client.view;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.extjs.gxt.ui.client.widget.grid.WidgetRowRenderer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ValidatePassengersViewImpl extends Composite implements
		ValidatePassengersView {

	@SuppressWarnings("unused")
	private Presenter presenter;

	private final Grid<BaseModelData> listGrid;

	private ColumnModel cm;
	private ListStore<BaseModelData> store;

	private WidgetExpander<BaseModelData> expander;
	private ValidatePassengersExpander expanderWidget;

	public ValidatePassengersViewImpl() {

		VerticalPanel pan = new VerticalPanel();
		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(check.getColumn());

		expander = new WidgetExpander<BaseModelData>(
				new WidgetRowRenderer<BaseModelData>() {

					@Override
					public Widget render(BaseModelData model, int rowIdx) {
						expanderWidget = new ValidatePassengersExpander(model);
						return expanderWidget;
					}

				});
		configs.add(expander);
		ColumnConfig coordsOrigin = new ColumnConfig();
		coordsOrigin.setId("origin");
		coordsOrigin.setHeader("Origin");
		configs.add(coordsOrigin);
		ColumnConfig coordsDestination = new ColumnConfig();
		coordsDestination.setId("destination");
		coordsDestination.setHeader("Destination");
		configs.add(coordsDestination);

		cm = new ColumnModel(configs);

		store = new ListStore<BaseModelData>();
		listGrid = new Grid<BaseModelData>(store, cm);
		listGrid.addPlugin(expander);
		listGrid.setWidth("300px");
		listGrid.setHeight("300px");
		listGrid.setSelectionModel(check);
		listGrid.getView().setAutoFill(true);

		pan.add(listGrid);

		initWidget(pan);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setPresenter(
			ValidatePassengersActivity validatePassengersActivity) {
		this.presenter = validatePassengersActivity;

	}

	@Override
	public Grid<BaseModelData> getListGrid() {

		return listGrid;
	}

	@Override
	public WidgetExpander<BaseModelData> getExpander() {
		return expander;
	}

	@Override
	public ValidatePassengersExpander getExpanderWidget() {
		return expanderWidget;
	}

}