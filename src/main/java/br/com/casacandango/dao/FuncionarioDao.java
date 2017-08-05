package br.com.casacandango.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import br.com.casacandango.modelo.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarAtivos(){ // recebendo chave do estado primary
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Query consulta =sessao.createQuery("from Funcionario where ativo=true");
			List<Funcionario> resultado= consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			System.out.println("rolback ->  "+erro);
			throw erro;
		}finally {
			sessao.close();
		}
		
	}

	
}
