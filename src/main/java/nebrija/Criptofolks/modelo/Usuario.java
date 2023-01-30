package nebrija.Criptofolks.modelo;

public class Usuario {
	
	private int id_usuario;
	private String nombreUsuario;
	private String correoUsuario;
	private String passwordUsuario;
	private boolean permisoUsuario;
	
	public Usuario() {
	}
	
	public Usuario(String correoUsuario, String passwordUsuario) {
		this.correoUsuario = correoUsuario;
		this.passwordUsuario = passwordUsuario;
	}

	public Usuario(String nombreUsuario, String correoUsuario, String passwordUsuario, Boolean permisoUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.correoUsuario = correoUsuario;
		this.passwordUsuario = passwordUsuario;
		this.permisoUsuario = permisoUsuario;
	}

	public Usuario(int id_usuario, String nombreUsuario, String correoUsuario, String passwordUsuario, Boolean permisoUsuario) {
		this.id_usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.correoUsuario = correoUsuario;
		this.passwordUsuario = passwordUsuario;
		this.permisoUsuario = permisoUsuario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public boolean getPermisoUsuario() {
		return permisoUsuario;
	}

	public void setPermisoUsuario(boolean permisoUsuario) {
		this.permisoUsuario = permisoUsuario;
	}
	
	

}
