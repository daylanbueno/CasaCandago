package br.com.casacandango.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.casacandango.dto.FuncionarioDTO;
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

	
	@SuppressWarnings({"unchecked" })
	public List<Funcionario> findFuncionarioByFilter(FuncionarioDTO funcionariodto){
	  Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();	
	  StringBuilder hql = new StringBuilder();
	  hql.append(" SELECT func FROM Funcionario func ");
	  hql.append(" LEFT JOIN FETCH func.documento doc ");
	  hql.append(" LEFT JOIN FETCH func.contato cont ");
	  hql.append(" LEFT JOIN FETCH func.endereco endereco ");
	  hql.append(" LEFT JOIN FETCH endereco.cidade cidade ");
	  hql.append(" LEFT JOIN FETCH cidade.estado estado ");
	  hql.append(" WHERE 1=1 ");
	  
	  if(funcionariodto.getNome()!=null && !funcionariodto.getNome().isEmpty()){
		  hql.append(" AND func.nome like  :pNome ");
	  }
	  if(funcionariodto.getCpf()!=null && !funcionariodto.getCpf().isEmpty()){
		  hql.append(" AND doc.cpf  = :pCpf ");
	  }
	  if(funcionariodto.getEmail()!=null && !funcionariodto.getEmail().isEmpty()){
		  hql.append(" AND cont.email = :pEmail ");
	  }
	  if(funcionariodto.getTelFix()!=null && !funcionariodto.getTelFix().isEmpty()){
		  hql.append(" AND cont.telFix = :pTel");
	  }
	  if(funcionariodto.getEstado()!=null){
		  hql.append(" AND estado = :pEstado");
	  }
	  if(funcionariodto.getCelular()!=null && !funcionariodto.getCelular().isEmpty()){
		  hql.append(" AND cont.celular = :pCelular ");
	  }
	  
	  Query query = sessao.createQuery(hql.toString());
	  if(funcionariodto.getNome()!=null && !funcionariodto.getNome().isEmpty()){
		  query.setParameter("pNome","%"+funcionariodto.getNome()+"%");
	  }
	 
	  if(funcionariodto.getCpf()!=null && !funcionariodto.getCpf().isEmpty()){
		  query.setParameter("pCpf",funcionariodto.getCpf());
	  }
	  if(funcionariodto.getEmail()!=null && !funcionariodto.getEmail().isEmpty()){
		  query.setParameter("pEmail", funcionariodto.getEmail());
	  }
	  if(funcionariodto.getTelFix()!=null && !funcionariodto.getTelFix().isEmpty()){
		  query.setParameter("pTel", funcionariodto.getTelFix());
	  }
	  if(funcionariodto.getCelular()!=null && !funcionariodto.getCelular().isEmpty()){
		  query.setParameter("pCelular", funcionariodto.getCelular());
	  }
	  if(funcionariodto.getEstado()!=null){
		  query.setParameter("pEstado",funcionariodto.getEstado());
	  }
	
	  return query.list();
	}
	
	
}
