package br.com.casacandango.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.casacandango.modelo.Permissao;

public class PermissaoDaoTest {

	PermissaoDao permissaodao = new PermissaoDao();
	Permissao permissao = new Permissao();

	@Test
	@Ignore
	public void salvar() {

		try {
			permissao.setNome("Usuario");
			permissaodao.salvar(permissao);
			System.out.println("salvou com sucesso!");
		} catch (RuntimeException e) {
			System.out.println("Não salvou");
			e.printStackTrace();

		}

	}

	@Test
	public void listar() {

		 List<Permissao> lista=  new ArrayList<>();
		
		try {
			
			lista = permissaodao.listar();
			System.out.println("tai");
			
			System.out.println();
			
			for(Permissao p :lista){
				System.out.println(p.getCodigo()+"  -  "+  p.getNome());
			}
			
		} catch(RuntimeException e) {
			System.out.println("Erro ao trazer a listar de Permissões");
		}
	}
}
