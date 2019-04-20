package dominio;

import java.util.ArrayList;

public class Rectangulo  extends Poligono implements Medible{
		private double base;
		private double altura;
	   
	public Rectangulo(Punto p1, double base, double altura) throws ExceptionRectangulo {
	 this.misVertices= new ArrayList<Punto>();
	     this.miOrigen= p1;
	     this.setBase(base);
	     this.setAltura(altura);
	    
	     this.generarCoordenadas(p1, base, altura);
	     

		
	}
	
	public Rectangulo(double base, double altura) throws ExceptionRectangulo {
		
		this(new Punto (),base,altura);
        
	

	}
	private void generarCoordenadas(Punto p1, double base2, double altura2) {
		     this.misVertices.add(p1);  
		     this.misVertices.add(new Punto ((this.misVertices.get(0).getX()),(p1.getY()+altura2)));
		     this.misVertices.add(new Punto((this.misVertices.get(1).getX()+base2), (p1.getY()+altura2)));
		   this.misVertices.add(new Punto( ((p1.getX()+base2)),p1.getY()));
		  
	
	}

	public void setBase(double base) throws ExceptionRectangulo {
		if (base<0) {
			throw new ExceptionRectangulo("La base no puede ser negativa");
		}
		this.base=base;
		
	}
	
	public void setAltura(double altura) throws ExceptionRectangulo {
		if (altura <0) {
			throw new ExceptionRectangulo("La altura no puede ser negativa");
		}
		this.altura=altura;
	}

	@Override
	public double getArea() {
		return this.base*this.altura;
	}

	@Override
	public double getPerimetro() {
		return (this.altura*2)+(this.base*2);
	}

	@Override
	public String getMisCoordenadas() {
		return "Mis cuatro coordenadas son: "+this.misVertices.get(0).getCoordenada()+" - "+this.misVertices.get(0).getCuadrante()+", "+this.misVertices.get(1).getCoordenada()+" - "+this.misVertices.get(1).getCuadrante()+", "+this.misVertices.get(2).getCoordenada()+" - "+this.misVertices.get(2).getCuadrante()+", "+this.misVertices.get(3).getCoordenada()+" - "+this.misVertices.get(3).getCuadrante();
	}

	@Override
	public String toString() {
     return "Soy un Rectangulo, con un area de: "+this.getArea()+" y un perimetro de: "+this.getPerimetro();
	}
	

	
}
