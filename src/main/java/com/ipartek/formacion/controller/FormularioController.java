package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class FormularioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doIt(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doIt(request, response);
    }

    private void doIt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String base = "/";
        String vista = "";

        boolean valido = true;
        List<String> mensaje = new ArrayList<String>();

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String deportes[] = request.getParameterValues("deportes");

        if(nombre == null || nombre.length() < 3) {
            mensaje.add("El nombre es demasiado corto. Minimo 3 caracteres");
            valido = false;
        }
        if(email == null || !email.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")) {
            mensaje.add("El email no tiene el formato convencional.");
            valido = false;
        }
        if(deportes == null || deportes.length < 2) {
            mensaje.add("Se deben elegir 2 deportes o mas.");
            valido = false;
        }


        if(valido) {

        	ArrayList<String> listaDeportes = new ArrayList<String>();

        	ServletContext sc = request.getServletContext();

        	HashMap<String, String> deportesMap = (HashMap<String, String>) sc.getAttribute("formDeportes");
        	for (String deporteKey : deportes) {
        		String deporteValue = deportesMap.get(deporteKey);

        		if (deporteValue != null) {
					listaDeportes.add(deporteValue);
				}
			}


        request.setAttribute("deportes", listaDeportes.toArray());


            vista = "index.jsp";
        } else {
        	// Genera el string de los deportes seleccionados poniendo barras verticales como separadores.
            StringBuilder sb = new StringBuilder();
            sb.append("|");

            if (deportes != null) {
    	        for (String deporte : deportes) {
    				sb.append(deporte + "|");
    			}
            }

            request.setAttribute("deportes", sb.toString());

            vista = "formulario.jsp";
        }

        request.setAttribute("mensaje", mensaje.toArray());
        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);

        request.getRequestDispatcher(base + vista).forward(request, response);
    }

}
