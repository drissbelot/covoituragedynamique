package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface SettingsView extends IsWidget {

	public abstract HasClickHandlers getSubmitButton();

	@Override
	public abstract Widget asWidget();

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public TextField<String> getNewPassword();

	public TextField<String> getFirstName();

	public TextField<String> getLastName();

	public TextField<String> getEmailAddress();

	public abstract ComboBox<BaseModelData> getLanguage();

	public TextField<String> getPassword();

	public SettingsViewConstants getConstants();

	public ComboBox<BaseModelData> getVehicleMake();

	public ComboBox<BaseModelData> getVehicleModel();

}
