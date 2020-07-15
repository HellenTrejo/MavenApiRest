package com.example.rest.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.util.ConectaDB;

import om.example.rest.entidades.Rol;
import om.example.rest.entidades.Usuario;



public class UsuarioModel {
private static final Log log = LogFactory.getLog(UsuarioModel.class);
	
	
	public List<Usuario> listarAlumno() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			String sql = "select u.idusuario,u.dni, u.password, u.nombre, u.apellido, u.celular, u.correo, r.idrol,r.descripcion from usuario u inner join rol r on u.idrol =r.idrol where u.idrol=2";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Usuario bean = null;
			
			while(rs.next()){
				bean = new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApellido(rs.getString(5));
				bean.setCelular(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				Rol obj = new Rol();
				obj.setIdRol(rs.getInt(8));
				obj.setDescripcion(rs.getString(9));
				bean.setRol(obj);
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

	public List<Usuario> listarDocente() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			String sql = "select u.idusuario,u.dni, u.password, u.nombre, u.apellido, u.celular, u.correo, r.idrol,r.descripcion from usuario u inner join rol r on u.idrol =r.idrol where u.idrol=1";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Usuario bean = null;
			
			while(rs.next()){
				bean = new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApellido(rs.getString(5));
				bean.setCelular(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				Rol obj = new Rol();
				obj.setIdRol(rs.getInt(8));
				obj.setDescripcion(rs.getString(9));
				bean.setRol(obj);
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
	
	public int insertaUsuario(Usuario obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into usuario values(null,?,?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, obj.getDni());
			pstm.setString(2, obj.getPassword());
			pstm.setString(3, obj.getNombre());
			pstm.setString(4, obj.getApellido());
			pstm.setString(5, obj.getCelular());
			pstm.setString(6, obj.getCorreo());
			pstm.setInt(7, obj.getIdrol());
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
	
	public int actualizaUsuario(Usuario obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update usuario set dni =?, password =?, nombre =?, apellido =?, celular =?, correo=?, idrol=? where idusuario =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDni());
			pstm.setString(2, obj.getPassword());
			pstm.setString(3, obj.getNombre());
			pstm.setString(4, obj.getApellido());
			pstm.setString(5, obj.getCelular());
			pstm.setString(6, obj.getCorreo());
			pstm.setInt(7, obj.getIdrol());
			pstm.setInt(8, obj.getIdUsuario());
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
	
	public List<Usuario> ingresoUsuario(String dni,String pass) {
		Connection conn = null;
		CallableStatement pstm = null;
		ResultSet rs = null;
		
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			String sql = "call sp_ingresoUsuario(?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareCall(sql);
			pstm.setString(1, dni);
			pstm.setString(2, pass);
			log.info(pstm);
			rs = pstm.executeQuery();
			Usuario bean = null;
			while(rs.next()){
				bean = new Usuario();
				bean.setIdUsuario(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApellido(rs.getString(5));
				bean.setCelular(rs.getString(6));
				bean.setCorreo(rs.getString(7));
				Rol obj = new Rol();
				obj.setIdRol(rs.getInt(8));
				obj.setDescripcion(rs.getString(9));
				bean.setRol(obj);
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
