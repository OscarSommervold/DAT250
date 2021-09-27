package no.hvl.dat110.rest.counters.rest;

import no.hvl.dat110.rest.counters.rest.Todo;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;

public class TodoDAO {

    private final EntityManager em;

    public TodoDAO(EntityManager entityManager){this.em = entityManager;}

    public List<Todo> getAll() {
        Query q = em.createQuery("SELECT todos FROM Todo todos");
        return q.getResultList();
    }

    public Todo getTodo(Long id) {
        return em.find(Todo.class,id);
    }

    public void createTodo(Todo t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        System.out.println("Created " + t.toString());
    }

    public Todo updateTodo(Todo t,Todo updated) {
        if(em.contains(t)) {
            em.getTransaction().begin();
            Todo updatedTodo = em.find(Todo.class,t.getId());
            updatedTodo.setDescription(updated.getDescription());
            updatedTodo.setSummary(updated.getSummary());
            em.getTransaction().commit();
            return updatedTodo;
        }
        return null;
    }

    public Todo deleteTodo(Todo t) {
        if(em.contains(t)){
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } else {
            System.out.println("Could not find" + t.toString());
        }
        return t;
    }
}
