package com.example.mstesisdocumento.service;


import com.example.mstesisdocumento.entity.TesisDocumento;
import com.example.mstesisdocumento.repository.TesisDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TesisDocumentoService {

    @Autowired
    private TesisDocumentoRepository tesisDocumentoRepository;

    private final String uploadDir = "uploads/";

    public TesisDocumento saveFile(MultipartFile file, Long idProyecto) throws IOException {
        // Crear el directorio de carga si no existe
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        TesisDocumento tesisDocumento = new TesisDocumento();
        tesisDocumento.setIdProyecto(idProyecto);
        tesisDocumento.setNombreDocumento(fileName);
        tesisDocumento.setTipoArchivo(file.getContentType());
        tesisDocumento.setRutaArchivo(filePath.toString());

        return tesisDocumentoRepository.save(tesisDocumento);
    }

    public TesisDocumento getFile(Long idDocumento) {
        return tesisDocumentoRepository.findById(idDocumento).orElse(null);
    }
}