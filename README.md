[![Published on Vaadin Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/granite-alert)
[![Build Status](https://jenkins.flowingcode.com/job/GraniteAlert-14-addon/badge/icon)](https://jenkins.flowingcode.com/job/GraniteAlert-14-addon)
[![Javadoc](https://img.shields.io/badge/javadoc-00b4f0)](https://javadoc.flowingcode.com/artifact/com.flowingcode.addons/granite-alert)

# Granite Alert

Vaadin 10+ global notifications (wrapper for https://github.com/LostInBrittany/granite-alert with [themable](https://github.com/vaadin/vaadin-themable-mixin) support.)

## Online demo

[Online demo here](http://addonsv14.flowingcode.com/granite-alert)

## Building and running demo

- git clone repository
- mvn clean install jetty:run

To see the demo, navigate to http://localhost:8080/

## Release notes

- **Version 2.0.0** Initial Version for Vaadin 14
- **Version 1.0.0** Initial Version for Vaadin 10

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:

- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

This add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

GraniteAlertAddon is written by Flowing Code S.A.

# Developer Guide

GraniteAlert is a container for other components, which are rendered inside the alert.
The property `level` maps to the `level` attribute of granite-alert, with each level (info, warning, error and success) providing a different style. The property `compact` enables additional style rules that reduce spacing around the content.

```
GraniteAlert alert = new GraniteAlert();
alert.setCompact(true);
alert.setLevel(GraniteAlertLevel.SUCCESS);
alert.add(new Span("Success!"));
```

It is also posible to injecting styles directly into the granite-alert shadow DOM, by using style modules:
```
<dom-module id="custom-granite-alert-theme" theme-for="granite-alert">
  <template>
    <style>
        :host(.custom) .alert {
            color: var(--lumo-body-text-color);
            background-color: white;
            border-color: grey;
        }
    </style>
  </template>
</dom-module>
```
