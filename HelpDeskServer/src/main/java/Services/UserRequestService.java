package Services;

import Entites.Statement;
import Entites.Statementtype;
import Entites.Users;

public class UserRequestService {

    /**
     * Блок обработки входящего сообщения от клиентской части
     * Результатом его работы является формирование запроса в базу
     * Возврат результата и отправка ответа пользователю.
     *
     * Данный блок обрабатывает классификацию, приоритет заявки.
     * Присваивает номер заявке, прикрепляет пользователя.
     *
     * Для обработки сообщение должно содержать параметры, отличимые методами ниже
     * Шесть методов классифицируют заявку окончательно и записывают ее в базу
     *         answer[0] = requestType(message); Метод определения типа заявки, классификация
     *         answer[1] = getUserID(message); Метод определения пользователя, отправившего заявку
     *         answer[2] = annotation(); Метод записи текста заявки в строку для базы данных
     *         answer[3] = getStateID(); Метод определения номера заявки
     *         answer[4] = setterPriority(); Метод определения и установки приоритета заявки
     *         answer[5] = setStatementDate(); Метод установки даты подачи заявки
     *
     * Синтаксис запроса:
     * /request /annAnnotation text/?ann /userid12345
     * В начале идет ключевое слово /request отдающее строку в обработку в метод processingRequest();
     * В контейнере /ann /?ann заключается сам текст пользовательской заявки
     * Тег /userid отдает часть строки в обработку, для определения пользователя.
     */

    private static String request;
    private static String[] answer;
    private static UserService service;

    public UserRequestService(String message) {
        service = new UserService();

    }

    /**
     * Метод обработки сообщения от клиента для создания запроса в БД
     * @param message Входной параметр сообщение
     * @return Возвращает строковый массив, который будет использоваться для предоставления информации пользователю.
     */
    public String[] processingRequest(String message) {



        answer = new String[6];
        answer[0] = requestType(message);
        answer[1] = getUserID(message);
        answer[2] = annotation(message);
        answer[3] = getStateID();
        answer[4] = setterPriority();
        answer[5] = setStatementDate();

        return answer;
    }

    private String setStatementDate() {
        return null;
    }

    private String setterPriority() {
        return null;
    }

    private String getStateID() {
        Statement statement = new Statement();
        Statementtype statementtype = new Statementtype();

        return null;
    }

    /**
     * Метод, возвращающий текст заявки пользователя
     * @param message
     * @return
     */
    private String annotation(String message) {
        int indexStart = message.indexOf("/ann");
        int indexFinish = message.indexOf("/?ann");
        return message.substring(indexStart + 3,indexFinish);
    }

    /**
     * Метод определения ID пользователя
     * @param message Входной параметр строка. Работаем с концом строки.
     * @return Возвращает строковое значение ID пользователя
     */
    private String getUserID(String message) {
        int index = message.indexOf("/userid");
        return message.substring(index + 6);
    }

    /**
     * Метод определения типа заявки
     * @param message В качестве параметра принимает полученное сообщение
     * @return Возвращает тип заявки по классификации
     */
    private String requestType(String message) {
        String result = "";
        if (message.contains("Не работает")){
            if (message.contains("почта")) result = "514";
            if (message.contains("принтер")) result = "514";
            if (message.contains("компьютер")) result = "513";
        }
        return result;
    }
}
