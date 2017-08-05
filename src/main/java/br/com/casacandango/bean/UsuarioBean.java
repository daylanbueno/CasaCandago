package br.com.casacandango.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.casacandango.dao.FuncionarioDao;
import br.com.casacandango.dao.PermissaoDao;
import br.com.casacandango.dao.UsuarioDao;
import br.com.casacandango.modelo.Funcionario;
import br.com.casacandango.modelo.Permissao;
import br.com.casacandango.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Usuario userSelecionado;
	private UsuarioDao usuariodao= new UsuarioDao();
	private List<Usuario> usuarios = new ArrayList<>();
	private Funcionario funcionario = new Funcionario();
	FuncionarioDao funcionariodao = new FuncionarioDao();
	private PermissaoDao permissaodao = new PermissaoDao();
	private Permissao permissao = new Permissao();
	private List<Funcionario> funcionarios = new ArrayList<>();
	private List<Permissao> permissoes= new ArrayList<>();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Usuario getUserSelecionado() {
		return userSelecionado;
	}
	public void setUserSelecionado(Usuario userSelecionado) {
		System.out.println("pegou!!");
		this.userSelecionado = userSelecionado;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	public UsuarioDao getUsuariodao() {
		return usuariodao;
	}
	public void setUsuariodao(UsuarioDao usuariodao) {
		this.usuariodao = usuariodao;
	}
	public FuncionarioDao getFuncionariodao() {
		return funcionariodao;
	}
	public void setFuncionariodao(FuncionarioDao funcionariodao) {
		this.funcionariodao = funcionariodao;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
	public PermissaoDao getPermissaodao() {
		return permissaodao;
	}
	public void setPermissaodao(PermissaoDao permissaodao) {
		this.permissaodao = permissaodao;
	}
	

	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	@PostConstruct
	public void listaFuncionario(){
		limpar();
		try {
			funcionarios = funcionariodao.listarAtivos();
			listarPermissoes();
			listarUsuarios();
			System.out.println("Lista de Funcionários carregada");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Falha ao carregar a lista de Funcionários");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listarPermissoes(){
		
		try {
			permissoes= permissaodao.listar();
			listarUsuarios();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar as permissões");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listarUsuarios(){
		try {
			limpar();
			this.usuarios= usuariodao.usuariosAtivos();
			System.out.println("A lista de Usuário foi carregada");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Falha ao carregar a lista de Usuários");
			e.printStackTrace();
		}
	}

	
	public void limpar(){
		usuario = new Usuario();
		funcionario = new Funcionario();
	}
	
	
	public void excluir(){
		if(userSelecionado!=null){
			
			try {
				usuariodao.excluir(userSelecionado);
				listarUsuarios();
				Messages.addGlobalInfo("Excluido com sucesso !");
			} catch (Exception erro) {
				Messages.addGlobalError("Não salvou o usuário");
			}
			
		}else{
			System.err.println("Não foi passado linha da tabela ");
		}
	}
	
	public void salvar(){
		try {
			
			usuariodao.merge(usuario);
			limpar();
			listarUsuarios();
			Messages.addGlobalInfo("Salvo  com sucesso");
		} catch (Exception e) {
			
		}
	}
	
	public void editar(){
		usuarios = usuariodao.listar();
		this.usuario = userSelecionado;
		Messages.addGlobalInfo(usuario.getFuncionario().getNome() + "  "+ usuario.getPermissao().getNome()+ "  " +usuario.getLogin() + " "+  usuario.getSenha());
		try {
		permissoes = permissaodao.listar();
		funcionarios = funcionariodao.listar();
		} catch (Exception e) {
		 Messages.addGlobalError("Erro ao carregar lista para editar");
		}
	}
	
}
