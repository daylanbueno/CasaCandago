package br.com.casacandango.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omnifaces.util.Messages;

import br.com.casacandango.modelo.Cidade;
import br.com.casacandango.modelo.Estado;
import br.com.casacandango.modelo.Responsavel;

public class IdosoDaoTest {
	@SuppressWarnings("unused")
	@Test
	public void listarCombos() {

		
		EstadoDao estadodao = new EstadoDao();
		List<Estado> estados = new ArrayList<>();

		
		CidadeDao cidadedao = new CidadeDao();
		List<Cidade> cidades = new ArrayList<>();

		
		ResponsavelDao responsaveldao = new ResponsavelDao();
		List<Responsavel> responsaveis = new ArrayList<>();

		try {
			cidades = cidadedao.listar();
			estados = estadodao.listar();
			responsaveis = responsaveldao.listar();
			System.out.println("Listas carregadas com sucesso!");
			System.out.println();
			
			for(Cidade cid : cidades){
				System.out.println(cid.getNome()+"-- "+cid.getEstado().getSigla());
			}
			
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao carregar as litas");
			e.printStackTrace();
		}

	}

}
