package com.tesis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesis.entidad.AmbitoGrafico;

public interface AmbitoGraficoRepositorio extends JpaRepository<AmbitoGrafico, Long>{

	public AmbitoGrafico findByNombreAmbito(String nombre_ambito);
}
