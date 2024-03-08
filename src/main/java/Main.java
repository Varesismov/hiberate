
import entities.Employee;
import entities.EmployeesGroup;
import jakarta.persistence.*;
import org.hibernate.jpa.HibernatePersistenceProvider;
import persistence.CustomPersistenceUnitInfo;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true"); // shows queries that happen
        //never use in real-world application
        props.put("hibernate.hbm2ddl.auto", "none"); // create, none, update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

//            em.persist(); -> adding an entity in the context
//            em.find();    -> finds by primary key, get from db and add it to the context, if it doesn't already exist
//            em.remove();  -> marking entity for removal
//            em.merge();   -> merges an entity from outside the context to the context
//            em.refresh(); -> mirror the context from the database
//            em.detach();  -> taking the entity out of the context
//            em.getReference() -> a element will be found only, if is later used

        // tworzenie nowej grupy:

            EmployeesGroup grupa = new EmployeesGroup();
            grupa.setGroup_name("pracownicy");
            grupa.setGroup_max_size(12);




         //  tworzenie pracownika i dodanie go do tabeli.
          //  EmployeesGroup grupa = em.find(EmployeesGroup.class,1);
            Employee pracownik = new Employee();
            pracownik.setFirst_name("MAteusz");
            pracownik.setLast_name("Braun");
            pracownik.setBirth(2000);
            pracownik.setSalary(5555);

            pracownik.setEmployeesGroup(grupa);
            grupa.addEmployee(pracownik);
            em.persist(grupa);
            em.persist(pracownik);

            //usuwanie pracownika
//            Employee pracownik = em.find(Employee.class, 3);
//            em.remove(pracownik);


            //tworzenie query
//            List<Employee> lista_pracownikow = em.createQuery("SELECT e FROM Employee e WHERE e.salary > 2500").getResultList();
//            for (Employee employee : lista_pracownikow) {
//                System.out.println(employee);
//
//            }


            em.getTransaction().commit();
        }

    }
}