package Seminar06;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> arrayList;
    Menu() {
        this.arrayList = new ArrayList<>();
    }
    
    public void createMenu(String[] string) {
        for (int i = 0; i < string.length; i++) {
            arrayList.add(i, string[i]); 
        }
                   
    }
    
    public void printMenu() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + 1) + ". " + arrayList.get(i));
        }
        System.out.println("0. Выход.");
        System.out.print("Выберите пункт меню: ");
    }
}