// *Получить исходную json строку из файла, используя FileReader или Scanner
// Дана json строка вида:
// String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
// "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
// "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

// Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
// результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.

// *Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package Seminar02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class main1 {
    static String path = "C:\\Users\\1\\Desktop\\GB\\Java_Task\\Seminar02\\readTest.json";
    static String writeTest = "C:\\Users\\1\\Desktop\\GB\\Java_Task\\Seminar02\\writeTest.txtе";
    static String log = "C:\\Users\\1\\Desktop\\GB\\Java_Task\\Seminar02\\log.txt";

    static Logger logger;

    
    public static void main(String[] args) {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                      "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                      "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        creatLogger();
        
        writeFile(writeTest, json);
        String data = readFile(path);
        readFile("Пустой путь");
        String result = students(parceFile(data));
        System.out.println(result);
        writeFile(writeTest, result);
        closeLogger();
    }    

    static void closeLogger() {
        for (Handler handler : logger.getHandlers()) {
            handler.close();
        }
    }

    static void creatLogger() {
        logger = Logger.getAnonymousLogger();
        // logger.config(encoding = "UTF-8");;
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(log);
            fileHandler.setEncoding("UTF-8");
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String readFile(String path) {
        String str = "";
        StringBuilder stringBuilder = new StringBuilder();           
        try (FileInputStream file = new FileInputStream(path);
            InputStreamReader input = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(input);) {
            while ((str = reader.readLine()) != null)
                stringBuilder.append(str);
            logger.info("Файл успешно прочитан.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Не удалось прочитать из файла.");
        }
        return stringBuilder.toString();
    }

    static void writeFile(String path, String json) {
        try (FileOutputStream file = new FileOutputStream(path);
                OutputStreamWriter output = new OutputStreamWriter(file, StandardCharsets.UTF_8);
                BufferedWriter reader = new BufferedWriter(output);) {
            reader.write(json);
            logger.info("Файл успешно записан.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Не удалось записать из файл.");
        }
    }

    static String students(ArrayList<Map<String, String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append("Студент " + arrayList.get(i).get("фамилия") + 
                                 " получил " + arrayList.get(i).get("оценка") + 
                                 " по предмету " + arrayList.get(i).get("предмет") + "\n");
        }
        return stringBuilder.toString();
    }

    static ArrayList<Map<String, String>> parceFile(String string) {
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        string = string.replaceAll("[^A-Za-zА-Яа-я0-9-\"-:]", "");
        String[] arrString = string.split("[,]");

        for (int i = 0; i < arrString.length; i++) {
            arrString[i] = arrString[i].replace("\"", "");
        }

        for (int i = 0, j = 0; i < arrString.length; i++) {
            int index = arrString[i].indexOf(":");
            map.put(arrString[i].toLowerCase().substring(0, index), 
                    arrString[i].substring(index + 1, arrString[i].length()));
            if ((i + 1) % 3 == 0 && i != 0) {
                result.add(j, new HashMap<>());
                Map<String, String> mapResult = result.get(j);
                mapResult.putAll(map);
                j++;
            }
            
        }
        return result;
    }    
}