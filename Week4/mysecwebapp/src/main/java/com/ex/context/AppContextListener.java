package com.ex.context;

import com.ex.connector.H2Connector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        H2Connector conn = H2Connector.CONNECTOR;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
