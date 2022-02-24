package Services;

import DAO.UserDAO;
import Entites.*;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public UserService(){}

    /**
     * Блок Access
     */
    public void saveAccess(Access access){
        userDAO.saveAccess(access);
    }

    public List<Access> findAccessByQuery(String query) {
        return userDAO.findAccessByQuery(query);
    }

    public void updateAccess(Access access) {
        userDAO.updateAccess(access);
    }

    public Access findAccessByID(String query) {
        return userDAO.findAccessByID(query);
    }

    public void deleteAccess(Access access){
        userDAO.deleteAccess(access);
    }

    /**
     * Блок Priority
     */

    public Priority findPriority(int id){
        return userDAO.findPriority(id);
    }

    public void deletePriority(Priority priority) {
        userDAO.deletePriority(priority);
    }

    public void updatePriority(Priority priority) {
        userDAO.updatePriority(priority);
    }

    public List<Priority> findPriorityByQuery(String query) {
        return userDAO.findPriorityByQuery(query);
    }

    public void savePriority(Priority priority){
        userDAO.savePriority(priority);
    }

    /**
     * Блок Statement
     */

    public void saveStatement(Statement satement){
        userDAO.saveState(satement);
    }

    public Statement findStateById(int id){
        return userDAO.stateSearch(id);
    }

    public void updateStatement(Statement statement) {
        userDAO.updateStatement(statement);
    }

    public List findStatesByQuery(String query) {
        return userDAO.findStateByQuery(query);
    }

    public void deleteStatementByID(String id) {
        userDAO.deleteStatement(userDAO.stateSearch(Integer.parseInt(id)));
    }

    /**
     * Блок Statementtype
     */

    public void saveStateType(Statementtype statementtype){
        userDAO.saveStateType(statementtype);
    }

    public void deleteStateType(Statementtype statementtype){
        userDAO.deleteStateType(statementtype);
    }

    public Statementtype findStateTypeById(String query) {
        return userDAO.findStateTypeByID(query);
    }

    public List<Statementtype> findStateTypeByQuery(String query) {
        return userDAO.findStateTypeByQuery(query);
    }

    public void updateStateType(Statementtype type) {
        userDAO.updateStateType(type);
    }

    public Statementtype findStateType(int id){
        return userDAO.findStateType(id);
    }

    /**
     * Блок Users
     */

    public Users findUser(int id){
        return userDAO.findById(id);
    }

    public void saveUser(Users user){
        userDAO.saveUser(user);
    }

    public void deleteUser(Users user){
        userDAO.deleteUser(user);
    }

    public void updateUser(Users user){
        userDAO.updateUser(user);
    }

    public List<Users> findAllUsers(){
        return userDAO.findAll();
    }

    public Users findUserByLogIn(String query) {
        return userDAO.findUserByLogIn(query);
    }
}