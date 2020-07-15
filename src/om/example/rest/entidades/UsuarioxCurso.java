package om.example.rest.entidades;

public class UsuarioxCurso {
	
	private int idUsuarioxcurso;
	
	private Curso curso;
	private Usuario usuario;
	
	private int idcurso;
	private int idusuario;
	
	
	
	public int getIdUsuarioxcurso() {
		return idUsuarioxcurso;
	}
	public void setIdUsuarioxcurso(int idUsuarioxcurso) {
		this.idUsuarioxcurso = idUsuarioxcurso;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	

}
