package DZ05.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserModel {
    private HashMap<Integer, User> users;
    private Integer currentUser = null;
    private boolean isCurrentUserAdmin = false;
    int count = 43;
    public UserModel(){
        users = new LinkedHashMap<>();
        User u = new User("root", "root", "");
        u.setAdmin(true);
        users.put(42, u);
    }

    private void add(User u) {
        users.put(count++, u);
    }

    public int validateUser(String name, String login, String password) {
        if (!Pattern.matches("[a-zA-Zа-яА-Я]+", name)) {
            return 1; // Не прошло валидацию имени
        }
        if (!Pattern.matches("[a-zA-Z]+", login)) {
            return 2; // Не прошло валидацию логина
        }
        if (!Pattern.matches("^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()])[a-zA-Z!@#$%^&*()]{6,}$", password)) {
            return 3; // Не прошло валидацию пароля
        }
        return 0;
    }

    public boolean regUser(String name, String login, String password) {
        Integer isNew = getIDByLogin(login);
        if(isNew == null) {
            add(new User(name, login, password));
            return true;
        }else return false;

    }
    public String usersList(){
        String res = "";
        for (int id:users.keySet()) {
            res += id + ": " +users.get(id).toString() + "\n";
        }
        return res;
    }
    public Integer signIn(String login, String password){
        for (int id: users.keySet()) {
            if(Objects.equals(users.get(id).getLogin(), login) && Objects.equals(users.get(id).getPassword(), password)){
                isCurrentUserAdmin = users.get(id).isAdmin();
                return currentUser = id;
            }
        }
        return null;
    }
    public void signOut(){
        currentUser = null;
    }
    public User getByID(int id){
        return users.get(id);
    }
    private Integer getIDByLogin(String login){
        for (int id: users.keySet()) {
            if(Objects.equals(users.get(id).getLogin(), login)){
                return id;
            }
        }
        return null;
    }
    public void setByID(Integer id, User u){
        users.put(id, u);
    }


    public Integer getCurrentUser() {
        return currentUser;
    }

    public boolean isCurrentUserAdmin() {
        return isCurrentUserAdmin;
    }
}
