package dominio;


public class Punto {
	
	private double x=0;
	private double y=0;
	
	public Punto(double x, double y) {
	   this.x=x;
	   this.y=y;
	}
	
	public Punto() {
		this(0,0);
	}

	
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distanciaEntreDosPuntos(Punto p) {
		return Math.sqrt(Math.pow(this.x-p.x, 2)+Math.pow(this.y-p.y, 2));
	}
	
	public String getCuadrante() {
	   if (this.x==0&& this.y==0)  return "Origen";
	   
	    if (this.x>=0 && this.y>=0)  return "I Cuadrante";
		      
		    	  if (x<0 && this.y>=0)  return "II Cuadrante";
		    	  
		    		  if (this.x>0 && y<0) return "IV Cuadrante";
		    		    return "III Cuadrante";
		    			 
		    				
	}
	
	public String getCoordenada() {
	     if (this.x==0 && this.y==0) {
	    	 return "(0.0;0.0)";
	     }else {
	    	 return "("+this.x+";"+this.y+")";
	     }
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
}
