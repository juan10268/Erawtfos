package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.EmpleadoDto;
import manager.EmpleadoManager;

public class EmpleadoServiceWS {
	EmpleadoManager empleadoManager= new EmpleadoManager();
	
	@POST
	@Path("/agregarempleado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean agregarEmpleado(EmpleadoDto empleadoDto) throws Exception{
		return empleadoManager.agregar(empleadoDto);		
	}
	@GET
	@Path("/eliminarempleado/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean eliminarEmpleado(@PathParam("id") Integer id, EmpleadoDto empleadoDto) throws Exception{
		return empleadoManager.eliminar(empleadoDto);
	}
}
