package com.stockmarket.stockpro.Repository;

import com.stockmarket.stockpro.Entities.StockExchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;
@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {

	
}

