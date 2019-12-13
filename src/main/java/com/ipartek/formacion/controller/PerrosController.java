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

import com.ipartek.formacion.model.ArrayPerroDAO;
import com.ipartek.formacion.model.pojo.Perro;
import com.mysql.jdbc.log.Log;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(PerrosController.class);

	private static ArrayPerroDAO dao = ArrayPerroDAO.getInstance();


    String mensaje = "";


	public PerrosController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Se ejecuta la primera vez que se entra y nunca mas");
		super.init(config);
		try {
			dao.create( new Perro(1,"bubba") );
			dao.create( new Perro(2,"rataplan") );
			dao.create( new Perro(3,"mosca") );
			dao.create( new Perro(4,"txakur") );
			dao.create( new Perro(5,"lagun") );
		} catch (Exception e) {
			LOG.warn(e);
		}
	}

	@Override
	public void destroy() {

		LOG.trace("Se ejecuta al parar el servidor Tomcat");

		super.destroy();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Se ejecuta antes del doGet o del doPost.");

		mensaje = "";

		super.service(request, response); // Ejecuta doGet o doPost

		LOG.trace("Se ejecuta despues de doGet o doPost");

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", dao.getAll());
		request.getRequestDispatcher("private/perros.jsp").forward(request, response);
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
			int id = Integer.parseInt(request.getParameter("id"));

			try {
			Perro perro = dao.delete(id);

			LOG.trace("Adoptado perro: " + perro);
			} catch (Exception e) {
				mensaje = "No se ha podido adoptar al perro";
			}
		} else if("modificar".equals(accion)) {
			LOG.trace("Doing get -> Modificar");
			int id = Integer.parseInt(request.getParameter("id"));
			Perro perro = dao.getById(id);

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


		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("imagen");

		Perro perro = new Perro();

		if (id > 0) {
			// modificar perro
			LOG.trace("Doing post -> Modificar");
			perro = dao.getById(id);

			perro.setNombre(nombre);
			perro.setFoto(imagen);

			try {
				dao.update(id, perro);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.warn("No se ha podido actualizar el perro");
			}

			LOG.trace("Modificado perro:" + perro);

		} else {
			LOG.trace("Doing post -> Crear");

			perro.setNombre(nombre);
			perro.setFoto(imagen);
			mensaje = "Gracias por dar de alta un nuevo perro";

			//guardar en lista
			try {
				dao.create(perro);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.warn("No se ha podido crear el perro");
			}
			LOG.trace("Perro dado de alta: " + perro);
		}

	}

}
