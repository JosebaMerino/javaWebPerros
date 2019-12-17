package com.ipartek.formacion.model.pojo;

public class Item {
	private int id;
	private String nombre;


	public Item() {
		super();
		this.id = 0;
		this.nombre = "";}



	public Item(String nombre) {
		this();
		this.nombre = nombre;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + "]";
	}



}
