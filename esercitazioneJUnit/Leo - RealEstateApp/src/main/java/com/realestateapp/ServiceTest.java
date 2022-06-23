package com.realestateapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class ServiceTest {

	@Test
	void isAvailableDatabase() {
		
		Database db = mock(Database.class);
		when(db.isAvailable()).thenReturn(true);
		
		Service service = new Service(db);
		
		assertTrue(service.query("test"));
		verify(db, times(1)).isAvailable();
	}
	
	@Test
	void notAvailableDatabase() {
		
		Database db = mock(Database.class);
		when(db.isAvailable()).thenReturn(false);
		
		Service service = new Service(db);
		
		assertFalse(service.query("test"));
		verify(db, times(1)).isAvailable();
	}
	
	@Test
	void getUniqueIdTest() {
		
		Database db = new Database();
		
		Service service = new Service(db);
		
		assertTrue(service.toString().equals("Using database with id: 42"));
	}
	
	@Test
	void wrongDatabase() {
		
		Database db = mock(Database.class);
		when(db.getUniqueId()).thenReturn(54);
		
		Service service = new Service(db);
		
		assertFalse(service.toString().equals("Using database with id: 42"));
	}

}
