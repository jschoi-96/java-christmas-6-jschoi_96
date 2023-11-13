package christmas;

import controller.ChristmasController;
import dto.Order;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController();
        christmasController.eventPlanner();
    }
}
