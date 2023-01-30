package nebrija.Criptofolks;

import javafx.scene.Parent;
import javafx.scene.Scene;
import nebrija.Criptofolks.modelo.Usuario;

public class Escena extends Scene{
	
	private Usuario usuarioLogueado;

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

	public Escena(Parent root, double width, double height) {
		super(root, width, height);
		// TODO Auto-generated constructor stub
	}



}
