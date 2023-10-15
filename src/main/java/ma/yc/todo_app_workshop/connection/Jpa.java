package ma.yc.todo_app_workshop.connection;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;
import ma.yc.todo_app_workshop.presistence.CusomPresistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Jpa {

    private static Jpa instance = null;
    private final EntityManagerFactory entityManagerFactory;
    @Getter
    private final EntityManager entityManager;

    private Jpa() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        String puName = "todo_app-presistence-unit";
        HashMap<String,String> props  = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","none");//create- update - none
        //in the production you mustn't use the create or update option
        entityManagerFactory = new HibernatePersistenceProvider().
                createContainerEntityManagerFactory(new CusomPresistenceUnitInfo(puName), props);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static Jpa getInstance() {
        if (instance == null) {
            instance = new Jpa();
        }
        return instance;
    }
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }

    }


    public void commit(){
        entityManager.getTransaction().commit();
    }

    public void rollback(){
        entityManager.getTransaction().rollback();
    }

}
