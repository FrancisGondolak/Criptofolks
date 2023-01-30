package nebrija.Criptofolks.modelo;

public class UsuarioLogueado {
	
	static Usuario usuarioLogueado = new Usuario();
	
	public static void obtenerUsuario (Usuario usuario) {
		
		usuarioLogueado.setNombreUsuario(usuario.getNombreUsuario());
	}

}
