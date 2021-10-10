package mvc.view;

import mvc.controller.SpecializationController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final SpecializationController controller;
    private final Map<String, String> menu;
    private final static Scanner input = new Scanner(System.in);

    public View() {
        controller = new SpecializationController();
        menu = new LinkedHashMap<>();
        menu.put("1", "  1 - print Specializations");
        menu.put("2", "  2 - get bean by id");
        menu.put("3", "  3 - add bean");
        menu.put("4", "  4 - update bean");
        menu.put("5", "  5 - delete bean");
        menu.put("Q", "  Q - exit");
    }

    private void pressButton1() {
        System.out.println(controller.getBeans());
    }

    private void pressButton2() {
        System.out.println("Please input bean id");
        int id = input.nextInt();
        System.out.println(controller.getBeanById(id));
    }

    private void pressButton3() {
        System.out.println(controller.getBeans());
    }

    private void pressButton4() {
        System.out.println(controller.getBeans());
    }

    private void pressButton5() {
        System.out.println("Please input bean id");
        int id = input.nextInt();
        System.out.println(controller.deleteBean(id));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                switch (keyMenu){
                    case "1":
                        pressButton1();
                        break;
                    case"2":
                        pressButton2();
                        break;
                        case"5":
                        pressButton5();
                        break;
                    default:
                        System.out.println("kk");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!keyMenu.equals("Q"));
    }
}
