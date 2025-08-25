package com.jek.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class CarTest {
    
    @Test
    public void testCarCreation() {
        Car car = new Car("ABC123", "Toyota", "Corolla", 2021, 
                         "Blue", Car.BodyType.SEDAN, 
                         Car.EngineType.GASOLINE, Car.Transmission.AUTOMATIC);
        
        assertEquals("ABC123", car.getLicensePlateNumber());
        assertEquals("Toyota", car.getMake());
        assertEquals("Corolla", car.getModel());
        assertEquals(2021, car.getYear());
        assertEquals("Blue", car.getColor());
        assertEquals(Car.BodyType.SEDAN, car.getBodyType());
        assertEquals(Car.EngineType.GASOLINE, car.getEngineType());
        assertEquals(Car.Transmission.AUTOMATIC, car.getTransmission());
    }
    
    @Test
    public void testCarSetters() {
        Car car = new Car();
        
        car.setLicensePlateNumber("XYZ789");
        car.setMake("Ford");
        car.setModel("Mustang");
        car.setYear(2022);
        car.setColor("Red");
        car.setBodyType(Car.BodyType.SEDAN);
        car.setEngineType(Car.EngineType.GASOLINE);
        car.setTransmission(Car.Transmission.MANUAL);
        
        assertEquals("XYZ789", car.getLicensePlateNumber());
        assertEquals("Ford", car.getMake());
        assertEquals("Mustang", car.getModel());
        assertEquals(2022, car.getYear());
        assertEquals("Red", car.getColor());
        assertEquals(Car.BodyType.SEDAN, car.getBodyType());
        assertEquals(Car.EngineType.GASOLINE, car.getEngineType());
        assertEquals(Car.Transmission.MANUAL, car.getTransmission());
    }
    
    @Test
    public void testCarIdAutoIncrement() {
        Car car1 = new Car("ABC123", "Toyota", "Corolla", 2021, 
                          "Blue", Car.BodyType.SEDAN, 
                          Car.EngineType.GASOLINE, Car.Transmission.AUTOMATIC);
        
        Car car2 = new Car("XYZ789", "Ford", "Mustang", 2022, 
                          "Red", Car.BodyType.SEDAN, 
                          Car.EngineType.GASOLINE, Car.Transmission.MANUAL);
        
        // Initially, carId should be null
        assertNull(car1.getCarId());
        assertNull(car2.getCarId());
        
        // Set IDs manually for testing
        car1.setCarId(1L);
        car2.setCarId(2L);
        
        assertEquals(1L, car1.getCarId());
        assertEquals(2L, car2.getCarId());
    }
    
    @Test
    public void testEnumValues() {
        // Test BodyType enum
        assertEquals(3, Car.BodyType.values().length);
        assertNotNull(Car.BodyType.valueOf("SEDAN"));
        assertNotNull(Car.BodyType.valueOf("SUV"));
        assertNotNull(Car.BodyType.valueOf("HATCHBACK"));
        
        // Test EngineType enum
        assertEquals(4, Car.EngineType.values().length);
        assertNotNull(Car.EngineType.valueOf("GASOLINE"));
        assertNotNull(Car.EngineType.valueOf("DIESEL"));
        assertNotNull(Car.EngineType.valueOf("ELECTRIC"));
        assertNotNull(Car.EngineType.valueOf("HYBRID"));
        
        // Test Transmission enum
        assertEquals(2, Car.Transmission.values().length);
        assertNotNull(Car.Transmission.valueOf("AUTOMATIC"));
        assertNotNull(Car.Transmission.valueOf("MANUAL"));
    }
}
