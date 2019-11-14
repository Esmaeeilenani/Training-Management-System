
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TMSmain {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        new TMSmain().Run();
    }

    public void Run() throws FileNotFoundException, ParseException {
        File FR = new File("input.txt");
        if (!FR.exists()) {
            System.out.println("File Not Exists!!");
            System.exit(0);
        }

        Scanner in = new Scanner(FR);

        PrintWriter out = new PrintWriter("output.txt");

        //get Arrays size Form file
        Trainer.setSize(in.nextInt());

        Assistant.setSize(in.nextInt());

        TrainingRoom.setSize(in.nextInt());

        TrainingSession.setSize(in.nextInt());

        Trainee.setSize(in.nextInt());

        //Read File input
        ReadFile(in, out);
    }

//Reading File Method
    public void ReadFile(Scanner in, PrintWriter out) throws FileNotFoundException, ParseException {

        String Command = "";
        out.println("--------------- Welcome to Training Management System ---------------");
        while (in.hasNext()) {
            Command = in.next().trim();

            if (Command.contains("Add")) {
                String type = Command.substring(4, Command.length());
                out.println("Command " + Command + " Add a new " + type.toLowerCase() + "  record in the System ");
                out.println(type + " information as follows:");

            } else if (Command.contains("Assign")) {
                out.println("Command " + Command + ": Successfully Processed by the System, Following are the details:");
            }

            switch (Command) {
                case "Add_Trainer":
                    AddTrainer(in, out);
                    break;

                case "Add_Assistant":
                    AddAssistant(in, out);
                    break;

                case "Add_TrainingRoom":
                    AddRoom(in, out);
                    break;

                case "Add_TrainingSession":
                    AddSession(in, out);
                    break;

                case "Add_Trainee":
                    AddTrainee(in, out);
                    break;

                case "Assign_TraingSession_Trainer":
                    Assign_Session_Trainar(in, out);
                    break;

                case "Assign_TrainingSession_Assistant":
                    Assign_Session_Assistant(in, out);
                    break;

                case "Assign_TrainingSession_TrainingRoom":
                    Assign_Session_Room(in, out);
                    break;

                case "Assign_TrainingSession_Trinee":
                    Assign_Session_Trinee(in, out);
                    break;

                case "Print_Report":
                    Trainee.Print(out);
                    break;

                case "Quit":
                    out.println("Thank you for using Training Management System, Good Bye! ");
                    out.close();
                    System.exit(0);

                    break;
            }
            out.println();
            out.println("----------------------------------------------------------------");
        }

    }
//------------------------------------------------------------------------------            

//Add Trainer to System
    public void AddTrainer(Scanner in, PrintWriter out) throws ParseException {

        if (!Trainer.isFull()) {
            Trainer T = new Trainer(in.next(), in.next(), in.nextDouble(), in.next(),
                    in.next(), in.nextBoolean(), in.nextInt(), in.next(), in.next(),
                    StringToDate(in.next()), in.next().charAt(0), in.nextInt(), in.next());

            out.println(T.toString());
            return;
        }

        out.println("You have exceed the Maxmum limit of Trainer");

    }
//------------------------------------------------------------------------------            

//Add Assistant to System
    public void AddAssistant(Scanner in, PrintWriter out) throws ParseException {

        if (!Assistant.isFull()) {

            Assistant A = new Assistant(in.nextInt(), in.next(), in.nextInt(), in.next(), in.next(), StringToDate(in.next()), in.next().charAt(0), in.nextLong(), in.next());
            out.println(A.toString());
            return;
        }

        out.println("You have exceed the Maxmum limit of Assistant");

    }
//------------------------------------------------------------------------------            

//Add Training Room to System
    public void AddRoom(Scanner in, PrintWriter out) {

        if (!TrainingRoom.isFull()) {

            TrainingRoom R = new TrainingRoom(in.nextInt(), in.next(), in.nextInt(), in.nextInt());
            out.println(R.toString());
            return;
        }

        out.println("You have exceed the Maxmum limit of Training Room");

    }
//------------------------------------------------------------------------------            

//add Training Session to System
    public void AddSession(Scanner in, PrintWriter out) throws ParseException {

        if (!TrainingSession.isFull()) {

            TrainingSession TS = new TrainingSession(in.nextInt(), in.next(), StringToDate(in.next()), in.nextInt());
            out.println(TS.INFO());
            return;
        }

        out.println("You have exceed the Maxmum limit of Training Session");

    }
//------------------------------------------------------------------------------            

