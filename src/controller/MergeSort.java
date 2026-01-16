/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.ArrayList;
import model.Guitar;

public class MergeSort {

    public static void sortByYear(List<Guitar> list) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;

        List<Guitar> left = new ArrayList<>(list.subList(0, mid));
        List<Guitar> right = new ArrayList<>(list.subList(mid, list.size()));

        sortByYear(left);
        sortByYear(right);

        merge(list, left, right);
    }

    private static void merge(List<Guitar> result,
                              List<Guitar> left,
                              List<Guitar> right) {

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getYear() <= right.get(j).getYear()) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }
}

