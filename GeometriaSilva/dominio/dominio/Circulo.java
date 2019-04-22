package dominio;

public class Circulo extends Poligono implements CalculaArea, CalculaPerimetro, CalculaCoordenadas {
	private double radio;
	private Punto origen;
	
	public Circulo(double radio) throws ExceptionCirculo {
		origen = new Punto();
		this.setRadio(radio);
		
	}
	
	public Circulo(Punto origen, double radio) throws ExceptionCirculo { 
		this(radio);
	    this.origen=origen;
	}
	
	public void setRadio(double radio) throws ExceptionCirculo {
		if (radio<0) {
			throw new ExceptionCirculo();
		}
		          this.radio=radio;
	}
		
	@Override
	public String toString() {
		return this.getResumen("Soy un Circulo, con un area de: "+ this.getArea()+" y un perimetro de: "+this.getPerimetro());

	}
	
	public boolean contieneElPunto(Punto p) {
           if (p.distanciaEntreDosPuntos(origen)<= this.radio) {
        	   return true;
           }
           return false;
	}

	@Override
	public double getArea() {
	     
	     return Math.pow(this.radio, 2)*Math.PI;
	     
	}

	@Override
	public double getPerimetro() {
		return (2*this.radio)*Math.PI;
	}

	@Override
	public String getMisCoordenadas() {
		return "Mi unica coordenada es "+origen.getCoordenada()+" y me encuentro en el "+origen.getCuadrante();
	}
}
