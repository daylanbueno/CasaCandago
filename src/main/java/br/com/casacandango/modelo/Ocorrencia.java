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
public class Ocorrencia extends GenericoControle{
	


	@ManyToOne
	@JoinColumn(nullable = false)
	private Idoso idoso;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable = false, length=5000)
	private String descricao;
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Idoso getIdoso() {
		return idoso;
	}
	public void setIdoso(Idoso idoso) {
		this.idoso = idoso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
