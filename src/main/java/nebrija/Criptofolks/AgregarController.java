package nebrija.Criptofolks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import nebrija.Criptofolks.conexion.ConexionMysql;
import nebrija.Criptofolks.modelo.Criptofolk;

public class AgregarController {
	
	@FXML
	private Button botonAgregarCriptofolk;

	@FXML
	private TextField descripcionCriptofolk;
	
	@FXML
    private TextField tipoCriptofolk;

	@FXML
	private TextField habitatCriptofolk;

	@FXML
	private TextField imagenCriptofolk;

	@FXML
	private TextField nombreCriptofolk;
	
	@FXML
	private TextField alertaAgregarCriptofolk;
	
	@FXML
    private Button botonAgregarImagenCriptofolk;
	
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
	private void switchToIndex() throws IOException {
        App.setRoot("index");
    }
	
	@FXML
    private void switchToRegistro() throws IOException {
        App.setRoot("registroLogin");
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
	
	@FXML
    void agregarCriptofolk(ActionEvent event) throws IOException, SQLException{
		
		System.out.println("Has pulsado el botón de agregar Criptofolk");
		
		//creamos un objeto de la clase ConexionMySql
		ConexionMysql conexion = new ConexionMysql();
		
		//en la variable con guardamos la variable de retorno del método getConexion del objeto anterior
		Connection con = conexion.getConexion();
		
		//creamos un objeto predefinido de tipo PreparedStatement
		PreparedStatement ps;
		
		//creamos una variable de tipo String con la query que vamos a lanzar
		String sql = "INSERT INTO criptofolk (nombreCriptofolk, habitatCriptofolk, tipoCriptofolk, descripcionCriptofolk, imagenCriptofolk) VALUES (?,?,?,?,?)";
		
		//condicional para comprobar si los campos de entrada de datos están vacíos. Si no lo están, registrar el Criptofolk en la BBDD
		if(!nombreCriptofolk.getText().isEmpty() && !habitatCriptofolk.getText().isEmpty() && !tipoCriptofolk.getText().isEmpty() && 
				!descripcionCriptofolk.getText().isEmpty() && !imagenCriptofolk.getText().isEmpty()) {
			
			//creamos un objeto de tipo Criptofolk donde guardamos los datos extraídos del formulario
			
			Criptofolk criptofolk = new Criptofolk(nombreCriptofolk.getText(),habitatCriptofolk.getText(),tipoCriptofolk.getText(),
					descripcionCriptofolk.getText(),imagenCriptofolk.getText());
			
			try {
			
				//en la variable ps guardamos la query dentro del PreparedStatement que está dentro de la conexión
				ps = con.prepareStatement(sql);
		
				//llenamos cada uno de los cambios de la query que vamos a lanzar con los datos extraídos del formulario
				ps.setString(1, criptofolk.getNombreCriptofolk());
				ps.setString(2, criptofolk.getHabitatCriptofolk());
				ps.setString(3, criptofolk.getTipoCriptofolk());
				ps.setString(4, criptofolk.getDescripcionCriptofolk());
				ps.setString(5, criptofolk.getImagenCriptofolk());
		
				//lanzamos la query
				ps.executeUpdate();
		
				//cerramos el PreparedStatement
				ps.close();
				
				alertaAgregarCriptofolk.setVisible(true);
				alertaAgregarCriptofolk.setText("Criptofolk agregado correctamente");
		
				//cuando finalizamos el registro, vacía los campos por si queremos introducir otro Criptofolk
				nombreCriptofolk.setText("");
				habitatCriptofolk.setText("");
				tipoCriptofolk.setText("");
				descripcionCriptofolk.setText("");
				imagenCriptofolk.setText("");
		
			} catch (Exception e) {
			
				System.err.println("Ocurrió un error");
				System.err.println("Mensaje del error: " + e.getMessage());
				System.err.println("Detalle del error: ");
			
				e.printStackTrace();
			}
		
		//si alguno de los campos está vacío, aparece el textfield con el mensaje de rigor
		}else {
			
			alertaAgregarCriptofolk.setVisible(true);
			alertaAgregarCriptofolk.setText("Debes rellenar todos los campos");
		}

    }
	
	//funcion para agregar la ruta de la imagen al formulario de agregar Criptofolk
	@FXML
    void agregarImagenCriptofolk(ActionEvent event) {

    }

}
