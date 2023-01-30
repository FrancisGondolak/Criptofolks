package nebrija.Criptofolks.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMysql {
	
	private Connection connection;
	private String usuario = "root";
	private String password = "";
	private String servidor = "localhost";
	private String puerto = "3306";
	private String nombreBD = "criptofolks";
	//el driver hace referencia al archivo .jar de MySQL que se ha metido en las librerías
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + nombreBD + "?serverTimezone=UTC";
	
	
	public Connection getConexion(){
		
		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, usuario, password);
			
			if( connection != null) {
				
				System.out.println("¡¡¡Conexión conseguida!!!");
			}
			
		} catch (Exception e) {
			
			System.err.println("Ocurrió un error en la conexión");
			System.err.println("Mensaje del error: " + e.getMessage());
			System.err.println("Detalle del error: ");
			
			e.printStackTrace();
		}
		return connection;
	}
	
	

}
