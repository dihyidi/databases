package views;

import controllers.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GeneralView {
    private final Map<String, String> menu;
    private final static Scanner input = new Scanner(System.in);

    public GeneralView() {
        menu = new LinkedHashMap<>();
        menu.put("1", " 1 - diagnosis" );
        menu.put("2", " 2 - doctor");
        menu.put("3", " 3 - patient");
        menu.put("4", " 4 - specialization");
        menu.put("5", " 5 - visit");
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
                    case "1" -> new EntityView<>(new DiagnosisController()).show();
                    case "2" -> new EntityView<>(new DoctorController()).show();
                    case "3" -> new EntityView<>(new PatientController()).show();
                    case "4" -> new EntityView<>(new SpecializationController()).show();
                    case "5" -> new EntityView<>(new VisitController()).show();
                    default -> System.out.println("--");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!keyMenu.equals("Q"));
    }
}
