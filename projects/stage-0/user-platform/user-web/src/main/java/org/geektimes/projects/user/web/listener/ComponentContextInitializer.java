package org.geektimes.projects.user.web.listener;

import org.geektimes.configuration.microprofile.config.source.servlet.ServletContextConfigInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

public class ComponentContextInitializer implements ServletContainerInitializer {
   
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
        servletContext.addListener(ComponentContextInitializerListener.class);
    }
}
