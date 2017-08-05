package br.com.casacandango.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.casacandango.modelo.Cidade;

public class CidadeDaoTest {
	
	@Test
	@Ignore
	public void listar(){
		CidadeDao cidadedao= new CidadeDao();
		
		List<Cidade> cidades = null;
		
		cidades = cidadedao.listar();
		
		if(cidades == null){
			System.out.println("lsita vazia!");
		}else{
			
			for(Cidade city: cidades){
				System.out.println(city.getNome()+ " -- "+city.getEstado().getNome()+" -- "+city.getEstado().getSigla());
			}
			
		}
		
		
	}
	

	@Test
	public void buscarPorEstado(){
		
		CidadeDao cidadedao= new CidadeDao();
		List<Cidade> cidades= new ArrayList<>();
		
		cidades= cidadedao.buscarPorEstado(1l);
		
		if(cidades == null){
			System.out.println("Não foi encontrada cidades");
		}else{
			
			for(Cidade cidade : cidades){
				System.out.println("Código "+cidade.getCodigo());
				System.out.println("Cidade  "+cidade.getNome());
			}
	
			
		}
		
		
		
	}
	

}
