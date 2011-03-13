package com.covoiturage.client.activity;


import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.NewUserEvent;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoginActivity extends AbstractActivity implements LoginView.Presenter {

	
	  private final EventBus eventBus;
	  private final LoginView loginView;
	  private UserInfoProxy currentUser;
	  private CovoiturageRequestFactory requestFactory;



	  public LoginActivity(ClientFactory clientFactory) {
		  this.requestFactory = clientFactory.getRequestFactory();
		    this.eventBus = clientFactory.getEventBus();
		    this.loginView = clientFactory.getLoginView();
		  }
	


	private void bind() {
		loginView.getSendLoginButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		   	  login();

		      }
		    });
		loginView.getAddUserButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new NewUserEvent());
		      }
		    });
		
	} 
	
	private void login()
	{
		
		UserInfoRequest request = requestFactory.userInfoRequest();


		Request<UserInfoProxy> createReq = request.login(loginView.getLogin(), loginView.getPassword());

		createReq.fire(new Receiver<UserInfoProxy>(){
			@Override
			public void onSuccess(UserInfoProxy result) {
				 currentUser = result;

		    	  
			        if(currentUser!=null && currentUser.getLoggedIn()) {

				        eventBus.fireEvent(new SendLoginEvent());
			        } else {
			        	  Window.alert("Veuillez vous identifiez");

			        }
				
			}
		});
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}

	 
	
	
	
}