package br.com.casacandango.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.casacandango.dto.ResponsavelDto;
import br.com.casacandango.modelo.Estado;
import br.com.casacandango.modelo.Responsavel;

public class ResponsavelDao extends GenericDao<Responsavel>{
	
	public void salvarR(Responsavel entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
				System.out.println("rollback "+erro);
			}
			throw erro;
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Estado> findAllEstados(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT estado from Estado estado");
        Query query = sessao.createQuery(hql.toString());
		return query.list();	
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public List<Responsavel> findResponsavelByFilter(ResponsavelDto responsaveldto){
	  Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();	
	  StringBuilder hql = new StringBuilder();
	  hql.append("SELECT resp FROM Responsavel resp ");
	 
	  if(responsaveldto.getNome()!=null || !responsaveldto.getNome().isEmpty()){
		  hql.append("WHERE resp.nome like  :pNome ");
	  }	
	  Query query = sessao.createQuery(hql.toString());
	  query.setParameter("pNome","%"+responsaveldto.getNome()+"%");
	  return query.list();
	}
	
}
