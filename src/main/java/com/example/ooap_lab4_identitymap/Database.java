package com.example.ooap_lab4_identitymap;

import java.util.Map;

public class Database {
    public Database(Map<Long, Item> data) {
        this.data = data;
    }

    private Map<Long, Item> data;

    public void save(Item item) {
        if(data.containsKey(item)) {
            data.replace(item.getId(), item);
        } else {
            data.put(item.getId(), item);
        }

    }

    public Item getById(Long id) {
        //при подгрузке объекта из бд каждый раз создается новый объект
        Item item = new Item(this.data.get(id));
        return item;
    }
}
