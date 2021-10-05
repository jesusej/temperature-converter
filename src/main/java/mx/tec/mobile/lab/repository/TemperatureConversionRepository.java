package mx.tec.mobile.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tec.mobile.lab.vo.TemperatureConversion;

@Repository
public interface TemperatureConversionRepository extends JpaRepository<TemperatureConversion, Long> {
}