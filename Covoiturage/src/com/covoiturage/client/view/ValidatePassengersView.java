package com.covoiturage.client.view;

import com.covoiturage.client.presenter.ValidatePassengersPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ValidatePassengersView extends Composite implements ValidatePassengersPresenter.Display {

  
  public ValidatePassengersView() {
   
    FlowPanel flowPanel = new FlowPanel();

  }
  
  public Widget asWidget() {
    return this;
  }

}