package br.com.casacandango.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.casacandango.modelo.Idoso;

public class IdosoDao extends GenericDao<Idoso> {
	

	@SuppressWarnings("unchecked")
	public List<Idoso> listarAtivos(){ // recebendo chave do estado primary
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Query consulta =sessao.createQuery("from Idoso where ativo=true");
			List<Idoso> resultado= consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			System.out.println("rolback ->  "+erro);
			throw erro;
		}finally {
			sessao.close();
		}
		
	}
	

 	@SuppressWarnings("unchecked")
	public List<Idoso> buscarPorFiltro(String ido){ // recebendo chave do estado primary
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta= sessao.createCriteria(Idoso.class);
			consulta.createAlias("funcionario","f");
			consulta.add(Restrictions.ilike("f.nome", ido, MatchMode.ANYWHERE));
			consulta.addOrder(Order.asc("nome"));
			List<Idoso> resultado= consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
		
	}
 



}
