package com.practiceofoneTomany.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "staticNameOfParentEntity")
@NoArgsConstructor
@Entity
public class parentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "foregin_key", nullable = false)
	private List<childEntity> childEntity1;
	

}
