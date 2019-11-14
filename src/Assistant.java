

import java.util.Date;

public class Assistant extends Person {

    private int ExperienceYears;
    private String Skills;
    private static Assistant Assistants[];
    private static int Counter = 0;

    public static void setSize(int size) {
        Assistants = new Assistant[size];

    }

    public Assistant(int ExperienceYears, String Skills, int id, String name, String Nationality, Date dateofBirth, char gender, long phone, String Address) {
        super(id, name, Nationality, dateofBirth, gender, phone, Address);
        this.ExperienceYears = ExperienceYears;
        this.Skills = Skills;
        Add(this);

    }

    private void Add(Assistant A) {
        Assistants[Counter++] = A;
        
    }

    public int getExperienceYears() {
        return ExperienceYears;
    }

    public void setExperienceYears(int ExperienceYears) {
        this.ExperienceYears = ExperienceYears;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String Skills) {
        this.Skills = Skills;
    }

    public static Assistant Find(int ID) {

        for (int i = 0; i < Counter; i++) {
            if (Assistants[i].getId() == ID) {
                return Assistants[i];
            }
        }
        return null;
    }

    public static boolean isFull() {

        return Counter == Assistants.length;
    }

    @Override
    public String toString() {

        return "ExperienceYears = " + this.ExperienceYears + ", Skills = " + this.Skills;
    }
}
