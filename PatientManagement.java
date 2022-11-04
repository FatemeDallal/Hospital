import java.util.ArrayList;

public class PatientManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();
    // لیست نوبت های بیمار
    private static ArrayList<Turn> listTurns = new ArrayList<>();

    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    // محاسبه شماره پرونده بیمار جدید از روی شماره پرونده بیمار قبلی
    public int getFileNumber(){

        if (patients.size() != 0 ){
            int previousFileNumber = patients.get(patients.size()-1).getFileNumber();
            previousFileNumber++;
            return previousFileNumber;
        }
        else {
            return 1;
        }

    }


    // اضافه کردن بیمار جدید به لیست بیماران
    public void addPatient(String firstName,String lastName,String password,
                           String phoneNumber,Integer fileNumber){
        patients.add(new Patient(firstName,lastName,password,phoneNumber,fileNumber));
    }


    // بررسی کردن وجود داشتن بیمار با این نام کاربری و گذرواژه
    public Boolean loginPatient(int userName ,String password){

        boolean checkUserNamePatient = false;
        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                checkUserNamePatient = true;
                break;
            }
        }

        boolean checkPasswordPatient = false;
        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getPassword().equals(password)){
                checkPasswordPatient = true;
                break;
            }
        }

        if (checkUserNamePatient && checkPasswordPatient) return true;
        else return false;
    }

    // دریافت نام بیمار برای خوش آمدگویی
    public String foundNamePatient(int userName){
        String name = "";
        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                name += patients.get(i).getFirstName();
                break;
            }
        }
        name += " ";
        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                name += patients.get(i).getLastName();
                break;
            }
        }
        return name;
    }

    // تغییر دادن نام بیمار براساس شماره پرونده
    public void changeFirstNamePatient(String newFirstName,int userName){

        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                patients.get(i).setFirstName(newFirstName);
                break;
            }
        }
    }

    // تغییر دادن نام خانوادگی بیمار براساس شماره پرونده
    public void changeLastNamePatient(String newLastName,int userName){

        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                patients.get(i).setLastName(newLastName);
                break;
            }
        }

    }

    // تغییر دادن گذرواژه براساس شماره پرونده
    public void changePasswordPatient(String newPasssword,int userName){

        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                patients.get(i).setPassword(newPasssword);
                break;
            }
        }

    }

    // تغییر دادن شماره تلفن همراه براساس شماره پرونده
    public void changePhoneNumberPatient(String newPhoneNumber,int userName){

        for (int i = 0 ;i < patients.size() ;i++){
            if (patients.get(i).getFileNumber().equals(userName)){
                patients.get(i).setPhoneNumber(newPhoneNumber);
                break;
            }
        }

    }

    // مشاهده همه پزشکان
    public void seeAllDoctor(){
        if (AdminManagement.getDoctors().size() != 0)
            System.out.println(AdminManagement.getDoctors());
        else  System.out.println("Doctor is not available");
    }

    // چک کردن وجود داشتن پزشکی با تخصص خاص
    public Boolean checkDoctorBaseSpecialty(String expertise){

        boolean checkExpertise = false;
        for (int i = 0 ;i < AdminManagement.getDoctors().size() ;i++){
            if (AdminManagement.getDoctors().get(i).getExpertise().equals(expertise)){
                checkExpertise = true;
            }
        }
        return checkExpertise;
    }

    // نمایش دادن پزشکان براساس تخصص
    public void seeDoctorBaseSpecialty(String expertise){

        boolean checkExpertise = false;
        for (int i = 0 ;i < AdminManagement.getDoctors().size() ;i++){
            if (AdminManagement.getDoctors().get(i).getExpertise().equals(expertise)){
                System.out.println(AdminManagement.getDoctors().get(i));
                checkExpertise = true;
            }
        }

        // ارور در صورتی که پزشکی با تخصص وارد شده وجود نداشت
        if (!checkExpertise)
            System.out.println("No doctor was found with such specialization");


    }

    // افزودن نوبت به لیست نوب های بیمار
    public void addTurnToListTurn(int numberOfTurn,int timeOfturn,int dateOfTurn,
                                  int fileNumberOfturn,String personalNumberDoctor){
        listTurns.add(new Turn(numberOfTurn,timeOfturn,dateOfTurn,
                fileNumberOfturn,personalNumberDoctor));

    }


    // چاپ نوبت ها برای بیمار
    public void chapVisit(int fileNumber){
        for (int i = 0 ;i < listTurns.size() ;i++){
            if (listTurns.get(i).getFileNumberOfPatient() == fileNumber){
                if (checkExpiration(listTurns.get(i)))
                    System.out.println(listTurns.get(i));

                else System.out.println(listTurns.get(i)+":expired");
            }
        }
    }

    // چک کردن منقضی شدن نوبت
    public boolean checkExpiration(Turn turn){
        boolean checkExpiration = false;

        for (int i = 0 ;i < SecretaryManagement.getTurns().size() ;i++){
            if (SecretaryManagement.getTurns().get(i).getNumberOfTurn() == turn.getNumberOfTurn()){
                checkExpiration = true;
                break;
            }
        }
        return checkExpiration;
    }

    // چاپ نسخه برای بیمار
    public void chapPrescription(int fileNumber){
        for (int i = 0 ;i < DoctorManagement.getPrescriptions().size() ;i++){
            if ( DoctorManagement.getPrescriptions().get(i).getFileNumberPatient() == fileNumber){
                System.out.println(DoctorManagement.getPrescriptions().get(i));
            }
        }
    }
}
