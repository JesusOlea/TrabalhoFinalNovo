package hiberjpaaven.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao 
{
    private static Conexao instance;
    protected EntityManager entityManager;

    public static Conexao getInstance()
    {
        if (instance == null) 
        {
            instance = new Conexao();
        }
        return instance;
    }
    public Conexao() 
    {
        entityManager = getEntityManager();
    }

    public EntityManager getEntityManager() 
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maven");
        if (entityManager == null) 
        {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}