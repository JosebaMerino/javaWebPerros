package com.ipartek.formacion.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerrosController2;
import com.ipartek.formacion.model.pojo.Usuario;

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

    	List<Usuario> usuarios =new ArrayList<Usuario>();

    	usuarios.add(new Usuario(1, "admin", "admin", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png"));
		usuarios.add(new Usuario(1, "pepe", "pepe", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png"));
		usuarios.add(new Usuario(1, "Joseba", "123456", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png"));

    	sc.setAttribute("usuarios", usuarios);

    	HashMap<String, String> deportes = new HashMap<String,String>();

    	deportes.put("1", "Surf");
    	deportes.put("110", "Tennis");
    	deportes.put("1010", "Baloncesto");
    	deportes.put("10", "Futbol");

    	sc.setAttribute("formDeportes", deportes);

    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {

    	// Entra por aqui al parar la aplicacion
    	LOG.trace("Destruyendo entorno AppListener");
    }
}
