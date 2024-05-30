package com.example.ooap_lab4_identitymap;

import java.util.HashMap;
import java.util.Map;

public class IdentityMap {
    private Map<Long, Item> internalMap;

    private ItemsFactory itemsFactory;

    private Database database;

    public IdentityMap(Map<Long, Item> internalMap, ItemsFactory itemsFactory, Database database) {
        this.internalMap = internalMap;
        this.itemsFactory = itemsFactory;
        this.database = database;
    }

    public Item retrieveById(Long id) {
        if(!internalMap.containsKey(id)) {
            Item item = database.getById(id);
            internalMap.put(id, item);
            return item;
        }
        return internalMap.get(id);
    }
}
