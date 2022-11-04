import java.util.Scanner;

public class PatientUserPanel {
    Scanner inp = new Scanner(System.in);
    static PatientManagement patientManagement = new PatientManagement();
    static SecretaryManagement secretaryManagement = new SecretaryManagement();

    // عملیات های بیمار
    public void operationPatient(){

        // فهرست عملیات های بیمار
        System.out.println("\n\nEnter the desired operation code\n\n1.Register\n2.Login\n3.Go to the main menu\n" +
                "4.Feedback\n5.Exit");
        int registerOrLoginCode = inp.nextInt();

        switch (registerOrLoginCode){

            // ثبت نام بیمار جدید
            case 1:
                registerPatient();

                break;


            // لاگین بیمار
            case 2:

                // وارد کردن نام کاربری و گذرواژه
                System.out.println("Enter your username");
                int userNamePatient = inp.nextInt();

                System.out.println("Enter your password");
                String passwordPatient = inp.next();

                // چک کردن درست بودن نام کاربری و گذرواژه وارد شده
                if (patientManagement.loginPatient(userNamePatient,passwordPatient)){

                    // چاپ درخواست خوشآمد گویی به بیمار
                    System.out.println("**Hello "+patientManagement.foundNamePatient(userNamePatient)+
                            " Welcome**");

                    // منوی عملیات های بیمار
                    System.out.println("\nEnter the desired operation code\n1.Change user information\n2.See Doctors\n" +
                            "3.Getting an appointment\n4.View visit records\n5.View version\n6.Go to the main menu\n" +
                            "7.Exit");
                    int operationPatientCode = inp.nextInt();

                    switch (operationPatientCode){

                        // تغییر اطلاعات بیمار
                        case 1:
                            changeInformationPatient(userNamePatient);

                            break;

                        // مشاهده پزشکان
                        case 2:
                            seeDoctors();

                            break;

                        // گرفتن نوبت
                        case 3:
                            getAppointment();

                            break;

                        // مشاهده سوابق ویزیت ها
                        case 4:
                            viewVisit();

                            break;

                        // مشاهده نسخه ها
                        case 5:
                            viewVersions();

                            break;

                        // رفتن به منوی اصلی
                        case 6:

                            break;

                        // خروج
                        case 7:
                            System.out.println("**Thank you for choosing us**");
                            System.exit(0);

                        // ارور برای وارد کردن کد دستوری نادرست
                        default:
                            System.out.println("The code entered is incorrect");
                    }

                }
                // ارور برای اینکه کاربری با چنین اطلاعاتی یافت نشد
                else System.out.println("There is no such user");


                break;

            // رفتن به منوی اصلی
            case 3:

                break;

            // انتقادات و پیشنهادات
            case 4:
                System.out.println("Enter your comment");
                String comment = inp.next();
                AdminManagement.addComment(comment);

                break;

            // خروج
            case 5:
                System.out.println("**Thank you for choosing us**");
                System.exit(0);

            // ارور برای وارد کردن کد دستوری نادرست
            default:
                System.out.println("The code entered is incorrect");
        }

    }

    // ثبت نام بیمار
    public void registerPatient(){
        // وارد کردن اطلاعات بیمار
        System.out.println("Enter your firstname");
        String firstNameOfNewPatient = inp.next();

        System.out.println("Enter your lastname");
        String lastNameOfNewPatient = inp.next();

        System.out.println("Enter your password");
        String passwordOfNewPatient = inp.next();

        System.out.println("Enter your phonenumber");
        String phoneNumberOfNewPatient = inp.next();

        // دریافت شماره پرونده بیمار جدید
        int fileNumberOfNewPatient = patientManagement.getFileNumber();

        // ثبت بیمار جدید
        patientManagement.addPatient(firstNameOfNewPatient,lastNameOfNewPatient,passwordOfNewPatient
        ,phoneNumberOfNewPatient,fileNumberOfNewPatient);


        //  نمایش شماره پرونده به بیمار
        System.out.println("Registration completed successfully\n" +
                "Your username(filenumber) is "+fileNumberOfNewPatient);

    }

