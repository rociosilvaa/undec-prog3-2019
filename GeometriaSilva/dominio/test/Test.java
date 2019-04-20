package test;

import static org.junit.jupiter.api.Assertions.*;

import dominio.Circulo;
import dominio.ExceptionCirculo;
import dominio.ExceptionRectangulo;
import dominio.ExceptionTriangulo;
import dominio.Punto;
import dominio.Rectangulo;
import dominio.Triangulo;

class Test {

	@org.junit.jupiter.api.Test
	void test01Punto() {
		Punto p1 = new Punto();
		Punto p2 = new Punto(5,7);
		Punto p3 = new Punto(-4.3,6);
		Punto p4 = new Punto(4,-3);
		Punto p5 = new Punto(-4.3,-6);
		Punto p6 = new Punto(-5,0);
		Punto p7 = new Punto(0,6);
		
		assertEquals(0, p1.getX()); 
		assertEquals(0.0, p1.getY());
		assertEquals(5, p2.getX()); 
		assertEquals(7.0, p2.getY());
		assertEquals(-4.3, p3.getX()); 
		assertEquals(6, p3.getY());
		
		assertEquals("(0.0;0.0)", p1.getCoordenada());
		assertEquals("(-4.3;6.0)", p3.getCoordenada());
		assertEquals("(-4.3;-6.0)", p5.getCoordenada());
		assertEquals("(0.0;6.0)", p7.getCoordenada());
		
		assertEquals("Origen", p1.getCuadrante());
		assertEquals("I Cuadrante", p2.getCuadrante());
		assertEquals("II Cuadrante", p3.getCuadrante());
		assertEquals("IV Cuadrante", p4.getCuadrante());
		assertEquals("III Cuadrante", p5.getCuadrante());
		assertEquals("II Cuadrante", p6.getCuadrante());
		assertEquals("I Cuadrante", p7.getCuadrante());
		
		assertEquals(5.0, p1.distanciaEntreDosPuntos(p4));
		assertEquals(12, p3.distanciaEntreDosPuntos(p5));
		assertEquals(0, p4.distanciaEntreDosPuntos(p4));
	}
	
	@org.junit.jupiter.api.Test
	void test02Rectangulo() throws ExceptionRectangulo {
		Punto origen = new Punto(2,3);
		
		Rectangulo r1 = new Rectangulo(origen,4,2);
		
		Rectangulo r2 = new Rectangulo(8.5,4.5);
		Rectangulo r3 = new Rectangulo(new Punto(-8,-3),8.5,4.5);
		
		assertEquals(8, r1.getArea());
		assertEquals(12, r1.getPerimetro());
		
		assertEquals("Soy un Rectangulo, con un area de: 8.0 y un perimetro de: 12.0", r1.toString());		
		assertEquals("Mis cuatro coordenadas son: (2.0;3.0) - I Cuadrante, (2.0;5.0) - I Cuadrante, (6.0;5.0) - I Cuadrante, (6.0;3.0) - I Cuadrante", r1.getMisCoordenadas());
		
		assertEquals("Soy un Rectangulo, con un area de: 38.25 y un perimetro de: 26.0", r2.toString());		
		assertEquals("Mis cuatro coordenadas son: (0.0;0.0) - Origen, (0.0;4.5) - I Cuadrante, (8.5;4.5) - I Cuadrante, (8.5;0.0) - I Cuadrante", r2.getMisCoordenadas());
		 
		assertEquals("Soy un Rectangulo, con un area de: 38.25 y un perimetro de: 26.0", r3.toString());		
		assertEquals("Mis cuatro coordenadas son: (-8.0;-3.0) - III Cuadrante, (-8.0;1.5) - II Cuadrante, (0.5;1.5) - I Cuadrante, (0.5;-3.0) - IV Cuadrante", r3.getMisCoordenadas());
		
	}
	
	@org.junit.jupiter.api.Test
	void test03Circulo() throws ExceptionCirculo {
		Punto origen = new Punto(2,3);
		Circulo c1 = new Circulo(origen, 5);
		Circulo c2 = new Circulo(4.5);
		
		assertEquals("Soy un Circulo, con un area de: 78.53981633974483 y un perimetro de: 31.41592653589793", c1.toString() );
		assertEquals("Mi unica coordenada es (2.0;3.0) y me encuentro en el I Cuadrante", c1.getMisCoordenadas() );
		
		assertEquals("Soy un Circulo, con un area de: 63.61725123519331 y un perimetro de: 28.274333882308138", c2.toString() );
		assertEquals("Mi unica coordenada es (0.0;0.0) y me encuentro en el Origen", c2.getMisCoordenadas() );
		
		assertEquals(true,c2.contieneElPunto(new Punto(2,2)));
		assertEquals(true,c2.contieneElPunto(new Punto(4.5,0)));
		assertEquals(true,c2.contieneElPunto(new Punto(0,4.5)));
		assertEquals(false,c2.contieneElPunto(new Punto(2,4.5)));
		assertEquals(true,c2.contieneElPunto(new Punto(-1,-2)));
		assertEquals(false,c2.contieneElPunto(new Punto(-2,4.5)));
	}
	
