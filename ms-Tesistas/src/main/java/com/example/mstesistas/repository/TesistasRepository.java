package com.example.mstesistas.repository;

import com.example.mstesistas.entity.Tesistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesistasRepository extends JpaRepository<Tesistas, Long> {
}
