package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Perro;
import com.mysql.jdbc.log.Log;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros2")
public class PerrosController2 extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private static int ID = 0;
	private final static Logger LOG = Logger.getLogger(PerrosController2.class);

    private ArrayList<Perro> perros = new ArrayList<Perro>();

    String mensaje = "";


	public PerrosController2() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Se ejecuta la primera vez que se entra y nunca mas");
		super.init(config);
		perros.add( new Perro(1,"bubba") );
		perros.add( new Perro(2,"rataplan") );
		perros.add( new Perro(3,"mosca") );
		perros.add( new Perro(4,"txakur") );
		perros.add( new Perro(5,"lagun") );
		ID = 6;
	}

	@Override
	public void destroy() {

		LOG.trace("Se ejecuta al parar el servidor Tomcat");

		super.destroy();
		perros = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Se ejecuta antes del doGet o del doPost.");

		mensaje = "";

		super.service(request, response); // Ejecuta doGet o doPost

		LOG.trace("Se ejecuta despues de doGet o doPost");

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("pages/perros-jstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LOG.trace("Doing get");
		//listar perros
		String accion = request.getParameter("accion");


		if("adoptar".equals(accion)) {
			LOG.trace("Doing get -> Adoptar");
			Perro perro = null;
			int id = Integer.parseInt(request.getParameter("id"));

			for( Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}
			LOG.trace("Adoptado perro: " + perro);
			perros.removeIf( p -> p.getId() == id);
		} else if("modificar".equals(accion)) {
			LOG.trace("Doing get -> Modificar");
			Perro perro = new Perro();
			int id = Integer.parseInt(request.getParameter("id"));

			for( Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}

			request.setAttribute("modificarPerro", perro);
		} else {
			LOG.trace("Doing get -> Ninguno");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recibir datos del form

		//TODO: validar la URL de la imagen (y pillar la imagen ) y todos los campos
		LOG.trace("Doing post");


		int id = Integer.parseInt(request.getParameter("id").trim());
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("imagen");

		Perro perro = new Perro();

		if (id > 0) {
			// modificar perro
			LOG.trace("Doing post -> Modificar");
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}
			perro.setNombre(nombre);
			perro.setFoto(imagen);

			LOG.trace("Modificado perro:" + perro);

		} else {
			LOG.trace("Doing post -> Crear");

			//crear perro
			perro.setId(ID);
			ID++;

			perro.setNombre(nombre);
			perro.setFoto(imagen);
			mensaje = "Gracias por dar de alta un nuevo perro";

			//guardar en lista
			perros.add(perro);
			LOG.trace("Perro dado de alta: " + perro);
		}

	}

}
