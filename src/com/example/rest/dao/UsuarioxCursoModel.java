package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.util.ConectaDB;

import om.example.rest.entidades.Curso;
import om.example.rest.entidades.Rol;
import om.example.rest.entidades.Usuario;
import om.example.rest.entidades.UsuarioxCurso;



public class UsuarioxCursoModel {
private static final Log log = LogFactory.getLog(UsuarioxCursoModel.class);
	
	
	public List<UsuarioxCurso> listarAlumnoXCurso() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<UsuarioxCurso> lista = new ArrayList<UsuarioxCurso>();
		try {
			String sql = "select uc.idusuarioxcurso, u.idusuario,u.dni,u.password,u.nombre,u.apellido,u.celular,u.correo,r.idrol, r.descripcion, c.idcurso, c.descripcion  from usuarioxcurso uc inner join usuario u on uc.idusuario=u.idusuario inner join rol r on u.idrol =r.idrol inner join curso c on uc.idcurso=c.idcurso where r.idrol=2;";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			UsuarioxCurso bean = null;
			
			while(rs.next()){
				bean = new UsuarioxCurso();
				bean.setIdUsuarioxcurso(rs.getInt(1));
				Usuario obj1= new Usuario();
				obj1.setIdUsuario(rs.getInt(2));
				obj1.setDni(rs.getString(3));
				obj1.setPassword(rs.getString(4));
				obj1.setNombre(rs.getString(5));
				obj1.setApellido(rs.getString(6));
				obj1.setCelular(rs.getString(7));
				obj1.setCorreo(rs.getString(8));
				Rol obj = new Rol();
				obj.setIdRol(rs.getInt(9));
				obj.setDescripcion(rs.getString(10));
				obj1.setRol(obj);
				bean.setUsuario(obj1);
				Curso obj2= new Curso();
				obj2.setIdCurso(rs.getInt(11));
				obj2.setDescripcion(rs.getString(12));
				bean.setCurso(obj2);
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	
	public List<UsuarioxCurso> listarDocenteXCurso() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<UsuarioxCurso> lista = new ArrayList<UsuarioxCurso>();
		try {
			String sql = "select uc.idusuarioxcurso, u.idusuario,u.dni,u.password,u.nombre,u.apellido,u.celular,u.correo,r.idrol, r.descripcion, c.idcurso, c.descripcion  from usuarioxcurso uc inner join usuario u on uc.idusuario=u.idusuario inner join rol r on u.idrol =r.idrol inner join curso c on uc.idcurso=c.idcurso where r.idrol=1;";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			UsuarioxCurso bean = null;
			
			while(rs.next()){
				bean = new UsuarioxCurso();
				bean.setIdUsuarioxcurso(rs.getInt(1));
				Usuario obj1= new Usuario();
				obj1.setIdUsuario(rs.getInt(2));
				obj1.setDni(rs.getString(3));
				obj1.setPassword(rs.getString(4));
				obj1.setNombre(rs.getString(5));
				obj1.setApellido(rs.getString(6));
				obj1.setCelular(rs.getString(7));
				obj1.setCorreo(rs.getString(8));
				Rol obj = new Rol();
				obj.setIdRol(rs.getInt(9));
				obj.setDescripcion(rs.getString(10));
				obj1.setRol(obj);
				bean.setUsuario(obj1);
				Curso obj2= new Curso();
				obj2.setIdCurso(rs.getInt(11));
				obj2.setDescripcion(rs.getString(12));
				bean.setCurso(obj2);
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	
	public int insertaUsuarioxCurso(UsuarioxCurso obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into usuarioxcurso values(null,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, obj.getIdcurso());
			pstm.setInt(2, obj.getIdusuario());
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
	
	public int actualizaUsuarioxCurso(UsuarioxCurso obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update usuarioxcurso set idcurso =?, idusuario =? where idusuarioxcurso=? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdcurso());
			pstm.setInt(2, obj.getIdusuario());
			pstm.setInt(3, obj.getIdUsuarioxcurso());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
	
	public List<UsuarioxCurso> consultaUsuarioDeUnCurso(int idcurso) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<UsuarioxCurso> lista = new ArrayList<UsuarioxCurso>();
		try {
			String sql = "select uc.idusuarioxcurso, u.idusuario, u.nombre, u.apellido, u.dni, u.correo, c.idcurso,c.descripcion  from  usuarioxcurso uc inner join usuario u on uc.idusuario = u.idusuario inner join curso c on uc.idcurso = c.idcurso where u.idrol=2 and c.idcurso = ?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idcurso);
			
			log.info(pstm);
			rs = pstm.executeQuery();
			UsuarioxCurso bean = null;
			while(rs.next()){
				bean = new UsuarioxCurso();
				bean.setIdUsuarioxcurso(rs.getInt(1));
				Usuario obj1= new Usuario();
				obj1.setIdUsuario(rs.getInt(2));
				obj1.setNombre(rs.getString(3));
				obj1.setApellido(rs.getString(4));
				obj1.setDni(rs.getString(5));
				obj1.setCorreo(rs.getString(6));
				bean.setUsuario(obj1);
				Curso obj2= new Curso();
				obj2.setIdCurso(rs.getInt(7));
				obj2.setDescripcion(rs.getString(8));
				bean.setCurso(obj2);
				lista.add(bean);
				
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	


}
