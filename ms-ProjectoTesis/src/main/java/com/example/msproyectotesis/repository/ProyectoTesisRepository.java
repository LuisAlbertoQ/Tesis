package com.example.msproyectotesis.repository;

import com.example.msproyectotesis.entity.ProyectoTesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoTesisRepository extends JpaRepository<ProyectoTesis, Long> {
}
