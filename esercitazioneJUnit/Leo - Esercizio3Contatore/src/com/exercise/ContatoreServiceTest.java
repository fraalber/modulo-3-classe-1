package com.exercise;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class ContatoreServiceTest {

	private ContatoreService service;
	
	@Test
	void multiplySuccessful() {
		
		Contatore counter = mock(Contatore.class);
		when(counter.getCounter()).thenReturn(40);
		
		service = new ContatoreService(counter);
		
		assertEquals(80, service.multiplyByN(2));
	}
	
	@Test
	void multiplyFail() {
		
		Contatore counter = mock(Contatore.class);
		when(counter.getCounter()).thenReturn(30);
		
		service = new ContatoreService(counter);
		
		assertNotEquals(80, service.multiplyByN(2));
	}

}
