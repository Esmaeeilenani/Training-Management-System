

public class TrainingRoom {

    private int trainingRoomNo;
    private String floor;
    private int buildingNo;
    private int Capacity;
    private static TrainingRoom Rooms[];
    private static int Counter;

    public static void setSize(int size) {
        Rooms = new TrainingRoom[size];
    }

    public TrainingRoom(int trainingRoomNo, String floor, int buildingNo, int Capacity) {
        this.trainingRoomNo = trainingRoomNo;
        this.floor = floor;
        this.buildingNo = buildingNo;
        this.Capacity = Capacity;
        Add(this);
    }

    private void Add(TrainingRoom Room) {
        Rooms[Counter++] = Room;
        
    }

    public int getTrainingRoomNo() {
        return trainingRoomNo;
    }

    public void setTrainingRoomNo(int trainingRoomNo) {
        this.trainingRoomNo = trainingRoomNo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public static TrainingRoom Find(int num) {

        for (int i = 0; i < Counter; i++) {
            if (Rooms[i].getTrainingRoomNo() == num) {
                return Rooms[i];
            }

        }
        return null;
    }

    public static boolean isFull() {

        return Counter == Rooms.length;
    }

    @Override
    public String toString() {

        return " Room  No. : " + this.trainingRoomNo + ", Floor: " + this.floor + ", Building No. : " + this.buildingNo;
    }
}