//add Trainee to System
    public void AddTrainee(Scanner in, PrintWriter out) throws ParseException {

        if (!Trainee.isFull()) {

            Trainee TE = new Trainee(StringToDate(in.next()), in.nextInt(), in.next(), in.next(), StringToDate(in.next()), in.next().charAt(0), in.nextLong(), in.next());
            out.println(TE.getId());
            return;
        }

        out.println("You have exceed the Maxmum limit of Trainee");

    }
//------------------------------------------------------------------------------            

//Assign Session to Trainer 
    public void Assign_Session_Trainar(Scanner in, PrintWriter out) {
        int SE_ID = in.nextInt();

        //Sarch for Session id in the System
        TrainingSession Sess = TrainingSession.Find(SE_ID);

        if (Sess != null) {

            int TR_ID = in.nextInt();

            //Sarch for Trainer id in the System
            Trainer TR = Trainer.Find(TR_ID);

            if (TR != null) {

                //the trainer is Available
                if (TR.isAvailable()) {

                    Sess.setTrainer(TR);
                    out.println("\t\tTraining Session: " + Sess.getTrainingSessionTitle());
                    out.println("\t\tAssigned to Trainer: " + TR.getName());
                } else {

                    out.println("\t\tThe trainer " + TR.getName() + " not available");
                }

            } else {

                out.println("Trainer with ID (#" + TR_ID + ") Not Found");
            }

        } else {
            out.println("Session with ID (#" + SE_ID + ") Not Found");
        }

    }
//------------------------------------------------------------------------------            

//Assign Session to Assistant
    public void Assign_Session_Assistant(Scanner in, PrintWriter out) {
        boolean Aprove = false;
        int SE_ID = in.nextInt();

        //Sarch for Session id in the System
        TrainingSession Sess = TrainingSession.Find(SE_ID);

        if (Sess != null) {
            int AS_ID = in.nextInt();

            //Sarch for Assistant id in the System
            Assistant AS = Assistant.Find(AS_ID);

            if (AS != null) {
                String skills[] = AS.getSkills().trim().toLowerCase().split("/");

                //make sure have the Skills to be in the Course
                for (int i = 0; i < skills.length && Aprove == false; i++) {
                    Aprove = Sess.getTrainingSessionTitle().toLowerCase().contains(skills[i]);
                }

                //if he have the Skill
                if (Aprove) {

                    Sess.setAssistant(AS);
                    out.println("\t\tTraining Session: " + Sess.getTrainingSessionTitle());
                    out.println("\t\tAssigned to Assistant: " + AS.getName());

                } else {
                    out.println("the requested assistant doesn’t have the required expertise");
                }

            } else {

                out.println("Assistant with ID (#" + AS_ID + ") Not Found");
            }

        } else {
            out.println("Session with ID (#" + SE_ID + ") Not Found");
        }

    }
//------------------------------------------------------------------------------            

//Assign Session to a Room
    public void Assign_Session_Room(Scanner in, PrintWriter out) {

        int SE_ID = in.nextInt();

        //Sarch for Session id in the System
        TrainingSession Sess = TrainingSession.Find(SE_ID);

        if (Sess != null) {

            int RoomNO = in.nextInt();

            //Search for Rom Number in the System
            TrainingRoom Room = TrainingRoom.Find(RoomNO);

            if (Room != null) {

                Sess.setTrainingRoom(Room);
                out.println("\t\tTraining Session: " + Sess.getTrainingSessionTitle());
                out.println("\t\tAssigned to Training Room : " + RoomNO);

            } else {

                out.println("Room with Number (#" + RoomNO + ") Not Found");
            }

        } else {
            out.println("Session with ID (#" + SE_ID + ") Not Found");
        }
    }
//------------------------------------------------------------------------------            

//Assign Session to a Trinee 
    public void Assign_Session_Trinee(Scanner in, PrintWriter out) {
        int TE_ID = in.nextInt();

        //Search for Trainee id in the System
        Trainee Tree = Trainee.Find(TE_ID);

        if (Tree != null) {

            int S_ID = in.nextInt();

            //Sarch for Session id in the System
            TrainingSession Sess = TrainingSession.Find(S_ID);

            if (Sess != null) {

                //Trainee can have Only 3 Session
                if (Tree.getNumOfSession() < 3) {

                    Tree.addST(Sess);
                    out.println("\t\tTraining Session: " + Sess.getTrainingSessionTitle());
                    out.println("\t\tAssigned to Trainee : " + Tree.getName());

                } else {
                    out.println("\t\tTrainee " + Tree.getName() + " has exceeded the maximum registered");

                }
            } else {

                out.println("Session with ID (#" + S_ID + ") Not Found");
            }

        } else {
            out.println("Trainee with ID (#" + TE_ID + ") Not Found");

        }

    }
//------------------------------------------------------------------------------            

    public static Date StringToDate(String str) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(str);
    }
}
