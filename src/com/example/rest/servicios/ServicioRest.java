package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.CursoModel;
import com.example.rest.dao.EvaluacionModel;
import com.example.rest.dao.NotaModel;
import com.example.rest.dao.RolModel;
import com.example.rest.dao.UsuarioModel;
import com.example.rest.dao.UsuarioxCursoModel;

import om.example.rest.entidades.Curso;
import om.example.rest.entidades.Nota;
import om.example.rest.entidades.Rol;
import om.example.rest.entidades.Usuario;
import om.example.rest.entidades.UsuarioxCurso;


//GET,POST,PUT,DELETE métodos del protocolo HTTP
	// La tecnología rest utiliza estos cuatro métodos
	// GET--->se va realiza un select
	// POST--->se va realiza un registrar
	// PUT--->se va realiza un actualizar
	// DELETE--->se va realiza un eliminar

@Path("/servicios")
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	

	private RolModel daoRol = new RolModel();


	private UsuarioModel daoUsuario= new UsuarioModel();
	private CursoModel daoCurso= new CursoModel();
	private UsuarioxCursoModel daoUsuxCurso= new UsuarioxCursoModel();
	private NotaModel daoNota = new NotaModel();
	private EvaluacionModel daoEvalua= new EvaluacionModel();
	
	//
	@GET
	@Path("/alumnoxCurso")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarusuarioXcurso() {
		log.info("listarAlumnoXcurso rest ");
		return Response.ok(daoUsuxCurso.listarAlumnoXCurso()).build();
	}
	@GET
	@Path("/docentexCurso")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listardocenteXcurso() {
		log.info("listardocenteXcurso rest ");
		return Response.ok(daoUsuxCurso.listarDocenteXCurso()).build();
	}
	@POST
	   @Path("/usuarioxCurso/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarusuarioXcurso(UsuarioxCurso bean) {
		return daoUsuxCurso.insertaUsuarioxCurso(bean);
	}
	
	@PUT
	   @Path("/usuarioxCurso/update")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int actualizarusuarioXcurso(UsuarioxCurso bean) {
		return daoUsuxCurso.actualizaUsuarioxCurso(bean);
	}
	
	@GET
	@Path("/nota")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarNota() {
		log.info("listarNota rest ");
		return Response.ok(daoNota.listarNota()).build();
	}
	
	@POST
	   @Path("/nota/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarNota(Nota bean) {
		return daoNota.insertaNota(bean);
	}
	
	@PUT
	   @Path("/nota/update")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int actualizarNota(Nota bean) {
		return daoNota.actualizaNota(bean);
	}
	
	@GET
	@Path("/curso")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarCurso() {
		log.info("listarAlumno rest ");
		return Response.ok(daoCurso.listarCurso()).build();
	}
	
	@POST
	   @Path("/curso/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarCurso(Curso bean) {
		return daoCurso.insertaCurso(bean);
	}
	
	@PUT
	   @Path("/curso/update")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int actualizarCurso(Curso bean) {
		return daoCurso.actualizaCurso(bean);
	}
	
	@GET
	@Path("/alumno")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarAlumno() {
		log.info("listarAlumno rest ");
		return Response.ok(daoUsuario.listarAlumno()).build();
	}
	@GET
	@Path("/docente")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarDocente() {
		log.info("listarAlumno rest ");
		return Response.ok(daoUsuario.listarDocente()).build();
	}
	
	@POST
	   @Path("/usuario/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarUsuario(Usuario bean) {
		return daoUsuario.insertaUsuario(bean);
	}
	
	@PUT
	   @Path("/usuario/update")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int actualizarUsuario(Usuario bean) {
		return daoUsuario.actualizaUsuario(bean);
	}
	
	@GET
	@Path("/usuario/{dni}/{password}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response ingresoUsuario(@PathParam("dni") String dni,@PathParam("password") String pass) {
		log.info("ingresoUsuario rest ");
		return Response.ok(daoUsuario.ingresoUsuario(dni, pass)).build();
	}
	
	@GET
	@Path("/usuarioCurso/{idcurso}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultaUsuarioDeUnCurso(@PathParam("idcurso") int idCurso) {
		log.info("consultaUsuarioDeUnCurso rest ");
		return Response.ok(daoUsuxCurso.consultaUsuarioDeUnCurso(idCurso)).build();
	}
	
	@GET
	@Path("/rol")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarRol() {
		log.info("listarRol rest ");
		return Response.ok(daoRol.listaRol()).build();
	}
	
	@GET
	@Path("/evaluacion")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarEvaluacion() {
		log.info("listarEvaluacion rest ");
		return Response.ok(daoEvalua.listaEvaluacion()).build();
	}
	
	@POST
	   @Path("/rol/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarRol(Rol bean) {
		System.out.println("aqui bb");
		return daoRol.insertaRol(bean);
	}
	
	
	
	
	

}