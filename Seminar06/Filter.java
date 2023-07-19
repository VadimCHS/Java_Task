package Seminar06;

import java.util.HashMap;
import java.util.Map;

public class Filter {
    private Map<String, String> map;

    Filter() {
        this.map = new HashMap<>();
        filling();
    }

    private void filling() {
        this.map.put("ОЗУ", " - ");
        this.map.put("ПЗУ", " - ");
        this.map.put("Цвет", " - ");
        this.map.put("Система", " - ");
        this.map.put("Цена", " - ");
    }

    public Map<String, String> getFilter() {
        return map;
    }

    public void changed(Map<String, String> data) {
        map.putAll(data);
    }

    public void clear() {
        for (String key : map.keySet()) {
            map.put(key, " - ");
        }
    }

    public void addFilter(String key, String value) {
        map.put(key, value);
    }

    @Override

    public String toString() {
        return "ОЗУ: от " + map.get("ОЗУ") + " Гб\n" +
                "ПЗУ: от " + map.get("ПЗУ") + " Гб\n" +
                "Цвет: " + map.get("Цвет") + "\n" +
                "Система: " + map.get("Система") + "\n" +
                "Цена: от " + map.get("Цена") + " у.е.";
    }
}
