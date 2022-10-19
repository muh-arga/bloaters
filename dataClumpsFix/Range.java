package dataClumpsFix;

public class Range {
    private int min;
    private int max;
    
    public Range(int min, int max){
        if(min > max){
            throw new IllegalArgumentException("Min harus lebih kecil dari Max");
        }
        
        this.min = min;
        this.max = max;
    }
    
    public int getMin(){
        return this.min;
    }
    
    public int getMax(){
        return this.getMax();
    }
}
