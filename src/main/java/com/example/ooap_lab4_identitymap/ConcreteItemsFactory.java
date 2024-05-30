package com.example.ooap_lab4_identitymap;

import java.util.Arrays;
import java.util.List;

public class ConcreteItemsFactory implements ItemsFactory{

    private static final String defaultDescription = "Описание";

    private static final List<String> defaultSizes = Arrays.asList("46","48", "50");

    private static final List<String> defaultColors = Arrays.asList("green","blue", "white");

    private static final Integer defautQuantity = 3;

    @Override
    public Item build(String name) {
        return new Item(
                name,
                defaultDescription,
                defaultSizes,
                defaultColors,
                defautQuantity
        );
    }
}
