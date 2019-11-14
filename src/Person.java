

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Person {

    private int id;
    private String name;
    private String Nationality;
    private Date dateofBirth;
    private char gender;
    private long phone;
    private String Address;

    public Person() {
    }

    public Person(int id, String name, String Nationality, Date dateofBirth, char gender, long phone, String Address) {
        this.id = id;
        this.name = name;
        this.Nationality = Nationality;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.phone = phone;
        this.Address = Address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String toString() {

        return "ID: " + this.id + ", Name: " + this.name + ", Nationality : " + this.Nationality + ", Date of Birth : " + new SimpleDateFormat("dd/MM/yyyy").format(this.dateofBirth) + "\r\n"
                + "Gender: " + this.gender + ", Phone: " + this.phone + ", Address: " + this.Address + "\r\n";
    }

}
