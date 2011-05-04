package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.extjs.gxt.ui.client.widget.grid.WidgetRowRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ValidatePassengersViewImpl extends Composite implements
		ValidatePassengersView {

	interface MyUiBinder extends
			UiBinder<ContentPanel, ValidatePassengersViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@SuppressWarnings("unused")
	private Presenter presenter;
	@UiField
	Grid<BaseModelData> listGrid;

	WidgetExpander<BaseModelData> expander;

	ValidatePassengersExpander expanderWidget;

	public ValidatePassengersViewImpl() {

		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);
		expander = new WidgetExpander<BaseModelData>(
				new WidgetRowRenderer<BaseModelData>() {

					@Override
					public Widget render(BaseModelData model, int rowIdx) {

						expanderWidget = new ValidatePassengersExpander(model);
						return expanderWidget;
					}

				});
		initWidget(binder.createAndBindUi(this));

		listGrid.addPlugin(expander);
		listGrid.getColumnModel().getColumns().add(0, check.getColumn());
		listGrid.getColumnModel().getColumns().add(1, expander);
		listGrid.setSelectionModel(check);
		listGrid.getView().setAutoFill(true);

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