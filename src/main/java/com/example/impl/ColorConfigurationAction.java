package com.example.impl;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import aQute.bnd.annotation.metatype.Configurable;

import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.example.api.ColorConfiguration;
import com.liferay.portal.kernel.portlet.ConfigurationAction;

@Component(
        configurationPid = "com.example.api.ColorConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=com_example_ColorPortlet"
        },
        service = ConfigurationAction.class
)
public class ColorConfigurationAction extends DefaultConfigurationAction {

    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
            throws Exception {

        String favoriteColor = ParamUtil.getString(actionRequest, "favoriteColor");
        setPreference(actionRequest, "favoriteColor", favoriteColor);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Override
    public void include(
            PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        httpServletRequest.setAttribute(
                ColorConfiguration.class.getName(),
                _exampleConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _exampleConfiguration = Configurable.createConfigurable(
                ColorConfiguration.class, properties);
    }

    private volatile ColorConfiguration _exampleConfiguration;

}