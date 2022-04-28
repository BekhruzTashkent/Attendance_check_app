package com.example.table_connection.repository;

import com.example.table_connection.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.table_connection.repository.UniversityRepository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
