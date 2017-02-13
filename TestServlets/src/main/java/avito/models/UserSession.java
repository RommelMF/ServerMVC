package avito.models;

/**
 * шаблон объекта userSession, который будет класться в сессию пользователя
 * @param 'userLogin'- логин
 */
public class UserSession {
    
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
