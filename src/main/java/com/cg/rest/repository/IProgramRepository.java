package com.cg.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.model.Program;

@Repository
public interface IProgramRepository extends JpaRepository<Program, Long>{

}
