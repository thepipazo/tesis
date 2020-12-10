package com.tesis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesis.entidad.Archivo;

public interface ArchivoRepositorio extends JpaRepository<Archivo, Long> {

}
