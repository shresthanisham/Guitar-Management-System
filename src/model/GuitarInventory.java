/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author Dell
 */
public class GuitarInventory {
    private  final ArrayList<Guitar> guitarList;
    private final Queue<Guitar> recentlyAddedQueue;

    public GuitarInventory() {
        guitarList = new ArrayList<>();
        recentlyAddedQueue = new LinkedList<>();
    }

    // ---------------- CRUD OPERATIONS ----------------

    public boolean addGuitar(Guitar guitar) {
        // Prevent duplicate (model + brand)
        for (Guitar g : guitarList) {
            if (g.getModelName().equalsIgnoreCase(guitar.getModelName())
                    && g.getBrand().equalsIgnoreCase(guitar.getBrand())) {
                return false;
            }
        }

        guitarList.add(guitar);
        addToRecentlyAdded(guitar);
        return true;
    }

    public boolean updateGuitar(Guitar updatedGuitar) {
        for (int i = 0; i < guitarList.size(); i++) {
            if (guitarList.get(i).getGuitarId() == updatedGuitar.getGuitarId()) {
                guitarList.set(i, updatedGuitar);
                return true;
            }
        }
        return false;
    }

    public boolean deleteGuitar(int guitarId) {
        return guitarList.removeIf(g -> g.getGuitarId() == guitarId);
    }

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

    // ---------------- RECENTLY ADDED (QUEUE) ----------------

    private void addToRecentlyAdded(Guitar guitar) {
        if (recentlyAddedQueue.size() == 5) {
            recentlyAddedQueue.poll(); // remove oldest
        }
        recentlyAddedQueue.offer(guitar);
    }

    public Queue<Guitar> getRecentlyAddedGuitars() {
        return new LinkedList<>(recentlyAddedQueue);
    }

    // ---------------- SEARCH METHODS ----------------

    // Linear search for partial matches (model, brand, year)
    public List<Guitar> searchByKeyword(String keyword) {
        List<Guitar> results = new ArrayList<>();
        keyword = keyword.toLowerCase();

        for (Guitar g : guitarList) {
            if (g.getModelName().toLowerCase().contains(keyword)
                    || g.getBrand().toLowerCase().contains(keyword)
                    || String.valueOf(g.getYear()).contains(keyword)) {
                results.add(g);
            }
        }
        return results;
    }

    // Binary search by year
    public Guitar binarySearchByYear(int year) {
    
    sortByYear(true);

    int low = 0;
    int high = guitarList.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int midYear = guitarList.get(mid).getYear();

        if (midYear == year) {
            return guitarList.get(mid);
        } else if (midYear < year) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return null;
}


    // ---------------- SORT METHOD ----------------

    // Insertion Sort by year (Ascending / Descending)
    public void sortByYear(boolean ascending) {
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

    // ---------------- DASHBOARD STATS ----------------

    public int getTotalGuitars() {
        return guitarList.size();
    }

    public int getTotalStockQuantity() {
        int total = 0;
        for (Guitar g : guitarList) {
            total += g.getStockQty();
        }
        return total;
    }
}
