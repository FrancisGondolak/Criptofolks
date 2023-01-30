package nebrija.Criptofolks;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nebrija.Criptofolks.conexion.ConexionMysql;
import nebrija.Criptofolks.modelo.Criptofolk;

public class MapaController {
	
	@FXML
    private Button andaluciaBoton;

    @FXML
    private Button aragonBoton;

    @FXML
    private Button asturiasBoton;

    @FXML
    private Button balearesBoton;

    @FXML
    private Button canariasBoton;

    @FXML
    private Button cantabriaBoton;

    @FXML
    private Button castillaLeonBoton;

    @FXML
    private Button castillaManchaBoton;

    @FXML
    private Button cataluniaBoton;

    @FXML
    private Button extremaduraBoton;

    @FXML
    private Button franciaBoton;

    @FXML
    private Button galiciaBoton;

    @FXML
    private Button lariojaBoton;

    @FXML
    private Button madridBoton;

    @FXML
    private Button murciaBoton;

    @FXML
    private Button navarraBoton;
	
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
    private Button paisvascoBoton;

    @FXML
    private Button portugalBoton;

    @FXML
    private Button valenciaBoton;
    
    @FXML
    private TableView<Criptofolk> tablaMapaCriptofolks;
	
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
    void mostrarCriptofolksAndalucia(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Andalucía");

    }

    @FXML
    void mostrarCriptofolksAragon(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Aragón");

    }

    @FXML
    void mostrarCriptofolksAsturias(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Asturias");

    }

    @FXML
    void mostrarCriptofolksBaleares(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Islas Baleares");

    }

    @FXML
    void mostrarCriptofolksCanarias(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Islas Canarias");

    }

    @FXML
    void mostrarCriptofolksCantabria(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Cantabria");

    }

    @FXML
    void mostrarCriptofolksCastillaLeon(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Castilla León");

    }

    @FXML
    void mostrarCriptofolksCastillaMancha(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("La Mancha");

    }

    @FXML
    void mostrarCriptofolksCatalunia(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Cataluña");

    }

    @FXML
    void mostrarCriptofolksExtremadura(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Extremadura");

    }

    @FXML
    void mostrarCriptofolksFrancia(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Francia");

    }

    @FXML
    void mostrarCriptofolksGalicia(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Galicia");

    }

    @FXML
    void mostrarCriptofolksLaRioja(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("La Rioja");

    }

    @FXML
    void mostrarCriptofolksMadrid(ActionEvent event) {
    	
    	tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Madrid");

    }

    @FXML
    void mostrarCriptofolksMurcia(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Murcia");

    }

    @FXML
    void mostrarCriptofolksNavarra(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Navarra");

    }

    @FXML
    void mostrarCriptofolksPaisVasco(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("País Vasco");

    }

    @FXML
    void mostrarCriptofolksPortugal(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Portugal");

    }

    @FXML
    void mostrarCriptofolksValencia(ActionEvent event) {
		
		tablaMapaCriptofolks.getColumns().clear();
    	
    	mostrarCriptofolks("Valencia");

    }
    
public void mostrarCriptofolks (String comunidadAutonoma) {
		
		ConexionMysql conexion = new ConexionMysql();
		
		Connection con = conexion.getConexion();
				
		PreparedStatement ps;
				
		String sql = "SELECT * FROM criptofolk WHERE habitatCriptofolk LIKE ?";
		
		ArrayList<Criptofolk> listaCriptofolks = new ArrayList<Criptofolk>();
		
		tablaMapaCriptofolks.setVisible(true);
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, comunidadAutonoma);
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				
				listaCriptofolks.add(new Criptofolk(rs.getString("nombreCriptofolk"),rs.getString("tipoCriptofolk")));
			
			}
			
			
		} catch (Exception e) {
				
			System.err.println("Ocurrió un error");
			System.err.println("Mensaje del error: " + e.getMessage());
			System.err.println("Detalle del error: ");
				
			e.printStackTrace();
		}
    	
		tablaMapaCriptofolks.setEditable(true);
    	
    	TableColumn nombreColumna = new TableColumn(comunidadAutonoma);
    	TableColumn tipoColumna = new TableColumn("");
    	
    	nombreColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("nombreCriptofolk"));
    	tipoColumna.setCellValueFactory(new PropertyValueFactory<Criptofolk, String>("tipoCriptofolk"));
    	
    	ObservableList<Criptofolk> listaMostrada = FXCollections.observableArrayList(listaCriptofolks);
    	
    	tablaMapaCriptofolks.setItems(listaMostrada);
    	
    	tablaMapaCriptofolks.getColumns().addAll(nombreColumna);
    	tablaMapaCriptofolks.getColumns().addAll(tipoColumna);
    }

}
