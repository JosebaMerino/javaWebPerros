package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.ArrayProductoDAO;
import com.ipartek.formacion.model.pojo.Producto;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/producto")
public class ProductosController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final static Logger LOG = Logger.getLogger(ProductosController.class);

    private static ArrayProductoDAO dao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosController() {
        super();

    }

    @Override
    public void init() throws ServletException {
        super.init();
        dao = ArrayProductoDAO.getInstance();

        try {
            dao.create(new Producto(1, "patatas", 3, "no", "No tengo descripcion", 0));
            dao.create(new Producto(1, "patatas", 3, "no", "No tengo descripcion", 0));
            dao.create(new Producto(1, "patatas", 3, "no", "No tengo descripcion", 0));
            dao.create(new Producto(1, "patatas", 3, "no", "No tengo descripcion", 0));
        } catch (Exception e) {
            LOG.warn("Ha ocuarrido un error al añadir el producto al dao");
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        int id = -1;
        if("eliminar".equals(accion) || "modificar".equals(accion)) {
            id = Integer.parseInt(request.getParameter("id"));
        }

        if(accion == null) {
            request.setAttribute("productos", dao.getAll());

            request.getRequestDispatcher("/productos/index.jsp").forward(request, response);
        } else if("modificar".equals(accion)) {
            request.setAttribute("mensaje", "He pasado por modificar y quiero modificar " + id);

            request.setAttribute("producto", dao.getById(id));

            request.getRequestDispatcher("/productos/formulario.jsp").forward(request, response);


        } else if("eliminar".equals(accion)) {
            try {
                dao.delete(id);
                LOG.trace("Producto " + id + " eliminado correctamente");
            } catch (Exception e) {
                LOG.warn("No se ha podido borrar correctamente el producto: " + id);
            }
            request.setAttribute("mensaje", "He pasado por eliminar y quiero eliminar " + id);

            request.setAttribute("productos", dao.getAll());

            //request.getRequestDispatcher("/productos/index.jsp").forward(request, response);
            response.sendRedirect("producto");
        } else if("repoblar".equals(accion)) {
            init();
            response.sendRedirect("producto");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        String imagen = request.getParameter("imagen");
        String descripcion= request.getParameter("descripcion");
        int descuento = Integer.parseInt(request.getParameter("descuento"));

        Producto prod = new Producto(id, nombre, precio, imagen, descripcion, descuento);

        if (id == 0) {
            try {
                dao.create(prod);
                LOG.trace("Producto añadido correctamente");
            } catch (Exception e) {
                LOG.warn("Producto no se ha podido añadir");
            }
        } else {
            try {
                dao.update(id, prod);
                LOG.trace("Producto actualizado correctamente");
            } catch (Exception e) {
                LOG.warn("Producto no se ha podido modificar correctamente");
            }
        }

        request.setAttribute("productos", dao.getAll());

        request.getRequestDispatcher("/productos/index.jsp").forward(request, response);

    }

}
