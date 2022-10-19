package largeClassFix;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {

    protected static Scanner scan;
    
    public Inputter(){
        this.scan = new Scanner(System.in);
    }

    public Date getDateInput(String message, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        Date date = null;
        do {
            try {
                System.out.println(message + " [" + format + "] :");
                String intput = scan.nextLine().trim();
                date = sdf.parse(intput);
            } catch (Exception e) {
                date = null;
            }
        } while (date == null);

        return date;
    }

    public String getStringInput(String message, int min, int max) {
        String input;
        do {
            System.out.println(message + " [" + min + "-" + max + " character] :");
            input = scan.nextLine();
        } while (input.length() < min || input.length() > max);

        return input;
    }

    public Integer getIntInput(String message, int min, int max) {
        int input = 0;
        do {
            System.out.println(message + " [" + min + "-" + max + "]: ");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                input = 0;
            } finally {
                scan.nextLine();
            }
        } while (input < min || input > max);

        return input;
    }
}
