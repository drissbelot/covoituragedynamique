package com.covoiturage.client.view;

import java.util.ArrayList;
import java.util.List;



import com.covoiturage.client.i18n.MessagesListViewConstants;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
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
	private ColumnModel cm; 
	private ListStore<BaseModelData>  store;
	@UiField Grid<BaseModelData> listGrid; 
	//TODO finir le UIBinder
	
	public MessagesListViewImpl() {
		//TODO i18n
		//TODO boutons pour gérer la suppression et tout ça
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		
		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);
		
		ColumnConfig fromColumn= new ColumnConfig();
		fromColumn.setId("from");
		fromColumn.setHeader("From");
		
		ColumnConfig subjectColumn = new ColumnConfig();
		subjectColumn.setId("subject");
		subjectColumn.setHeader("Subject");
		
		ColumnConfig dateColumn = new ColumnConfig();
		dateColumn.setId("date");
		dateColumn.setHeader("Date");
		
		configs.add(check.getColumn());
		configs.add(fromColumn);
		configs.add(subjectColumn);
		configs.add(dateColumn);
		cm = new ColumnModel(configs);  

		store = new ListStore<BaseModelData>(); 
		listGrid = new Grid<BaseModelData>(store,cm);
		listGrid.setWidth("300px");  
		listGrid.setHeight("300px");  
		listGrid.setSelectionModel(check);
		listGrid.getView().setAutoFill(true);
		
		
		
		
		
		
		
		initWidget(binder.createAndBindUi(this)); 
		

		
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	public Grid<BaseModelData> getListGrid() {

		return listGrid;
	}


}
