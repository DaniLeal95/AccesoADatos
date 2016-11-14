package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String url;
	private String usuario;
	private String password;
	private Connection conexion;
	
	//Constructores
	public Conexion (){
		this.url="jdbc:sqlserver://localhost";
		this.usuario="user";
		this.password="pass";
		this.iniConexion();
	}
	
	public Conexion (String url,String usuario, String password){
		this.url=url;
		this.usuario=usuario;
		this.password=password;
		this.iniConexion();
		
		
	}
	
	//Getters && Setters
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	//Metodos
	


	//Inicia una conexion
	/*	Interfaz:
	 * 		Breve comentario:
	 * 			Este metodo intenta iniciar una conexion con las propiedades de la clase.
	 * 				si hay algun problema saltara una excepcion.
	 * 		Cabecera:
	 * 			public void iniConexion()
	 * 		Precondiciones:
	 * 			Las propiedades de clase deben ser correctas
	 * 		Entradas:
	 * 			Nada
	 * 		Salida:
	 * 			Inicia una conexion.
	 * 		Postcondiciones:
	 * 			Nada
	 * */
	public void iniConexion(){
		try {
			this.conexion=DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			System.out.println("No se ha iniciado la conexion");		}
	}
}