	@org.junit.jupiter.api.Test
	void test04CirculoException()  {
		Punto origen = new Punto(2,3);
		try {
			Circulo c1 = new Circulo(origen, -5);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionCirculo e) {
			assertEquals("El radio no puede ser negativo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}
		
		try {
			Circulo c1 = new Circulo(origen, 5);	
			assertEquals("Mi unica coordenada es (2.0;3.0) y me encuentro en el I Cuadrante", c1.getMisCoordenadas());
			c1.setRadio(-4);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionCirculo e) {
			assertEquals("El radio no puede ser negativo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
	}
	
	@org.junit.jupiter.api.Test
	void test05RectanguloException()  {
		Punto origen = new Punto(2,3);
		
		try {
			Rectangulo r1 = new Rectangulo(origen, -5, 4);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionRectangulo e) {
			assertEquals("La base no puede ser negativa",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Rectangulo r1 = new Rectangulo(origen, -5, -44);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionRectangulo e) {
			assertEquals("La base no puede ser negativa",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Rectangulo r1 = new Rectangulo(origen, 5, -44);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionRectangulo e) {
			assertEquals("La altura no puede ser negativa",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Rectangulo r1 = new Rectangulo(origen, 5, 44);				
			assertEquals("Mis cuatro coordenadas son: (2.0;3.0) - I Cuadrante, (2.0;47.0) - I Cuadrante, (7.0;47.0) - I Cuadrante, (7.0;3.0) - I Cuadrante", r1.getMisCoordenadas());
			r1.setBase(-7);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionRectangulo e) {
			assertEquals("La base no puede ser negativa",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Rectangulo r1 = new Rectangulo(origen, 5, 44);				
			assertEquals("Mis cuatro coordenadas son: (2.0;3.0) - I Cuadrante, (2.0;47.0) - I Cuadrante, (7.0;47.0) - I Cuadrante, (7.0;3.0) - I Cuadrante", r1.getMisCoordenadas());
			r1.setAltura(-7);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionRectangulo e) {
			assertEquals("La altura no puede ser negativa",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
	}
	
	@org.junit.jupiter.api.Test
	void test06Triangulo() throws ExceptionTriangulo {
		Punto p1 = new Punto(2,3);
		Punto p2 = new Punto(4,3);
		Punto p3 = new Punto(2,6);
		Triangulo t1 = new Triangulo(p1,p2,p3);

		assertEquals("Soy un Triangulo, con un area de: 3.000000000000001 y un perimetro de: 8.60555127546399", t1.toString() );
		assertEquals("Mis tres coordenadas son: (2.0;3.0) - I Cuadrante, (4.0;3.0) - I Cuadrante, (2.0;6.0) - I Cuadrante", t1.getMisCoordenadas() );
		
		assertEquals(3.000000000000001, t1.getArea());
		assertEquals(8.60555127546399, t1.getPerimetro());
		
		assertEquals(p1.getCoordenada(),t1.getPunto(1).getCoordenada());
		assertEquals(p2.getCoordenada(),t1.getPunto(2).getCoordenada());
		assertEquals(p3.getCoordenada(),t1.getPunto(3).getCoordenada());
		
		t1.setPunto(new Punto (), 1);
		assertEquals(new Punto().getCoordenada(),t1.getPunto(1).getCoordenada());
		assertEquals("Soy un Triangulo, con un area de: 8.999999999999998 y un perimetro de: 14.930106595800748", t1.toString() );
		assertEquals("Mis tres coordenadas son: (0.0;0.0) - Origen, (4.0;3.0) - I Cuadrante, (2.0;6.0) - I Cuadrante", t1.getMisCoordenadas() );
		
		assertEquals(8.999999999999998, t1.getArea());
		assertEquals(14.930106595800748, t1.getPerimetro());
		
		assertEquals("(0.0;0.0)",t1.getPunto(1).getCoordenada());
		assertEquals(p2.getCoordenada(),t1.getPunto(2).getCoordenada());
		assertEquals(p3.getCoordenada(),t1.getPunto(3).getCoordenada());
		
	}
	
	@org.junit.jupiter.api.Test
	void test07TrianguloException() {
		Punto p1 = new Punto(1,7);
		Punto p2 = new Punto(2,8);
		Punto p3 = new Punto(3,19);
		
		try {
			Triangulo t1 = new Triangulo(p1,new Punto(1,7),p3);				
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionTriangulo e) {
			assertEquals("No es un Triangulo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Triangulo t1 = new Triangulo(p1,p2,new Punto(1,7));				
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionTriangulo e) {
			assertEquals("No es un Triangulo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Triangulo t1 = new Triangulo(new Punto(3,19),p2,p3);				
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionTriangulo e) {
			assertEquals("No es un Triangulo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Triangulo t1 = new Triangulo(p1,new Punto(3,19),p3);				
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionTriangulo e) {
			assertEquals("No es un Triangulo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		try {
			Triangulo t1 = new Triangulo(p1,p2,p3);
			assertEquals("Soy un Triangulo, con un area de: 5.000000000000032 y un perimetro de: 24.625099640156797", t1.toString() );
			assertEquals("Mis tres coordenadas son: (1.0;7.0) - I Cuadrante, (2.0;8.0) - I Cuadrante, (3.0;19.0) - I Cuadrante", t1.getMisCoordenadas() );
			t1.setPunto(new Punto(2,8), 1);
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionTriangulo e) {
			assertEquals("No es un Triangulo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
	
		try {
			Triangulo t1 = new Triangulo(p1,p2,p3);
			assertEquals("Soy un Triangulo, con un area de: 5.000000000000032 y un perimetro de: 24.625099640156797", t1.toString() );
			assertEquals("Mis tres coordenadas son: (1.0;7.0) - I Cuadrante, (2.0;8.0) - I Cuadrante, (3.0;19.0) - I Cuadrante", t1.getMisCoordenadas() );
			t1.setPunto(new Punto(2,8), 3);
			System.out.println(t1.getMisCoordenadas());
			fail("Esta linea no deberia Correrse");
		} catch (ExceptionTriangulo e) {
			assertEquals("No es un Triangulo",e.getMessage());
		} catch (Exception e) {
			fail("Esta linea no deberia Correrse");
		}	
		
		
	}
	
	
}
