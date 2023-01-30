package nebrija.Criptofolks;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nebrija.Criptofolks.conexion.ConexionMysql;
import nebrija.Criptofolks.modelo.Criptofolk;

public class ListaCriptofolksController implements Initializable {
	
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
    private TableView<Criptofolk> tablaCriptofolks;
	
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
	
	public void initialize(URL location, ResourceBundle resource) {
		
		ConexionMysql conexion = new ConexionMysql();
		
		Connection con = conexion.getConexion();
				
		PreparedStatement ps;
				
		String sql = "SELECT * FROM criptofolk";
		
		ArrayList<Criptofolk> listaCriptofolks = new ArrayList<Criptofolk>();
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				
				listaCriptofolks.add(new Criptofolk(rs.getString("nombreCriptofolk"),rs.getString("habitatCriptofolk"),rs.getString("tipoCriptofolk"),
						rs.getString("descripcionCriptofolk"),rs.getString("imagenCriptofolk")));
			
			}
			
			
		} catch (Exception e) {
				
			System.err.println("Ocurrió un error");
			System.err.println("Mensaje del error: " + e.getMessage());
			System.err.println("Detalle del error: ");
				
			e.printStackTrace();
		}
    	
		tablaCriptofolks.setEditable(true);
    	
    	TableColumn nombreColumna = new TableColumn("Nombre");
    	TableColumn habitatColumna = new TableColumn("Habitat");
    	TableColumn tipoColumna = new TableColumn("Tipo");
    	TableColumn descripcionColumna = new TableColumn("Descripción");
    	TableColumn imagenColumna = new TableColumn("Imagen");
    	
    	
    	nombreColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("nombreCriptofolk"));
    	habitatColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("habitatCriptofolk"));
    	tipoColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("tipoCriptofolk"));
    	descripcionColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("descripcionCriptofolk"));
    	imagenColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("imagenCriptofolk"));
    	
    	ObservableList<Criptofolk> listaMostrada = FXCollections.observableArrayList(listaCriptofolks);
    	
    	tablaCriptofolks.setItems(listaMostrada);
    	
    	tablaCriptofolks.getColumns().addAll(nombreColumna);
    	tablaCriptofolks.getColumns().addAll(habitatColumna);
    	tablaCriptofolks.getColumns().addAll(tipoColumna);
    	tablaCriptofolks.getColumns().addAll(descripcionColumna);
    	tablaCriptofolks.getColumns().addAll(imagenColumna);
    }


}
