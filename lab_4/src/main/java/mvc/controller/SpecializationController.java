package mvc.controller;

import mvc.model.beans.Specialization;
import mvc.model.managers.SpecializationManager;

import java.util.Scanner;

public class SpecializationController extends ControllerImpl<Specialization> {
    private final static Scanner input = new Scanner(System.in);

    public SpecializationController() {
        super(new SpecializationManager());
    }

    public boolean addBean(){
        System.out.println("Please input name:");
        var name = input.nextLine();
        return super.addBean(new Specialization(0, name));
    }
    public boolean updateBean(int id){
        System.out.println("Please input name:");
        var name = input.nextLine();
        return super.updateBean(id, new Specialization(id, name));
    }
}
