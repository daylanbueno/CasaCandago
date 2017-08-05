package br.com.casacandango.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
