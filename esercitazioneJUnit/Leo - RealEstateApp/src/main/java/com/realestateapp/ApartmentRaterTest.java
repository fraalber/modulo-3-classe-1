package com.realestateapp;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApartmentRaterTest {

	@Test
	void rateApartmentAreaZero() {
		
		Apartment apart = mock(Apartment.class);
		when(apart.getArea()).thenReturn(0.0);
		
		assertEquals(-1, ApartmentRater.rateApartment(apart));
		
	}
	
	@Test
	void belowCheapThreshold() {
		
		Apartment apart = mock(Apartment.class);
		when(apart.getArea()).thenReturn(30.0);
		when(apart.getPrice()).thenReturn(new BigDecimal(50000.0));
		
		assertEquals(0, ApartmentRater.rateApartment(apart));
		
	}
	
	@Test
	void betweenCheapAndModerateThreshold() {
		
		Apartment apart = mock(Apartment.class);
		when(apart.getArea()).thenReturn(2.0);
		when(apart.getPrice()).thenReturn(new BigDecimal(14000.0));
		
		assertEquals(1, ApartmentRater.rateApartment(apart));
		
	}
	
	@Test
	void expensiveTest() {
		
		Apartment apart = mock(Apartment.class);
		when(apart.getArea()).thenReturn(20.0);
		when(apart.getPrice()).thenReturn(new BigDecimal(300000.0));
		
		assertEquals(2,ApartmentRater.rateApartment(apart));
		
	}
	
	@Test
	void averageRatingEmpty() {
		 
		List<Apartment> list = new ArrayList<>();
		
		assertThrows(RuntimeException.class, () -> ApartmentRater.calculateAverageRating(list));
		
	}
	
	@Test
	void sumRatingsTest() {
		 
		List<Apartment> list = new ArrayList<>();
		
		Apartment apart1 = new Apartment(20.0,new BigDecimal(300000.0));
		Apartment apart2 = new Apartment(2.0,new BigDecimal(14000.0));
		
		list.add(apart1);
		list.add(apart2);
		
		assertEquals(1.5, ApartmentRater.calculateAverageRating(list));
		
	}
	

}
