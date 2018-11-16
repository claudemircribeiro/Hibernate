package com.mkyong;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.stock.Pessoa;
import com.mkyong.stock.Telefone;
import com.mkyong.util.HibernateUtil;

public class App {
	
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Mauro");	
		
		//tefefones
		Telefone t1 = new Telefone();
		t1.setDdd(41);
		t1.setNumero(55555);
		
		Telefone t2 = new Telefone();
		t2.setDdd(41);
		t2.setNumero(6666);
	
		
		pessoa1.addTelefone(t1);
		pessoa1.addTelefone(t2);
	
		session.save(pessoa1);
		
		session.save(t1);
		session.save(t2);
		
		session.getTransaction().commit();
		
		Query query = session.createQuery("select p from Pessoa p join fetch p.telefones t where t.numero = 55555");

		List<Pessoa> p = query.list();
		
		for(Pessoa pe : p) {
			List<Telefone> telefones =  pe.getTelefones().stream().filter(po -> po.getNumero() == 55555).collect(Collectors.toList());
			pe.getTelefones().clear();
			pe.getTelefones().addAll(telefones);
		}
		
		System.out.println("Done");
		
	}
}
