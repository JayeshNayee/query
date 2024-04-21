package com.practiceofoneTomany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "staticNameOfChildEntity")
@NoArgsConstructor
@Entity

public class childEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ansId;
	private String firstAns;
	private String secondAns;
	private String thirdAns;

	

}
