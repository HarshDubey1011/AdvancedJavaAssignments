package com.hibernate_id.prac_hibernate.listeners;

import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_id.prac_hibernate.App;
import com.hibernate_id.prac_hibernate.entity.Category;
import com.hibernate_id.prac_hibernate.entity.Products;

@WebListener
public class AppListener implements ServletContextListener {
	SessionFactory hibernateFactory = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    
 	   try {
 		   System.out.println("AppListener: Application started.");
 	       Configuration hibernateConfiguration = new Configuration();
 	       Properties properties = new Properties();
 		   properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
		   hibernateConfiguration.addProperties(properties);
	 	   hibernateConfiguration.addAnnotatedClass(Category.class);
	 	   //hibernateConfiguration.addAnnotatedClass(Products.class);
	 	   hibernateFactory = hibernateConfiguration.buildSessionFactory();
	 	   sce.getServletContext().setAttribute("hibernateFactory", hibernateFactory);
	 	   System.out.println("Hibernate Framework initialized and ready");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AppListener: Application shutting down.");
        hibernateFactory.close();
    }
}
