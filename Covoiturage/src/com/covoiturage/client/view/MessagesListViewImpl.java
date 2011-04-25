package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessagesListViewImpl extends Composite implements MessagesListView {

	interface MyUiBinder extends UiBinder<VerticalPanel, MessagesListViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@SuppressWarnings("unused")
	private Presenter presenter;
	@UiField
	Grid<BaseModelData> listGrid;
	@UiField
	Button deleteButton;
	private final ColumnConfig acceptButton;

	public MessagesListViewImpl() {

		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);
		ColumnConfig checkColumn = check.getColumn();

		acceptButton = new ColumnConfig();
		initWidget(binder.createAndBindUi(this));
		listGrid.getColumnModel().getColumns().add(checkColumn);
		listGrid.getColumnModel().getColumns().add(acceptButton);
		listGrid.setSelectionModel(check);
		listGrid.getView().setAutoFill(true);

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Grid<BaseModelData> getListGrid() {
		return listGrid;
	}

	@Override
	public Button getDeleteButton() {
		return deleteButton;
	}

	@Override
	public ColumnConfig getAcceptButton() {
		return acceptButton;
	}
}
