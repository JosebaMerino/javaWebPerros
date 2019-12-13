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
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		//dao.get
	}

	@Test
	public void testDelete() throws Exception {
		int size = dao.getAll().size();
		dao.create(mock);
		assertTrue("No se ha añadido correctamente", dao.getAll().size() == (size + 1));
		dao.delete(mock.getId());
		assertTrue("No se ha borrado correctamente", dao.getAll().size() == size);

	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() throws Exception {
		int size = dao.getAll().size();

		dao.create(mock);

		assertTrue("No se ha añadido correctamente", dao.getAll().size() == (size + 1));
	}

}
