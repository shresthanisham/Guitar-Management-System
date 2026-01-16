package controller;

import java.util.List;
import model.Guitar;

public class InsertionSortGuitar {

    public static void sortById(List<Guitar> list) {
        for (int i = 1; i < list.size(); i++) {
            Guitar key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getGuitarId() > key.getGuitarId()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void sortByYear(List<Guitar> list) {
        for (int i = 1; i < list.size(); i++) {
            Guitar key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getYear() > key.getYear()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void sortByBrand(List<Guitar> list) {
        for (int i = 1; i < list.size(); i++) {
            Guitar key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                   list.get(j).getBrand().compareToIgnoreCase(key.getBrand()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
