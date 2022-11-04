import java.util.ArrayList;

public class SecretaryManagement {
    // لیست نوبت های منشی
    private static ArrayList<Turn> turns = new ArrayList<>();

    public static ArrayList<Turn> getTurns() {
        return turns;
    }

    // دریافت شماره نوبت
    public int getNumberOfTurn(){
        if (turns.size() != 0){
            int numbetOfTurn = turns.get(turns.size()-1).getNumberOfTurn();
            numbetOfTurn++;
            return numbetOfTurn;
        }
        else
            return 0;
    }

    // دریافت زمان نوبت قبلی
    public int getTimePrevious(int numberOfTurn){
        if (numberOfTurn != 0)
            return turns.get(numberOfTurn-1).getTimeOfTurn();

        else
            return 800;
    }

    // دریافت تاریخ نوبت قبلی
    public int getDatePrevius(int numberOfTurn){
        if (numberOfTurn != 0)
            return turns.get(numberOfTurn-1).getDateOfTurn();

        else
            return 14010201;
    }

    // افزودن نوبت به لیست نوبت های منشی
    public void addTurn(int numberOfTurn,int timeOfTurn,int dateOfTurn,
                        int fileNumberOfTurn,String personalNumberDoctor){
        turns.add(new Turn(numberOfTurn,timeOfTurn,dateOfTurn,
                fileNumberOfTurn,personalNumberDoctor));
    }


    // ست کردن زمان و تاریخ نوبت فعلی بر اساس زمان و تاریخ نوبت قبلی
    public void setTimeAndDate(int numberOfTurn){

        if (numberOfTurn != 0){
            // گذشت یک سال
            if (numberOfTurn % (334 * 16) == 0){
                turns.get(numberOfTurn).setDateOfTurn(turns.get(numberOfTurn-1).getDateOfTurn()+10000);
                turns.get(numberOfTurn).setTimeOfTurn(800);
            }

            // نیمه دوم سال
            else if (numberOfTurn > 5 * 31 * 16){

                // زمان و تاریخ بعد از گذشت یک ماه
                if ((numberOfTurn - 5 * 31 * 16) % (30 * 16) == 0){
                    turns.get(numberOfTurn).setDateOfTurn(turns.get(numberOfTurn-1).getDateOfTurn()+100);
                    turns.get(numberOfTurn).setTimeOfTurn(800);
                }

                // زمان و تاریخ بعد از گذشت یک روز
                else if ((numberOfTurn - 5 * 31 * 16) % 16 == 0){
                    turns.get(numberOfTurn).setDateOfTurn(turns.get(numberOfTurn-1).getDateOfTurn()+1);
                    turns.get(numberOfTurn).setTimeOfTurn(800);
                }

                // زمان و تاریخ بعد از گذشت یک ساعت
                else if ((numberOfTurn - 5 * 31 * 16) % 4 == 0)
                    turns.get(numberOfTurn).setTimeOfTurn(turns.get(numberOfTurn-1).getTimeOfTurn()+(100-45));

                    // زمان و تاریخ بعد از گذشت یک ربع
                else
                    turns.get(numberOfTurn).setTimeOfTurn(turns.get(numberOfTurn-1).getTimeOfTurn()+15);

            }

            // نیمه اول سال
            else {

                // زمان و تاریخ بعد از گذشت یک ماه
                if (numberOfTurn % (31 * 16) == 0){
                    turns.get(numberOfTurn).setDateOfTurn(turns.get(numberOfTurn-1).getDateOfTurn()+100);
                    turns.get(numberOfTurn).setTimeOfTurn(800);
                }

                // زمان و تاریخ بعد از گذشت یک روز
                else if (numberOfTurn % 16 == 0){
                    turns.get(numberOfTurn).setDateOfTurn(turns.get(numberOfTurn-1).getDateOfTurn()+1);
                    turns.get(numberOfTurn).setTimeOfTurn(800);
                }

                // زمان و تاریخ بعد از گذشت یک ساعت
                else if (numberOfTurn % 4 == 0)
                    turns.get(numberOfTurn).setTimeOfTurn(turns.get(numberOfTurn-1).getTimeOfTurn()+(100-45));

                // زمان و تاریخ بعد از گذشت یک ربع
                else
                    turns.get(numberOfTurn).setTimeOfTurn(turns.get(numberOfTurn-1).getTimeOfTurn()+15);
            }


        }

    }

    // دریافت زمان نوبت فعلی برای افزودن به لیست نوبت های بیمار
    public int getTimeCurrent(int numberOfTurn){
        return turns.get(numberOfTurn).getTimeOfTurn();
    }

    // دریافت تاریخ نوبت فعلی برای افزودن به لیست نوبت های بیمار
    public static int getDateCurrent(int numberOfTurn){
        return turns.get(numberOfTurn).getDateOfTurn();
    }

    // حذف کردن نوبت از لیست نوبت های منشی
    public void deleteTurn(int fileNumber){
        for (int i = 0 ;i < turns.size() ;i++){
            if (turns.get(i).getFileNumberOfPatient() == fileNumber){
                turns.remove(i);
                break;
            }
        }
    }

    // پرینت نوبت دریافتی بیمار
    public void printTurn(int numberOfTurn){
        System.out.println(turns.get(numberOfTurn));
    }


    // دریافت شماره پرونده بیماری که نوبتش هست
    public static int foundFileNumberPatient(String personalNumberDoctor){
       for (int i = 0 ;i < turns.size() ;i++){
           if (turns.get(i).getPersonalNumberOfDoctor().equals(personalNumberDoctor))
               return turns.get(i).getFileNumberOfPatient();
       }
       return 0;
    }






}
