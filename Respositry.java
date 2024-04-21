package com.query.repositry;

import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.query.entity.queryEntity;

import jakarta.transaction.Transactional;

@Repository
public interface Respositry extends CrudRepository<queryEntity, Long>{
	
	 /*********************Save Data**********************/
	@Transactional
	@Modifying
	@Query(value =" Insert into query_entity(address, name)values(:address,:name)" ,nativeQuery   = true)
	Integer saveData( @Param("address")String name, @Param("name") String address);
	
	
	
	 /*********************Delete By Id*********************/
	
	@Modifying
	@Transactional
	@Query(value = "delete from queryEntity where id =:id1 ")
	Integer deleteByid(@Param("id1")Long id);
	
	
	
	 /*********************Update Data**********************/
	@Modifying
	@Transactional
	@Query(value = "UPDATE queryEntity quE  SET quE.id =:idValue, quE.address =:addreddValues, quE.name=:nameValue WHERE quE.id =:idValue")
	Integer updateDataById(@Param("idValue")Long id, @Param("addreddValues") String address, @Param("nameValue") String name);
	
	
	
	 /*********************Delete By id **********************/
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM queryEntity")
	Integer deleALLData();
	
	
	 /*********************Get all Data**********************/
	@Modifying
	@Transactional
	//@Query(value = "SELECT * FROM queryEntity",nativeQuery = true)
	@Query("SELECT s FROM queryEntity s")    // jpql query
	List<queryEntity> getAllData();
	
	

	 /*********************get Data By Id**********************/
	@Transactional
	@Query(value = "SELECT s FROM queryEntity s WHERE s.id=:id1 ")
	queryEntity getDataByid(@Param("id1")Long id);
	
	
	
	
	 /*********************get Data By Name**********************/
	@Modifying
	@Transactional
	@Query(value = "SELECT * FROM query_entity  WHERE name LIKE '%a' ",nativeQuery = true)
	List<queryEntity> getDataByName();
	
	
	 /*********************getData ByName And Address**********************/
	//@Modifying
	@Transactional
	@Query(value = "SELECT * FROM query_entity WHERE name='Keyur' AND address= 'Rajkot' ",nativeQuery = true)
	queryEntity getDataByNameAndAddress();
	
	
	 /*************************Get only name ******************/
	
	@Transactional
	@Query(value = "SELECT name FROM query_entity  WHERE name LIKE '%L' ",nativeQuery = true)
	List<String> getDataByNamechar();
//	
//	@Modifying
//	@Transactional
//	@Query(value = "SELECT count(id) from query_entity")
//	Integer getNumbersOfRow();
//	
	
	
	
	
}
