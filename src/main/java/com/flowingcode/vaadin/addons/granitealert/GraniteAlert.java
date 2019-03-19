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



import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

/**Wrapper for {@code granite-alert} Polymer element
 * 
 * @author Javier Godoy / Flowing Code
 */
@Tag("granite-alert-mixin")
@HtmlImport("frontend://bower_components/granite-alert-mixin/granite-alert-mixin.html")
public class GraniteAlert extends Component implements HasComponents, HasStyle {

	private static final long serialVersionUID = 1L;

	/**The level of the alert*/
	public enum GraniteAlertLevel {
		ERROR("danger"),
		WARNING("warning"),
		INFO("info"),
		SUCCESS("success");
		
		private final String style;

		private GraniteAlertLevel(String style) {
			this.style = style;
		}		
		
		private static GraniteAlertLevel fromProperty(String property) {
			for (GraniteAlertLevel level : GraniteAlertLevel.values()) {
				if (level.style.equals(property)) {
					return level;
				}
			}
			return null;
		}
	}
	
	/**Set the level of the alert*/
	public void setLevel(GraniteAlertLevel level) {
	    getElement().setAttribute("level", level!=null ? level.style: null);
	}	
	
	/**Returns the level of the alert*/
	public GraniteAlertLevel getLevel() {
		return Optional.ofNullable(getElement().getProperty("level"))
		.map(GraniteAlertLevel::fromProperty)
		.orElse(GraniteAlertLevel.INFO);
	}
		
	/**Set the {@code compact} attribute of the element.*/
	public void setCompact(boolean value) {
		getElement().setAttribute("compact", value);
	}
}
