package com.stockmarket.stockpro.Repository;

import com.stockmarket.stockpro.Entities.Company;

import org.springframework.stereotype.Repository; 

import org.springframework.data.repository.CrudRepository;
@Repository
//public interface Personjparepository2 extends JpaRepository <Person, Long> { }
public interface CompanyRespository2  extends CrudRepository<Company, Long> {
	
	
}
