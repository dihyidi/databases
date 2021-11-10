package mvc.view;

import mvc.controller.DoctorController;
import mvc.controller.SpecializationController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GeneralView {
    private final Map<String, String> menu;
    private final static Scanner input = new Scanner(System.in);

    public GeneralView() {
        menu = new LinkedHashMap<>();
        menu.put("1", " 1 - doctor" );
        menu.put("2", " 2 - specialization");
        menu.put("Q", "  Q - exit");
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
                switch (keyMenu) {
                    case "1":
                        new BeanView<>(new DoctorController()).show();
                        break;
                    case"2":
                        new BeanView<>(new SpecializationController()).show();
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
