import java.util.Scanner;

public class DoctorUserPanel {
    Scanner inp = new Scanner(System.in);
    static DoctorManagement doctorManagement = new DoctorManagement();
    static SecretaryManagement secretaryManagement = new SecretaryManagement();


    // عملیات های دکتر
    public void operationDoctor(){
        System.out.println("Enter your UseName");
        String userName = inp.next();

        System.out.println("Enter your password");
        String password = inp.next();

        // نمایش عملیات های دکتر و چک کردن موجود بودن دکتری با چنین نام کاربری و رمز عبور
        if (AdminManagement.checkDoctor(userName,password)){
            System.out.println("\n\nEnter the desired operation code\n\n1.Add secretary\n" +
                    "2.Patient visit\n3.Go to the main menu\n4.Exit");
            int operationDoctor = inp.nextInt();

            switch (operationDoctor){

                // افزودن منشی توسط پزشک
                case 1:
                    addSecretary(userName);

                    break;

                // ویزیت بیمار
                case 2:
                    visitPatient(userName);

                    break;

                // رفتن به منوی اصلی
                case 3:

                    break;

                // خروج
                case 4:
                    System.out.println("**Thank you for choosing us**");
                    System.exit(0);


                // ارور برای وارد کردن کد دستوری نادرست
                default:
                    System.out.println("The code entered is incorrect");

            }
        }
        // ارور برای وارد کردن کد دستوری نادرست
        else System.out.println("There is no such Doctor");


    }

    // افزودن منشی برای دکتر
    public void addSecretary(String personalNumberDoctor){

        while (true)
        {
            System.out.println("Enter the firstname of the secretary");
            String firstNameNewSecretary = inp.next();

            System.out.println("Enter the lastname of the secretary");
            String lastNameNewSecretary = inp.next();

            System.out.println("Enter the personalnumber of the secretary");
            String personalNumberNewSecretary = inp.next();

            doctorManagement.addSecretary(firstNameNewSecretary,
                    lastNameNewSecretary,personalNumberNewSecretary,
                    personalNumberDoctor);

            System.out.println("The operation was successful");

            // چک کردن اینکه آیا پزشک می خواهد باز هم منشی اضافه کند
            System.out.println("Do you want to add a secretary again?(Yes Or No)");
            String yesOrNo = inp.next();

            if (yesOrNo.equals("No")) break;
            else if (!yesOrNo.equals("Yes")){
                System.out.println("You entered the word incorrectly\nRe-enter");
                String yesOrNoAgain = inp.next();
                if (yesOrNoAgain.equals("No")) break;
            }
        }

    }

    // ویزیت کردن بیمار
    public void visitPatient(String personalNumberDoctor){
        System.out.print("Your Patient is ");
        doctorManagement.showPatient(personalNumberDoctor);

        System.out.println("Enter the patient file number");
        int fileNumber = inp.nextInt();

        // دریافت شماره نسخه
        int numberOfPrescription = doctorManagement.getNumberOfPrescription();


        // ایجاد نسخه برای بیمار
        doctorManagement.addPrescription(numberOfPrescription,
                doctorManagement.getDateOfPrescription(numberOfPrescription),
                personalNumberDoctor,fileNumber);

        boolean checkEndPrescription = false;

        // افزودن دارو به نسخه
        while (!checkEndPrescription)
        {
            // چاپ لیست دارو ها
            System.out.println(AdminManagement.getMedicines());
            System.out.println("\n\nEnter the name of the medicine");
            String nameOfMedicine = inp.next();

            // چک کردن درست بودن نام دارو وارد شده و موجود بودن آن
            if (AdminManagement.checkMedicine(nameOfMedicine))
                // افزودن دارو به نسخه بیمار
                Prescription.addMedicineToPrescription(AdminManagement.getMedicine(nameOfMedicine));

            else System.out.println("The name of the medicine entered is incorrect");


            System.out.println("Do you want to add more medicine to the prescription?"+
                    "(Yse Or No)");
            String yesOrNo = inp.next();

            if (yesOrNo.equals("No"))
                checkEndPrescription = true;
            else if (!yesOrNo.equals("Yes"))
                System.out.println("You entered the request incorrectly");
        }

        // حذف نوبت از لیست نوبت های منشی
        secretaryManagement.deleteTurn(fileNumber);

    }
}
