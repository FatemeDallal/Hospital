import java.util.ArrayList;

public class AdminManagement {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Medicine> medicines = new ArrayList<>();
    private static ArrayList<String> comments = new ArrayList<>();


    // دریافت اطلاعات پزشکان
    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    // دریافت اطلاعات داروها
    public static void setMedicines(ArrayList<Medicine> medicines) {
        AdminManagement.medicines = medicines;
    }

    // دریافت کامنت ها
    public static ArrayList<String> getComments() {
        return comments;
    }

    // افزودن دکتر به لیست پزشکان
    public void addDoctor(String firsName,String lastName,String password,
                          String personalNumber ,String expertise){
        doctors.add(new Doctor(firsName,lastName,password,personalNumber,expertise));
    }

    // افزودن دارو به لیست داروها
    public void addMedicine(String nameOfMedicine,String priceOfMedicine,
                            String dateOfManufacture,String dateOfExpiration){
        medicines.add(new Medicine(nameOfMedicine,priceOfMedicine,dateOfManufacture,dateOfExpiration));
    }

    // چک کردن وجود داشتن دکتر با چنین نام کاربری و گذرواژه ای
    public static boolean checkDoctor(String personalNumber,String password){

        boolean checkPersonalNumber = false;
        for (int i = 0 ;i < doctors.size() ;i++){
            if (doctors.get(i).getPersonalNumber().equals(personalNumber)){
                checkPersonalNumber = true;
                break;
            }
        }

        boolean checkPassword = false;
        for (int i = 0 ;i < doctors.size() ;i++){
            if (doctors.get(i).getPassword().equals(password)){
                checkPassword = true;
                break;
            }
        }

        return (checkPersonalNumber && checkPassword) ;
    }


    public static ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    // چک کردن وجود داشتن دارویی با چنین نامی
    public static boolean checkMedicine(String nameOfMedicine){
        boolean checkMedicine = false;
        for (int i = 0 ;i < medicines.size() ;i++){
            if (medicines.get(i).getNameOfMedicine().equals(nameOfMedicine)){
                checkMedicine = true;
                break;
            }
        }
        return checkMedicine;
    }

    // دریافت دارویی با چنین نامی
    public static Medicine getMedicine(String nameOfMedicine){
        for (int i = 0 ;i < medicines.size() ;i++){
            if (medicines.get(i).getNameOfMedicine().equals(nameOfMedicine)){
                return medicines.get(i);
            }
        }
        return null;
    }

    // افزودن کامنت به لیست کامنت ها
    public static void addComment(String comment){
        comments.add(comment);
    }

}
