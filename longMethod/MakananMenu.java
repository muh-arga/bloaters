package longMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MakananMenu {
    private ArrayList<Makanan> makanans;
    private Scanner scan;
    
    public MakananMenu(){
        makanans = new ArrayList<Makanan>();
        scan = new Scanner(System.in);
    }
    
    public void open(){
        while(menu()){}
    }
    
    private boolean menu(){
        for(int i=0; i<makanans.size(); i++){
            Makanan makanan = makanans.get(i);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            System.out.print((i+1) + ". ");
            System.out.print(makanan.getNama());
            System.out.print(" - ");
            System.out.print(format.format(makanan.getStart()));
            System.out.print(" - ");
            System.out.print(format.format(makanan.getExp()));
            System.out.println("");
        }
        
        System.out.println("");
        
        System.out.println("1. Create");
        System.out.println("2. Delete");
        System.out.println("3. Exit");
        
        int input = 0;
        do{
            System.out.println("Pilih [1-3]: ");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                input = 0;
            } finally {
                scan.nextLine();
            }
        } while(input < 1 || input > 3);
        
        switch(input){
            case 1: create(); break;
            case 2: delete(); break;
            case 3: return false;
        }
        
        return true;
    }
    
    private void create(){
        String nama = "";
        do {
            System.out.println("Input nama makanan [3-20 Character]: ");
            nama = scan.nextLine();
        }while(nama.length() < 3 || nama.length() > 20 || !isNameUniqe(nama));
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        
        Date startDate = null;
        Date expDate = null;
        
        do{
            do{
                try {
                    System.out.println("Input tanggal pembuatan [yyyy-MM-dd]: ");
                    String input = scan.nextLine().trim();
                    startDate = format.parse(input);
                } catch (Exception e) {
                    startDate = null;
                }
            }while( startDate == null );
            
            do{
                try {
                    System.out.println("Input tanggal kadaluarsa [yyyy-MM-dd]: ");
                    String input = scan.nextLine().trim();
                    expDate = format.parse(input);
                } catch (Exception e) {
                    expDate = null;
                }
            }while( expDate == null );
        }while(startDate.after(expDate));
        
        makanans.add(new Makanan(nama, startDate, expDate));
    }
    
    private void delete(){
        int input = 0;
        do{
            System.out.println("Pilih makanan [1-"+makanans.size()+"]: " );
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                input = 0;
            } finally {
                scan.nextLine();
            }
        }while(input < 1 || input > makanans.size());
        makanans.remove(input - 1);
    }
    
    private boolean isNameUniqe(String nama){
        for(Makanan makanan: makanans){
            if(makanan.getNama().equalsIgnoreCase(nama)) return false;
        }
        return true;
    }
}
