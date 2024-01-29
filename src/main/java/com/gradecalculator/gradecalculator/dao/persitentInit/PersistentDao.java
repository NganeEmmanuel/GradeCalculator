package com.gradecalculator.gradecalculator.dao.persitentInit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.exception.ConstraintViolationException;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T> The Class(Model) whose objects you wish to perform the CRUD operations on
 * @param <U> The data type of the ID of the class
 * @Example public class UserDao extends TestDao<User, Long>{}
 */

@SuppressWarnings({"unchecked","unused"})
public abstract class PersistentDao<T, U> {
    private final persistentUnitInt persistentUnitInt = new persistentUnitInt();
    private final EntityManager entityManager = persistentUnitInt.getEntityManager();

    private final Class<T> entityClass;

    public PersistentDao() {
        // Use reflection to obtain the entity class at runtime
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    /**
     *
     * @param t object type to be persisted to the database
     * @return the object being persisted to the database, throws and exception, or returns if there is an issue
     * @Example add(userObject)
     */
    public T add(T t) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return t;
        } catch (PersistenceException e) {
            // Check if the exception is due to a unique constraint violation
            if (e.getCause() instanceof ConstraintViolationException) {
                // Handle the unique constraint violation here
                // For example, you can log an error message or throw a custom exception
                // throw new CustomException("Duplicate entry detected");
                // Or you can return null to indicate that the addition failed
                return null;
            } else {
                // Rethrow the exception if it's not a unique constraint violation
                throw e;
            }
        }
    }

    /**
     *
     * @return a complete list of all objects/entries in the database of the entity type or null if no entry is found
     * @Example findAll() -- will return a list of objets equals to the total number of rows in the database table/entity
     */
    public List<T> findAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t");
        entityManager.getTransaction().commit();
        List<T> resultList = query.getResultList();
        return  !resultList.isEmpty()? resultList : null;
    }

    /**
     *
     * @param beginIndex the index from which the result should begin
     * @param endIndex the index at which the result should end
     * @return a sub list of objects in the database of the entity type
     * @Example findWithRange(1, 10) -- will return ten results
     */
    public List<T> findAllWithRange(int beginIndex, int endIndex) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t");
        entityManager.getTransaction().commit();
        List<T> resultList = query.getResultList();
        return  !resultList.isEmpty()? resultList.subList(beginIndex, endIndex): null;
    }

    /**
     *
     * @param id integer value denoting the unique identification of the record in the table in the database
     * @return the complete row associated with the id entered found in the database or null if no row is found
     * @Example findById(IdObject) -- findById(1), findById(10)
     */
    public Optional<T> findById(U id) {
        entityManager.getTransaction().begin();
        T t = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(t);
    }

    /**
     *
     * @param id integer value denoting the unique identification of the record in the table in the database
     * @return the complete row associated with the id entered found in the database or null if no row is found
     * @Example findByIdPrivately(idObject) -- findByIdPrivately(1), findByIdPrivately(10)
     */
    private Optional<T> findByIdPrivately(U id){
        T t = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(t);
    }

    /**
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value      String value of the actual information you want to filter for
     * @param maxResult  The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of records from the table in the database if present and null if absent
     * @Example findBy(" username ", " exampleName ")
     */
    public List<T> findBy(String columnName, String value, int maxResult) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(maxResult > 0) query.setMaxResults(maxResult);
        entityManager.getTransaction().commit();
        List<T> resultList = query.getResultList();
        return !resultList.isEmpty()? resultList: null;
    }

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Integer value of the actual information you want to filter for
     * @param maxResult The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of records from the table in the database if present and null if absent
     * @Example findBy("age", 10)
     */
    public List<T> findBy(String columnName, int value, int maxResult) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(maxResult > 0) query.setMaxResults(maxResult);
        entityManager.getTransaction().commit();
        List<T> resultList = query.getResultList();
        return !resultList.isEmpty()? resultList: null;
    }

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Long data value of the actual information you want to filter for
     * @param maxResult The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of records from the table in the database if present and null if absent
     * @Example findBy("page",1L)
     */
    public List<T> findBy(String columnName, long value, int maxResult) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(maxResult > 0) query.setMaxResults(maxResult);
        entityManager.getTransaction().commit();
        List<T> resultList = query.getResultList();
        return !resultList.isEmpty()? resultList: null;
    }

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value object value of the actual information you want to filter for
     * @param maxResult The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of records from the table in the database if present and null if absent
     * @Example findBy("username",objectVariable)
     */
    public List<T> findBy(String columnName, Object value, int maxResult) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(maxResult > 0) query.setMaxResults(maxResult);
        entityManager.getTransaction().commit();
        List<T> resultList = query.getResultList();
        return !resultList.isEmpty()? resultList: null;
    }

    /**
     *
     * @param t populated object to be updated
     * @return object in the database that has been updated
     * @Example update(UserObject)
     */
    public T update(T t) {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        return t;
    }

    /**
     *
     * @param t the object to be deleted from the database
     * @return returns the object that has been deleted
     * @Example delete(userObject) --  Completely removes the row of user with id = userObject.Id from the database
     */
    public T delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
        return t;
    }

    /**
     *
     * @param query query to  be executed e.g., ("select t from users t where t.id = 1")
     * @return  a list of objects/rows in the database of the entity class
     */
    public List<T> runQuery(String query, int maxResult) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        if(maxResult > 0) query1.setMaxResults(maxResult);
        List<T> resultList = query1.getResultList();
        entityManager.getTransaction().commit();
        return !resultList.isEmpty()? resultList: null;
    }

    /**
     *
     * @param query query to  be executed e.g., ("select t from users t where t.id = 1")
     * @return a single objects in the database of the class type
     */
    public T runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (T) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

}