package mx.tec.mobile.lab.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.tec.mobile.lab.vo.Temperature;
import mx.tec.mobile.lab.vo.TemperatureConversion;
import mx.tec.mobile.lab.repository.TemperatureConversionRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TemperatureManagerTest {
	@Resource
	private TemperatureConversionRepository repository;	
	
	@Test
	void testAddConversionToHistory() {
		// Given
		TemperatureManager manager = new TemperatureManager();
		manager.repository = this.repository;
		int originalSize = manager.getHistory().size();
		
		// When
		TemperatureConversion conversion = new TemperatureConversion(
				0,
				Calendar.getInstance(), 
				new Temperature(0, 0, Temperature.Unit.CELSIUS), 
				new Temperature(0, 32, Temperature.Unit.FAHRENHEIT));
		manager.addConversionToHistory(conversion); 
		
		// Then
		int newSize = manager.getHistory().size();
		assertEquals(originalSize + 1, newSize);
		
		TemperatureConversion savedConversion = manager.getHistory().get(newSize - 1);
		assertEquals(savedConversion.getOriginal().getValue(), conversion.getOriginal().getValue());
		assertEquals(savedConversion.getOriginal().getUnit(), conversion.getOriginal().getUnit());
		assertEquals(savedConversion.getConverted().getValue(), conversion.getConverted().getValue());
		assertEquals(savedConversion.getConverted().getUnit(), conversion.getConverted().getUnit());		
		assertEquals(savedConversion.getCreated().get(Calendar.DAY_OF_YEAR), conversion.getCreated().get(Calendar.DAY_OF_YEAR));
	}

}