package com.rba.customspinner.model.entity;

/**
 * Created by Ricardo Bravo on 4/07/16.
 */

public class ItemEntity {

    String id, description;

    public ItemEntity(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
