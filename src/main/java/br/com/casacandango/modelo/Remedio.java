package br.com.casacandango.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Remedio extends GenericoControle {

	@Column(length = 400, nullable = false)
	private String posologia;
	
	@Column(length = 50, nullable = false)
	
	private String indicacao;
	@Column(length = 50, nullable = false)
	private String  horarioDia;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Idoso idoso;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	public String getPosologia() {
		return posologia;
	}
	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	public String getIndicacao() {
		return indicacao;
	}
	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}
	public String getHorarioDia() {
		return horarioDia;
	}
	public void setHorarioDia(String horarioDia) {
		this.horarioDia = horarioDia;
	}
	public Idoso getIdoso() {
		return idoso;
	}
	public void setIdoso(Idoso idoso) {
		this.idoso = idoso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
