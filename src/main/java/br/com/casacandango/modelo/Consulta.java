package br.com.casacandango.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Consulta extends GenericoControle {

	@ManyToOne
	@JoinColumn(nullable = false)
	private Idoso idoso;
	
	@Temporal(TemporalType.DATE)
	private Date dataConsulta;
	
	@Temporal(TemporalType.TIME)
	private Date horasConsulta;
	
	@Column(length = 80 , nullable = false)
	private String localConsulta;
	
	@Column(length = 50, nullable = false)
	private String especialidade;
	
	
	public Idoso getIdoso() {
		return idoso;
	}

	public void setIdoso(Idoso idoso) {
		this.idoso = idoso;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Date getHorasConsulta() {
		return horasConsulta;
	}

	public void setHorasConsulta(Date horasConsulta) {
		this.horasConsulta = horasConsulta;
	}

	public String getLocalConsulta() {
		return localConsulta;
	}

	public void setLocalConsulta(String localConsulta) {
		this.localConsulta = localConsulta;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
	
	
}
