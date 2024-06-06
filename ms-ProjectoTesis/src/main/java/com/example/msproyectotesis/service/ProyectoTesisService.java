package com.example.msproyectotesis.service;

import com.example.msproyectotesis.entity.ProyectoTesis;

import java.util.List;
import java.util.Optional;

public interface ProyectoTesisService {

    public List<ProyectoTesis> listar();
    public ProyectoTesis guardar(ProyectoTesis proyectoTesis);
    public ProyectoTesis actualizar(ProyectoTesis proyectoTesis);
    public Optional<ProyectoTesis> listarPorId(Long id);
    public void eliminarPorId(Long id);
}