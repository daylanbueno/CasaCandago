package br.com.casacandango.dao;



import org.junit.Ignore;
import org.junit.Test;

import br.com.casacandango.modelo.Responsavel;
import br.com.casacandango.modelo.Cidade;
import br.com.casacandango.modelo.Contato;
import br.com.casacandango.modelo.Documento;
import br.com.casacandango.modelo.Endereco;
import br.com.casacandango.modelo.Estado;

public class ResponsavelDaoTest {
	
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void salvar(){
		
		 Contato contato = new Contato();
		 Endereco endereco = new Endereco();
		 Cidade cidade = new Cidade();
		 CidadeDao cidadedao = new CidadeDao();
		 DocumentoDao documentodao = new DocumentoDao();
		 Documento documento = new Documento();
		 Estado estado  = new Estado();
		 EstadoDao estadodao= new EstadoDao();
		 Responsavel responsavel  = new Responsavel();
		 ResponsavelDao responsaveldao = new ResponsavelDao();
		 

		 estado = estadodao.buscar(1l);
		 cidade = cidadedao.buscar(1l);
		 
		 if(estado == null || cidade== null){
			 System.out.println("Não carregou as listas");
		 }else{
			 
			 endereco.setLogradouro("asdfasf");
			 endereco.setNumero("234");
			 endereco.setRua("asdfas");
			 endereco.setComplemento("sdfasf");
			 
			 documento.setCpf("345345354");
			 documento.setRg("54rtert");
			 
			 contato.setCelular("453453");
			 contato.setTelFix("3464789679");
			 contato.setEmail("gmail.coj");
			 
			 
			 
			 try {
				 
				 cidade.setEstado(estado);
				 endereco.setCidade(cidade);
				 responsavel.setEndereco(endereco);
				 responsavel.setContato(contato);
				 responsavel.setDocumento(documento);
				 responsavel.setNome("Jorge");

				 responsaveldao.salvar(responsavel); // dando erro
				 System.out.println("Salvou o responsável");
				} catch (RuntimeException e) {
					System.out.println("Erro ao salvar try");
					e.printStackTrace();
				}
			 
			 
		 }
		 
		 
		

		
		
	}

}
