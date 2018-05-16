package it.polito.tdp.borders.model;

public class Border {
	private int Ccode1;
	private int Ccode2;
	private int contType;
	private int anno;
	public Border(int ccode1, int ccode2, int contType, int anno) {
		super();
		Ccode1 = ccode1;
		Ccode2 = ccode2;
		this.contType = contType;
		this.anno = anno;
	}
	
	
	public Border(int ccode1, int ccode2) {
		super();
		Ccode1 = ccode1;
		Ccode2 = ccode2;
	}


	public int getCcode1() {
		return Ccode1;
	}
	public void setCcode1(int ccode1) {
		Ccode1 = ccode1;
	}
	public int getCcode2() {
		return Ccode2;
	}
	public void setCcode2(int ccode2) {
		Ccode2 = ccode2;
	}
	public int getContType() {
		return contType;
	}
	public void setContType(int contType) {
		this.contType = contType;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Ccode1;
		result = prime * result + Ccode2;
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
		Border other = (Border) obj;
		if((Ccode1 == other.Ccode1 && Ccode2 == other.Ccode2)||(Ccode1 == other.Ccode2 && Ccode2 == other.Ccode1)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public String toString() {
		return "Border [Ccode1=" + Ccode1 + ", Ccode2=" + Ccode2 + ", contType=" + contType + ", anno=" + anno + "]";
	}
	
	

}
