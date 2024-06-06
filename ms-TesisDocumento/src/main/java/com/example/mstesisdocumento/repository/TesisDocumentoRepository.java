package com.example.mstesisdocumento.repository;

import com.example.mstesisdocumento.entity.TesisDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesisDocumentoRepository extends JpaRepository<TesisDocumento, Long> {
}