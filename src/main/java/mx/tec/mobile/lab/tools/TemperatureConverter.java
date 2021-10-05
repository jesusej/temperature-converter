package mx.tec.mobile.lab.tools;

import org.springframework.stereotype.Service;

import mx.tec.mobile.lab.vo.Temperature;

@Service
public class TemperatureConverter {
    public Temperature convert(Temperature temperature, Temperature.Unit unitToConvert) {
        if (temperature.getUnit() == Temperature.Unit.CELSIUS && unitToConvert == Temperature.Unit.FAHRENHEIT) {
            float convertedValue = (temperature.getValue() * 9/5) + 32;
            return new Temperature(0, convertedValue, unitToConvert);
        } else if (temperature.getUnit() == Temperature.Unit.FAHRENHEIT && unitToConvert == Temperature.Unit.CELSIUS) {
            float convertedValue = (temperature.getValue() - 32) * 5/9;
            return new Temperature(0, convertedValue, unitToConvert);
        } else {
            return new Temperature(0, temperature.getValue(), temperature.getUnit());
        }        
    }
}