package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.pojo.Perro;

public class ArrayPerroDAOTest {

	private static Perro mock;

	private static ArrayPerroDAO dao;

	private static final int MOCK_ID_INEXISTENTE = -1;
	private static int MOCK_ID = 1;
	private static int indice = MOCK_ID;
	private static final String MOCK_NOMBRE = "Pulgas";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = ArrayPerroDAO.getInstance();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		mock = new Perro( indice, MOCK_NOMBRE);
		dao.create(mock);
		indice++;
	}

	@After
	public void tearDown() throws Exception {
		mock = null;

		dao.delete(indice);
	}


	@Test
	public void testGetAll() throws Exception {

		assertEquals(2 , dao.getAll().size());
//
//		dao.delete(mock.getId());
//
//		assertEquals(0 , dao.getAll().size());

	}

	@Test
	public void testGetById() {
		assertNull("Es imposible que exista este perro", dao.getById(-1));

		Perro p = dao.getById(mock.getId());

		assertSame(" Deberia existir el perro " + MOCK_NOMBRE, p, mock);
	}

	@Test
	public void testDelete() {

		try {
			//TODO: solucionar bug tear down, creamos un perro para eliminarlo

			Perro pEliminar = new Perro(1234, "Pulgas1234");

			dao.create(pEliminar);

			Perro p = dao.delete(MOCK_ID);
			assertSame("Deberian ser el mismo",p, mock);
			assertEquals("No queda ninguno", 0 , dao.getAll().size());

			dao.delete(MOCK_ID_INEXISTENTE);
			fail("Deberia haber lanzado exception");

		} catch (Exception e) {
			assertTrue("Lanzada exception correctamente", true);

		}
	}

	@Test
	public void testUpdate() {
		//TODO: testUpdate
	}

	@Test
	public void testCreate() {
		//TODO: testCreate
	}

}
