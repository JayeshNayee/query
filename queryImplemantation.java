package com.query.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.query.dto.queryDto;
import com.query.entity.queryEntity;
import com.query.helper.helper;
import com.query.interFaces.queryInterface;
import com.query.repositry.Respositry;

@Component
public  class queryImplemantation implements queryInterface {
	
	@Autowired
	private Respositry repoObj;
	
	@Autowired
	private helper helper1;
	
	@Autowired
	private Faker faker;

	@Override
	public String saveData() {	
	for(int i = 0; i<50; i++)
	{
		repoObj.saveData(faker.name().firstName(), faker.address().cityName());
	}
	
		return "Data will be saved";
	}

	@Override
	public String deleteDataById(Long id) {
	Integer deleteData =	repoObj.deleteByid(id);
		return "One row data will be deleted";
	}


	@Override
	public String deleteAllData() {
		Integer deleALLData = repoObj.deleALLData();
		return "ALL Data will be deleted ";
	}

	@Override
	public String updateDataById(queryDto queryDto, Long id) {
		
		repoObj.updateDataById(id, queryDto.getAddress(), queryDto.getName());
		
		return "Updated done";
	}

	@Override
	public List<queryDto> getAllData() {
		
			List<queryEntity> allData = repoObj.getAllData();
		// create new array list
		List<queryDto>ansList = new ArrayList<>();
		
		for (queryEntity queryEntity : allData) {
			queryDto dtoObj = helper1.entityToDto(queryEntity);
			ansList.add(dtoObj);
		}
		return ansList;
	}

	@Override
	public queryDto getDataByid(Long id) {
		
		 queryEntity queryEntity = repoObj.getDataByid(id);
		 queryDto entityToDto = helper1.entityToDto(queryEntity);
		 
		return entityToDto;
	}

	@Override
	public List<queryDto> getDataByName() {
		List<queryDto>list=new ArrayList<>();
			List<queryEntity> dataByName = repoObj.getDataByName();
			
			for (queryEntity queryEntity : dataByName) {
				
				queryDto entityToDto = helper1.entityToDto(queryEntity);
				list.add(entityToDto);
			}
		return list;
	}

	@Override
	public queryDto getDataByNameAndAddress() {
		
	     queryEntity dataByNameAndAddress = repoObj.getDataByNameAndAddress();
		
			queryDto entityToDto = helper1.entityToDto(dataByNameAndAddress);
				System.out.println("data "+entityToDto);
			return entityToDto;
	}

	@Override
	public List<String> getDataByNamechar() {
	 List<String> dataByNamechar = repoObj.getDataByNamechar();
	 
//	 List<String>ansList  = new ArrayList<>();
//		for (String string : dataByNamechar) {
//			
//		}

		return dataByNamechar;
	}

	
	


}
