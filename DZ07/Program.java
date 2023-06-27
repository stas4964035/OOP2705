package DZ07;

import DZ07.controller.Controller;
import DZ07.view.View;

public class Program {
    public static void main(String[] args) {
        Controller controller = new Controller(new View());
        controller.buttonClick();
    }
}
