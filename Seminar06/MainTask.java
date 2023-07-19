// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
// Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) 
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.

// Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев - сохранить 
// параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
// Работу сдать как обычно ссылкой на гит репозиторий

// Частые ошибки:
// 1. Заставляете пользователя вводить все существующие критерии фильтрации
// 2. Невозможно использовать более одного критерия фильтрации одновременно
// 3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, 
//    а не всем введенным пользователем
// 4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять 
//    характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно

package Seminar06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MainTask {
    public static void main(String[] args) {
        String[] menuTop = { "Фильтр.", "Очистить фильтр", "Показать фильтры", "Показать ноутбуки." };
        boolean exit = true;

        Set<NoteBook> set = new HashSet<>();
        Menu menu = new Menu();
        try (Scanner in = new Scanner(System.in)) {
            Filter filter = new Filter();

            for (int i = 0; i < 10; i++) {
                set.add(createNoteBook());
            }

            menu.createMenu(menuTop);

            do {
                System.out.println();
                menu.printMenu();
                String input;
                input = in.nextLine();
                switch (input) {
                    case "1":
                        boolean flag = true;
                        do {
                            int count = 1;
                            System.out.println();
                            for (String key : filter.getFilter().keySet()) {
                                System.out.println((count++) + ". " + key);
                            }
                            System.out.println("0. Вернуться.");
                            System.out.print("Выберите пункт: ");
                            input = in.nextLine();
                            switch (input) {
                                case "1", "2", "3", "4", "5":
                                    switch (input) {
                                        case "1":
                                            System.out.println("Введите минимельно езначение.");
                                            System.out.print("Цена: ");
                                            input = in.nextLine();
                                            filter.addFilter("Цена", input);
                                            break;
                                        case "2":
                                            System.out.println("Введите минимельно езначение.");
                                            System.out.print("ПЗУ: ");
                                            input = in.nextLine();
                                            filter.addFilter("ПЗУ", input);
                                            break;
                                        case "3":
                                            System.out.println("Введите минимельно езначение.");
                                            System.out.print("ОЗУ: ");
                                            input = in.nextLine();
                                            filter.addFilter("ОЗУ", input);                                        
                                            break;
                                        case "4":
                                            System.out.println("Введите цвет (Gray, Black, White, Green, Red).");
                                            System.out.print("Цвет: ");
                                            input = in.nextLine();
                                            filter.addFilter("Цвет", input);
                                            break;
                                        case "5":
                                            System.out.println("Введите операционную систему (Windows, iOS, Linux).");
                                            System.out.print("Система: ");
                                            input = in.nextLine();
                                            filter.addFilter("Система", input);
                                            break;

                                        default:
                                            System.out.println();
                                            System.out.println("Не верный ввод. Попробуйте еще раз.");
                                            break;
                                    }
                                case "0":
                                    flag = false;
                                    break;

                                default:
                                    System.out.println();
                                    System.out.println("Не верный ввод. Попробуйте еще раз.");
                                    break;
                            }

                        } while (flag);

                        break;

                    case "2":
                        filter.clear();
                        System.out.println();
                        System.out.println("Фильтр очищен.");
                        System.out.println();
                        break;

                    case "3":
                        System.out.println();
                        System.out.println(filter);
                        System.out.println();
                        break;

                    case "4":
                        printNoteBook(sortFilter(set, filter));
                        break;

                    case "0":
                        exit = false;
                        break;

                    default:
                        System.out.println();
                        System.out.println("Не верный ввод. Попробуйте еще раз.");
                        break;
                }
            } while (exit);
        }
    }

    static Set<NoteBook> sortFilter(Set<NoteBook> set, Filter filter) {
        Set<NoteBook> temp = new HashSet<>();
        List<String> key = new ArrayList<>();
        List<String> value = new ArrayList<>();

        for (String string : filter.getFilter().keySet()) {
            if (filter.getFilter().get(string) != " - ") {
                System.out.println(string);
                key.add(string);
                value.add(filter.getFilter().get(string));
            }
        }

        for (NoteBook data : set) {
            boolean check = true;
            for (int i = 0; i < key.size(); i++) {
                if (number(value.get(i))) {
                    int tempValue = Integer.parseInt(value.get(i));
                    if (!data.check(key.get(i), tempValue)) {
                        check = false;

                        break;
                    }
                } else {
                    if (!data.check(key.get(i), value.get(i))) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                temp.add(data);
            }
        }
        return temp;
    }

    static void printNoteBook(Set<NoteBook> set) {
        System.out.println();
        System.out
                .println("===========================================================================================");
        for (NoteBook noteBook : set) {
            System.out.println(noteBook);
        }
        System.out
                .println("===========================================================================================");
        System.out.println();
    }

    static NoteBook createNoteBook() {
        Random random = new Random();

        int[] ramSize = { 4, 8, 16, 32 };
        int[] ccdSize = { 128, 256, 512, 1024 };
        String[] color = { "Gray", "Black", "White", "Green", "Red" };
        String[] system = { "Linux", "Windows", "iOS" };

        int ram = random.nextInt(ramSize.length);
        int ccd = random.nextInt(ccdSize.length);
        int sys = random.nextInt(system.length);

        NoteBook noteBook = new NoteBook(ramSize[ram],
                ccdSize[ccd],
                color[random.nextInt(color.length)],
                system[sys],
                (ram + 1) * 4000 + (ccd + 1) * 4500 + (sys + 1) * 8500);

        return noteBook;
    }

    static boolean number(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
