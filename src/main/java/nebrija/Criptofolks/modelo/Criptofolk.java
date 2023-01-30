package nebrija.Criptofolks.modelo;

public class Criptofolk {
	
	private int id_criptofolk;
	private String nombreCriptofolk;
	private String habitatCriptofolk;
	private String tipoCriptofolk;
	private String descripcionCriptofolk;
	private String imagenCriptofolk;
	private String nombreAntiguoCriptofolk;
	
	
	public Criptofolk() {
		
	}
	
	
	//constructor para buscar un Criptofolk en la BBDD por el nombre
	public Criptofolk(String nombreCriptofolk) {
		
		this.nombreCriptofolk = nombreCriptofolk;
	}
	
	
	//constructor para la tabla de Criptofolks del mapa
	public Criptofolk(String nombreCriptofolk, String tipoCriptofolk) {
		
		this.nombreCriptofolk = nombreCriptofolk;
		this.tipoCriptofolk = tipoCriptofolk;
		
	}


	//constructor para agregar un nuevo Criptofolk a la BBDD
	public Criptofolk(String nombreCriptofolk, String habitatCriptofolk, String tipoCriptofolk,
			String descripcionCriptofolk, String imagenCriptofolk) {
		
		this.nombreCriptofolk = nombreCriptofolk;
		this.habitatCriptofolk = habitatCriptofolk;
		this.tipoCriptofolk = tipoCriptofolk;
		this.descripcionCriptofolk = descripcionCriptofolk;
		this.imagenCriptofolk = imagenCriptofolk;
	}

	//constructor para traer un Criptofolk completo desde la BBDD y poder mostrarlo 
	public Criptofolk(int id_criptofolk, String nombreCriptofolk, String habitatCriptofolk, String tipoCriptofolk,
			String descripcionCriptofolk, String imagenCriptofolk) {
		
		this.id_criptofolk = id_criptofolk;
		this.nombreCriptofolk = nombreCriptofolk;
		this.habitatCriptofolk = habitatCriptofolk;
		this.tipoCriptofolk = tipoCriptofolk;
		this.descripcionCriptofolk = descripcionCriptofolk;
		this.imagenCriptofolk = imagenCriptofolk;
	}
	
	//constructor para editar o eliminar el Criptofolk de la BBDD
	public Criptofolk(String nombreCriptofolk, String habitatCriptofolk, String tipoCriptofolk,
			String descripcionCriptofolk, String imagenCriptofolk, String nombreAntiguoCriptofolk) {
		
		this.nombreCriptofolk = nombreCriptofolk;
		this.habitatCriptofolk = habitatCriptofolk;
		this.tipoCriptofolk = tipoCriptofolk;
		this.descripcionCriptofolk = descripcionCriptofolk;
		this.imagenCriptofolk = imagenCriptofolk;
		this.nombreAntiguoCriptofolk = nombreAntiguoCriptofolk;
	}


	public int getId_criptofolk() {
		return id_criptofolk;
	}


	public void setId_criptofolk(int id_criptofolk) {
		this.id_criptofolk = id_criptofolk;
	}


	public String getNombreCriptofolk() {
		return nombreCriptofolk;
	}


	public void setNombreCriptofolk(String nombreCriptofolk) {
		this.nombreCriptofolk = nombreCriptofolk;
	}


	public String getHabitatCriptofolk() {
		return habitatCriptofolk;
	}


	public void setHabitatCriptofolk(String habitatCriptofolk) {
		this.habitatCriptofolk = habitatCriptofolk;
	}


	public String getTipoCriptofolk() {
		return tipoCriptofolk;
	}


	public void setTipoCriptofolk(String tipoCriptofolk) {
		this.tipoCriptofolk = tipoCriptofolk;
	}


	public String getDescripcionCriptofolk() {
		return descripcionCriptofolk;
	}


	public void setDescripcionCriptofolk(String descripcionCriptofolk) {
		this.descripcionCriptofolk = descripcionCriptofolk;
	}


	public String getImagenCriptofolk() {
		return imagenCriptofolk;
	}


	public void setImagenCriptofolk(String imagenCriptofolk) {
		this.imagenCriptofolk = imagenCriptofolk;
	}


	public String getNombreAntiguoCriptofolk() {
		return nombreAntiguoCriptofolk;
	}


	public void setNombreAntiguoCriptofolk(String nombreAntiguoCriptofolk) {
		this.nombreAntiguoCriptofolk = nombreAntiguoCriptofolk;
	}
	
	
	
	
	
	
	
	
	

}
