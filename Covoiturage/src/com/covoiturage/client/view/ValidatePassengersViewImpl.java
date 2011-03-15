package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;

public class ValidatePassengersViewImpl extends Composite implements  ValidatePassengersView {

	 CellTable<UserInfoProxy> passengersCellTable = new CellTable<UserInfoProxy>();
	private Presenter presenter;
  public ValidatePassengersViewImpl() {
   initWidget(passengersCellTable);
   
    TextColumn<UserInfoProxy> nameColumn = new TextColumn<UserInfoProxy>() {
        @Override
        public String getValue(UserInfoProxy user) {
          return user.getLogin();
        }
      };
      
      TextColumn<UserInfoProxy> passwordColumn = new TextColumn<UserInfoProxy>() {
          @Override
          public String getValue(UserInfoProxy user) {
            return user.getPassword();
     
          }
        };
        
        passengersCellTable.addColumn(nameColumn,"Login");
        passengersCellTable.addColumn(passwordColumn,"Pass");
    

  }
  

public Widget asWidget() {
    return this;
  }


@Override
public HasData<UserInfoProxy> getTable() {
	
	return passengersCellTable;
}


@Override
public void setPresenter(ValidatePassengersActivity validatePassengersActivity) {
	this.presenter = validatePassengersActivity;
	
}

}