package com.kiki.core.common;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;
@Component
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

	private Properties props;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		this.props = props;
	}

	public Object getProperty(String key) {
		return props.getProperty(key);
	}

}
