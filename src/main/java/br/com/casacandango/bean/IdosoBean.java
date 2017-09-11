package br.com.casacandango.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.casacandango.dao.CidadeDao;
import br.com.casacandango.dao.DocumentoDao;
import br.com.casacandango.dao.EstadoDao;
import br.com.casacandango.dao.FormacaoDao;
import br.com.casacandango.dao.IdosoDao;
import br.com.casacandango.dao.ResponsavelDao;
import br.com.casacandango.modelo.Cidade;
import br.com.casacandango.modelo.Documento;
import br.com.casacandango.modelo.Estado;
import br.com.casacandango.modelo.Formacao;
import br.com.casacandango.modelo.Idoso;
import br.com.casacandango.modelo.Responsavel;

@ManagedBean
@ViewScoped
public class IdosoBean {

	private Estado estado = new Estado();
	private Idoso idosoSelecionado;
	private EstadoDao estadodao = new EstadoDao();
	private List<Estado> estados = new ArrayList<>();
	

	private FormacaoDao formacaodao = new FormacaoDao();
	private Formacao formacao = new Formacao();
	private List<Formacao> formacoes = new ArrayList<>();

	private Cidade cidade = new Cidade();
	private CidadeDao cidadedao = new CidadeDao();
	private List<Cidade> cidades = new ArrayList<>();

	private Responsavel responsavel = new Responsavel();
	private ResponsavelDao responsaveldao = new ResponsavelDao();
	private List<Responsavel> responsaveis = new ArrayList<>();

	private Idoso idoso = new Idoso();
	private IdosoDao idosodao = new IdosoDao();
	private List<Idoso> idosos = new ArrayList<>();
	private List<Idoso> idososTodos = new ArrayList<>();

	Documento documento = new Documento();
	DocumentoDao documentodao = new DocumentoDao();
	
	private String idosoBucar;
	
	public Idoso getIdosoSelecionado() {
		return idosoSelecionado;
	}

	public void setIdosoSelecionado(Idoso idosoSelecionado) {
		this.idosoSelecionado = idosoSelecionado;
	}


	public IdosoDao getIdosodao() {
		return idosodao;
	}
	

	public void setIdosodao(IdosoDao idosodao) {
		this.idosodao = idosodao;
	}

	public Idoso getIdoso() {
		return idoso;
	}

	public void setIdoso(Idoso idoso) {
		this.idoso = idoso;
	}

	public Estado getEstado() {
		return estado;
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

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public DocumentoDao getDocumentodao() {
		return documentodao;
	}

	public void setDocumentodao(DocumentoDao documentodao) {
		this.documentodao = documentodao;
	}

	public List<Idoso> getIdosos() {
		return idosos;
	}

	public void setIdosos(List<Idoso> idosos) {
		this.idosos = idosos;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public FormacaoDao getFormacaodao() {
		return formacaodao;
	}

	public void setFormacaodao(FormacaoDao formacaodao) {
		this.formacaodao = formacaodao;
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}
	

	public String getIdosoBucar() {
		return idosoBucar;
	}

	public void setIdosoBucar(String idosoBucar) {
		this.idosoBucar = idosoBucar;
	}
	
	
	public List<Idoso> getIdososTodos() {
		return idososTodos;
	}

	public void setIdososTodos(List<Idoso> idososTodos) {
		this.idososTodos = idososTodos;
	}

//--------------------------------------------------------------------------------------------------------------------------------------------------
			
	public void cidadePopular() {

		System.out.println("estado " + estado.getCodigo());
		try {
			if (estado != null) {
				cidades = cidadedao.buscarPorEstado(estado.getCodigo());
				System.out.println("cidades carregada");
			} else {
				limparTudo();
			}

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar a lista de cidades");
			e.printStackTrace();
		}

	}

//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void grauInstrucao() {
		try {
			formacoes = formacaodao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar a formação");

		}
	}

//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void limparTudo() {
		idoso = new Idoso();
		responsavel = new Responsavel();
		cidade = new Cidade();
		estado = new Estado();
		formacao = new Formacao();
		documento = new Documento();
	}


//--------------------------------------------------------------------------------------------------------------------------------------------------

	@PostConstruct
	public void listarCombos() {
		getDataHoje();
		try {
			grauInstrucao();
			cidades = cidadedao.listar();
			estados = estadodao.listar();
			responsaveis = responsaveldao.listar();
			System.out.println("Listas carregadas com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar as litas");
			e.printStackTrace();
		}

	}

//--------------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar() {
		idoso.setAtivo(true);
		try {
			cidade.setEstado(estado);
			idoso.setCidade(cidade);
			idoso.setResponsavel(responsavel);
			idoso.setDocumento(documento);
			idoso.setFormacao(formacao);
			idosodao.salvar(idoso);
			listar();
			limparTudo();
			Messages.addGlobalInfo("Salvo com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar o Idoso !");
			e.printStackTrace();
		}

	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------	
	public void alteraIdoso(){
		idoso.setAtivo(true);
		try {
			idosodao.merge(idoso);
		    limparTudo();
			Messages.addGlobalInfo("Os dados o idoso foram alterados com sucesso !");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao alterar os dados do Idoso");
		}
		
	}

//--------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void editar(){
		this.idoso =idosoSelecionado;
		listarCombos();
		System.out.println("Estamos ae");
	}

//--------------------------------------------------------------------------------------------------------------------------------------------------
	public void desativar(){
		idoso.setAtivo(false);
		System.out.println("Desativar !!!");
		try {
			idosodao.merge(idoso);
			idosoSelecionado=null;
			listar();
			limparTudo();
			Messages.addGlobalInfo("O idoso foi desligado com sucesso!");
		} catch (Exception e) {
			Messages.addGlobalError("Não consegui desligar o idoso");
			e.printStackTrace();
		}
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void cancelar(){		
				Messages.addGlobalInfo("Operação cancelada com sucesso!");
	}
		
	
//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void bucarPorNome(){		
				System.out.println("buscar por nome   => "+idosoBucar);
				idosos=idosodao.buscarPorFiltro(idosoBucar);
				
	}
		
//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void listar() {
		try {
			idosos = idosodao.listarAtivos();
			System.out.println("lista de idosos carregada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar a lista de Idosos");
			e.printStackTrace();
		}

	}

//--------------------------------------------------------------------------------------------------------------------------------------------------
		public void listarTodos() {
			try {
				idososTodos= idosodao.listar();
				System.out.println("lista de idosos carregada com sucesso!");
			} catch (RuntimeException e) {
				Messages.addGlobalError("Erro ao carregar a lista de Idosos");
				e.printStackTrace();
			}

		}

	
//-----------------------------------------------------------------------------------------------------------------------------
	// metodo que pega a data de hoje
	
	public Date getDataHoje(){
		return new Date();
	}

	
	
}
