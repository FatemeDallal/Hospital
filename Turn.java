public class Turn {
    private int numberOfTurn = 0;
    private int timeOfTurn = 800;
    private int dateOfTurn = 14010201;
    private int fileNumberOfPatient;
    private String personalNumberOfDoctor;

    public Turn(int numberOfTurn, int timeOfTurn, int dateOfTurn
            , int fileNumberOfPatient, String personalNumberOfDoctor) {
        this.numberOfTurn = numberOfTurn;
        this.timeOfTurn = timeOfTurn;
        this.dateOfTurn = dateOfTurn;
        this.fileNumberOfPatient = fileNumberOfPatient;
        this.personalNumberOfDoctor = personalNumberOfDoctor;
    }

    public int getNumberOfTurn() {
        return numberOfTurn;
    }

    public int getTimeOfTurn() {
        return timeOfTurn;
    }

    public void setTimeOfTurn(int timeOfTurn) {
        this.timeOfTurn = timeOfTurn;
    }

    public int getDateOfTurn() {
        return dateOfTurn;
    }

    public void setDateOfTurn(int dateOfTurn) {
        this.dateOfTurn = dateOfTurn;
    }

    public int getFileNumberOfPatient() {
        return fileNumberOfPatient;
    }

    public String getPersonalNumberOfDoctor() {
        return personalNumberOfDoctor;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "numberOfTurn=" + numberOfTurn +
                ", timeOfTurn=" +timeOfTurn/100+":"+timeOfTurn%100+
                ", dateOfTurn=" +dateOfTurn/10000+"/"+(dateOfTurn%10000)/100+"/"+dateOfTurn%100+
                ", fileNumberOfPatient=" + fileNumberOfPatient +
                ", personalNumberOfDoctor='" + personalNumberOfDoctor + '\'' +
                '}';
    }


}
