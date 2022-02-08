package DAO;

import Entites.*;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {

    public Users findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public void save(Users user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(Users user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(Users user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<Users> findAll(){
        List<Users> users = (List<Users>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From users").list();
        return users;
    }

    public void saveState(Statement satement) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(satement);
        transaction.commit();
        session.close();
    }

    public void saveAccess(Access access) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(access);
        transaction.commit();
        session.close();
    }

    public void deleteAccess(Access access) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(access);
        transaction.commit();
        session.close();
    }

    public void saveStateType(Statementtype statementtype) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statementtype);
        transaction.commit();
        session.close();
    }

    public void deleteStateType(Statementtype statementtype) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(statementtype);
        transaction.commit();
        session.close();
    }

    public void savePriority(Priority priority) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(priority);
        transaction.commit();
        session.close();
    }
}
