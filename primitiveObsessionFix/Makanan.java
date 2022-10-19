package primitiveObsessionFix;

import java.util.Date;

public class Makanan {
    private Name nama;
    private Date start;
    private Date exp;
    
    public Makanan(Name nama, Date start, Date exp){
        this.nama = nama;
        this.start = start;
        this.exp = exp;
    }
    
    public String getNama(){
        return this.nama.getValue();
    }
    
    public Date getStart(){
        return this.start;
    }
    
    public Date getExp(){
        return this.exp;
    }
}
