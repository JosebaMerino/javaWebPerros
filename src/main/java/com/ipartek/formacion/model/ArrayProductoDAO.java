package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.pojo.Producto;

public class ArrayProductoDAO implements IDAO<Producto> {

	private static ArrayProductoDAO INSTANCE = null;

	private ArrayList<Producto> registros;
	private static int indice = 1;

	public ArrayProductoDAO() {
		super();
		registros = new ArrayList<Producto>();
	}

	public synchronized static ArrayProductoDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE= new ArrayProductoDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Producto> getAll() {
		return registros;
	}

	@Override
	public Producto getById(int id) {
		Producto resul = null;

		for (Producto producto : registros) {
			if (producto.getId() == id) {
				resul = producto;
				break;
			}
		}

		return resul;
	}

	@Override
	public Producto delete(int id) throws Exception {
		Producto resul = null;

		for (Producto producto : registros) {
			if(id == producto.getId()) {
				resul = producto;
				registros.remove(producto);
				break;
			}
		}

		if(resul == null) {
			throw new Exception("Producto no encontrado por su id");
		}

		return resul;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		Producto resul = null;

		for (int i = 0; i < registros.size(); i++) {
			if (registros.get(i).getId() == id) {
				registros.remove(i);
				registros.add(pojo);
				resul = pojo;
				break;
			}
		}

		if(resul == null) {
			throw new Exception("Producto no encontrado por su id");
		}

		return resul;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {
		Producto resul = null;

		if (pojo != null) {
			pojo.setId(++indice);
			registros.add(pojo);
			resul = pojo;
		} else {
			throw new Exception("Producto null");
		}

		return resul;
	}

}
