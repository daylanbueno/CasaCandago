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
	
	@SuppressWarnings({"unchecked" })
	public List<Responsavel> findResponsavelByFilter(ResponsavelDto responsaveldto){
	  Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();	
	  StringBuilder hql = new StringBuilder();
	  hql.append(" SELECT resp FROM Responsavel resp ");
	  hql.append(" LEFT JOIN FETCH resp.documento doc ");
	  hql.append(" LEFT JOIN FETCH resp.contato cont ");
	  hql.append(" WHERE 1=1 ");
	  
	  if(responsaveldto.getNome()!=null && !responsaveldto.getNome().isEmpty()){
		  hql.append(" AND resp.nome like  :pNome ");
	  }
	  if(responsaveldto.getCpf()!=null && !responsaveldto.getCpf().isEmpty()){
		  hql.append(" AND doc.cpf  = :pCpf ");
	  }
	  if(responsaveldto.getEmail()!=null && !responsaveldto.getEmail().isEmpty()){
		  hql.append(" AND cont.email = :pEmail ");
	  }
	  if(responsaveldto.getTelFix()!=null && !responsaveldto.getTelFix().isEmpty()){
		  hql.append(" AND cont.telFix = :pTel");
	  }
	  if(responsaveldto.getCelular()!=null && !responsaveldto.getCelular().isEmpty()){
		  hql.append(" AND cont.celular = :pCelular ");
	  }
	  
	  Query query = sessao.createQuery(hql.toString());
	  if(responsaveldto.getNome()!=null && !responsaveldto.getNome().isEmpty()){
		  query.setParameter("pNome","%"+responsaveldto.getNome()+"%");
	  }
	 
	  if(responsaveldto.getCpf()!=null && !responsaveldto.getCpf().isEmpty()){
		  query.setParameter("pCpf",responsaveldto.getCpf());
	  }
	  if(responsaveldto.getEmail()!=null && !responsaveldto.getEmail().isEmpty()){
		  query.setParameter("pEmail", responsaveldto.getEmail());
	  }
	  if(responsaveldto.getTelFix()!=null && !responsaveldto.getTelFix().isEmpty()){
		  query.setParameter("pTel", responsaveldto.getTelFix());
	  }
	  if(responsaveldto.getCelular()!=null && !responsaveldto.getCelular().isEmpty()){
		  query.setParameter("pCelular", responsaveldto.getCelular());
	  }
	
	  return query.list();
	}
	
}
