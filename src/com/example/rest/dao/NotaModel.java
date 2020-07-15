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
import om.example.rest.entidades.Evaluacion;
import om.example.rest.entidades.Nota;
import om.example.rest.entidades.Usuario;



public class NotaModel {
private static final Log log = LogFactory.getLog(NotaModel.class);
	
	
	public List<Nota> listarNota() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Nota> lista = new ArrayList<Nota>();
		try {
			String sql = "select n.idnota,n.descripcion,e.idevaluacion, e.descripcion,c.idcurso,c.descripcion, u.idusuario,u.dni, u.password,u.nombre,u.apellido,u.celular,u.correo from nota n inner join curso c on n.idcurso = c.idcurso inner join usuario u on n.idusuario = u.idusuario inner join evaluacion e on n.idevaluacion = e.idevaluacion";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Nota bean = null;
			
			while(rs.next()){
				bean = new Nota();
				bean.setIdNota(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				
				Evaluacion obj3 = new Evaluacion();
				obj3.setIdEvaluacion(rs.getInt(3));
				obj3.setDescripcion(rs.getString(4));
				bean.setEvaluacion(obj3);
				
				Curso obj1= new Curso();
				obj1.setIdCurso(rs.getInt(5));
				obj1.setDescripcion(rs.getString(6));
				bean.setCurso(obj1);
				
				Usuario obj2= new Usuario();
				obj2.setIdUsuario(rs.getInt(7));
				obj2.setDni(rs.getString(8));
				obj2.setPassword(rs.getString(9));
				obj2.setNombre(rs.getString(10));
				obj2.setApellido(rs.getString(11));
				obj2.setCelular(rs.getString(12));
				obj2.setCorreo(rs.getString(13));
				bean.setUsuario(obj2);
				
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

	
	public int insertaNota(Nota obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into nota values(null,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getIdcurso());
			pstm.setInt(3, obj.getIdusuario());
			pstm.setInt(4, obj.getIdevalucion());
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
	
	public int actualizaNota(Nota obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update Nota set descripcion=?, idcurso =?, idusuario =?, idevaluacion =? where idnota =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getIdcurso());
			pstm.setInt(3, obj.getIdusuario());
			pstm.setInt(4, obj.getIdevalucion());
			pstm.setInt(5, obj.getIdNota());
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


}
