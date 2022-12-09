package training;

public class Date {
    private short year;
    private byte month, day;
    String inputDate1;

    public Date(String inputDate) {
        inputDate1 = inputDate;
        if (inputDate.length() != 10) {
            System.err.println("Введите дату в формате YYYY-MM-DD");
        }

        try {
            month = Byte.parseByte(inputDate.substring(6, 7));
            day = Byte.parseByte(inputDate.substring(9, 10));
            year = Short.parseShort(inputDate.substring(0, 4));
        } catch (Exception e) {
            System.err.println("Введите дату в формате YYYY-MM-DD");
        }
    }

    //день недели
    public String getDayWeeks() {
        return getDayOfWeekName(weekday(year, month, day));
    }

    //дней в месяце
    public int lengthOfMonth() {
        return length(isLeapYear());
    }

    //высокосный год
    public boolean isLeapYear() {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }

    //число дней до конца месяца
    public int daysLeft() {
        return (lengthOfMonth() - day);
    }

    //форматирование даты
    public String dateFormat(String mask) {
        String year = String.valueOf(this.year);
        String month = this.month / 10 >= 1 ? String.valueOf(this.month) : "0" + this.month;
        String day = this.day / 10 >= 1 ? String.valueOf(this.day) : "0" + this.day;
        return mask.replace("YYYY", year).replace("YY", year.substring(2, 4)).replace("MM", month).replace("DD", day);
    }

    private static String getDayOfWeekName(byte day) {
        String dayName = "";
        switch (day) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            case 4:
                dayName = "Четверг";
                break;
            case 5:
                dayName = "Пятница";
                break;
            case 6:
                dayName = "Суббота";
                break;
            case 7:
                dayName = "Воскресенье";
                break;
        }
        return dayName;
    }

    private static byte weekday(short year, byte month, byte day) {
        if (month < 3) {
            --year;
            month += 10;
        } else
            month -= 2;
        return (byte) (((short) day + 31 * (short) month / 12 + year + year / 4 - year / 100 + year / 400) % 7);
    }

    private int length(boolean leapYear) {
        switch (month) {
            case 2:
                return (leapYear ? 29 : 28);
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

}
