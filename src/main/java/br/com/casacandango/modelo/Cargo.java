package br.com.casacandango.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Cargo extends GenericoControle{

	
	@Column(length = 45, nullable = false )
	private String nome;
	
	@Column(nullable = false,precision = 6, scale = 2 )//9.999,99 conseguimos representar
	private BigDecimal salario;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
}
