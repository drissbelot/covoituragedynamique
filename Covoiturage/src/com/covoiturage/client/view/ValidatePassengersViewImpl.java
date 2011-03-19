package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.shared.SimpleTravelProxy;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class ValidatePassengersViewImpl extends Composite implements  ValidatePassengersView {

	CellTable<SimpleTravelProxy> passengersCellTable = new CellTable<SimpleTravelProxy>();
	public CellTable<SimpleTravelProxy> getPassengersCellTable() {
		return passengersCellTable;
	}


	@SuppressWarnings("unused")
	private Presenter presenter;
	private   Column<SimpleTravelProxy, Boolean> checkColumn;
	private final MultiSelectionModel<SimpleTravelProxy> selectionModel;

	public MultiSelectionModel<SimpleTravelProxy> getSelectionModel() {
		return selectionModel;
	}


	public ValidatePassengersViewImpl() {
		initWidget(passengersCellTable);

		TextColumn<SimpleTravelProxy> nameColumn = new TextColumn<SimpleTravelProxy>() {
			@Override
			public String getValue(SimpleTravelProxy travel) {
				return travel.getPassenger();
			}
		};

	  TextColumn<SimpleTravelProxy> coordColumn= new TextColumn<SimpleTravelProxy>() {
			@Override
			public String getValue(SimpleTravelProxy travel) {
				return travel.getSteps().get(0);
			}
		};
		
		
		selectionModel = new MultiSelectionModel<SimpleTravelProxy>();
		passengersCellTable.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SimpleTravelProxy> createCheckboxManager());
		initTableColumns(selectionModel);
		passengersCellTable.addColumn(nameColumn,"Login");
		
		passengersCellTable.addColumn(coordColumn,"Coordinates");


	}


	private void initTableColumns(final SelectionModel<SimpleTravelProxy> selectionModel) {

		checkColumn = new Column<SimpleTravelProxy, Boolean>(
				new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(SimpleTravelProxy object) {

				return selectionModel.isSelected(object);
			}
		};
		passengersCellTable.addColumn(checkColumn);

	}


	public Widget asWidget() {
		return this;
	}


	@Override
	public HasData<SimpleTravelProxy> getTable() {

		return passengersCellTable;
	}


	@Override
	public void setPresenter(ValidatePassengersActivity validatePassengersActivity) {
		this.presenter = validatePassengersActivity;

	}

}