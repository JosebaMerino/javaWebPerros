package com.ipartek.formacion.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
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

		HttpSession session = request.getSession();

		session.removeAttribute("usuario");

		session.invalidate();

//		request.getRequestDispatcher("index.jsp").forward(request, response);

		/* Para convertir un String al formato de la URL
		 * URLEncoder.encode(mensaje, StandardCharsets.UTF_8.toString()
		 *
		 * Siempre añadir base al hacer una redireccion o forward
		 * */
		String mensaje = "Gracias por visitarnos";

		String base = request.getContextPath();

		response.sendRedirect(base + "/login.jsp?mensaje=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8.toString() ));

	}

}
