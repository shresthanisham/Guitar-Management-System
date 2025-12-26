package controller;

import model.Guitar;
import model.GuitarInventory;

public class GuitarController {

    private GuitarInventory inventory;

    public GuitarController(GuitarInventory inventory) {
        this.inventory = inventory;
    }

    public boolean addGuitar(Guitar guitar) {
        return inventory.addGuitar(guitar);
    }

    public boolean updateGuitar(Guitar guitar) {
        return inventory.updateGuitar(guitar);
    }

    public boolean deleteGuitar(int id) {
        return inventory.deleteGuitar(id);
    }

    public Guitar getGuitarById(int id) {
        for (Guitar g : inventory.getAllGuitars()) {
            if (g.getGuitarId() == id) {
                return g;
            }
        }
        return null;
    }
}
