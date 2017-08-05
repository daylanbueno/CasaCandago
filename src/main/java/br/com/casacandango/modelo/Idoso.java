package br.com.casacandango.modelo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Idoso extends GenericoControle {

	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 100, nullable = false)
	private String nomePai;
	
	@Column(length = 100, nullable = false)
	private String nomeMae;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	
	@Column(length = 20, nullable = false)
	private String estadoCivil;
	
	@Column(length = 20, nullable = false)
	private String sexo;
	
	@Column(length = 100)
	private String encaminhadoPor;
	
	@Column(length = 30)
	private String numCarteira;
	
	@Column(length = 30)
	private String numCarteiraSus;
	
	
	@Column(length = 400, nullable = false)
	private String motivoInstitucional;
	
	@Column(length = 400)
	private String pertencesTrazido;
	
	@Column(length = 100)
	private String deficiencia;
	
	
	@Column(length = 50, nullable = false)
	private String tipoRenda;
	
	@Column(length = 400)
	private String motivoDesligamento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade Cidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Responsavel responsavel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Documento documento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Formacao formacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDesligamento;
	
	@Column
	private Boolean ativo;
	
	
	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public String getNumCarteiraSus() {
		return numCarteiraSus;
	}

	public void setNumCarteiraSus(String numCarteiraSus) {
		this.numCarteiraSus = numCarteiraSus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEncaminhadoPor() {
		return encaminhadoPor;
	}

	public void setEncaminhadoPor(String encaminhadoPor) {
		this.encaminhadoPor = encaminhadoPor;
	}

	public String getNumCarteira() {
		return numCarteira;
	}

	public void setNumCarteira(String numCarteira) {
		this.numCarteira = numCarteira;
	}

	public String getMotivoInstitucional() {
		return motivoInstitucional;
	}

	public void setMotivoInstitucional(String motivoInstitucional) {
		this.motivoInstitucional = motivoInstitucional;
	}

	public String getPertencesTrazido() {
		return pertencesTrazido;
	}

	public void setPertencesTrazido(String pertencesTrazido) {
		this.pertencesTrazido = pertencesTrazido;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}


	public String getTipoRenda() {
		return tipoRenda;
	}

	public void setTipoRenda(String tipoRenda) {
		this.tipoRenda = tipoRenda;
	}

	public String getMotivoDesligamento() {
		return motivoDesligamento;
	}

	public void setMotivoDesligamento(String motivoDesligamento) {
		this.motivoDesligamento = motivoDesligamento;
	}

	public Cidade getCidade() {
		return Cidade;
	}

	public void setCidade(Cidade cidade) {
		Cidade = cidade;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Date getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(Date dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
}
