package br.com.casacandango.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.casacandango.dao.UsuarioDao;
import br.com.casacandango.modelo.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@PostConstruct
	public void iniciar(){
		usuario = new Usuario();
	}
	
	public void autenticar(){
		try{
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioLogado = usuarioDao.autenticar(usuario.getLogin(), usuario.getSenha());
			if(usuarioLogado == null && !isAdministrador()){
				Messages.addGlobalError("Usuário ou senha incorretos.");
				return;
			}
			Faces.redirect("./index.xhtml");
		}catch(IOException erro){
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
	
	public boolean isAdministrador(){
		boolean retorno = false;
		if(getUsuario().getLogin().equals("admin") && getUsuario().getSenha().equals("admin")){
			getUsuario().getFuncionario().setNome("Administrador do Sistema");
			usuarioLogado = getUsuario();
			retorno = true;
		}
		return retorno;
	}
	
	public void controle(){
		if(usuarioLogado == null){
			try {
				Faces.redirect("./Login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sair(){
		if(usuarioLogado != null){
			usuarioLogado = null;
			try {
				Faces.redirect("./Login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				Faces.redirect("./Login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
