/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

/**
 *
 * @author Dell
 */
public class GuitarInventory {

    private final ArrayList<Guitar> guitarList;
    private final Stack<Guitar> deletedStack;
    private final Queue<Guitar> recentlyAddedQueue;

    public GuitarInventory() {
        guitarList = new ArrayList<>();
        recentlyAddedQueue = new LinkedList<>();
        deletedStack = new Stack<>();

    }

    // ------------------ ADD ------------------
    public boolean addGuitar(Guitar guitar) {

        // Unique ID check
        for (Guitar g : guitarList) {
            if (g.getGuitarId() == guitar.getGuitarId()) {
                return false;
            }
        }

        // Duplicate record check (brand + type + year)
        for (Guitar g : guitarList) {
            if (g.getBrand().equalsIgnoreCase(guitar.getBrand())
                    && g.getType().equalsIgnoreCase(guitar.getType())
                    && g.getYear() == guitar.getYear()) {
                return false;
            }
        }

        guitarList.add(guitar);
        addToRecentlyAdded(guitar);
        return true;
    }

    // ------------------ UPDATE ------------------
    public boolean updateGuitar(Guitar updatedGuitar) {
        for (int i = 0; i < guitarList.size(); i++) {
            if (guitarList.get(i).getGuitarId() == updatedGuitar.getGuitarId()) {
                guitarList.set(i, updatedGuitar);
                return true;
            }
        }
        return false;
    }

    // ------------------ DELETE ------------------
    public boolean deleteGuitar(int guitarId) {
         for (int i = 0; i < guitarList.size(); i++) {
        if (guitarList.get(i).getGuitarId() == guitarId) {
            Guitar removed = guitarList.remove(i);
            deletedStack.push(removed);  
            return true;
        }
    }
    return false;
    }
    public Guitar undoLastDelete() {
    if (deletedStack.isEmpty()) {
        return null;
    }

    Guitar restored = deletedStack.pop(); 
    guitarList.add(restored);
    return restored;
}

    // ------------------ READ ------------------
    public ArrayList<Guitar> getAllGuitars() {
        return new ArrayList<>(guitarList);
    }

    public Guitar getGuitarById(int id) {
        for (Guitar g : guitarList) {
            if (g.getGuitarId() == id) {
                return g;
            }
        }
        return null;
    }

    public void clearAllGuitars() {
        guitarList.clear();
        recentlyAddedQueue.clear();
    }

    public int getTotalGuitars() {
        return guitarList.size();
    }
    
    //Insertion Sort
    public void insertionSortByYear(boolean ascending) {
        for (int i = 1; i < guitarList.size(); i++) {
            Guitar key = guitarList.get(i);
            int j = i - 1;

            while (j >= 0 && (ascending
                    ? guitarList.get(j).getYear() > key.getYear()
                    : guitarList.get(j).getYear() < key.getYear())) {
                guitarList.set(j + 1, guitarList.get(j));
                j--;
            }
            guitarList.set(j + 1, key);
        }
    }
    
    
    public void sortByYear(boolean ascending) {
        insertionSortByYear(ascending);
    }

    // ------------------ QUEUE (Recently Added) ------------------
    private void addToRecentlyAdded(Guitar guitar) {
        if (recentlyAddedQueue.size() == 5) {
            recentlyAddedQueue.poll(); // remove oldest
        }
        recentlyAddedQueue.offer(guitar);
    }

    public Queue<Guitar> getRecentlyAddedGuitars() {
        return new LinkedList<>(recentlyAddedQueue);
    }

    // ------------------ SEARCH (Linear Search) ------------------
    public List<Guitar> searchByKeyword(String keyword) {
        List<Guitar> results = new ArrayList<>();
        if (keyword == null) return results;

        keyword = keyword.toLowerCase();

        for (Guitar g : guitarList) {
            if (g.getBrand().toLowerCase().contains(keyword)
                    || g.getType().toLowerCase().contains(keyword)
                    || String.valueOf(g.getYear()).contains(keyword)) {
                results.add(g);
            }
        }
        return results;
    }

    
    public Guitar binarySearchByYear(int year) {

        ArrayList<Guitar> sorted = new ArrayList<>(guitarList);

        // Sort copy by year ascending (insertion sort)
        for (int i = 1; i < sorted.size(); i++) {
            Guitar key = sorted.get(i);
            int j = i - 1;

            while (j >= 0 && sorted.get(j).getYear() > key.getYear()) {
                sorted.set(j + 1, sorted.get(j));
                j--;
            }
            sorted.set(j + 1, key);
        }

        int low = 0;
        int high = sorted.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midYear = sorted.get(mid).getYear();

            if (midYear == year) {
                return sorted.get(mid);
            } else if (midYear < year) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
