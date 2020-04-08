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
import {PolymerElement} from '@polymer/polymer/polymer-element.js';


/*
@license MIT
Copyright (c) 2016 Horacio "LostInBrittany" Gonzalez

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

class GraniteAlert extends PolymerElement {
    static get is() { return 'granite-alert'; }
    
    static get template() {
       return html`
      <style>
        :host {
          display: block;
        }        
        .hidden {
          display: none;
        }
        .alert {
          padding: 15px;
          margin-bottom: 20px;
          border: 1px solid transparent;
          border-radius: 4px;
        }
        .success {
          color: #3c763d;
          background-color: #dff0d8;
          border-color: #d6e9c6;
        }
        .info {
          color: #31708f;
          background-color: #d9edf7;
          border-color: #bce8f1;
        }
        .warning {
          color: #8a6d3b;
          background-color: #fcf8e3;
          border-color: #faebcc;
        }
        .danger {
          color: #a94442;
          background-color: #f2dede;
          border-color: #ebccd1;
       }
      </style>
      <div class$="alert {{level}} {{_hidden}}">
        <slot></slot>
      </div>
    `;}


	static get properties() {
	  return {
          /**
           * The level of the alert. Alowed values: `info` (default), `warning`, `danger` and `success`
           */
          level: {
            type: String,
            value: "info"
          },
          /**
           * If true, the alert is not shown
           */
          hide: {
            type: Boolean,
            value: false,
          },

          _hidden: {
            type: String,
            computed: "_getHidden(hide)"
          },

          _allowedValues: {
            type: Array,
            value: [ "info", "warning", "danger", "success" ]
          },
	  };
	}

	static get observers() {
	  return [
		  "_onValueChange(level,_allowedValues)"
      ];
	}

    // Observers
    _onValueChange() {
      if (this._allowedValues && this._allowedValues.indexOf(this.level) < 0) {
        this.level = this._allowedValues[0];  // Set default value for `level` if unknown value is given
      }
    }

    // Computed properties
    _getHidden() {
      if (this.hide) {
        return "hidden";
      }
      return "";
    }
    
}

customElements.define(GraniteAlert.is, GraniteAlert);