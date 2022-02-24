package Services;

import AdminRequests.*;
import Entites.*;
import UserRequests.DeleteStatement;
import UserRequests.NewStatement;
import UserRequests.ReadStatement;

import java.util.List;

public class SwitchService {
    /**
     * Метод определения и разбиения запросов от пользователя. Служит так же для формирования
     * ответа в клиентскую часть.
     * @param message Сообщение от клиента
     * @param clientHandler Текущий обработчик клиента
     * @return Возвращает строку для обработки клиентом
     */
    public String userRequestSwitcher(String message, ClientHandler clientHandler) {

        switch (message.substring(0,9)){
            /**
             * Кейс отправляет строку на создание запроса и получает объект Statement,
             * получает id, запаковывает в строку и отправляет на сервер для
             * отправки пользователю.
             */
            case "/newstate":{
                NewStatement newStatement = new NewStatement(message, clientHandler);
                StringBuilder builder = new StringBuilder();
                Statement state = (Statement) newStatement.request(message);
                builder.append("/newState ").append(state.getId().toString());
                return builder.toString();
            }
            /**
             * Кейс проверяет два условия и действует в зависимости от полученного объекта:
             * Если получает List, то все заявки пользователя преобразуются в строку и отправляются в класс сервер,
             * для отправки в клиентскую часть. Пользователь получит список своих заявок.
             * Если получает Statement, то так же преобразуется в строку и отправляется
             * клиентской части. Пользователь получит информацию о своей заявке.
             */
            case "/wiestate":{
                ReadStatement readStatement = new ReadStatement(message, clientHandler);
                if (readStatement.request(message).getClass().equals(List.class)){
                    StringBuilder builder = new StringBuilder();
                    builder.append("/statesList ");
                    for (Statement state : (List<Statement>) readStatement.request(message)){
                        builder.append(state.getId().toString()).append(" ").append(state.getDescription()).append("//| ");
                    }
                    return builder.toString();
                }
                StringBuilder builder = new StringBuilder();
                Statement state = (Statement) readStatement.request(message);
                builder.append("/thisStatement ").append(state.getId().toString()).append(" ").append(state.getDescription()).append("//| ");
                return builder.toString();

            }
            /**
             * Кейс отрабатывает удаление заявки пользователя.
             */
            case "/edistate":{
                new DeleteStatement(message);
                return "/stateDeleted";
            }
        }
        return "";
    }

    /**
     * Метод обработки запросов от администратора.
     * @param message Входящее сообщение из сети
     * @return Возвращает маркерное сообщение клиенту
     */
    public String adminRequestSwitcher(String message) {
        switch (message.substring(0,8)){
            /**
             * Запрос на добавление доступа
             */
            case "/admNewA":{
                new AddAccess(message);
                return "/newAccessOk";
            }
            /**
             * Запрос на добавление приоритета
             */
            case "/admNewP":{
                new AddPriority(message);
                return "newPriorityOk";
            }
            /**
             * Запрос на добавление классификатора
             */
            case "/admNewC":{
                new AddClassificator(message);
                return "/newClassificatorOk";
            }
            /**
             * Запрос на добавление пользователя
             */
            case "/admNewU":{
                AddUser addUser = new AddUser(message);
                StringBuilder builder = new StringBuilder();
                builder.append("/newUserOk ");
                builder.append((String) addUser.request(message));
                return builder.toString();
            }
            /**
             * Запрос на список прав доступа
             */
            case "/admReaA":{
                ReadAccess readAccess = new ReadAccess(message);
                List<Access> accessList = (List<Access>) readAccess.request(message);
                StringBuilder builder = new StringBuilder();
                builder.append("/accessList ");
                for (Access access: accessList){
                    builder.append(access.getId().toString()).append(" ").append(access.getDescription()).append("//| ");
                }
                return builder.toString();
            }
            /**
             * Запрос на список приоритетов
             */
            case "/admReaP":{
                ReadPriority readPriority = new ReadPriority(message);
                List<Priority> priorityList = (List<Priority>) readPriority.request(message);
                StringBuilder builder = new StringBuilder();
                builder.append("/priorityList ");
                for (Priority priority: priorityList){
                    builder.append(priority.getId().toString()).append(" ").append(priority.getDescription()).append("//| ");
                }
                return builder.toString();
            }
            /**
             * Запрос на список типов заявок (классификатор)
             */
            case "/admReaC":{
                ReadClassificator readClassificator = new ReadClassificator(message);
                List<Statementtype> statementTypeList = (List<Statementtype>) readClassificator.request(message);
                StringBuilder builder = new StringBuilder();
                builder.append("/typesList ");
                for (Statementtype type: statementTypeList){
                    builder.append(type.getId().toString()).append(" ").append(type.getDescription()).append("//| ");
                }
                return builder.toString();
            }
            /**
             * Запрос списка пользователей
             */
            case "/admReaU":{
                ReadUser readUser = new ReadUser(message);
                List<Users> userList = (List<Users>) readUser.request(message);
                StringBuilder builder = new StringBuilder();
                builder.append("/userList ");
                for (Users user: userList){
                    builder.append(user.getFirstname()).append(" ").append(user.getSecondname()).append(" ").append(user.getLastname()).append("//| ");
                }
                return builder.toString();
            }
            /**
             * Запрос на удаление доступа
             */
            case "/admDelA":{
                new DeleteAccess(message);
                return "/accessDeleted";
            }
            /**
             * Запрос на удаление классификатора
             */
            case "/admDelC":{
                new DeleteClassificator(message);
                return "/typeDeleted";
            }
            /**
             * Запрос на удаление приоритета
             */
            case "/admDelP":{
                new DeletePriority(message);
                return "/priorityDeleted";
            }
            /**
             * Запрос на удаление пользователя
             */
            case "/admDelU":{
                new DeleteUser(message);
                return "/userDeleted";
            }
            /**
             * Запрос на изменение доступа
             */
            case "/admEdiA":{
                new EditAccess(message);
                return "/accessEdited";
            }
            /**
             * Запрос на изменение классификатора
             */
            case "/admEdiC":{
                new EditClassificator(message);
                return "/typeEdited";
            }
            /**
             * Запрос на изменение приоритета
             */
            case "/admEdiP":{
                new EditPriority(message);
                return "/priorityEdited";
            }
            /**
             * Запрос на изменение заявки
             */
            case "/admEdiS":{
                new EditStatement(message);
                return "/stateEdited";
            }
            /**
             * Запрос на изменение пользователя
             */
            case "/admEdiU":{
                new EditUser(message);
                return "/userEdited";
            }
        }
        return "";
    }
}