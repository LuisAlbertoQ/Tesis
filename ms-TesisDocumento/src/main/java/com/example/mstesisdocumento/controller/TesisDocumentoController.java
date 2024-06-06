package com.example.mstesisdocumento.controller;

import com.example.mstesisdocumento.entity.TesisDocumento;
import com.example.mstesisdocumento.service.TesisDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tesis")
public class TesisDocumentoController{

    @Autowired
    private TesisDocumentoService tesisDocumentoService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("idProyecto") Long idProyecto) {
        try {
            tesisDocumentoService.saveFile(file, idProyecto);
            return ResponseEntity.status(HttpStatus.OK).body("Archivo Subido Exitosamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo en Subir el Archivo");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<TesisDocumento>> listDocuments() {
        List<TesisDocumento> documentos = tesisDocumentoService.listarDocumentos();
        return ResponseEntity.ok().body(documentos);
    }

    @GetMapping("/download/{idDocumento}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long idDocumento) {
        TesisDocumento tesisDocumento = tesisDocumentoService.getFile(idDocumento);
        if (tesisDocumento != null) {
            try {
                File file = new File(tesisDocumento.getRutaArchivo());
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] data = fileInputStream.readAllBytes();
                fileInputStream.close();

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + tesisDocumento.getNombreDocumento() + "\"")
                        .header(HttpHeaders.CONTENT_TYPE, tesisDocumento.getTipoArchivo())
                        .body(data);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}