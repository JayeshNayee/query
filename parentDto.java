package com.practiceofoneTomany.Dto;

import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "staticNameOfParentDto")
@NoArgsConstructor
public class parentDto {
	
	private Long id;
	private String first;


	private List<childDto> childDto1;
	
}
