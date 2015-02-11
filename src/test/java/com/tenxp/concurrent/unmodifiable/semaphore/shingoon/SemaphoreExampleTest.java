package com.tenxp.concurrent.unmodifiable.semaphore.shingoon;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tenxp.concurrent.semaphore.SemaphoreExample;

public class SemaphoreExampleTest {

	@Test
	public void testSemaphoreDefault() throws Exception {
		SemaphoreExample.semaphoreDefault();
		assertTrue(true);
	}
	
	@Test
	public void testSemaforeTryAcquire() throws Exception {
		SemaphoreExample.semaforeTryAcquire();
		assertTrue(true);
	}
}
