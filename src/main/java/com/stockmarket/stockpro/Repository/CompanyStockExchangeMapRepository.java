package com.stockmarket.stockpro.Repository;

// import javax.persistence.Query;

import com.stockmarket.stockpro.Entities.CompanyStockExchangeMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;
@Repository
public interface CompanyStockExchangeMapRepository extends JpaRepository<CompanyStockExchangeMap, Long> {

	
	
   
	
}

