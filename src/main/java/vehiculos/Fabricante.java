package vehiculos;
import java.util.ArrayList;

public class Fabricante {
	private String nombre;
	private Pais pais;
	
	public Fabricante(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return this.pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public static Fabricante fabricaMayorVentas() {
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		for (int i = 0; i < Vehiculo.getVehiculos().size(); i++) {
			Fabricante f = Vehiculo.getVehiculos().get(i).getFabricante();
			if (fabricantes.contains(f) == false) {
				fabricantes.add(f);
			}
		}
		int vars[]; vars = new int[fabricantes.size()];
		for (Vehiculo vehiculo: Vehiculo.getVehiculos()) {
			int a = fabricantes.indexOf(vehiculo.getFabricante());
			vars[a]++;
		}
		int ix = 0;
		for (int i = 1; i < vars.length; i++) {
			if (vars[i] > vars[ix]) {
				ix = i;
			}
		}
		return fabricantes.get(ix);
	}
}
