package dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.Boleto;

/*
 * Clase Funcionalidades
 * 	Esta clase sirve para utilizar funcionalidades de la base de datos.
 * */
public class Funcionalidades {
	
	/*
	 * ObtenerBoletos.
	 * 	BreveComentario:
	 * 		Este metodo devolvera un vector de Boletos, de todos los boletos que esten registrados
	 * 			en nuestra base de datos.
	 * 
	 * 	
	 * 
	 * */
	
	public Vector<Boleto> obtenerBoletos(){
		Vector<Boleto> boletos = new Vector<Boleto>(0,1);
		Conexion conexion=new Conexion();
		Statement sentencia;
		ResultSet resultado;
		
		String select = "Select "+Columnas.idBoleto_bol+","+Columnas.idSorteo_bol+","+Columnas.fechaCompra_bol+
				","+Columnas.numeros_jugados_bol+","+Columnas.reintegro_bol+","+Columnas.premio_bol+" From"
						+ " Boletos";
		try{
			conexion.iniConexion();
			sentencia=conexion.getConexion().createStatement();
			resultado=sentencia.executeQuery(select);
			
			while(resultado.next()){
				
				Boleto boleto = new Boleto();
				boleto.setId_boleto(resultado.getInt(Columnas.idBoleto_bol.toString()));
				boleto.setId_sorteo(resultado.getInt(Columnas.idSorteo_bol.toString()));
				boleto.setFecha_compra(resultado.getDate(Columnas.fechaCompra_bol.toString()));
				boleto.setReintegro(resultado.getShort(Columnas.reintegro_bol.toString()));
				boleto.setNumeros_jugados(resultado.getShort(Columnas.numeros_jugados_bol.toString()));
				boleto.setPremio(resultado.getDouble(Columnas.premio_bol.toString()));
				
				boletos.add(boleto);
			}
			
		}catch(SQLException sqle){
			System.out.println(sqle);
		}finally{
			conexion.closeConexion();
		}
		
		
		
		return boletos;
	}
	
	
}
