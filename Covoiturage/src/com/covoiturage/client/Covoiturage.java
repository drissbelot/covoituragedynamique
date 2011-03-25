package com.covoiturage.client;

import com.covoiturage.client.place.LoginPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Covoiturage implements EntryPoint {
	private final Place defaultPlace = new LoginPlace("Covoiturage");
	private final DockLayoutPanel layoutPanel = new DockLayoutPanel(Unit.PCT);

	private final ScrollPanel mainPanel = new ScrollPanel();
	private final ScrollPanel vertMasterPanel = new ScrollPanel();
	private final ScrollPanel horizMasterPanel = new ScrollPanel();
	private final ScrollPanel asidePanel = new ScrollPanel();

	AcceptsOneWidget horizMasterDisplay = new AcceptsOneWidget() {
		@Override
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			horizMasterPanel.setVisible(widget != null);
			SimplePanel temp = new SimplePanel();
			if (mainPanel != null) {
				temp = mainPanel;
				layoutPanel.remove(mainPanel);
			}
			layoutPanel.addNorth(horizMasterPanel, 10);
			layoutPanel.add(temp);
			horizMasterPanel.setWidget(widget);
		}
	};
	AcceptsOneWidget asideDisplay = new AcceptsOneWidget() {
		@Override
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			asidePanel.setVisible(widget != null);
			SimplePanel temp = new SimplePanel();

			if (mainPanel != null) {
				temp = mainPanel;
				layoutPanel.remove(mainPanel);
			}
			layoutPanel.addEast(asidePanel, 30);
			layoutPanel.add(temp);
			asidePanel.setWidget(widget);
		}
	};
	AcceptsOneWidget vertMasterDisplay = new AcceptsOneWidget() {
		@Override
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			vertMasterPanel.setVisible(widget != null);
			layoutPanel.addWest(vertMasterPanel, 20);
			vertMasterPanel.setWidget(widget);
		}
	};

	AcceptsOneWidget mainDisplay = new AcceptsOneWidget() {
		@Override
		public void setWidget(IsWidget activityWidget) {
			Widget widget = Widget.asWidgetOrNull(activityWidget);
			mainPanel.setVisible(widget != null);
			if (mainPanel != null)
				layoutPanel.remove(mainPanel);
			layoutPanel.add(mainPanel);
			mainPanel.setWidget(widget);

		}
	};

	@Override
	public void onModuleLoad() {
		layoutPanel.setSize("100%", "100%");
		ClientFactory clientFactory = new ClientFactoryImpl();
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		ActivityMapper vertMasterActivityMapper = new VertMasterAppActivityMapper(
				clientFactory);
		ActivityMapper horizMasterActivityMapper = new HorizMasterAppActivityMapper(
				clientFactory);
		ActivityMapper mainActivityMapper = new MainAppActivityMapper(
				clientFactory);
		ActivityMapper asideActivityMapper = new AsideAppActivityMapper(
				clientFactory);

		ActivityManager vertMasterActivityManager = new ActivityManager(
				vertMasterActivityMapper, eventBus);
		ActivityManager horizMasterActivityManager = new ActivityManager(
				horizMasterActivityMapper, eventBus);
		ActivityManager mainActivityManager = new ActivityManager(
				mainActivityMapper, eventBus);
		ActivityManager asideActivityManager = new ActivityManager(
				asideActivityMapper, eventBus);

		vertMasterActivityManager.setDisplay(vertMasterDisplay);
		horizMasterActivityManager.setDisplay(horizMasterDisplay);
		asideActivityManager.setDisplay(asideDisplay);
		mainActivityManager.setDisplay(mainDisplay);

		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(layoutPanel);

		historyHandler.handleCurrentHistory();

	}
}
