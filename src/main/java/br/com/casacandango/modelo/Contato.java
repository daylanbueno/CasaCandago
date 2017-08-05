package br.com.casacandango.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Contato extends GenericoControle {

	@Column(length = 20)
	private String telFix;
	@Column(length = 20)
	private String telTrabalho;
	@Column(length = 20)
	private String celular;
	@Column(length = 50)
	private String email;
	
	public String getTelFix() {
		return telFix;
	}
	public void setTelFix(String telFix) {
		this.telFix = telFix;
	}
	public String getTelTrabalho() {
		return telTrabalho;
	}
	public void setTelTrabalho(String telTrabalho) {
		this.telTrabalho = telTrabalho;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
