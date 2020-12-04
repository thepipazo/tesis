package com.tesis.services;

import java.util.List;
import com.tesis.entidad.PlanAnual;

public interface PlanAnualServicio {

	public PlanAnual GuardarPlanAnual(PlanAnual plananual);
	public List<PlanAnual>ListarPlanAnuals();
	public PlanAnual ListarPlanAnualPorId(Long id);
	public void EliminarPlanAnual(Long id);
}
