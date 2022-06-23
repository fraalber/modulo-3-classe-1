package com.realestateapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApartmentRaterTest {

	@Test
	void rateApartmentAreaZero() {

		Apartment apart = mock(Apartment.class);
		when(apart.getArea()).thenReturn(0.0);
		
		assertEquals(ApartmentRater.rateApartment(apart), -1);
		
	}

	@Test
	void rateEmptyApartment() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
	        List<Apartment> apartments = new ArrayList<Apartment>();
	        ApartmentRater.calculateAverageRating(apartments);
		});

	    String expectedMessage = "Cannot calculate average rating for empty list";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
}
