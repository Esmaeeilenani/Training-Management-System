

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trainee extends Person {

    private Date DateOfenrollment;
    private TrainingSession[] ST;
    private int numOfSession;
    private static Trainee Trainees[];
    private static int Counter = 0;

    public static void setSize(int size) {
        Trainees = new Trainee[size];

    }

    public Trainee(Date DateOfenrollment, int id, String name, String Nationality, Date dateofBirth, char gender, long phone, String Address) {
        super(id, name, Nationality, dateofBirth, gender, phone, Address);
        this.DateOfenrollment = DateOfenrollment;
        ST = new TrainingSession[3];
        numOfSession = 0;

        Add(this);
    }

    private void Add(Trainee T) {
        Trainees[Counter++] = T;
        
    }

    public Date getDateOfenrollment() {
        return DateOfenrollment;
    }

    public void setDateOfenrollment(Date DateOfenrollment) {
        this.DateOfenrollment = DateOfenrollment;
    }

    public int getNumOfSession() {
        return numOfSession;
    }

    public void addST(TrainingSession session) {
        ST[numOfSession++] = session;

    }

    public static Trainee Find(int ID) {

        for (int i = 0; i < Counter; i++) {
            if (Trainees[i].getId() == ID) {
                return Trainees[i];
            }
        }
        return null;
    }

    public static boolean isFull() {

        return Counter == Trainees.length;
    }

    public static void Print(PrintWriter out) {

        for (int i = 0; i < Counter; i++) {

            out.println("Trainee " + Trainees[i].getName() + " detail are as Follows: ");
            out.println(Trainees[i].toString() + "\r\n");
        }

    }

    @Override
    public String toString() {

        String Str = super.toString()
                + "-----------------------------------------------------------------------------------------\r\n"
                + "Enrollment Date: " + new SimpleDateFormat("dd/MM/yyyy").format(this.DateOfenrollment) + ", The trainee is registered in " + numOfSession + " Sessions\r\n"
                + "Sessions Details are as Follows:\r\n";

        for (int i = 0; i < numOfSession; i++) {
            Str += ST[i].toString() + "\r\n"
                    + "-----------------------------------------------------------------------------------------\r\n";
        }

        return Str;

    }

}
