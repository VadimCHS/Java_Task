package Seminar06;

import java.util.HashMap;
import java.util.Map;

public class NoteBook {
    private int ramSize;
    private int ccdSize;
    private String color;
    private String system;
    private int price;

    private Map<String, Integer> mapInt = new HashMap<>();
    private Map<String, String> mapStr = new HashMap<>();


    NoteBook(int ramSize, int ccdSize, String color, String system, int price) {
        this.ramSize = ramSize;
        this.ccdSize = ccdSize;
        this.color = color;
        this.system = system;
        this.price = price;
        this.mapInt.put("ОЗУ", this.ramSize);
        this.mapInt.put("ПЗУ", this.ccdSize);
        this.mapInt.put("Цена", this.price);
        this.mapStr.put("Цвет", this.color);
        this.mapStr.put("Система", this.system);
        System.out.println(this.mapStr.get("Цвет"));
    }

    public boolean check(String key, int value){
        if (mapInt.get(key) >= value)
            return true;
        return false;
    }

    public boolean check(String key, String value){
        if (this.mapStr.get(key).equalsIgnoreCase(value))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "ОЗУ: " + ramSize + " Гб, \t" +
               "ПЗУ: " + ccdSize + " Гб,  \t" +
               "Цвет: " + color + ",  \t" +
               "Система: " + system + ",    \t" +
               "Цена: " + price + " у.е.";
    }

    @Override
    public int hashCode() {
        return ramSize * 7 + ccdSize * 13 + color.hashCode() + 
               system.hashCode() + (int)price * 100000;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof NoteBook)){
            return false;
        }
        NoteBook noteBook = (NoteBook) obj;
        return ramSize == noteBook.ramSize &&
               ccdSize == noteBook.ccdSize &&
               color.equalsIgnoreCase(noteBook.color) &&
               system.equalsIgnoreCase(noteBook.system) &&
               price == noteBook.price;
    }
}
