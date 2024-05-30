package com.example.ooap_lab4_identitymap;

import java.util.List;
import java.util.Objects;

public class Item {
    private static Long nextId = 0L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(sizes, item.sizes) && Objects.equals(colors, item.colors) && Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, sizes, colors, quantity);
    }

    public Item(String name, String description, List<String> sizes, List<String> colors, Integer quantity) {
        this.name = name;
        this.description = description;
        this.sizes = sizes;
        this.colors = colors;
        this.quantity = quantity;
        this.id = ++nextId;
    }

    public Item(Item item) {
        this.name = item.name;
        this.id = item.id;
        this.colors = item.colors;
        this.quantity = item.quantity;
        this.sizes = item.sizes;
        this.description = item.description;
    }

    private List<String> sizes;

    private List<String> colors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Integer quantity;
}
