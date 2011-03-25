package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class ValidatePassengersViewImpl extends Composite implements  ValidatePassengersView {



	@SuppressWarnings("unused")
	private Presenter presenter;

	private final ListGrid listGrid; 
	private Button saveButton;

	private Label distanceLabel;

	private Label durationLabel;



	public ValidatePassengersViewImpl() {

		VerticalPanel pan = new VerticalPanel();
		listGrid = new ListGrid(){  
			@Override  
			public Canvas getExpansionComponent(final ListGridRecord record) {  


				HLayout layout = new HLayout(2);  
				Label firstName = new Label();
				layout.addMember(firstName);
				firstName.setContents(record.getAttribute("firstName"));
				Label lastName = new Label();
				layout.addMember(lastName);
				lastName.setContents(record.getAttribute("lastName"));

				return layout;  
			}  
		};  

		listGrid.setWidth("30%");  
		listGrid.setHeight("30%");  
		listGrid.setDrawAheadRatio(4);  
		listGrid.setCanExpandRecords(true);  
		listGrid.setSelectionType(SelectionStyle.SIMPLE);
		listGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);


		ListGridField coordsOrigin = new ListGridField("origin");  
		ListGridField coordsDestination = new ListGridField("destination");
		listGrid.setFields(coordsOrigin,coordsDestination);  

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
	public ListGrid getListGrid() {

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