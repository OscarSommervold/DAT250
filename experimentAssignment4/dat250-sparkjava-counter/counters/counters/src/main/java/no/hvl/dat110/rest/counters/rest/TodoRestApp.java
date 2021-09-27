package no.hvl.dat110.rest.counters.rest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import static spark.Spark.*;
import java.util.List;
import com.google.gson.Gson;
import no.hvl.dat110.rest.counters.rest.Todo;
import no.hvl.dat110.rest.counters.rest.TodoDAO;

public class TodoRestApp {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static final String ENTITY_NAME = "todos";

    public static void main(String[] args) {
        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8081);
        }
        entityManagerFactory = Persistence.createEntityManagerFactory(ENTITY_NAME);
        entityManager = entityManagerFactory.createEntityManager();
        TodoDAO todoDAO = new TodoDAO(entityManager);

        after((req, res) -> {
            res.type("application/json");
        });

        get("/todo",(req,res) -> "todo restAPI");
        get("/todo",(req,res) -> {
           List<Todo> todos = todoDAO.getAll();
           String body = "[";
           for(Todo t : todos) {
               body += t.toJson();
               if(todos.indexOf(t) != todos.size()-1){body += ",";}
           }
           body += "]";
           res.body(body);
           return res.body();
        });

        /*
        Create
         */
        post("/todo",(req,res) -> {
           Gson gson = new Gson();
           Todo t = gson.fromJson(req.body(),Todo.class);
           todoDAO.createTodo(t);
           return t.toJson();
        });

        /*
        Read
         */
        get("/todo/:id",(req,res) -> {
            if (req.params(":id") == null) {
                res.body("missing id");
                return res.body();
            } else {
                Long id = Long.parseLong(req.params(":id"));
                Todo t = todoDAO.getTodo(id);
                return t.toJson();
            }
        });

        /*
        Update
         */
        put("/todo/:id",(req,res) -> {
            if (req.params(":id") == null) {
                res.body("Please pass an id");
                return res.body();
            }
            Gson gson = new Gson();
            Long id = Long.parseLong(req.params(":id"));
            Todo t = todoDAO.getTodo(id);
            Todo nt = gson.fromJson(req.body(),Todo.class);
            t = todoDAO.updateTodo(t,nt);
            return t.toJson();
        });

        /*
        Delete
         */

        delete("/todo/:id", (req,res) -> {
            if(req.params(":id") == null) {
                res.body("nonvalid id");
                return res.body();
            }
            Long id = Long.parseLong(req.params(":id"));
            Todo t = entityManager.find(Todo.class,id);
            Todo dt = todoDAO.deleteTodo(t);
            res.body(dt.toJson() + "has been deleted");
            return res.body();
        });

    }
}
