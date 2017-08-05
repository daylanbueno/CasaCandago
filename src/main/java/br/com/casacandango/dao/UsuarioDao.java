package br.com.casacandango.dao;

import java.util.List;

//import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import br.com.casacandango.modelo.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {
	
	
	public Usuario autenticar(String login,String senha){
		 Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 
		 try{
			 Criteria consulta = sessao.createCriteria(Usuario.class);
			 consulta.add(Restrictions.eq("login", login));
			 //SimpleHash hash = new SimpleHash("md5", senha);  CRIPTOGRAFIA
			 consulta.add(Restrictions.eq("senha", senha));
			 
			 Usuario resultado = (Usuario) consulta.uniqueResult();
			 
			 return resultado;
		 }catch(RuntimeException erro){
			 throw erro;
		 }finally{
			 sessao.close();
		 }
		 
	}
	


	@SuppressWarnings("unchecked")
	public List<Usuario> usuariosAtivos(){ // recebendo chave do estado primary
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Query consulta =sessao.createQuery("from Usuario where funcionario.ativo=true");
			List<Usuario> resultado= consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			System.out.println("rolback ->  "+erro);
			throw erro;
		}finally {
			sessao.close();
		}
		
	}
	
	
}
