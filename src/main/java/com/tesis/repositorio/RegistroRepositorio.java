package com.tesis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesis.entidad.Registro;

public interface RegistroRepositorio extends JpaRepository<Registro, Long> {

}
