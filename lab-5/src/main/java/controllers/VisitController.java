package controllers;

import dao.SpecializationDaoImpl;
import dao.VisitDaoImpl;
import models.Specialization;
import models.Visit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitController extends ControllerImpl<Visit> {

    public VisitController() {
        super(new VisitDaoImpl());
    }

    @Override
    public boolean addEntity(){
        Visit visit = inputEntity();
        return super.addEntity(visit);
    }

    @Override
    public boolean updateEntity(int id) {
        Visit visit = inputEntity();
        return super.updateEntity(id, visit);
    }

    @Override
    protected Visit inputEntity() {
        System.out.println("Please input date:");
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Please input price:");
        var price = Integer.parseInt(input.nextLine());
        return new Visit(date,price);
    }
}
