import java.util.ArrayList;

public class DoctorManagement {
    private static ArrayList<Secretary> secretaries = new ArrayList<>();
    private static ArrayList<Prescription> prescriptions = new ArrayList<>();

    public static ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    // افزودن منشی
    public void addSecretary(String firstName,String lastName,String personalNumber,
                             String personalNumberDoctor){
        secretaries.add(new Secretary(firstName,lastName,personalNumber,personalNumberDoctor));
    }

    // نمایش اطلاعات بیمار برای پزشک
    public static void showPatient(String personalNumberDoctor){
        int fileNumber = SecretaryManagement.foundFileNumberPatient(personalNumberDoctor);
        for (int i = 0 ;i < PatientManagement.getPatients().size() ;i++){
            if (PatientManagement.getPatients().get(i).getFileNumber().equals(fileNumber)){
                System.out.println(PatientManagement.getPatients().get(i));
                break;
            }
        }
    }

    // دریافت شماره نسخه
    public int getNumberOfPrescription(){
        if (prescriptions.size() != 0){
            int numberOfPrescription = prescriptions.get(prescriptions.size()-1).getNumberOfprescription();
            numberOfPrescription++;
            return numberOfPrescription;
        }
        else return 0;
    }

    // دریافت تاریخ تجویز نسخه
    public int getDateOfPrescription(int numberOfPrescription){
        int dateOfPrescription = SecretaryManagement.getDateCurrent(numberOfPrescription);
        return dateOfPrescription;
    }

    // افزودن نسخه به لیست نسخه ها
    public void addPrescription(int numberOfprescription,int dateOfprescription,
                                String personalNumber,int fileNumberPatient){
        prescriptions.add(new Prescription(numberOfprescription,dateOfprescription,
                personalNumber,fileNumberPatient));
    }


}
