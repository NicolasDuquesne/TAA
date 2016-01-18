package repository;

import domain.Function;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Function> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Function> functions = new ArrayList<Function>();
        try {
           functions = manager.createQuery("SELECT d from function f", Function.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return functions;
    }
}