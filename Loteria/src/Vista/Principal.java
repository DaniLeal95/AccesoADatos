package Vista;

import java.util.Vector;

import dal.Funcionalidades;
import modelo.Boleto;

public class Principal {

	public static void main(String[] args) {
		Vector<Boleto> boletos=new Vector<Boleto>(0,1);
		Funcionalidades f=new Funcionalidades();
		
		boletos=f.obtenerBoletos();
		System.out.println("IdSorteo \tIdBoleto \tReintegro \tTipoApuesta \tPremio");
		for(int i=0;i<boletos.size();i++){
			System.out.print(boletos.elementAt(i).getId_boleto());
			System.out.print("\t"+boletos.elementAt(i).getId_sorteo());
			System.out.print("\t"+boletos.elementAt(i).getFecha_compra());
			System.out.print("\t"+boletos.elementAt(i).getReintegro());
			System.out.print("\t"+boletos.elementAt(i).getNumeros_jugados());
			System.out.print("\t"+boletos.elementAt(i).getPremio());
			System.out.println();
		}
	}

}
