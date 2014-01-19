package com.waffles.tablemap;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestTableMap {

	private TableMap<Car, Integer, Double> carsAndYearsToCostMap
	
	private class Car {
		String make;
		String model;
		int year;
		
		private Car(String make, String model, String year) {
			this.make = make;
			this.model = model;
			this.year = year;
		}
	} 
	
	@Test
	public void testTableMap() {
		// insert some fields
		Car audi2006 = new Car("Audi", "Machine", 2006);
		Car audi2008 = new Car("Audi", "Other Machine", 2008);
		Car pontiac2002 = new Car("Pontiac", "Grand Prix", 2002);
		Car fordfiso1998 = new Car("Ford", "F150", 1998); // F150 looks like FISO
		
		carsAndYearsToCostMap.set(audi2006, audi2006.year, 13458.24);
		carsAndYearsToCostMap.set(audi2008, audi2008.year, 15210.49);
		carsAndYearsToCostMap.set(pontiac2002, pontiac2002.year, 4048.10);
		carsAndYearsToCostMap.set(fordfiso1998, fordfiso1998.year, 9286.07);
		
		assertEquals(13458.24, carsAndYearsToCostMap.get(audi2006, audi2006.year));
		assertEquals(15210.49, carsAndYearsToCostMap.get(audi2008, audi2008.year));
		assertEquals(13458.24, carsAndYearsToCostMap.get(audi2006, audi2006.year));
		assertEquals(13458.24, carsAndYearsToCostMap.get(audi2006, audi2006.year));
		
		assertEquals(null, carsAndYearsToCostMap.get(audi2006, audi2008.year));
		assertEquals(null, carsAndYearsToCostMap.get(audi2008, audi2006.year));
		
		assertEquals(null, carsAndYearsToCostMap.get(null, null));
	}
}