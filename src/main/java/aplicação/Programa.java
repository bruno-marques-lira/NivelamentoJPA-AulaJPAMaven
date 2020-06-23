package aplicação;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		// Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		// Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		// Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

		// Instanciando conexão com banco de dados MySQL
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// Iniciando transação para inserir os objetos do tipo pessoa no banco de dados
		// em.getTransaction().begin();
		// em.persist(p1);
		// em.persist(p2);
		// em.persist(p3);
		// Finalizando transação e realizando commit nas tarefas
		// em.getTransaction().commit();

		// Buscando uma pessoa no banco de dados
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		System.out.println(p);

		// Apagar uma pessoa do banco de dados
		em.remove(p);
		em.getTransaction().commit();

		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
