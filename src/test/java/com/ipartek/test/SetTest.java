package com.ipartek.test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class SetTest {

	@Test
	public void test() {

		assertTrue(true);

		HashSet<String> paises = new HashSet<String>();

		assertNotNull("NO deberia ser null ",paises);

		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");

		assertEquals("Mensaje personalizado por si falla",4, paises.size());

		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");

		assertEquals("No deberia haber duplicados",4, paises.size());



	}

}
