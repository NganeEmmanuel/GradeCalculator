package com.gradecalculator.gradecalculator.dao.persitentInit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SuppressWarnings("unused")
public class persistentUnitInt {
    private EntityManager entityManager;
    private EntityManagerFactory eMf;

    public persistentUnitInt() {
        this.eMf = Persistence.createEntityManagerFactory("gradeCalculator_pu");
        this.entityManager = this.eMf.createEntityManager();
    }
    public persistentUnitInt(String persistentUnit){
        this.eMf = Persistence.createEntityManagerFactory(persistentUnit);
        this.entityManager = this.eMf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManagerFactory geteMf() {
        return eMf;
    }

    public void seteMf(EntityManagerFactory eMf) {
        this.eMf = eMf;
    }

    public void close(){
        this.entityManager.close();
        this.eMf.close();
    }
    public void clear(){
        this.entityManager.clear();
    }

}
