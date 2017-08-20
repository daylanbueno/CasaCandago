package br.com.casacandango.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.casacandango.dao.CargoDao;
import br.com.casacandango.dao.CidadeDao;
import br.com.casacandango.dao.EstadoDao;
import br.com.casacandango.dao.FuncionarioDao;
import br.com.casacandango.dto.FuncionarioDTO;
import br.com.casacandango.modelo.Cargo;
import br.com.casacandango.modelo.Cidade;
import br.com.casacandango.modelo.Contato;
import br.com.casacandango.modelo.Documento;
import br.com.casacandango.modelo.Endereco;
import br.com.casacandango.modelo.Estado;
import br.com.casacandango.modelo.Funcionario;

@SuppressWarnings("serial")
@ManagedBean
@ApplicationScoped
public class FuncionarioBean implements Serializable {

	private Cidade cidade = new Cidade();
	private CidadeDao cidadedao = new CidadeDao();
	private List<Cidade> cidades = new ArrayList<>();
	private List<Estado> estados = new ArrayList<>();
	private Contato contato = new Contato();
	private Endereco endereco = new Endereco();
	private Documento documento = new Documento();
	private Cargo cargo = new Cargo();
	private List<Cargo> cargos = new ArrayList<>();
	private CargoDao cargodao = new CargoDao();
	private Funcionario funcionarioSelecionado;

	private EstadoDao estadodao = new EstadoDao();
	private Estado estado = new Estado();
	private FuncionarioDao funcionariodao = new FuncionarioDao();
	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<>();
	private FuncionarioDTO funcionariodto = new FuncionarioDTO();

	public FuncionarioBean() {
		listarFuncionario();
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public CargoDao getCargodao() {
		return cargodao;
	}

	public void setCargodao(CargoDao cargodao) {
		this.cargodao = cargodao;
	}

	public EstadoDao getEstadodao() {
		return estadodao;
	}

	public void setEstadodao(EstadoDao estadodao) {
		this.estadodao = estadodao;
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public CidadeDao getCidadedao() {
		return cidadedao;
	}

	public void setCidadedao(CidadeDao cidadedao) {
		this.cidadedao = cidadedao;
	}

	public FuncionarioDTO getFuncionariodto() {
		return funcionariodto;
	}

	public void setFuncionariodto(FuncionarioDTO funcionariodto) {
		this.funcionariodto = funcionariodto;
	}

	public void cidadePopular() {

		System.out.println("estado " + estado.getCodigo());
		try {
			if (estado != null) {
				cidades = cidadedao.buscarPorEstado(estado.getCodigo());
				System.out.println("cidades carregada");
			} else {
				limpar();
			}

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar a lista de cidades");
			e.printStackTrace();
		}

	}
	
	
	

	public void limpar() {
		cidade = new Cidade();
		cidades = new ArrayList<>();
		estado = new Estado();
		funcionario = new Funcionario();
		endereco = new Endereco();
		documento = new Documento();
		contato = new Contato();
		cargo = new Cargo();

	}


	public void listaCombos() {
		limpar();
		getDataHoje();
		try {
			estados = estadodao.listar();
			cargos = cargodao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro os lista para os combos");
			e.printStackTrace();
		}

	}

	public void salvar() {
		try {
			System.out.println(estado);

			cidade.setEstado(estado);
			endereco.setCidade(cidade);
			funcionario.setEndereco(endereco);
			funcionario.setContato(contato);
			funcionario.setDocumento(documento);
			funcionario.setEndereco(endereco);
			funcionario.setCargo(cargo);
			funcionario.setAtivo(true);
			funcionariodao.merge(funcionario);
			listarFuncionario();
			listaCombos();
			Messages.addGlobalInfo("Salvo com sucesso!!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar o funcionário");
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void listarFuncionario() {
		listaCombos();
		try {
			System.out.println("caregou a lista de funcionarioS");
			this.funcionarios = funcionariodao.listarAtivos();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar a lista de  funcionários");
			e.printStackTrace();

		}
	}
	
	
//------------------------------------------------------------------------------------------------------------/
	public void alterarFunc(){
			funcionario.setAtivo(true);
     		try {
			funcionariodao.merge(funcionario);
			limpar();
			Messages.addGlobalInfo("Os dados foram alterado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao alterar os dados");
			System.out.println("Erro: "+e);
		}
		
		
	}
	
//------------------------------------------------------------------------------------------------------------//
	public void editar(){
		listaCombos();
		try {
			this.funcionario=funcionarioSelecionado;
			estado = estadodao.buscar(funcionario.getEndereco().getCidade().getEstado().getCodigo());
			estados  = estadodao.listar();
			cidades =cidadedao.buscarPorEstado(estado.getCodigo());
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar  a lista de editar");
		}
	
	}

	
//------------------------------------------------------------------------------------------------------------//
	
	public void demitir(){
		funcionario.setDataDemissao(getDataHoje());
		funcionario.setAtivo(false);
		try {
			funcionariodao.merge(funcionario);
			listarFuncionario();
			funcionarioSelecionado=null;
			Messages.addGlobalInfo("O Funcionário foi demitido");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao demitir o funionário");
			e.printStackTrace();
		}
	}
	
	
//------------------------------------------------------------------------------------------------------------//
	public void listar(){
		try {
			funcionarios = funcionariodao.listarAtivos();
		} catch (Exception e) {
			 	Messages.addGlobalError("Erro ao carregar a lista de funcionários");
		}
		
	}
	
	
	public void excluir(){
		
		if(this.funcionarioSelecionado!=null){
			try {
				funcionariodao.excluir(funcionarioSelecionado);
				Messages.addGlobalInfo("Excluido com sucesso!");
			} catch (Exception e) {
				Messages.addGlobalError("Erro ao excluir ");
				e.printStackTrace();
			}

		}
		
	}
	
	public String findFuncionarioByFilter(){
			setFuncionarios(funcionariodao.findFuncionarioByFilter(getFuncionariodto()));
			if(getFuncionarios().size()>0){
				return"ResultadoPesquisarFuncionario.xhtml";
			}else{
				Messages.addGlobalError(" Não foi encontrado registros que atendam os paramentros da pesquisa!");
				return "";
			}
	}
	
	// metodo que pega a data de hoje
	@PostConstruct
	public Date getDataHoje(){
		return new Date();
	}

	public void limparFiltro(){
		funcionariodto = new FuncionarioDTO();
	}
}
