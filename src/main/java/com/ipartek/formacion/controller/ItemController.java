package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.ArrayItemDAO;
import com.ipartek.formacion.model.pojo.Item;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/items")
public class ItemController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private final static Logger LOG = Logger.getLogger(ItemController.class);

    private ArrayItemDAO dao = ArrayItemDAO.getInstance();




	public ItemController() {
		super();
		try {
			dao.create( new Item("bubba") );
			dao.create( new Item("rataplan") );
			dao.create( new Item("mosca") );
			dao.create( new Item("txakur") );
			dao.create( new Item("lagun") );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//listar items
		LOG.trace("Items >>>>");
		request.setAttribute("items", dao.getAll());
		request.getRequestDispatcher("pages/items.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recibir datos del form

		String nombre = request.getParameter("nombre");


		//crear item
		Item item = new Item();
		item.setNombre(nombre);

		//guardar en lista
		try {
			dao.create(item);
			LOG.trace("Item <<<<");
		} catch (Exception e) {
			LOG.warn("No se ha podido añadido el Items");
		}


		//listar items
		request.setAttribute("items", dao.getAll());
		request.getRequestDispatcher("pages/items.jsp").forward(request, response);

	}

}
