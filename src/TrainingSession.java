

import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainingSession {

    private int trainingSessionID;
    private String trainingSessionTitle;
    private Date StraingDate;
    private int Numberofdays;
    private Trainer trainer;
    private Assistant assistant;
    private TrainingRoom trainingRoom;
    private static TrainingSession Sessions[];
    private static int Counter;

    public static void setSize(int size) {
        Sessions = new TrainingSession[size];
    }

    public TrainingSession(int trainingSessionID, String trainingSessionTitle, Date StraingDate, int Numberofdays) {
        this.trainingSessionID = trainingSessionID;
        this.trainingSessionTitle = trainingSessionTitle;
        this.StraingDate = StraingDate;
        this.Numberofdays = Numberofdays;
        Add(this);
    }

    private void Add(TrainingSession S) {
        Sessions[Counter++] = S;
        
    }

    public int getTrainingSessionID() {
        return trainingSessionID;
    }

    public void setTrainingSessionID(int trainingSessionID) {
        this.trainingSessionID = trainingSessionID;
    }

    public String getTrainingSessionTitle() {
        return trainingSessionTitle;
    }

    public void setTrainingSessionTitle(String trainingSessionTitle) {
        this.trainingSessionTitle = trainingSessionTitle;
    }

    public Date getStraingDate() {
        return StraingDate;
    }

    public void setStraingDate(Date StraingDate) {
        this.StraingDate = StraingDate;
    }

    public int getNumberofdays() {
        return Numberofdays;
    }

    public void setNumberofdays(int Numberofdays) {
        this.Numberofdays = Numberofdays;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public TrainingRoom getTrainingRoom() {
        return trainingRoom;
    }

    public void setTrainingRoom(TrainingRoom trainingRoom) {
        this.trainingRoom = trainingRoom;
    }

    public static TrainingSession Find(int ID) {
        for (int i = 0; i < Counter; i++) {
            if (Sessions[i].getTrainingSessionID() == ID) {
                return Sessions[i];
            }
        }
        return null;
    }

    public static boolean isFull() {

        return Counter == Sessions.length;
    }

    public String INFO() {

        return "Session ID: " + this.trainingSessionID + ", Session Title: " + this.trainingSessionTitle + ", Start at : " + new SimpleDateFormat("dd/MM/yyyy").format(this.StraingDate) + " For " + this.Numberofdays + " Days ";
    }

    public String toString() {
        return "Training Session Title is: " + this.trainingSessionTitle + ", Session ID: " + this.trainingSessionID
                + "\r\nTrainer is: " + this.trainer.getName()
                + "\r\nAssistant is: " + this.assistant.getName()
                + "\r\nRoom No: " + this.trainingRoom.getTrainingRoomNo();

    }

}
