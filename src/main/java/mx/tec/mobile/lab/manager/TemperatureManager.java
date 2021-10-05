package mx.tec.mobile.lab.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.mobile.lab.vo.TemperatureConversion;
import mx.tec.mobile.lab.repository.TemperatureConversionRepository;

@Service
public class TemperatureManager {
	@Resource
	TemperatureConversionRepository repository;

	public List<TemperatureConversion> getHistory() {
		return repository.findAll();
	}

	public void addConversionToHistory(TemperatureConversion conversion) {
		repository.save(conversion);
	}	
}