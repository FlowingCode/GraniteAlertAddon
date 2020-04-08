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
import {html} from '@polymer/polymer/lib/utils/html-tag.js';

import '../granite-alert/granite-alert.js';

import {ThemableMixin} from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';

class GraniteAlertMixin extends ThemableMixin(customElements.get('granite-alert')) 
  {
    static get is() { return 'granite-alert-mixin'; }

    static get template() {
      return html`
        <style>
          :host([compact]) .alert {
            padding: 0 10px 0 10px;
            margin-bottom: 8px;
          }
        </style>
      ${super.template}
    `;}
  
};

customElements.define(GraniteAlertMixin.is, GraniteAlertMixin);
