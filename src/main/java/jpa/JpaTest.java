package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Employee;
import domain.Function;
import domain.Project;
import domain.Department;

public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
	public static void main(String[] args) {
        EntityManagerFactory factory =   
              Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        test.listEmployees();
            
        manager.close();
        System.out.println(".. done");
    }

    private void createEmployees() {
        /*int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
        if (numOfEmployees == 0) {*/
            Department department = new Department("java");
            Function function = new Function("Engineer");
            Project project = new Project("TAA");
            
            manager.persist(department);
            manager.persist(function);
            manager.persist(project);

            
            
            Employee employee1 = new Employee("Franck Dupond", department, function, project);
            Employee employee2 = new Employee("Alain Durand", department, function, project);
            
            manager.persist(employee1);
            manager.persist(employee2);
        /*}*/
    }

    private void listEmployees() {
        List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
    } 
}

