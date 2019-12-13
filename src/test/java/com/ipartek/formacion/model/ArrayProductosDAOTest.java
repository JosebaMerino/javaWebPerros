package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.pojo.Producto;

public class ArrayProductosDAOTest {

	static ArrayProductoDAO dao = ArrayProductoDAO.getInstance();
	static Producto mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mock = new Producto(1, "Patatas", 2, "", "nipa", 2);
		dao.create(mock);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() throws Exception {
		int size = dao.getAll().size();
		Producto prod = new Producto(1, "Patatas", 2, "", "nipa", 2);
		dao.create(prod);

		assertTrue("No se ha añadido correctamente", dao.getAll().size() == (size + 1));

		dao.delete(prod.getId());
	}

	@Test
	public void testGetById() throws Exception {

		Producto prod = dao.getById(mock.getId());
		assertSame("Los productos no son iguales", prod, mock);

	}

	@Test
	public void testDelete() throws Exception {
		int size = dao.getAll().size();
		Producto prod = new Producto(1, "Patatas", 2, "", "nipa", 2);
		dao.create(prod);


		assertTrue("No se ha añadido correctamente", dao.getAll().size() == (size + 1));
		dao.delete(prod.getId());
		assertTrue("No se ha borrado correctamente", dao.getAll().size() == size);
		assertNull(dao.getById(prod.getId()));

	}

	@Test
	public void testUpdate() throws Exception {
		Producto prod = dao.getById(mock.getId());
		prod.setNombre("Debo estar cambiado");

		Producto updated = dao.update(prod.getId(), prod);

		assertSame(updated, prod);

	}

	@Test
	public void testCreate() throws Exception {
		int size = dao.getAll().size();

		Producto prod = new Producto(1, "Patatas", 2, "", "nipa", 2);

		dao.create(prod);
		assertTrue("No se ha añadido correctamente", dao.getAll().size() == (size + 1));

		dao.delete(prod.getId());
	}

}
