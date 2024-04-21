package com.practiceofoneTomany.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practiceofoneTomany.Dto.childDto;
import com.practiceofoneTomany.Dto.parentDto;
import com.practiceofoneTomany.Repositry.Respositry;
import com.practiceofoneTomany.entity.childEntity;
import com.practiceofoneTomany.entity.parentEntity;
import com.practiceofoneTomany.helper.convertter;
import com.practiceofoneTomany.services.serviceInterFace;

@Component
public class serviceImple implements serviceInterFace {

	@Autowired
	private Respositry repoObj;

	@Autowired
	private convertter convertterObj;

	@Override
	public List<parentDto> getAllData() {

		List<parentEntity> all = (List<parentEntity>) repoObj.findAll();

		List<parentDto> ansOfParentDto = new ArrayList<>();

		for (parentEntity parentEntity : all) {
			List<childEntity> allChildEntities = parentEntity.getChildEntity1();

			List<childDto> childDtos = new ArrayList<>();

			for (childEntity childEntityObj : allChildEntities) {
				childDto staticNameOfchildDto = childDto.staticNameOfchildDto(childEntityObj.getAnsId(),
						childEntityObj.getFirstAns(), childEntityObj.getSecondAns(), childEntityObj.getThirdAns());
				childDtos.add(staticNameOfchildDto);
			}
			parentDto ParentDto1 = parentDto.staticNameOfParentDto(parentEntity.getId(), parentEntity.getFirst(),
					childDtos);
			ansOfParentDto.add(ParentDto1);
		}

		return ansOfParentDto;

	}

	@Override
	public String saveData(parentDto parentDto1) {

		List<childEntity> childEntities = new ArrayList<>();

		List<childDto> childDto1 = parentDto1.getChildDto1();

		for (childDto childDto : childDto1) {
			childEntity staticNameOfChildEntity = childEntity.staticNameOfChildEntity(childDto.getAnsId(),
					childDto.getFirstAns(), childDto.getSecondAns(), childDto.getThirdAns());
			childEntities.add(staticNameOfChildEntity);
		}

		parentEntity staticNameOfParentEntity = parentEntity.staticNameOfParentEntity(parentDto1.getId(),
				parentDto1.getFirst(), childEntities);

		repoObj.save(staticNameOfParentEntity);
		return "Data wil be saved";
	}

	@Override
	public parentDto getDataByid(Long id) {

		Optional<parentEntity> byId = repoObj.findById(id);
		List<childDto> childList = new ArrayList<>();

		if (byId.isPresent()) {
			parentEntity parentEntity = byId.get();

			List<childEntity> allChildData = parentEntity.getChildEntity1();

			for (childEntity childEntity : allChildData) {
				childDto staticNameOfchildDto = childDto.staticNameOfchildDto(childEntity.getAnsId(),
						childEntity.getFirstAns(), childEntity.getSecondAns(), childEntity.getThirdAns());
				childList.add(staticNameOfchildDto);
			}
			parentDto staticNameOfParentDto = parentDto.staticNameOfParentDto(id, parentEntity.getFirst(), childList);
			return staticNameOfParentDto;

		} else {

			return null;
		}

	}

	@Override
	public String deleteAllData() {
		repoObj.deleteAll();

		return "ALL data will be deleted";
	}

	@Override
	public String deleteById(Long id) {
		repoObj.deleteById(id);
		return "One row will be deleted..";
	}

	@Override
	public String updateData(parentDto pDto, Long id) {

		
		  Optional<parentEntity> byId = repoObj.findById(id);
		  
		  List<childEntity> emptyChildEntities = new ArrayList<>();
		  
		  if (byId.isPresent()) { parentEntity parentEntity1 = byId.get();
		  
		  List<childDto> allChildDtosData = pDto.getChildDto1();
		  
		  for (childDto childDto : allChildDtosData) {
		  
		  childEntity staticNameOfChildEntity =
		  childEntity.staticNameOfChildEntity(childDto.getAnsId(),
		  childDto.getFirstAns(), childDto.getSecondAns(), childDto.getThirdAns());
		  emptyChildEntities.add(staticNameOfChildEntity); } parentEntity
		  staticNameOfParentEntity = parentEntity.staticNameOfParentEntity(id,
		  parentEntity1.getFirst(), emptyChildEntities);
		  repoObj.save(staticNameOfParentEntity);
		  
		  return "Data will be updated";
		  
		  } else { return "please enter valid id"; }
		 

		/*
		 * Optional<parentEntity> byId = repoObj.findById(id); if(byId.isPresent()) {
		 * parentEntity parentEntity = byId.get();
		 * 
		 * List<childDto>childList = new ArrayList<>();
		 * 
		 * List<childDto> childEntity = pDto.getChildDto1();
		 * 
		 * for (childDto childEntity1 : childEntity) {
		 * 
		 * childDto childDtoStaticName =
		 * childEntity1.staticNameOfchildDto(childEntity1.getAnsId(),
		 * childEntity1.getFirstAns(), childEntity1.getSecondAns(),
		 * childEntity1.getThirdAns());
		 * 
		 * System.out.println("childDtoStaticNAme "+ childDtoStaticName);
		 * childList.add(childDtoStaticName);
		 * System.out.println("AnsId "+childEntity1.getAnsId()); }
		 * 
		 * parentDto staticNameOfParentDto = parentDto.staticNameOfParentDto(id,
		 * pDto.getFirst(), childList);
		 * 
		 * 
		 * parentEntity dtoToEntityConvertter =
		 * convertterObj.dtoToEntityConvertter(staticNameOfParentDto);
		 * System.out.println("sssssssssssssss "+convertterObj.dtoToEntityConvertter(
		 * staticNameOfParentDto)); repoObj.save(dtoToEntityConvertter);
		 * System.out.println(" ---"+parentEntity); return "Update will be done"; }else
		 * {
		 * 
		 * return "Please enter valid id"; }
		 */

	}

}
