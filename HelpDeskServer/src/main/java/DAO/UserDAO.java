package DAO;

import Entites.*;
import Utils.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO implements DAO{
    /**
     * Блок методов флагов доступа для пользователя
     */
    @Override
    public void saveAccess(Access access) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(access);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateAccess(Access access) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(access);
        transaction.commit();
        session.close();
    }

    @Override
    public Access findAccessByID(String query) {
        return (Access) SessionFactoryUtil.getSessionFactory().openSession().createQuery(query);
    }

    @Override
    public void deleteAccess(Access access) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(access);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Access> findAccessByQuery(String query) {
        return SessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
    }

    /**
     * Блок методов приоритета заявок
     */
    @Override
    public void savePriority(Priority priority) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(priority);
        transaction.commit();
        session.close();
    }

    @Override
    public void updatePriority(Priority priority) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(priority);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Priority> findPriorityByQuery(String query) {
        return SessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
    }

    @Override
    public void deletePriority(Priority priority) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(priority);
        transaction.commit();
        session.close();
    }

    @Override
    public Priority findPriority(int id){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Priority.class, id);
    }

    /**
     * Блок методов добавления, поиска и удаления заявок
     */
    @Override
    public Statement stateSearch(int stateid){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Statement.class, stateid);

    }

    @Override
    public void updateStatement(Statement statement) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(statement);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveState(Statement statement) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statement);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Statement> findStateByQuery(String query) {
        return (List<Statement>) SessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
    }

    @Override
    public void deleteStatement(Statement statement) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(statement);
        transaction.commit();
        session.close();
    }

    /**
     * Блок методов классификатора
     */
    @Override
    public void saveStateType(Statementtype statementtype) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statementtype);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateStateType(Statementtype type) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(type);
        transaction.commit();
        session.close();
    }

    @Override
    public Statementtype findStateTypeByID(String query) {
        return (Statementtype) SessionFactoryUtil.getSessionFactory().openSession().createQuery(query);
    }

    @Override
    public List<Statementtype> findStateTypeByQuery(String query) {
        return SessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
    }

    @Override
    public Statementtype findStateType(int id){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Statementtype.class, id);
    }

    @Override
    public void deleteStateType(Statementtype statementtype) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(statementtype);
        transaction.commit();
        session.close();
    }

    /**
     * Блок формирования запросов для таблицы Users:
     * findById(); поиск пользователя по id. Входной параметр id пользователя.
     * saveUser(); сохранение пользователя
     * updateUser(); обновление пользователя
     * deleteUser(); удаление пользователя
     */
    @Override
    public Users findById(int id){
        return SessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    @Override
    public void saveUser(Users user){
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(Users user){
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(Users user){
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Users> findAll(){
        List<Users> users = (List<Users>) SessionFactoryUtil.getSessionFactory().openSession().createQuery("SELECT firstname, secondname, lastname FROM users").list();
        return users;
    }

    @Override
    public Users findUserByLogIn(String query) {
        return (Users) SessionFactoryUtil.getSessionFactory().openSession().createQuery("SELECT id, firstname, secondname, lastname, access FROM users WHERE firstname = '" + query + "'");
    }
}