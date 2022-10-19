package longMethod;

import java.util.Date;

public class Makanan {
    private String nama;
    private Date start;
    private Date exp;
    
    public Makanan(String nama, Date start, Date exp){
        this.nama = nama;
        this.start = start;
        this.exp = exp;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public Date getStart(){
        return this.start;
    }
    
    public Date getExp(){
        return this.exp;
    }
}
