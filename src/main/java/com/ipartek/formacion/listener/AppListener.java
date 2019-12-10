package com.ipartek.formacion.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerrosController2;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	private final static Logger LOG = Logger.getLogger(AppListener.class);


	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {

    	// NEtra por aqui al lanzar la aplicacion
    	LOG.trace("Inicializando entorno AppListener");


    	//SC == applicationScope
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("numeroUsuariosConectados", 0);
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {

    	// Entra por aqui al parar la aplicacion
    	LOG.trace("Destruyendo entorno AppListener");
    }
}
