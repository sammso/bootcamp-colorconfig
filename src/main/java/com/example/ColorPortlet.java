package com.example;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.example.api.ColorConfiguration;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import aQute.bnd.annotation.metatype.Configurable;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=com.example.configuration Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class,
		configurationPid = "com.example.api.ColorConfiguration")
public class ColorPortlet extends MVCPortlet {
	public String getFavoriteColor(Map colors) {
		return (String) colors.get(_configuration.favoriteColor());
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(ColorConfiguration.class, properties);
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		renderRequest.setAttribute(ColorConfiguration.class.getName(), _configuration);
		super.doView(renderRequest, renderResponse);
	}
	
	private volatile ColorConfiguration _configuration;
}