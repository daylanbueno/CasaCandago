package br.com.casacandango.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.omnifaces.util.Messages;


import br.com.casacandango.dao.CidadeDao;
import br.com.casacandango.dao.EstadoDao;
import br.com.casacandango.dao.ResponsavelDao;
import br.com.casacandango.dto.ResponsavelDto;
import br.com.casacandango.modelo.Cidade;
import br.com.casacandango.modelo.Contato;
import br.com.casacandango.modelo.Documento;
import br.com.casacandango.modelo.Endereco;
import br.com.casacandango.modelo.Estado;
import br.com.casacandango.modelo.Responsavel;

@ManagedBean
@ApplicationScoped
public class ResponsavelBean {
	
	private Estado estado = new Estado();
	private EstadoDao estadodao= new EstadoDao();
	private List<Estado> estados = new ArrayList<>();
	private Responsavel responsavelSelecionado;
	
	private Responsavel responsavel = new Responsavel();
	private ResponsavelDao responsaveldao = new ResponsavelDao();
	private List<Responsavel> responsaveis= new ArrayList<>();
	
	private Cidade  cidade = new Cidade();
	private CidadeDao cidadedao = new CidadeDao();
	private List<Cidade> cidades = new ArrayList<>();
	private Contato contato = new Contato();
	private Endereco endereco = new Endereco();
	private Documento documento  = new Documento();
	
	private ResponsavelDto responsaveldto;
	
	
	public Estado getEstado() {
		return estado;
	}
	
	
	public Responsavel getResponsavelSelecionado() {
		return responsavelSelecionado;
	}


	public void setResponsavelSelecionado(Responsavel responsavelSelecionado) {
		this.responsavelSelecionado = responsavelSelecionado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public EstadoDao getEstadodao() {
		return estadodao;
	}
	public void setEstadodao(EstadoDao estadodao) {
		this.estadodao = estadodao;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public CidadeDao getCidadedao() {
		return cidadedao;
	}
	public void setCidadedao(CidadeDao cidadedao) {
		this.cidadedao = cidadedao;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
		
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	public ResponsavelDao getResponsaveldao() {
		return responsaveldao;
	}
	public void setResponsaveldao(ResponsavelDao responsaveldao) {
		this.responsaveldao = responsaveldao;
	}
	
		
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}
	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public ResponsavelDto getResponsaveldto() {
		if(responsaveldto ==null){
			responsaveldto = new ResponsavelDto();
		}
		return responsaveldto;
	}


	public void setResponsaveldto(ResponsavelDto responsaveldto) {
		this.responsaveldto = responsaveldto;
	}


	public void limpar(){
		cidades = new ArrayList<>();
		estados = new ArrayList<>();
		estado   = new Estado();
		contato = new Contato();
		documento = new Documento();
		endereco = new Endereco();
		contato = new Contato();  
		cidade = new Cidade();
		responsavel = new Responsavel();
	}
		
	public void cidadePopular() {

		//System.out.println("estado " + estado.getCodigo());
		try {
			if (estado != null) {
				cidades = cidadedao.buscarPorEstado(estado.getCodigo());
			//	System.out.println("cidades carregada");
			} 
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar a lista de cidades");
			e.printStackTrace();
		}

	}

	
	public void salvar(){
		try {
			cidade.setEstado(estado);
			endereco.setCidade(cidade);
			responsavel.setEndereco(endereco);
			responsavel.setDocumento(documento);
			responsavel.setContato(contato);
			responsaveldao.merge(responsavel);
			listar();
			limpar();
			Messages.addGlobalInfo("Salvo com sucesso");;
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar o responsável");
			e.printStackTrace();
		}
		
	}
	
	public void editar(){
		carregarEstados();
		this.responsavel=responsavelSelecionado;
	
	}
	public void carregarEstados(){
	 estados =	estadodao.listar();
	}
	public void alterarResponsavel(){
		try {
			responsaveldao.merge(responsavel);
			limpar();
			Messages.addGlobalInfo("Os dados do responsável foi alterado com sucesso!");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao alterar os dados");
		}
		
	}
	
	@PostConstruct 
	public void listar(){
		try {
			carregarEstados();
			responsaveis = responsaveldao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar a lista de Responsáveis ");
			e.printStackTrace();
		}
		
	}
	
	public String findResponsavelByFilter(){
		responsaveis =	responsaveldao.findResponsavelByFilter(getResponsaveldto());
		if(responsaveis.size()>0){
			return "Responsavel.xhtml";
		}else{
			Messages.addGlobalError("Não foi encontrado registros que atendam os paramentros da pesquisa!");
			return "";
		}
	}
	
	
}
