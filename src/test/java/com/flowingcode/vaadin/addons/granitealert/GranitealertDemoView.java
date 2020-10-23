/*-
 * #%L
 * Granite Alert
 * %%
 * Copyright (C) 2018 - 2020 Flowing Code
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

import com.flowingcode.vaadin.addons.DemoLayout;
import com.flowingcode.vaadin.addons.demo.impl.TabbedDemoImpl;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route(value = "granite-alert", layout = DemoLayout.class)
@StyleSheet("context://frontend/styles/granitealert/demo-styles.css")
@CssImport(value = "./styles/granitealert/custom-granite-styles.css", themeFor = "granite-alert-mixin")
public class GranitealertDemoView extends VerticalLayout {

	private static final String GRANITE_DEMO = "Granite Alert Demo";
	private static final String GRANITE_SOURCE = "https://github.com/FlowingCode/GraniteAlertAddon/tree/master/src/test/java/com/flowingcode/vaadin/addons/granitealert/GranitealertDemo.java";

	public GranitealertDemoView() {
		TabbedDemoImpl<GranitealertDemo> grDemo = new TabbedDemoImpl<>(new GranitealertDemo(), GRANITE_DEMO,
				GRANITE_SOURCE);
		add(grDemo);
		setSizeFull();
	}
}
