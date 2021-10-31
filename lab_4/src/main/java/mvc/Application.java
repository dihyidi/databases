package mvc;

import mvc.view.GeneralView;

public class Application {

    public static void main(final String[] args) {
        System.out.println("Please select bean category");
        new GeneralView().show();
    }
}
