package dominio;

public class Cuadrado extends Rectangulo{

	public Cuadrado(double lado) throws ExceptionRectangulo {
		super(lado, lado);
	}
	@Override
	public void setBase(double lado) throws ExceptionRectangulo {
		this.setBase(lado);
		this.setAltura(lado);
	}
	
	@Override
	public void setAltura(double lado) throws ExceptionRectangulo {
		this.setBase(lado);
		this.setAltura(lado);
	}
}
