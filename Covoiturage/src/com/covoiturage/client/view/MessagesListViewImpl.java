package com.covoiturage.client.view;





import com.covoiturage.client.i18n.MessagesListViewConstants;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;

import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessagesListViewImpl extends Composite implements MessagesListView {

	interface MyUiBinder extends UiBinder<VerticalPanel, MessagesListViewImpl> { }
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private MessagesListViewConstants constants=(MessagesListViewConstants)GWT.create(MessagesListViewConstants.class);


	@SuppressWarnings("unused")
	private Presenter presenter;

	@UiField Grid<BaseModelData> listGrid; 
	@UiField Button deleteButton;
	private ColumnConfig acceptButton;

	public MessagesListViewImpl() {
		//TODO i18n
		//TODO boutons pour gérer la suppression et tout ça


		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);
		ColumnConfig checkColumn=check.getColumn();

		acceptButton = new ColumnConfig();

		

	


		initWidget(binder.createAndBindUi(this)); 
		listGrid.getColumnModel().getColumns().add(checkColumn);
		listGrid.getColumnModel().getColumns().add(acceptButton);
		listGrid.setSelectionModel(check);
		listGrid.getView().setAutoFill(true);
		deleteButton.setText("Delete");



	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	public Grid<BaseModelData> getListGrid() {

		return listGrid;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public ColumnConfig getAcceptButton() {
		return acceptButton;
	}
}
