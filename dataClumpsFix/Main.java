package dataClumpsFix;

public class Main {
    public static void main(String[] args){
        Makanans makanans = new Makanans();
        Inputter inputter = new Inputter();
        MakananMenu makananMenu = new MakananMenu(makanans, inputter);
        makananMenu.open();
    }
}
