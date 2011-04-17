package com.covoiturage.client.gwtanimation;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;

public class AnimationVoiture extends Animation{
	
	private final Element element;
    @SuppressWarnings("unused")
	private int startX;
    private int startY;
    private int milliseconds;
    
    public AnimationVoiture(Element element,int milli){
        this.element = element;
        this.milliseconds=milli*1;
        
    }

    public void scrollTo(){	
		startX = element.getOffsetLeft();
		startY = 100;
		run(milliseconds);
	}
    
	@Override
	protected void onUpdate(double progress){
		if (progress<0.5){
			double positionX = progress*2*Window.getClientWidth();
			double positionY = startY + (progress * 0);
			this.element.getStyle().setLeft(positionX, Style.Unit.PX);
			this.element.getStyle().setTop(positionY, Style.Unit.PX);
		}
		else{
			double positionX = Window.getClientWidth()*2-progress*2.1*Window.getClientWidth();
			double positionY = startY+ (progress * 0);
			this.element.getStyle().setLeft(positionX, Style.Unit.PX);
			this.element.getStyle().setTop(positionY, Style.Unit.PX);
		}
	}

}