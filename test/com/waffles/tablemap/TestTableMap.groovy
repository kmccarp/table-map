package com.waffles.tablemap;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestTableMap
{

    private TableMap<Car, Integer, Double> carsAndYearsToCostMap;
    Car audi2006 = new Car("Audi", "Machine", 2006);
    Car audi2008 = new Car("Audi", "Other Machine", 2008);
    Car pontiac2002 = new Car("Pontiac", "Grand Prix", 2002);
    Car fordfiso1998 = new Car("Ford", "F150", 1998); // F150 looks like FISO

    @Before
    public void before() {
        // insert some fields
        carsAndYearsToCostMap = new TableMap<>([
            audi2006,
            audi2008,
            pontiac2002,
            fordfiso1998
        ], [2006, 2008, 2002, 1998], Double.class);

        carsAndYearsToCostMap.set(audi2006, audi2006.year, (Double) 13458.24);
        carsAndYearsToCostMap.set(audi2008, audi2008.year, (Double) 15210.49);
        carsAndYearsToCostMap.set(pontiac2002, pontiac2002.year, (Double) 4048.10);
        carsAndYearsToCostMap.set(fordfiso1998, fordfiso1998.year, (Double) 9286.07);
    }

    private class Car {
        String make;
        String model;
        int year;

        private Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }

    @Test
    public void testTableMap() {

        assertEquals((Double) 13458.24, carsAndYearsToCostMap.get(audi2006, audi2006.year), 0.0);
        assertEquals((Double) 15210.49, carsAndYearsToCostMap.get(audi2008, audi2008.year), 0.0);
        assertEquals((Double) 13458.24, carsAndYearsToCostMap.get(audi2006, audi2006.year), 0.0);
        assertEquals((Double) 13458.24, carsAndYearsToCostMap.get(audi2006, audi2006.year), 0.0);

        assertEquals(null, carsAndYearsToCostMap.get(audi2006, audi2008.year));
        assertEquals(null, carsAndYearsToCostMap.get(audi2008, audi2006.year));

        assertEquals(null, carsAndYearsToCostMap.get(null, null));
    }

    @Test
    public void stressTest() {
        def list = []
        for (def i = 0; i < 5000; i++) {
            list += i
        }
        TableMap<Integer, Integer, Integer> map = new TableMap(list, list, Integer.class);

        for (int i = 0; i < 5000; i++) {
            for (int j = 0; j < 5000; j++) {
                map.set(i, j, i * j);
            }
        }
    }
}