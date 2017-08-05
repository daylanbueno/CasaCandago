package br.com.casacandango.dao;

import org.junit.Test;

import br.com.casacandango.modelo.Funcionario;
import br.com.casacandango.modelo.Usuario;

public class UsuarioDaoTest {

	@Test
	public void salvar(){
		
		Funcionario funcionario = new Funcionario();
		FuncionarioDao funcionariodao = new FuncionarioDao();
		
		Usuario usuario = new Usuario();
		UsuarioDao usuariodao = new UsuarioDao();
		
		funcionario = funcionariodao.buscar(2l);
		if(funcionario == null){
			System.out.println("Funcionario não encontrado");
		}else{
			
			usuario.setFuncionario(funcionario);
			usuario.setLogin("daylan.bueno");
			usuario.setSenha("daylan123");
			usuariodao.salvar(usuario);
			System.out.println("Usuário salvo com sucesso");
		}
		
	}
	
}
