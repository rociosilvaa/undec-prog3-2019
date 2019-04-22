package dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Poligono {
	protected List<Punto> misVertices= new ArrayList<Punto>();	
	protected Punto miOrigen;
	
	public String getResumen(String datos) {
		return datos;
	}
	
}
