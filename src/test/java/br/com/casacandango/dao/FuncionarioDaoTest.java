package br.com.casacandango.dao;

import java.util.Date;

import org.junit.Test;

import br.com.casacandango.modelo.Cargo;
import br.com.casacandango.modelo.Cidade;
import br.com.casacandango.modelo.Contato;
import br.com.casacandango.modelo.Documento;
import br.com.casacandango.modelo.Endereco;
import br.com.casacandango.modelo.Estado;
import br.com.casacandango.modelo.Funcionario;

public class FuncionarioDaoTest {

	@Test
	public void salvar() {

		Funcionario funcionario = new Funcionario();
		FuncionarioDao funcionarioDao = new FuncionarioDao();

		Endereco endereco = new Endereco();

		Estado estado = new Estado();
		EstadoDao estadodao = new EstadoDao();

		Cidade cidade = new Cidade();
		
		Cargo cargo = new Cargo();
		CargoDao cargodao = new CargoDao();

		Documento documento = new Documento();
		Contato contato = new Contato();

		estado = estadodao.buscar(1l);

		cargo = cargodao.buscar(6l);

		if (estado == null) {

			System.out.println("não encotrou um cidade");

		} else if (cargo == null) {
			System.out.println("Cargo não foi encontrado");
		} else {

			funcionario.setNome("Daylan Bueno dos Santos");

			funcionario.setEstadoCivil("Casado");
			funcionario.setSexo("Masculino");

			System.out.println("-----------------------------");

			endereco.setRua("01");
			endereco.setComplemento("sem /n");
			endereco.setLogradouro("Conjunto c casa ");
			endereco.setNumero("23");
			cidade.setNome("Sobradinho");
			cidade.setEstado(estado);
			endereco.setCidade(cidade);

			contato.setTelFix("61-3101-1637");
			contato.setEmail("daylansantos@gmail.com.br");
			contato.setCelular("61-0105-2632");

			documento.setCpf("99999999");
			documento.setRg("433229999");

			funcionario.setContato(contato);
			funcionario.setDocumento(documento);
			funcionario.setEndereco(endereco);
			funcionario.setCargo(cargo);
			funcionario.setDataAdmisao(new Date());
			

			funcionarioDao.salvar(funcionario);
			System.out.println("Salvo com sucesso");

		}

	}

}
