package com.covoiturage.client.view;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.extjs.gxt.ui.client.widget.grid.WidgetRowRenderer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class ValidatePassengersViewImpl extends Composite implements  ValidatePassengersView {



	@SuppressWarnings("unused")
	private Presenter presenter;

	private final Grid<BaseModelData> listGrid; 
	private Button saveButton;

	private Label distanceLabel;

	private Label durationLabel;

	private ColumnModel cm; 
	private  ListStore<BaseModelData>  store;
	private  ContentPanel panel;

	public ValidatePassengersViewImpl() {

		VerticalPanel pan = new VerticalPanel();
		CheckBoxSelectionModel<BaseModelData> check = new CheckBoxSelectionModel<BaseModelData>();
		check.setSelectionMode(SelectionMode.MULTI);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		configs.add(check.getColumn());
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
		listGrid = new Grid<BaseModelData>(store,cm);
		listGrid.setWidth("30%");  
		listGrid.setHeight("30%");  
		listGrid.setSelectionModel(check);


		WidgetExpander<BaseModel> expander=new WidgetExpander<BaseModel>(new WidgetRowRenderer<BaseModel>() {

			@Override
			public Widget render(BaseModel model, int rowIdx) {
				panel = new ContentPanel();
				Label firstName = new Label();
				panel.add(firstName);

				Label lastName = new Label();
				panel.add(lastName);

				return panel;
			}

		});
		listGrid.addPlugin(expander);  
		

		saveButton = new Button("Save");
		distanceLabel=new Label();
		durationLabel=new Label();
		pan.add(listGrid);
		pan.add(distanceLabel);
		pan.add(durationLabel);
		pan.add(saveButton);

		initWidget(pan);
	}


	public Widget asWidget() {
		return this;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	@Override
	public void setPresenter(ValidatePassengersActivity validatePassengersActivity) {
		this.presenter = validatePassengersActivity;

	}


	@Override
	public Grid<BaseModelData> getListGrid() {

		return listGrid;
	}


	@Override
	public Label getDistanceLabel() {

		return distanceLabel;
	}


	@Override
	public Label getDurationLabel() {

		return durationLabel;
	}

}