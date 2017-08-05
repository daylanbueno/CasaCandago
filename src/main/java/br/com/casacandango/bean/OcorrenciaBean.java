package br.com.casacandango.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.omnifaces.util.Messages;

import br.com.casacandango.dao.FuncionarioDao;
import br.com.casacandango.dao.IdosoDao;
import br.com.casacandango.dao.OcorrenciaDao;
import br.com.casacandango.modelo.Funcionario;
import br.com.casacandango.modelo.Idoso;
import br.com.casacandango.modelo.Ocorrencia;

@ManagedBean
@ViewScoped
public class OcorrenciaBean {

	private Funcionario funcionario = new Funcionario();
	private FuncionarioDao funcionariodao = new FuncionarioDao();
	private List<Funcionario> funcionarios = new ArrayList<>();

	private Idoso idoso = new Idoso();
	private IdosoDao idosodao = new IdosoDao();
	private List<Idoso> idosos = new ArrayList<>();
	
	private Ocorrencia ocorrenciaSelecionada;

	private Ocorrencia ocorrencia = new Ocorrencia();
	private OcorrenciaDao ocorrenciadao = new OcorrenciaDao();
	private List<Ocorrencia> ocorrencias = new ArrayList<>();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Ocorrencia getOcorrenciaSelecionada() {
		return ocorrenciaSelecionada;
	}

	public void setOcorrenciaSelecionada(Ocorrencia ocorrenciaSelecionada) {
		this.ocorrenciaSelecionada = ocorrenciaSelecionada;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioDao getFuncionariodao() {
		return funcionariodao;
	}

	public void setFuncionariodao(FuncionarioDao funcionariodao) {
		this.funcionariodao = funcionariodao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Idoso getIdoso() {
		return idoso;
	}

	public void setIdoso(Idoso idoso) {
		this.idoso = idoso;
	}

	public IdosoDao getIdosodao() {
		return idosodao;
	}

	public void setIdosodao(IdosoDao idosodao) {
		this.idosodao = idosodao;
	}

	public List<Idoso> getIdosos() {
		return idosos;
	}

	public void setIdosos(List<Idoso> idosos) {
		this.idosos = idosos;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public OcorrenciaDao getOcorrenciadao() {
		return ocorrenciadao;
	}

	public void setOcorrenciadao(OcorrenciaDao ocorrenciadao) {
		this.ocorrenciadao = ocorrenciadao;
	}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}


	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}


	@PostConstruct
	public void listarCombos(){
		try {
		idosos=idosodao.listar();
		funcionarios =funcionariodao.listarAtivos();
		System.out.println("lsita carreagas para A ocorrencia");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar alista");
			e.printStackTrace();
		}
		
	}
	
	public void limparTudo(){
		idoso = new Idoso();
		funcionario = new Funcionario();
		ocorrencia = new Ocorrencia();
	}
	
	@PostConstruct
	public void listarOcorrencias(){
		try {
			this.ocorrencias=ocorrenciadao.listar();
			System.out.println("*****A lista de ocorrência foi carregada com sucesso******* !!");
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao carregar a lista  de ocorrências");
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			ocorrencia.setFuncionario(funcionario);
			ocorrencia.setIdoso(idoso);
			ocorrenciadao.salvar(ocorrencia);
			limparTudo();
			Messages.addGlobalInfo("Salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar ocorrência");
			e.printStackTrace();
		}
		
	}
	
	public void alterar(){
		try {
			ocorrenciadao.merge(ocorrencia);
			Messages.addGlobalInfo("Ocorrência foi alterada com sucesso ! ");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao alterar os dados da ocorrência !! ");
			e.printStackTrace();
		}
	}
	
	public void editar(){
		ocorrencia =ocorrenciaSelecionada;
		listarCombos();
		System.out.println("Ocorrencia tamos aee");
	}

}
