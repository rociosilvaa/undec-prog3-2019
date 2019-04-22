package dominio;

import java.util.ArrayList;

public class Triangulo extends Poligono implements  CalculaArea, CalculaPerimetro, CalculaCoordenadas{

	public Triangulo(Punto p1, Punto p2, Punto p3) throws ExceptionTriangulo {
		
		this.misVertices=new ArrayList<Punto>();
		if (p1.equals(p2)|| p1.equals(p3) || p2.equals(p1) || p2.equals(p3)||p3.equals(p1)|| p3.equals(p2)) {
		
			throw new ExceptionTriangulo();
		}	
				this.misVertices.add(p1);
				this.misVertices.add(p2);
				this.misVertices.add(p3);
			
		}
	

	public void setPunto(Punto p, int index) throws ExceptionTriangulo {
		for (int i=0;i<this.misVertices.size();i++) {
	    	if (this.misVertices.get(i).equals(p)) {
	    		throw new ExceptionTriangulo();
	    	}
	    }
		this.misVertices.remove(index-1);
		this.misVertices.add(index-1, p);
     
           
	}
	
	public Punto getPunto(int index) {
		return this.misVertices.get(index-1);
	}

	@Override
	
public double getPerimetro() {
//		double resta1;
//		double resta2;
//		double resta3;
//		double suma;
//		resta1 = ((this.misVertices.get(0).distanciaEntreDosPuntos(this.misVertices.get(1))));
//		   resta2 = ((this.misVertices.get(1).distanciaEntreDosPuntos(this.misVertices.get(2))));
//		    resta3 = ((this.misVertices.get(2).distanciaEntreDosPuntos(this.misVertices.get(0))));    
	  return ((this.misVertices.get(0).distanciaEntreDosPuntos(this.misVertices.get(1))))+  ((this.misVertices.get(1).distanciaEntreDosPuntos(this.misVertices.get(2))))+ ((this.misVertices.get(2).distanciaEntreDosPuntos(this.misVertices.get(0)))); 
	    
	}

	public double getArea() {
double resta1;
double resta2;
double resta3;
double suma;
 resta1 = ((this.misVertices.get(0).distanciaEntreDosPuntos(this.misVertices.get(1))));
   resta2 = ((this.misVertices.get(1).distanciaEntreDosPuntos(this.misVertices.get(2))));
    resta3 = ((this.misVertices.get(2).distanciaEntreDosPuntos(this.misVertices.get(0))));
    suma= (resta1+resta2+resta3)/2;
    return Math.sqrt(suma*(suma-resta1)*(suma-resta2)*(suma-resta3));
	}	
	
public String toString() {
		return super.getResumen("Soy un Triangulo, con un area de: "+this.getArea()+" y un perimetro de: "+this.getPerimetro());
	}

	@Override
	public String getMisCoordenadas() {
		return "Mis tres coordenadas son: "+this.misVertices.get(0).getCoordenada()+" - "+this.misVertices.get(0).getCuadrante()+", "+this.misVertices.get(1).getCoordenada()+" - "+this.misVertices.get(1).getCuadrante()+", "+this.misVertices.get(2).getCoordenada()+" - "+this.misVertices.get(2).getCuadrante();
	}
	
}
