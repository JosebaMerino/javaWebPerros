package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private static final String NOMBRE = "admin";
	private static final String PASSWORD = "admin";

	Usuario usuario;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        usuario = new Usuario(1, "Joseba", "123456", "https://github.com/JosebaMerino/", "/javaWebPerros/images/user.png");
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
		String base = "/";
		String vista = "";


		// Recibir los datos del formulario
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");


		// Validar si es admin
		boolean valido = NOMBRE.equals(nombre) && PASSWORD.equals(password);

		if(valido) {
			vista = "index.jsp";

			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(0);
		} else {
			vista = "login.jsp";
		}


		// Llevar a la vista
		request.getRequestDispatcher(base + vista).forward(request, response);

	}

}
