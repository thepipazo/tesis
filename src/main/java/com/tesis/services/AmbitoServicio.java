package com.tesis.services;

import java.util.List;

import com.tesis.entidad.Ambito;

public interface AmbitoServicio {

	public void GuardarAmbito(Ambito criterio);
	public List<Ambito>ListarAmbitos();
	public Ambito ListarAmbitoPorId(Long id);
	public void EliminarAmbito(Long id);
}
