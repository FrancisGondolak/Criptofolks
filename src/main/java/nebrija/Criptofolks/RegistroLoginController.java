package nebrija.Criptofolks;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import nebrija.Criptofolks.conexion.ConexionMysql;
import nebrija.Criptofolks.modelo.Usuario;

public class RegistroLoginController {
	
	private static Usuario usuarioLogueado;
	
	public static Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public static void setUsuarioLogueado(Usuario usuarioLogueado) {
		RegistroLoginController.usuarioLogueado = usuarioLogueado;
	}

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
	private Button botonEnviarLogin;

	@FXML
	private Button botonEnviarRegistro;

	@FXML
    private TextField correoLogin;

    @FXML
	private TextField correoRegistro;

	@FXML
	private TextField nombreRegistro;

	@FXML
    private PasswordField passwordLogin;

    @FXML
    private PasswordField passwordRegistro;
	
	@FXML
	private TextField alertaLogin;

	@FXML
	private TextField alertaRegistro;
	
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
	
	//método para encriptar la contraseña con MD5 antes de mandarla a la BBDD
	public static String getMD5(String input) {
		
		try {
			 
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(input.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
			 
			 hashtext = "0" + hashtext;
		 }
		 
		 return hashtext;
		 
		 }
		 
		 catch (NoSuchAlgorithmException e) {
			 
			 throw new RuntimeException(e);
		 }
	}
	
	@FXML
    void registrarUsuario() throws IOException, SQLException{
		
		System.out.println("Has pulsado el botón de registrar");
		//creamos un objeto de la clase ConexionMySql
		ConexionMysql conexion = new ConexionMysql();
		
		//en la variable con guardamos la variable de retorno del método getConexion del objeto anterior
		Connection con = conexion.getConexion();
		
		//creamos un objeto predefinido de tipo PreparedStatement
		PreparedStatement ps;
		
		//creamos una variable de tipo String con la query que vamos a lanzar
		String sql = "INSERT INTO usuario (nombreUsuario, correoUsuario, passwordUsuario, permisoUsuario) VALUES (?,?,?,?)";
		
		//condicional para comprobar si los campos de entrada de datos están vacíos. Si no lo están, registrar al usuario en la BBDD
		if(!nombreRegistro.getText().isEmpty() && !correoRegistro.getText().isEmpty() && !passwordRegistro.getText().isEmpty()) {
			
			//comprobación para que el nombre no tenga más de 12 caracteres
			if (nombreRegistro.getText().length()>12) {
				
				alertaRegistro.setVisible(true);
				alertaRegistro.setText("El nombre introducido tiene más de 12 caracteres");
				
				//Seteamos los campos vacíos para que el usuario introduzca los datos de nuevo
				nombreRegistro.setText("");
				correoRegistro.setText("");
				passwordRegistro.setText("");
			
			//comprobación para que el correo no tenga más de 50 caracteres y que tenga la @
			}else if (correoRegistro.getText().length()>50  || !correoRegistro.getText().contains("@")) {
				
				alertaRegistro.setVisible(true);
				alertaRegistro.setText("Por favor, introduce un correo válido");
				
				//Seteamos los campos vacíos para que el usuario introduzca los datos de nuevo
				nombreRegistro.setText("");
				correoRegistro.setText("");
				passwordRegistro.setText("");
				
			//comprobación para que la contraseña no tenga más de 50 caracteres
			}else if (passwordRegistro.getText().length()>50) {
				
				alertaRegistro.setVisible(true);
				alertaRegistro.setText("La contraseña debe tener menos de 50 caracteres");
				
				//Seteamos los campos vacíos para que el usuario introduzca los datos de nuevo
				nombreRegistro.setText("");
				correoRegistro.setText("");
				passwordRegistro.setText("");
					
			}else {
				
				//creamos un objeto de tipo usuario donde guardamos los datos extraídos del formulario. Al permisoUsuario le damos el valor por defecto
			//"false" dado que cualquier usuario que se registre por medio de la página no va a ser administrador
			Usuario usuario = new Usuario(nombreRegistro.getText(),correoRegistro.getText(),getMD5(passwordRegistro.getText()),false);
		
			try {
			
				//en la variable ps guardamos la query dentro del PreparedStatement que está dentro de la conexión
				ps = con.prepareStatement(sql);
		
				//llenamos cada uno de los cambios de la query que vamos a lanzar con los datos extraídos del formulario
				ps.setString(1, usuario.getNombreUsuario());
				ps.setString(2, usuario.getCorreoUsuario());
				ps.setString(3, usuario.getPasswordUsuario());
				ps.setBoolean(4, usuario.getPermisoUsuario());
		
				//lanzamos la query
				ps.executeUpdate();
		
				//cerramos el PreparedStatement
				ps.close();
		
				//cuando finalizamos el registro, nos dirige a la página del espacio personal del usuario
				App.setRoot("espacioPersonal");
		
			} catch (Exception e) {
			
				System.err.println("Ocurrió un error");
				System.err.println("Mensaje del error: " + e.getMessage());
				System.err.println("Detalle del error: ");
			
				e.printStackTrace();
			}
		
		//si alguno de los campos está vacío, aparece el textfield alertaRegistro con el mensaje de rigor
		
			}
			
		}else {
			
			alertaRegistro.setVisible(true);
			alertaRegistro.setText("Debes rellenar todos los campos");
		}
    }
	
	@FXML
    void loguearUsuario() throws IOException{
		
		System.out.println("Has pulsado el botón de loguear");
		
		ConexionMysql conexion = new ConexionMysql();
		
		 usuarioLogueado = null;
				
		//en la variable "con" guardamos la variable de retorno del método getConexion del objeto conexion de tipo ConexionMysql
		Connection con = conexion.getConexion();
				
		PreparedStatement ps;
		
		//preparamos la query para lanzarla a la base de datos
		String sql = "SELECT * from usuario where correoUsuario = ? and passwordUsuario = ?";
		
		if(!correoLogin.getText().isEmpty() && !passwordLogin.getText().isEmpty()) {
			
			Usuario usuario = new Usuario(correoLogin.getText(),getMD5(passwordLogin.getText()));
				
			try {
				//enlazamos la query con la conexión a la base de datos (con)
				ps = con.prepareStatement(sql);
					
					
				ps.setString(1, usuario.getCorreoUsuario());
				ps.setString(2, usuario.getPasswordUsuario());
					
				//guardamos en el objeto ResultSet (objeto nativo de Java) el resultado de la query 
				ResultSet rs = ps.executeQuery();
					
				//si hay resultado (next() es un booleano seteado en true) guarda los datos obtenidos
				//en la variable resultado y devuelve dicho resultado para seguir trabajando con él
				if (rs.next()) {
				
					usuarioLogueado = new Usuario (rs.getInt("id_usuario"), rs.getString("nombreUsuario"), rs.getString("correoUsuario"), rs.getString("passwordUsuario"), rs.getBoolean("permisoUsuario"));
					App.setRoot("espacioPersonal");
				
				}else {
				
					alertaLogin.setVisible(true);
					alertaLogin.setText("Correo y/o contraseña incorrectos");
				}
					
					
			} catch (Exception e) {
			
				System.err.println("Ocurrió un error");
				System.err.println("Mensaje del error: " + e.getMessage());
				System.err.println("Detalle del error: ");
			
				e.printStackTrace();
								
			}
		}else {
			
			alertaLogin.setVisible(true);
			alertaLogin.setText("Debes rellenar todos los campos");
		}
    }
}
	

