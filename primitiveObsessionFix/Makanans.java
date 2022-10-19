package primitiveObsessionFix;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Makanans {
    private ArrayList<Makanan> makanans;
    
    public Makanans(){
        this.makanans = new ArrayList<Makanan>();
    }
    
    public boolean add(Makanan makanan){
        if(!isNamaUnique(makanan.getNama())){
            throw new IllegalArgumentException("Nama sudah terpakai");
        }
        return makanans.add(makanan);
    }
    
    public int getSize(){
        return makanans.size();
    }
    
    public void removeAtIndex(int index){
        makanans.remove(index);
    }
    
    public void show(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0; i<makanans.size(); i++){
            Makanan makanan = makanans.get(i);
            System.out.println((i+1) + " . " + makanan.getNama() + ": " + sdf.format(makanan.getStart()) + " - " + sdf.format(makanan.getExp()));
        }
        System.out.println("");
    }
    
    public boolean isNamaUnique(String nama){
        for(Makanan makanan : makanans){
            if(makanan.getNama().equalsIgnoreCase(nama)) return false;
        }
        return true;
    }

    void add(Name name, Date startDate, Date expDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

