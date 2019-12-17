package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.cfg.context.ReturnValueTarget;

import com.ipartek.formacion.model.pojo.Item;

public class ArrayItemDAO implements IDAO<Item> {

	private ArrayList<Item> registros;
	private static int indice = 1;

    private static ArrayItemDAO INSTANCE = null;

    // Capar para que no se pueda hacer new de eesta clase
    private ArrayItemDAO() {
    	super();
    	registros = new ArrayList<Item>();
    }

    public synchronized static ArrayItemDAO getInstance() {
    	if (INSTANCE == null) {
			INSTANCE = new ArrayItemDAO();
		}
    	return INSTANCE;
    }

	@Override
	public List<Item> getAll() {

		return registros;
	}

	@Override
	public Item getById(int id) {
		Item resul = null;

		for (Item perro : registros) {
			if (id == perro.getId()) {
				resul = perro;
				break;
			}
		}

		return resul;
	}

	@Override
	public Item delete(int id) throws Exception {
		Item resul = null;


		for (Item perro : registros) {
			if (id == perro.getId()) {
				resul = perro;
				registros.remove(perro);
				break;
			}
		}

		if (resul == null) {
			throw new Exception("Perro no encontrado por su id");
		}

		return resul;
	}

	@Override
	public Item update(int id, Item pojo) throws Exception {
		Item  resul = null;

		for(int i = 0 ; i < registros.size(); i++) {
			if (registros.get(i).getId() == id) {
				registros.remove(i);
				registros.add(pojo);
				resul = pojo;
			}
		}

		if (resul == null) {
			throw new Exception("Perro no encontrado por su id " + id);
		}
		return resul;
	}

	@Override
	public Item create(Item pojo) throws Exception {
		Item resul = null;

		//TODO: comprobar campos del pojo
		if (pojo != null) {
			pojo.setId(++indice);
			registros.add(pojo);
			resul = pojo;
		} else {
			throw new Exception("Perro null");
		}
		return resul;
	}

}
