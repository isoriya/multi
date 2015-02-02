package com.tenxp.concurrent.unmodifiable;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnmodifiableTest {
	@Test
	public void testUnmodifiableCollection() throws Exception {
		UnmodifiableCollection.unmodifiableCollection();
		assertTrue(true);
	}
	
	@Test
	public void testUnmodifiableList() throws Exception {
		UnmodifiableList.unmodifiableList();
		assertTrue(true);
	}
	
	@Test
	public void testUnmodifiableMap() throws Exception {
		UnmodifiableMap.unmodifiableMap();
		assertTrue(true);
	}
	
	@Test
	public void testUnmodifiableSet() throws Exception {
		UnmodifiableSet.unmodifiableSet();
		assertTrue(true);
	}
	
	@Test
	public void testUnmodifiableSortedMap() throws Exception {
		UnmodifiableSortedMap.unmodifiableSortedMap();
		assertTrue(true);
	}
}
