package Services;

import Entites.Statement;
import Entites.Statementtype;

import java.util.List;

public class Classificator {

    public Statement classified(String description, UserService service, Statement statement) {
        description = description.toLowerCase();
        List<Statementtype> typeList = service.findStateTypeByQuery("SELECT flag, description FROM statementtype");

        for (Statementtype type: typeList){
            if (containsPlus(description, type.getDescription())){
                statement.setType_id(type.getId());
                if (type.getId() > 510 && type.getId() < 520){
                    statement.setPriority_id(3);
                }
                break;
            }
        }
        return statement;
    }

    private boolean containsPlus(String description, String type) {
        String[] token = type.split("\\s");
        StringBuilder query = new StringBuilder();
        for (String object: token){
            if (object.equals("не")){
                continue;
            }
            if (description.contains(object)){
                query.append(object).append(" ");
            }
        }
        return description.contains(query);
    }
}