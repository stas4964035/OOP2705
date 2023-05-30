package Sem02.task_4;

public interface I_My {
    int getUserID();

    default int getAdminID() {
        return 1;
    }
}
