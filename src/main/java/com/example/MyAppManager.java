package com.example;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.example.api.ColorConfiguration;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Modified;
import aQute.bnd.annotation.metatype.Configurable;

@Component(configurationPid = "com.example.api.ColorConfiguration")
public class MyAppManager {
	public String getFavoriteColor(Map colors) {
		return (String) colors.get(_configuration.favoriteColor());
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(ColorConfiguration.class, properties);
	}

	private volatile ColorConfiguration _configuration;
}
