import java.util.ArrayList;

public class Prescription {
    private int numberOfprescription = 0;
    private int dateOfprescription;
    private String personalNumberDoctor;
    private int fileNumberPatient;
    private static ArrayList<Medicine> listOfMedicine = new ArrayList<>();

    public Prescription(int numberOfprescription, int dateOfprescription,
                        String personalNumberDoctor, int fileNumberPatient) {
        this.numberOfprescription = numberOfprescription;
        this.dateOfprescription = dateOfprescription;
        this.personalNumberDoctor = personalNumberDoctor;
        this.fileNumberPatient = fileNumberPatient;
    }

    public int getNumberOfprescription() {
        return numberOfprescription;
    }

    public static void addMedicineToPrescription(Medicine medicine){
        listOfMedicine.add(medicine);
    }

    public int getFileNumberPatient() {
        return fileNumberPatient;
    }

    public static ArrayList<Medicine> getListOfMedicine() {
        return listOfMedicine;
    }


    @Override
    public String toString() {
        return "Prescription{" +
                "numberOfprescription=" + numberOfprescription +
                ", dateOfprescription=" + dateOfprescription/10000+"/"+(dateOfprescription%10000)/100+"/"+dateOfprescription%100+
                ", personalNumberDoctor='" + personalNumberDoctor + '\'' +
                ", fileNumberPatient=" + fileNumberPatient +
                " \n{"+getListOfMedicine()+"} "+
                '}';
    }
}
