/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class MessagesListViewImpl.
 */
public class MessagesListViewImpl extends Composite implements MessagesListView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<VerticalPanel, MessagesListViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	/** The list grid. */
	@UiField
	Grid<BaseModelData> listGrid;
	
	/** The delete button. */
	@UiField
	Button deleteButton;
	
	/** The accept button. */
	private final ColumnConfig acceptButton;

	/**
	 * Instantiates a new messages list view impl.
	 */
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

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessagesListView#setPresenter(com.covoiturage.client.view.MessagesListView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessagesListView#getListGrid()
	 */
	@Override
	public Grid<BaseModelData> getListGrid() {
		return listGrid;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessagesListView#getDeleteButton()
	 */
	@Override
	public Button getDeleteButton() {
		return deleteButton;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessagesListView#getAcceptButton()
	 */
	@Override
	public ColumnConfig getAcceptButton() {
		return acceptButton;
	}
}
