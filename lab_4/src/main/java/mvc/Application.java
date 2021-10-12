package mvc;

import mvc.view.GeneralView;

public class Application {

    public static void main(String[] args) {
        System.out.println("Please input bean id");
        new GeneralView().show();
    }
}
