package Dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
	@Data
	public class Appointment {

		@Id
		int id;
		String problem;
		LocalDateTime time;
		
		@ManyToOne
		Patient patient;

		@ManyToOne
		Doctor doctor;
		
	}
