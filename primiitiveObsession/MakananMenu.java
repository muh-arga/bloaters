package primiitiveObsession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MakananMenu {

    private Makanans makanans;
    private Inputter inputter;

    public MakananMenu(Makanans makanans, Inputter inputter) {
        this.makanans = makanans;
        this.inputter = inputter;
    }

    public void open() {
        while (menu()) {
        }
    }

    private boolean menu() {
        makanans.show();
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

    private int printAndGetMenu() {
        System.out.println("1. Create");
        System.out.println("2. Delete");
        System.out.println("3. Exit");

        return inputter.getIntInput("Pilih menu", 1, 3);
    }

    private void create() {
        String nama;
        do {
            nama = inputter.getStringInput("Input nama makanan", 3, 20);
        } while (!makanans.isNamaUnique(nama));

        Date startDate;
        Date expDate;

        do {
            startDate = inputter.getDateInput("Input tanggal pembuatan", "yyyy-MM-dd");
            expDate = inputter.getDateInput("Input tanggal kadaluarsa", "yyyy-MM-dd");
        } while (startDate.after(expDate));

        makanans.add(new Makanan(nama, startDate, expDate));
    }

    private void delete() {
        int input = inputter.getIntInput("Pilih makanan", 1, makanans.getSize());
        makanans.removeAtIndex(input - 1);
    }
}
