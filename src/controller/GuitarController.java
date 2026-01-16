package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Guitar;
import model.GuitarInventory;

public class GuitarController {

    private final GuitarInventory inventory;

    public GuitarController(GuitarInventory inventory) {
        this.inventory = inventory;
    }

    // CRUD
    public boolean addGuitar(Guitar guitar) {
        return inventory.addGuitar(guitar);
    }

    public boolean updateGuitar(Guitar guitar) {
        return inventory.updateGuitar(guitar);
    }

    public boolean deleteGuitar(int guitarId) {
        return inventory.deleteGuitar(guitarId);
    }

    public List<Guitar> getAllGuitars() {
        return inventory.getAllGuitars();
    }

    public Guitar getGuitarById(int id) {
        return inventory.getGuitarById(id);
    }

    public void clearAllGuitars() {
        inventory.clearAllGuitars();
    }
    
    public Guitar undoLastDelete() {
    return inventory.undoLastDelete();
}
    // Queue (Recently Added)
    public Queue<Guitar> getRecentlyAddedGuitars() {
        return inventory.getRecentlyAddedGuitars();
    }

    // Searching
    public List<Guitar> searchByKeyword(String keyword) {
        return inventory.searchByKeyword(keyword);
    }

    public Guitar binarySearchByYear(int year) {
        return inventory.binarySearchByYear(year);
    }

    // Sorting using LinkedList
    public LinkedList<Guitar> getSortedGuitarsById() {
        LinkedList<Guitar> list =
                new LinkedList<>(inventory.getAllGuitars());
        InsertionSortGuitar.sortById(list);
        return list;
    }

    public LinkedList<Guitar> getSortedGuitarsByYear() {
        LinkedList<Guitar> list =
                new LinkedList<>(inventory.getAllGuitars());
        InsertionSortGuitar.sortByYear(list);
        return list;
    }

    public LinkedList<Guitar> getSortedGuitarsByBrand() {
        LinkedList<Guitar> list =
                new LinkedList<>(inventory.getAllGuitars());
        InsertionSortGuitar.sortByBrand(list);
        return list;
    }
}
