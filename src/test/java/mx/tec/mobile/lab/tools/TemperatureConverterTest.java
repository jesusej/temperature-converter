package mx.tec.mobile.lab.tools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mx.tec.mobile.lab.vo.Temperature;

class TemperatureConverterTest {
    TemperatureConverter temperatureConverter = new TemperatureConverter();
    
    @Test
    void testConvertCelsius0ToCelsius() {
        // Given
        Temperature input = new Temperature(0, 0, Temperature.Unit.CELSIUS);
        
        // When
        Temperature result = temperatureConverter.convert(input, Temperature.Unit.CELSIUS);
        
        // Then
        Temperature expected = new Temperature(0, 0, Temperature.Unit.CELSIUS);
        assertEquals(expected, result);
    }
    
    @Test
    void testConvertFahrenheit0ToFahrenheit() {
        // Given
        Temperature input = new Temperature(0, 0, Temperature.Unit.FAHRENHEIT);
        
        // When
        Temperature result = temperatureConverter.convert(input, Temperature.Unit.FAHRENHEIT);
        
        // Then
        Temperature expected = new Temperature(0, 0, Temperature.Unit.FAHRENHEIT);
        assertEquals(expected, result);
    }

    @Test
    void testConvertCelsius0ToFahrenheit() {
        // Given
        Temperature input = new Temperature(0, 0, Temperature.Unit.CELSIUS);
        
        // When
        Temperature result = temperatureConverter.convert(input, Temperature.Unit.FAHRENHEIT);
        
        // Then
        Temperature expected = new Temperature(0, 32, Temperature.Unit.FAHRENHEIT);
        assertEquals(expected, result);    	
    }

    @Test
    void testConvertFahrenheit68ToCelsius() {
        // Given
        Temperature input = new Temperature(0, 68, Temperature.Unit.FAHRENHEIT);
        
        // When
        Temperature result = temperatureConverter.convert(input, Temperature.Unit.CELSIUS);
        
        // Then
        Temperature expected = new Temperature(0, 20, Temperature.Unit.CELSIUS);
        assertEquals(expected, result);       	
    }
}