package br.com.casacandango.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.casacandango.modelo.Cidade;

public class CidadeDao extends GenericDao<Cidade> {

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstado(Long codigo){ // recebendo chave do estado primary
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta= sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eqOrIsNull("estado.codigo", codigo));
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado= consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
		
	}
	
}
