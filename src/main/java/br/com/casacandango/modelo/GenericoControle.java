package br.com.casacandango.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass // dizendo que não conresponde a uma tabela.
public class GenericoControle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	
	 @Override
	public String toString() {
		 return String.format("%s[id=%d]", getClass().getSimpleName(), getCodigo());
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
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
		GenericoControle other = (GenericoControle) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}







}
