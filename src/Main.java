import training.Date;

public class Main {

    public static void main(String[] args) {

        Date date = new Date("2022.12.08");

        System.out.println(date.getDayWeeks());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(date.daysLeft());
        System.out.println(date.dateFormat("YYYY/MM/DD"));
    }

}