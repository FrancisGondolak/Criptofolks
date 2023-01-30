package nebrija.Criptofolks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import nebrija.Criptofolks.conexion.ConexionMysql;
import nebrija.Criptofolks.modelo.Criptofolk;
import nebrija.Criptofolks.modelo.Usuario;

public class EditarEliminarController {
	
	@FXML
	private Button botonBuscarCriptofolk;

	@FXML
    private Button botonEditarCriptofolk;

	@FXML
	private Button botonEliminarCriptofolk;

	@FXML
	private TextField busquedaCriptofolk;

	@FXML
	private TextField descripcionCriptofolk;

	@FXML
	private TextField habitatCriptofolk;

	@FXML
	private TextField imagenCriptofolk;

	@FXML
	private TextField nombreCriptofolk;

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
	private TextField tipoCriptofolk;
	
	@FXML
	private TextField alertaEditarEliminar;
	
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
    void buscarCriptofolk(ActionEvent event) {
		
		//creamos un objeto de la clase ConexionMySql
		ConexionMysql conexion = new ConexionMysql();
		
		Criptofolk criptofolkEncontrado = null;
				
		//en la variable con guardamos la variable de retorno del método getConexion del objeto anterior
		Connection con = conexion.getConexion();
				
		//creamos un objeto predefinido de tipo PreparedStatement
		PreparedStatement ps;
				
		//condicional para comprobar si los campos de entrada de datos están vacíos. Si no lo están, buscar el Criptofolk en la BBDD
		if(!busquedaCriptofolk.getText().isEmpty()) {
			
			//creamos una variable de tipo String con la query que vamos a lanzar
			String sql = "SELECT * FROM criptofolk WHERE nombreCriptofolk LIKE ?";
			
			//cogemos el nombre del Criptofolk que buscamos del textfield de búsqueda
			Criptofolk criptofolkBuscado = new Criptofolk(busquedaCriptofolk.getText());
					
			try {
					
				//en la variable ps guardamos la query dentro del PreparedStatement que está dentro de la conexión
				ps = con.prepareStatement(sql);
				
				ps.setString(1, criptofolkBuscado.getNombreCriptofolk());
				
				//lanzamos la query y guardamos lo que devuelve en una variable de tipo ResultSet
				ResultSet rs = ps.executeQuery();
				
				//si existe el Criptofolk en la BBDD, crea uno con todos los datos para usarlo
				if (rs.next()) {
					
					criptofolkEncontrado = new Criptofolk (rs.getInt("id_criptofolk"), rs.getString("nombreCriptofolk"), rs.getString("habitatCriptofolk"), 
							rs.getString("tipoCriptofolk"), rs.getString("descripcionCriptofolk"), rs.getString("imagenCriptofolk"));
				
				//si no, salta la alerta
				}else {
				
					alertaEditarEliminar.setVisible(true);
					alertaEditarEliminar.setText("El Criptofolk no está registrado");
				}
				
				//agregamos en los textfield los datos del Criptofolk encontrado para poder editarlo o eliminarlo
				nombreCriptofolk.setText(criptofolkEncontrado.getNombreCriptofolk());
				habitatCriptofolk.setText(criptofolkEncontrado.getHabitatCriptofolk());
				tipoCriptofolk.setText(criptofolkEncontrado.getTipoCriptofolk());
				descripcionCriptofolk.setText(criptofolkEncontrado.getDescripcionCriptofolk());
				imagenCriptofolk.setText(criptofolkEncontrado.getImagenCriptofolk());
				
				
			} catch (Exception e) {
					
				System.err.println("Ocurrió un error");
				System.err.println("Mensaje del error: " + e.getMessage());
				System.err.println("Detalle del error: ");
					
				e.printStackTrace();
			}
				
		//si no metemos un nombre a buscar, aparece el textfield con el mensaje de rigor
		}else {
					
			alertaEditarEliminar.setVisible(true);
			alertaEditarEliminar.setText("Introduce un nombre de Criptofolk");
		}

    }

    @FXML
    void editarCriptofolk(ActionEvent event) {
    	
    	ConexionMysql conexion = new ConexionMysql();
    			
    	Connection con = conexion.getConexion();
    			
    	PreparedStatement ps;
    	
    	String sql = "UPDATE criptofolk SET nombreCriptofolk = ?, habitatCriptofolk = ?, tipoCriptofolk = ?,"
    			+ " descripcionCriptofolk = ?, imagenCriptofolk = ? WHERE nombreCriptofolk = ?";
    			
    	if(!nombreCriptofolk.getText().isEmpty() && !habitatCriptofolk.getText().isEmpty() && !tipoCriptofolk.getText().isEmpty() && 
    			!descripcionCriptofolk.getText().isEmpty() && !imagenCriptofolk.getText().isEmpty()) {
    				
    		Criptofolk criptofolk = new Criptofolk(nombreCriptofolk.getText(),habitatCriptofolk.getText(),tipoCriptofolk.getText(),
    				descripcionCriptofolk.getText(),imagenCriptofolk.getText(),busquedaCriptofolk.getText());
    				
    		try {
    				
    			ps = con.prepareStatement(sql);
    			
    			ps.setString(1, criptofolk.getNombreCriptofolk());
    			ps.setString(2, criptofolk.getHabitatCriptofolk());
    			ps.setString(3, criptofolk.getTipoCriptofolk());
    			ps.setString(4, criptofolk.getDescripcionCriptofolk());
    			ps.setString(5, criptofolk.getImagenCriptofolk());
    			ps.setString(6, criptofolk.getNombreAntiguoCriptofolk());
    			
    			ps.executeUpdate();
    			
    			ps.close();
    			
    			alertaEditarEliminar.setVisible(true);
    			alertaEditarEliminar.setText("Criptofolk editado correctamente");
    			
    		} catch (Exception e) {
    				
    			System.err.println("Ocurrió un error");
    			System.err.println("Mensaje del error: " + e.getMessage());
    			System.err.println("Detalle del error: ");
    				
    			e.printStackTrace();
    		}
    			
    	}else {
    				
    		alertaEditarEliminar.setVisible(true);
    		alertaEditarEliminar.setText("Debes rellenar todos los campos");
    	}
    	
    	
    }

    @FXML
    void eliminarCriptofolk(ActionEvent event) {
    	
    	System.out.println("Has pulsado el botón de eliminar Criptofolk");
    	
    	ConexionMysql conexion = new ConexionMysql();
		
    	Connection con = conexion.getConexion();
    			
    	PreparedStatement ps;
    	
    	String sql = "DELETE FROM criptofolk WHERE nombreCriptofolk = ?";
    			
    	if(!busquedaCriptofolk.getText().isEmpty()) {
    				
    		Criptofolk criptofolk = new Criptofolk(busquedaCriptofolk.getText());
    				
    		try {
    				
    			ps = con.prepareStatement(sql);
    			
    			ps.setString(1, criptofolk.getNombreCriptofolk());
    			
    			ps.executeUpdate();
    			
    			ps.close();
    			
    			alertaEditarEliminar.setVisible(true);
    			alertaEditarEliminar.setText("Criptofolk eliminado correctamente");
    			
    			busquedaCriptofolk.setText("");
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
    			
    	}else {
    				
    		alertaEditarEliminar.setVisible(true);
    		alertaEditarEliminar.setText("Debes rellenar todos los campos");
    	}
    	
    }

}


