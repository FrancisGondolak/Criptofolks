package nebrija.Criptofolks;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class EspacioPersonalController {
	
	@FXML
	private Button paginaAgregarBoton;

	@FXML
	private Button paginaEditarBoton;

	@FXML
	private Button paginaIndexBoton;

	@FXML
	private Button paginaListaBoton;

	@FXML
	private Button paginaMapaBoton;

	@FXML
	private Button paginaPersonalBoton;

	@FXML
	private Button paginaRegistroBoton;
	
	@FXML
	private Text textoEspacioPersonal;
	
	@FXML
	private void switchToIndex() throws IOException {
        App.setRoot("espacioPersonal");
    }
	
	@FXML
    private void switchToRegistro() throws IOException {
        App.setRoot("espacioPersonal");
    }
	
	@FXML
    private void switchToLista() throws IOException {
        App.setRoot("listaCriptofolks");
    }
	
	@FXML
    private void switchToAgregar() throws IOException {
		
		if (RegistroLoginController.getUsuarioLogueado().getPermisoUsuario() == true) {
			App.setRoot("agregar");
		}
    }
	
	@FXML
    private void switchToEditar() throws IOException {
		
		if (RegistroLoginController.getUsuarioLogueado().getPermisoUsuario() == true) {
			App.setRoot("editarEliminar");
		} 
    }
	
	@FXML
    private void switchToMapa() throws IOException {
        App.setRoot("mapa");
    }
	
	@FXML
    private void switchToPersonal() throws IOException {

		if (!RegistroLoginController.getUsuarioLogueado().getPermisoUsuario()) {
			App.setRoot("espacioPersonal");
		} 
    }

}
