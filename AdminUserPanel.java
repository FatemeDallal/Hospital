import java.util.Scanner;

public class AdminUserPanel {
    Scanner inp = new Scanner(System.in);
    static AdminManagement adminManagement = new AdminManagement();


    // عملیات های مدیر
    public void operationAdmin(){
        System.out.println("Enter your username");
        String userNameAdmin = inp.next();

        System.out.println("Enter your password");
        String passwordAdmin = inp.next();

        // نمایش لیست عملیات های مدیر
        if (userNameAdmin.equals("Admin") && passwordAdmin.equals("Admin")){
            System.out.println("\nEnter the desired operation code\n\n1.Add doctor\n" +
                    "2.Add medicine\n3.Go to the main menu\n4.See comments\n5.Exit");
            int operationAdminCode = inp.nextInt();

            switch (operationAdminCode){

                // افزودن پزشک
                case 1:
                    getDoctorInformation();

                    break;

                // افزودن دارو
                case 2:
                    getMedicineformation();

                    break;

                // رفتن به منوی اصلی
                case 3:

                    break;

                // مشاهده نظر ها
                case 4:
                    chapComment();

                    break;

                // خروج
                case 5:
                    System.exit(0);

                // ارور برای وارد کردن کد دستوری نادرست
                default:
                    System.out.println("The code entered is incorrect");
            }
        }
        // ارور برای وارد کردن نام کاربری و گذرواژه نادرست
        else System.out.println("Wrong username or password");

    }

    // دریافت اطلاعات پزشک
    public void getDoctorInformation(){

        while (true)
        {
            System.out.println("Enter the doctor's firstname");
            String firstNameDoctor = inp.next();

            System.out.println("Enter the doctor's lastname");
            String lastNameDoctor = inp.next();

            System.out.println("Enter the doctor's password");
            String passwordDoctor = inp.next();

            System.out.println("Enter the doctor's personalnumber");
            String personalNumberDoctor = inp.next();

            System.out.println("Enter the doctor's expertise");
            String expertiseDoctor = inp.next();

            // افزودن پزشک به لیست پزشکان
            adminManagement.addDoctor(firstNameDoctor,lastNameDoctor,
                    passwordDoctor,personalNumberDoctor,expertiseDoctor);

            System.out.println("The operation was successful");

            // چک کردن اینکه آیا مدیر می خواهد بازهم پزشک اضافه کند
            System.out.println("Do you want to add a doctor again?(Yes Or No)");
            String yesOrNo = inp.next();

            if (yesOrNo.equals("No")) break;
            else if (!yesOrNo.equals("Yes")){
                System.out.println("You entered the word incorrectly\nRe-enter");
                String yesOrNoAgain = inp.next();
                if (yesOrNoAgain.equals("No")) break;
            }
        }

    }

    // دریافت اطلاعات دارو
    public void getMedicineformation(){

        while (true)
        {
            System.out.println("Enter the name of medicine");
            String nameOfMedicine = inp.next();

            System.out.println("Enter the price of medicine");
            String priceOfMedicine = inp.next();

            System.out.println("Enter the date of manufacture");
            String dateOfManufacture = inp.next();

            System.out.println("Enter the date of expiration");
            String dateOfExpiration = inp.next();

            // افزودن دارو به لیست داروها
            adminManagement.addMedicine(nameOfMedicine,priceOfMedicine,dateOfManufacture,dateOfExpiration);

            System.out.println("The operation was successful");

            // چک کردن اینکه آیا مدیر باز هم می خواهد دارو اضافه کند
            System.out.println("Do you want to add medicine again?(Yes Or No)");
            String yesOrNo = inp.next();

            if (yesOrNo.equals("No")) break;
            else if (!yesOrNo.equals("Yes")){
                System.out.println("You entered the word incorrectly\nRe-enter");
                String yesOrNoAgain = inp.next();
                if (yesOrNoAgain.equals("No")) break;
            }
        }

    }

    // چاپ کامنت ها
    public void chapComment(){
        for (int i = 0 ;i < AdminManagement.getComments().size() ;i++){
            System.out.println(AdminManagement.getComments().get(i));
        }
    }
}
