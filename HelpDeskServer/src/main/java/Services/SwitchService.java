package Services;

import Entites.Statement;
import UserRequests.EditStatement;
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
                EditStatement editStatement = new EditStatement(message);
                return (String) editStatement.request(message);
            }
        }
        return "";
    }
}