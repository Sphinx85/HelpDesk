package DAO;

import Entites.*;
import Utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    /**
     * Блок формирования запросов для таблицы Users:
     * findById(); поиск пользователя по id. Входной параметр id пользователя.
     * saveUser(); сохранение пользователя
     * updateUser(); обновление пользователя
     * deleteUser(); удаление пользователя
     */
    public Users findById(int id){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public void saveUser(Users user){
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(Users user){
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(Users user){
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<Users> findAll(){
        List<Users> users = (List<Users>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM users").list();
        return users;
    }

    /**
     * Блок методов добавления, поиска и удаления заявок
     */
    public Statement stateSearch(int stateid){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Statement.class, stateid);

    }

    public Statementtype findStateType(int id){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Statementtype.class, id);
    }

    public void saveState(Statement statement) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statement);
        transaction.commit();
        session.close();
    }

    /**
     * Блок методов флагов доступа для пользователя
     */
    public void saveAccess(Access access) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(access);
        transaction.commit();
        session.close();
    }

    public void deleteAccess(Access access) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(access);
        transaction.commit();
        session.close();
    }

    /**
     * Блок методов классификатора
     */
    public void saveStateType(Statementtype statementtype) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statementtype);
        transaction.commit();
        session.close();
    }

    public void deleteStateType(Statementtype statementtype) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(statementtype);
        transaction.commit();
        session.close();
    }

    /**
     * Блок методов приоритета заявок
     */
    public void savePriority(Priority priority) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(priority);
        transaction.commit();
        session.close();
    }

    public Priority findPriority(int id){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Priority.class, id);
    }
}
