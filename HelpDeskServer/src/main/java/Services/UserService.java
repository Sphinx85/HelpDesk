package Services;

import DAO.UserDAO;
import Entites.*;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public UserService(){}

    public Users findUser(int id){
        return userDAO.findById(id);
    }

    public Statementtype findStateType(int id){
        return userDAO.findStateType(id);
    }

    public Priority findPriority(int id){
        return userDAO.findPriority(id);
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

    public Statement findStateById(int id){
        return userDAO.stateSearch(id);
    }

    public void saveStatement(Statement satement){
        userDAO.saveState(satement);
    }

    public void saveAccess(Access access){
        userDAO.saveAccess(access);
    }

    public void deleteAccess(Access access){
        userDAO.deleteAccess(access);
    }

    public void saveStateType(Statementtype statementtype){
        userDAO.saveStateType(statementtype);
    }

    public void deleteStateType(Statementtype statementtype){
        userDAO.deleteStateType(statementtype);
    }

    public void savePriority(Priority priority){
        userDAO.savePriority(priority);
    }
}