    // تغییر اطلاعات بیمار با توجه به شماره پرونده
    public void changeInformationPatient(int userName){

        // منوی عملیات تغییرات اطلاعات بیمار
        System.out.println("\nWhich item do you want to change?\nEnter the operation code\n\n" +
                "1.Firstname\n2.Lastname\n3.Password\n4.Phonenumber\n5.Go to the main menu\n6.Exit");
        int operationCodeChangeInformation = inp.nextInt();

        switch (operationCodeChangeInformation){

            // تغییر دادن نام
            case 1:
                System.out.println("Enter a new firstname");
                String newFirstName = inp.next();

                patientManagement.changeFirstNamePatient(newFirstName ,userName);
                System.out.println("The change was successful\nYour new firstname is "+newFirstName);
                break;

            //تغییر دادن نام خانوادگی
            case 2:
                System.out.println("Enter a new lastname");
                String newLastName = inp.next();

                patientManagement.changeLastNamePatient(newLastName,userName);
                System.out.println("The change was successful\nYour new lastname is "+newLastName);
                break;

            // تغییر دادن گذرواژه
            case 3:
                System.out.println("Enter a new password");
                String newPassword = inp.next();

                patientManagement.changePasswordPatient(newPassword,userName);
                System.out.println("The change was successful\nYour new password is "+newPassword);
                break;

            // تغییر دادن شماره همراه
            case 4:
                System.out.println("Enter a new phonenumber");
                String newPhoneNumber = inp.next();

                patientManagement.changePhoneNumberPatient(newPhoneNumber,userName);
                System.out.println("The change was successful\nYour new phonenumber is "+newPhoneNumber);
                break;

            // رفتن به منوی اصلی
            case 5:

                break;

            // خروج
            case 6:
                System.out.println("**Thank you for choosing us**");
                System.exit(0);

            // ارور برای وارد کردن کد دستوری نادرست
            default:
                System.out.println("The code entered is incorrect.");
        }

    }

    // مشاهده پزشکان
    public void seeDoctors(){
        // انتخاب بین مشاهده همه پزشکان یا براساس تخصص
        System.out.println("Enter the desired operation code\n\n1.See all doctors\n" +
                "2.See doctors based on specialty\n3.Go to the main menu\n4.Exit");
        int operationSeeDoctor = inp.nextInt();

        switch (operationSeeDoctor){

            // مشاهده همه پزشکان
            case 1:
                patientManagement.seeAllDoctor();

                break;

            // مشاهده پزشکان براساس تخصص
            case 2:
                System.out.println("Enter the specialty");
                String specialty = inp.next();

                patientManagement.seeDoctorBaseSpecialty(specialty);

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

    // گرفتن نوبت بر اساس تخصص مورد نظر بیمار
    public void getAppointment(){
        System.out.println("Enter the specialty");
        String specialty = inp.next();

        // چک کردن وجود داشتن پزشکی با چنین تخصصصی
        if (patientManagement.checkDoctorBaseSpecialty(specialty)){
            // نمایش دادن لیستی از پزشکان با توجه به تخصص موردنیاز بیمار برای انتخاب
            patientManagement.seeDoctorBaseSpecialty(specialty);

            System.out.println("Enter your username");
            int userName = inp.nextInt();

            System.out.println("Enter the doctor's personal number");
            String personalNumberDoctor = inp.next();

            // دریافت شماره نوبت بیمار
            int numberOfTurn = secretaryManagement.getNumberOfTurn();

            // افزودن نوبت به لیست نوبت های منشی
            secretaryManagement.addTurn(numberOfTurn,
                    secretaryManagement.getTimePrevious(numberOfTurn),
                    secretaryManagement.getDatePrevius(numberOfTurn),
                    userName,personalNumberDoctor);

            // ست کردن تایم نوبت
            secretaryManagement.setTimeAndDate(numberOfTurn);

            // افزودن نوبت به لیست نوبت های بیمار
            patientManagement.addTurnToListTurn(numberOfTurn,
                    secretaryManagement.getTimeCurrent(numberOfTurn),
                    secretaryManagement.getDateCurrent(numberOfTurn),
                    userName,personalNumberDoctor);

            // ثبت نوبت و دادن اطلاعات نوبت ثبت شده به بیمار
            System.out.println("Your turn has been registered");
            secretaryManagement.printTurn(numberOfTurn);
        }
        // عدم وجود داشتن پزشکی با چنین تخصصی
        else System.out.println("No doctor was found with such specialization");

    }

    // مشاهده ویزیت ها
    public void viewVisit(){
        System.out.println("Enter your userName");
        int userName = inp.nextInt();

        patientManagement.chapVisit(userName);
    }

    // مشاهده نسخه ها
    public void viewVersions(){
        System.out.println("Enter your userName");
        int userName = inp.nextInt();

        patientManagement.chapPrescription(userName);
    }

}
