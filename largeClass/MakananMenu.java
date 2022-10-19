package largeClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MakananMenu {

    private ArrayList<Makanan> makanans;
    private Scanner scan;

    public MakananMenu() {
        makanans = new ArrayList<Makanan>();
        scan = new Scanner(System.in);
    }

    public void open() {
        while (menu()) {
        }
    }

    private boolean menu() {
        showMakanan();
        int input = printAndGetMenu();
        switch (input) {
            case 1:
                create();
                break;
            case 2:
                delete();
                break;
            case 3:
                return false;
        }

        return true;
    }

    private void create() {
        String nama = "";
        do {
            nama = getStringInput("Input nama makanan", 3, 20);
        } while (!isNameUniqe(nama));

        Date startDate;
        Date expDate;

        do {
            startDate = getDateInput("Input tanggal pembuatan", "yyyy-MM-dd");
            expDate = getDateInput("Input tanggal kadaluarsa", "yyyy-MM-dd");
        } while (startDate.after(expDate));

        makanans.add(new Makanan(nama, startDate, expDate));
    }

    private void delete() {
        int input = getIntInput("Pilih makanan", 1, makanans.size());
        makanans.remove(input - 1);
    }

    private boolean isNameUniqe(String nama) {
        for (Makanan makanan : makanans) {
            if (makanan.getNama().equalsIgnoreCase(nama)) {
                return false;
            }
        }
        return true;
    }

    private int printAndGetMenu() {
        System.out.println("1. Create");
        System.out.println("2. Delete");
        System.out.println("3. Exit");

        return getIntInput("Pilih menu", 1, 3);

    }

    private void showMakanan() {
        for (int i = 0; i < makanans.size(); i++) {
            Makanan makanan = makanans.get(i);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            System.out.print((i + 1) + ". ");
            System.out.print(makanan.getNama());
            System.out.print(" - ");
            System.out.print(format.format(makanan.getStart()));
            System.out.print(" - ");
            System.out.print(format.format(makanan.getExp()));
            System.out.println("");
        }
        System.out.println("");
    }

    private int getIntInput(String message, int min, int max) {
        int input;
        do {
            System.out.print(message + " [" + min + "-" + max + "]: ");
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

    private String getStringInput(String message, int min, int max) {
        String input;
        do {
            System.out.print(message + " [" + min + "-" + max + " character] :");
            input = scan.nextLine();
        } while (input.length() < min || input.length() > max);

        return input;
    }

    private Date getDateInput(String message, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        Date date = null;
        do {
            try {
                System.out.print(message + " [" + format + "] :");
                String intput = scan.nextLine().trim();
                date = sdf.parse(intput);
            } catch (Exception e) {
                date = null;
            }
        } while (date == null);

        return date;
    }
}
