

import java.util.Date;

public class Trainer extends Person {

    private String degree;
    private String department;
    private double teachingHours;
    private String jobTitle;
    private String officeNumber;
    private boolean available;
    private static Trainer Trainers[];
    private static int Counter;

    public static void setSize(int size) {
        Trainers = new Trainer[size];
    }

    public Trainer(String degree, String department, double teachingHours, String jobTitle, String officeNumber, boolean available, int id, String name, String Nationality, Date dateofBirth, char gender, int phone, String Address) {
        super(id, name, Nationality, dateofBirth, gender, phone, Address);
        this.degree = degree;
        this.department = department;
        this.teachingHours = teachingHours;
        this.jobTitle = jobTitle;
        this.officeNumber = officeNumber;
        this.available = available;
        Add(this);
    }

    private void Add(Trainer T) {
        Trainers[Counter++] = T;
        
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(double teachingHours) {
        this.teachingHours = teachingHours;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static Trainer Find(int ID) {
        for (int i = 0; i < Counter; i++) {
            if (Trainers[i].getId() == ID) {
                return Trainers[i];
            }
        }

        return null;
    }

    public static boolean isFull() {

        return Counter == Trainers.length;
    }

    @Override
    public String toString() {

        return super.toString() + " Degree = " + this.degree + ", Department = " + this.department
                + ", TeachingHours = " + this.teachingHours + ", JobTitle = " + this.jobTitle
                + ", OfficeNumber = " + this.officeNumber + ", Available = " + this.available;

    }
}
