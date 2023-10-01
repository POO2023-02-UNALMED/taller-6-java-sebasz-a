package vehiculos;
import java.util.ArrayList;

public class Pais {
	private String nombre;
	
	public Pais(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static Pais paisMasVendedor() {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		for (int i = 0; i < Vehiculo.getVehiculos().size(); i++) {
			Pais p = Vehiculo.getVehiculos().get(i).getFabricante().getPais();
			if (paises.contains(p) == false){
				paises.add(p);
			}
		}
		int vars[]; vars = new int[paises.size()];
		for (Vehiculo vehiculo : Vehiculo.getVehiculos()) {
			int a = paises.indexOf(vehiculo.getFabricante().getPais());
			vars[a]++;
		}
		int ix = 0;
		for (int i = 1; i < vars.length; i++) {
			if (vars[i] > vars[ix]) {
				ix = i;
			}
		}
		return paises.get(ix);
	}
}
