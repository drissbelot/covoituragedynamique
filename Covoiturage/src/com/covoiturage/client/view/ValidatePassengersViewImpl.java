package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ValidatePassengersViewImpl extends Composite implements ValidatePassengersActivity.Display, ValidatePassengersView {

  
  public ValidatePassengersViewImpl() {
   
    FlowPanel flowPanel = new FlowPanel();

  }
  
  /* (non-Javadoc)
 * @see com.covoiturage.client.view.ValidatePassengers#asWidget()
 */
@Override
public Widget asWidget() {
    return this;
  }

}