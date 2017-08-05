package br.com.casacandango.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.casacandango.modelo.Formacao;

public class FormacaoDaoTest {
	
	
	@Test
	@Ignore
	public void listar(){
		FormacaoDao formacaodao  = new FormacaoDao();
		List<Formacao> formacao = new  ArrayList<>();
		
		try {
			formacao = formacaodao.listar();
			
			for(Formacao f: formacao){
				System.out.println(f.getCodigo()+"  -- "+f.getNome());
			}
		} catch (RuntimeException e) {
			System.out.println("Nao carregou a lista ");
		}
		
	}

}
