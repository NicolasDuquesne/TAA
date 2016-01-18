package repository;

import domain.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Project> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Project> projects = new ArrayList<Project>();
        try {
            projects = manager.createQuery("SELECT d from Project p", Project.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return projects;
    }
}
