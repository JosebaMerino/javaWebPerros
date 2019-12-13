package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.cfg.context.ReturnValueTarget;

import com.ipartek.formacion.model.pojo.Perro;

public class ArrayPerroDAO implements IDAO<Perro> {

	private ArrayList<Perro> registros;
	private static int indice = 1;

    private static ArrayPerroDAO INSTANCE = null;

    // Capar para que no se pueda hacer new de eesta clase
    private ArrayPerroDAO() {
    	super();
    	registros = new ArrayList<Perro>();
    }

    public synchronized static ArrayPerroDAO getInstance() {
    	if (INSTANCE == null) {
			INSTANCE = new ArrayPerroDAO();
		}
    	return INSTANCE;
    }

	@Override
	public List<Perro> getAll() {

		return registros;
	}

	@Override
	public Perro getById(int id) {
		Perro resul = null;

		for (Perro perro : registros) {
			if (id == perro.getId()) {
				resul = perro;
				break;
			}
		}

		return resul;
	}

	@Override
	public Perro delete(int id) throws Exception {
		Perro resul = null;


		for (Perro perro : registros) {
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
	public Perro update(int id, Perro pojo) throws Exception {
		Perro  resul = null;

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
	public Perro create(Perro pojo) throws Exception {
		Perro resul = null;

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
