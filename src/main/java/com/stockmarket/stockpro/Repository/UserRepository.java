package com.stockmarket.stockpro.Repository;

import com.stockmarket.stockpro.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
