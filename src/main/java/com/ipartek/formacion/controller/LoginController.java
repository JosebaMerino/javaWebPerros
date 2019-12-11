package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(PerrosController.class);

	Usuario usuarios[] = {
		new Usuario(1, "admin", "admin", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png"),
		new Usuario(1, "pepe", "pepe", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png"),
		new Usuario(1, "Joseba", "123456", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png")
	};

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables del controlador


		// Provocar un error
//		 int infinito = 5 / 0;

		String base = "/";
		String vista = "";

		ServletContext sc = request.getServletContext();

		List<Usuario> usuarios = (List<Usuario>) sc.getAttribute("usuarios");


		// Recibir los datos del formulario
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		// Validar si es admin
		//boolean valido = NOMBRE.equals(nombre) && PASSWORD.equals(password);

		boolean valido = false;
		Usuario usuario = new Usuario();

		LOG.debug("Buscando usuario "  + usuario + " ...");
		for (Usuario u : usuarios) {
			if (nombre.equals(u.getNombre())) {
				usuario = u;
				break;
			}
		}

		valido = usuario.getPassword().equals(password);

		LOG.debug("El usuario y la contraseña coinciden?" + valido);

		if(valido) {
			vista = "private/home";

			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(60); // en segundos

			String basee = request.getContextPath();
			response.sendRedirect(basee + "/private/home");

		} else {
			vista = "login.jsp";
			request.getRequestDispatcher(base + vista).forward(request, response);
		}


		// Llevar a la vista

	}

}
