package com.devsuperior.aulajparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.aulajparepository.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
//	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
//	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
//	@Query("SELECT obj FROM User obj WHERE obj.name = :name")
//	Page<User> serchName(String name, Pageable pageable);
	
	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> serchName(String name, Pageable pageable);
	
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
	Page<User> findByNameIgnoreCase(String name, Pageable pageable);
	
	
}
