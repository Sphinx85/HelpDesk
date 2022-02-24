package DAO;

import Entites.*;

import java.util.List;

public interface DAO {
    /**
     * Блок методов для работы с таблицей Access
     */
    void saveAccess(Access access);
    List<Access> findAccessByQuery(String query);
    void updateAccess(Access access);
    Access findAccessByID(String query);
    void deleteAccess(Access access);
    /**
     * Блок методов для работы с таблицей Priority
     */
    void savePriority(Priority priority);
    List<Priority> findPriorityByQuery(String query);
    void updatePriority(Priority priority);
    void deletePriority(Priority priority);
    Priority findPriority(int id);
    /**
     * Блок методов для работы с таблицей Statement
     */
    List<Statement> findStateByQuery(String query);
    Statement stateSearch(int stateid);
    void updateStatement(Statement statement);
    void saveState(Statement statement);
    void deleteStatement(Statement statement);
    /**
     * Блок методов для работы с таблицей Statementtype
     */
    void saveStateType(Statementtype statementtype);
    void deleteStateType(Statementtype statementtype);
    Statementtype findStateTypeByID(String query);
    List<Statementtype> findStateTypeByQuery(String query);
    void updateStateType(Statementtype type);
    Statementtype findStateType(int id);
    /**
     * Блок методов для работы с таблицей Users
     */
    Users findById(int id);
    void saveUser(Users user);
    void updateUser(Users user);
    void deleteUser(Users user);
    Users findUserByLogIn(String query);
    List<Users> findAll();
}