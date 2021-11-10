package mvc.controller;

import mvc.model.beans.Doctor;
import mvc.model.managers.DoctorManager;

import java.util.Scanner;

public class DoctorController extends ControllerImpl<Doctor> {
    private final static Scanner input = new Scanner(System.in);

    public DoctorController() {
        super(new DoctorManager());
    }

    public boolean addBean(){
        System.out.println("Please input name:");
        var name = input.nextLine();
        System.out.println("Please input experience:");
        var exp = Integer.parseInt(input.nextLine());
        System.out.println("Please input specialization id:");
        var spec = Integer.parseInt(input.nextLine());
        return super.addBean(new Doctor(0, name, exp, spec));
    }
    public boolean updateBean(int id){
        System.out.println("Please input name:");
        var name = input.nextLine();
        System.out.println("Please input experience:");
        var exp = Integer.parseInt(input.nextLine());
        System.out.println("Please input specialization id:");
        var spec = Integer.parseInt(input.nextLine());
        return super.addBean(new Doctor(id, name, exp, spec));
    }
}
