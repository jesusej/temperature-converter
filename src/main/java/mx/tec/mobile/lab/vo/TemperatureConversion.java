package mx.tec.mobile.lab.vo;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TemperatureConversion {
	@Id
	@GeneratedValue	
	private long id;
    
	@JsonFormat(pattern="yyyy-M-dd",timezone = "GMT-6")
	private Calendar created;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "original_temp_id", referencedColumnName = "id")
    private Temperature original;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "converted_temp_id", referencedColumnName = "id")
	private Temperature converted;
    
	public TemperatureConversion() {
	}

	public TemperatureConversion(long id, Calendar created, Temperature original, Temperature converted) {
		this.id = id;
		this.created = created;
		this.original = original;
		this.converted = converted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public Temperature getOriginal() {
		return original;
	}

	public void setOriginal(Temperature original) {
		this.original = original;
	}

	public Temperature getConverted() {
		return converted;
	}

	public void setConverted(Temperature converted) {
		this.converted = converted;
	}

}