/*-
 * #%L
 * Granite Alert
 * %%
 * Copyright (C) 2018 - 2019 Flowing Code
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.flowingcode.vaadin.addons.granitealert;


import com.flowingcode.vaadin.addons.granitealert.GraniteAlert.GraniteAlertLevel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@SuppressWarnings("serial")
@Route("")
@Theme(Lumo.class)
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
public class DemoView extends Div {
	
	Div container = new Div();
	
	{		
		createAlert(null, "boring", "Welcome to the GraniteAlertAddon demo. Please click any button below.");
    	
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);
		
		buttons.add(new Button(VaadinIcon.EXCLAMATION.create(), ev->createErrorAlert()));
		buttons.add(new Button(VaadinIcon.WARNING.create(), ev->createWarningAlert()));
		buttons.add(new Button(VaadinIcon.INFO.create(), ev->createInfoAlert()));
		buttons.add(new Button(VaadinIcon.CHECK.create(), ev->createSuccessAlert()));
		buttons.add(new Button(VaadinIcon.MEH_O.create(), ev->createCustomAlert("boring")));
		buttons.add(new Button(VaadinIcon.SMILEY_O.create(), ev->createCustomAlert("funny")));
			
		
		add(container, buttons);
	}
   
	private void createSuccessAlert() {
		createAlert(GraniteAlertLevel.SUCCESS, null, "Success");
	}
	
	private void createCustomAlert(String className) {
		createAlert(null, className, "Info");
	}

	private void createInfoAlert() {
		createAlert(GraniteAlertLevel.INFO, null, "Info");
	}
	
	private void createWarningAlert() {
		createAlert(GraniteAlertLevel.WARNING, null, "Warning");
	}
	
	private void createErrorAlert() {
		createAlert(GraniteAlertLevel.ERROR, null, "Error");
	}
	
	private void createAlert(GraniteAlertLevel level, String className, String message) {
		GraniteAlert alert = new GraniteAlert();
		alert.setCompact(true);
		if (level!=null) {
			alert.setLevel(level);
		}
		if (className!=null) {
			alert.addClassName(className);
		}
		
		alert.add(new Span(message));
				
		Button button = new Button(VaadinIcon.CLOSE_CIRCLE.create());
		button.addClickListener(ev->container.remove(alert));
		alert.add(button);
		container.add(alert);
	}
    
}
