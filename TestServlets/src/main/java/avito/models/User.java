package avito.models;

/**
 * модель объекта User(пользователь программы) параметрами :
 * @param 'id'-идентификатор 
 * @param 'name'-имя 
 * @param 'email'-почта 
 * @param 'login'-логин
 * @param 'password'-пароль
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String login;
    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
