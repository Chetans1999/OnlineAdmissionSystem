package com.cg.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	public List<Application> findByEmailId(String emailId);

	public List<Application> findByApplicationStatus(String applicationStatus);

	
}
