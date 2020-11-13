package com.cg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.rest.model.Program;

public interface IProgramRepository extends JpaRepository<Program, Long> {

}
