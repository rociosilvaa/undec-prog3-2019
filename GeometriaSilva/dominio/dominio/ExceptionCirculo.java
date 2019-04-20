package dominio;

@SuppressWarnings("serial")
public class ExceptionCirculo extends Exception{
	public ExceptionCirculo() {
		super ("El radio no puede ser negativo");
	}
}
