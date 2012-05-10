/*
 * Copyright 2011 FatWire Corporation. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fatwire.gst.foundation.controller.action.support;

import javax.servlet.ServletContext;

import COM.FutureTense.Interfaces.ICS;

import com.fatwire.gst.foundation.controller.AppContext;
import com.fatwire.gst.foundation.controller.action.ActionLocator;
import com.fatwire.gst.foundation.controller.action.ActionNameResolver;
import com.fatwire.gst.foundation.controller.action.Factory;
import com.fatwire.gst.foundation.controller.action.FactoryProducer;
import com.fatwire.gst.foundation.controller.action.Injector;
import com.fatwire.gst.foundation.controller.support.WebAppContext;

public class DefaultWebAppContext extends WebAppContext implements FactoryProducer {

    public DefaultWebAppContext(ServletContext context, AppContext parent) {
        super(context, parent);
       
    }

    public DefaultWebAppContext(ServletContext context) {
        super(context);

    }

    public ActionLocator createActionLocator() {
        // this method is expected to be called only once during the lifecycle
        // of the WebAppContext, though more often does not need to be a
        // problem per se.
        final Injector injector = createInjector();
        ActionLocator root = new RenderPageActionLocator(injector);
        final ClassActionLocator cal = new ClassActionLocator(root, injector);
        return cal;

    }

    public ActionNameResolver createActionNameResolver() {
        return new CommandActionNameResolver("action");
    }

    public Injector createInjector() {
        return new DefaultAnnotationInjector(this);
    }

    @Override
    public Factory getFactory(ICS ics) {
        // called very often; once per request/pagelet, scoped per ICS context
        return new IcsBackedObjectFactoryTemplate(ics);
    }

}