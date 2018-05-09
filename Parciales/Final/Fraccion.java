
public class Fraccion {
	int numerador;
	int denominador;
	
	public static int euclides(int a, int b) {
		if (b == 0)
			return a;
		return euclides(b, a % b);
	}
	
	public int getNumerador() {
		return numerador;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	public Fraccion(int numerador, int denominador) {
		super();
		int mcd = euclides(numerador, denominador);
		this.numerador = numerador / mcd;
		this.denominador = denominador / mcd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominador;
		result = prime * result + numerador;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Fraccion)) {
			return false;
		}
		Fraccion other = (Fraccion) obj;
		if (denominador != other.denominador) {
			return false;
		}
		if (numerador != other.numerador) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		int entero = this.numerador / this.denominador;
		if (entero != 0) {
			return entero + " " + numerador%denominador + "%" + denominador;
		}
		return this.numerador + "%" + this.denominador;
	}
	

}
