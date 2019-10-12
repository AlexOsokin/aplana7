package stepsCucumber;

import cucumber.api.java.ru.Когда;

public class CucumberSteps {
    @Когда("пользователь авторизуется используя логин \"(.*)\" и пароль \"(.*)\"")
    public void loginWithUsernameAndPassword(String login, String password) {

        System.out.println("привет из логина!" + login +" "+ password);
    }


    @Когда("выполняется шаг без параметров")
    public void doWithouParams() {
        System.out.println("Шаг без параметров");
    }


}
