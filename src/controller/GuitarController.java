package controller;

import java.util.ArrayList;
import model.Guitar;
import model.GuitarInventory;

public class GuitarController {

    private final GuitarInventory inventory;

    public GuitarController(GuitarInventory inventory) {
        this.inventory = inventory;
    }

    // ADD
    public boolean addGuitar(Guitar guitar) {
        return inventory.addGuitar(guitar);
    }

    // UPDATE
    public boolean updateGuitar(Guitar updatedGuitar) {
        return inventory.updateGuitar(updatedGuitar);
    }

    // DELETE
    public boolean deleteGuitar(int guitarId) {
        return inventory.deleteGuitar(guitarId);
    }

    // FIND BY ID (needed for update/delete)
    public Guitar getGuitarById(int guitarId) {
        return inventory.getGuitarById(guitarId);
    }
    public void clearAllGuitars() {
    inventory.clearAllGuitars();
}

    // LIST ALL
    public ArrayList<Guitar> getAllGuitars() {
        return inventory.getAllGuitars();
    }
}