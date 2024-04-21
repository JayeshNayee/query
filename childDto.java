package com.practiceofoneTomany.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "staticNameOfchildDto")
@NoArgsConstructor
@Data
public class childDto {
	
	private Long ansId;
	private String firstAns;
	private String secondAns;
	private String thirdAns;

}
