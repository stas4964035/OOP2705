package DZ05.User;

public class UserPresenter {
    UserModel model = new UserModel();
    UserView view = new UserView();

    UserPresenter() {
        model.regUser("Иван", "firstUser", "");
        model.regUser("мария", "secondUser", "asdqwe");

    }

    public void mainMenu() {
        view.print("Для входа под админом введите логин root и пустой пароль.\n" +
                "Админ может редактировать любого пользователя и видеть общий списовк пользоватлей, обычный пользователь только свои данные");
        view.print("Главное меню.\n",
                "1. Регистраця\n" +
                        (model.getCurrentUser() == null ? "2. Войти\n" : "2. Выйти(" + model.getByID(model.getCurrentUser()) + ")\n") +
                        (model.getCurrentUser() != null ? "3. Редактировать профиль\n" : "") +
                        (model.isCurrentUserAdmin() ? "4. Редактирование пользователей" : "")
        );


        int menuSelection = view.menuSelector("Введите пункт меню:");
        switch (menuSelection) {
            case 1:
                registerMenu();
                break;
            case 2:
                if (model.getCurrentUser() == null) signInMenu();
                else model.signOut();
                mainMenu();
                break;
            case 3:
                view.print("Редактирование профиля:");
                editUserByID(model.getCurrentUser());
                break;
            case 4:
                if (model.isCurrentUserAdmin()) {
                    usersList();

                } else {
                    view.print("Ошибка ввода пунта меню.", "");
                    mainMenu();
                }
                break;

            default:
                view.print("Ошибка ввода пунта меню.", "");
                mainMenu();
                break;
        }
    }

    public void usersList() {
        view.print("Список пользователей.", model.usersList());
        view.print("0. Вернуться");
        int userForEdit = view.menuSelector("Введите ID пользователя");
        if (model.getByID(userForEdit) != null) {
            editUserByID(userForEdit);
        }
        mainMenu();
    }

    public void editUserByID(int id) {
        view.print("Редактирование пользователя ", model.getByID(id).toString());
        view.print("1. Имя\n2. Пароль\n0. Вернуться");
        int menuSelection = view.menuSelector("Что редактировать: ");
        switch (menuSelection) {
            case 1:
                editNameByID(id);
                editUserByID(id);
                break;
            case 2:
                editPassByID(id);
                editUserByID(id);
                break;
            case 0:
                if (model.isCurrentUserAdmin()) usersList();
                else mainMenu();
                break;
            default:
                view.print("Ошибка ввода пунта меню.", "");
                editUserByID(id);
                break;
        }
    }

    public void editNameByID(int id) {
        User edit = model.getByID(id);
        edit.setName(view.input("Введите новое имя: "));
        model.setByID(id, edit);
    }

    public void editPassByID(int id) {
        User edit = model.getByID(id);
        edit.setPassword(view.input("Введите новый пароль: "));
        model.setByID(id, edit);
    }

    public void registerMenu() {
        String name = view.input("Ваше имя:");
        String login = view.input("Ваш логин:");
        String password = view.input("Ваш пароль:");
        int validation = model.validateUser(name, login, password);
        switch (validation) {
            case 1:
                System.out.println("Введите имя состоящее только из русских или английских букв.");
                registerMenu();
                break;
            case 2:
                System.out.println("Введите логин состоящий только из английских букв.");
                registerMenu();
                break;
            case 3:
                System.out.println("пароль должен состоять только из английский букв и хотя бы одним из символов !\"#$%^&*()");
                registerMenu();
                break;
            case 0:
                if (model.regUser(name, login, password)) {
                    view.print("Новый пользователь зарегистрирован");
                    mainMenu();
                }else{
                    view.print("Логин занят.");
                    registerMenu();
                }
                break;
        }
    }

    public void signInMenu() {
        String login = view.input("Ваш логин:");
        String password = view.input("Ваш пароль:");
        Integer signID = model.signIn(login, password);
        if (signID != null) {
            view.print("Вы успешно вошли как: ", model.getByID(signID).toString());
            mainMenu();
        } else {
            System.out.println("Ошибка при вводе логина или пароля!");
            mainMenu();
        }
    }
}
