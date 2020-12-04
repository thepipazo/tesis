package com.tesis.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.entidad.PlanAnual;
import com.tesis.repositorio.PlanAnualRepositorio;
import com.tesis.services.PlanAnualServicio;

@Service
public class PlanAnualImplement implements PlanAnualServicio {

	@Autowired
	private PlanAnualRepositorio pr;
	
	@Override
	public PlanAnual GuardarPlanAnual(PlanAnual plananual) {
		return pr.save(plananual) ;
	}

	@Override
	public List<PlanAnual> ListarPlanAnuals() {
		return pr.findAll();
	}

	@Override
	public PlanAnual ListarPlanAnualPorId(Long id) {
		return pr.findById(id).orElse(null);
	}

	@Override
	public void EliminarPlanAnual(Long id) {
		pr.deleteById(id);
	}

}
