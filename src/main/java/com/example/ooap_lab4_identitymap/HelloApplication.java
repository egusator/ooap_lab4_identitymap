package com.example.ooap_lab4_identitymap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {

    private TabPane tabPane;

    private Database database;

    private IdentityMap identityMap;

    @Override
    public void start(Stage primaryStage) {
        tabPane = new TabPane();
        database = new Database(new HashMap<Long, Item>());

        ConcreteItemsFactory factory = new ConcreteItemsFactory();
        Item item = factory.build("item1");
        database.save(item);

        identityMap = new IdentityMap(
                new HashMap<>(),
                new ConcreteItemsFactory(),
                database
        );

        Tab tab = new Tab("Item");
        VBox formLayout = createFormLayout();
        tab.setContent(formLayout);
        tabPane.getTabs().add(tab);


        BorderPane root = new BorderPane();
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Form Editor");
        primaryStage.show();
    }

    private VBox createFormLayout() {
        Map<String, TextField> textFieldsById = new HashMap<>();

        VBox formLayout = new VBox();

        Label idLabel = new Label("ID:");
        TextField idField = new TextField();
        textFieldsById.put("idField", idField);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        textFieldsById.put("nameField", nameField);


        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();
        textFieldsById.put("quantityField", quantityField);


        Button loadButton = new Button("Load");
        loadButton.setOnAction(event -> {
            Item item = identityMap.retrieveById(Long.valueOf(textFieldsById.get("idField").getText()));
            textFieldsById.get("nameField").setText(item.getName());
            textFieldsById.get("quantityField").setText(item.getQuantity().toString());
        });

        Button saveButton = new Button("Increase quantity");
        saveButton.setOnAction(event -> {
            Item item = identityMap.retrieveById(Long.valueOf(textFieldsById.get("idField").getText()));
            Integer oldQuantity = item.getQuantity();
            item.setQuantity(oldQuantity + 1);
            database.save(item);
            textFieldsById.get("quantityField").setText(item.getQuantity().toString());
        });

        Button addTabButton = new Button("Add tab");
        addTabButton.setOnAction(event -> {
            Tab tab = new Tab("Item");
            VBox form = createFormLayout();
            tab.setContent(form);
            tabPane.getTabs().add(tab);
        });

        formLayout.getChildren().addAll(idLabel, idField, nameLabel, nameField, quantityLabel, quantityField, saveButton, loadButton, addTabButton);

        return formLayout;
    }

    private void clearFields(TextField idField, TextField nameField, TextField quantityField) {
        idField.clear();
        nameField.clear();
        quantityField.clear();
    }

    public static void main(String[] args) {
        /*
        //без паттерна
        Database database = new Database(new HashMap<Long, Item>());
        ConcreteItemsFactory factory = new ConcreteItemsFactory();
        Item item = factory.build("item1");
        database.save(item);

        //...

        Item item1 = database.getById(item.getId());

        //...

        Item item2 = database.getById(item.getId());

        item1.setQuantity(item1.getQuantity() + 3);

        database.save(item1);

        //...

        Item item3 = database.getById(item.getId());

        System.out.println("without identity map " + item2.equals(item3));

        //с паттерном

        IdentityMap identityMap = new IdentityMap(
                new HashMap<>(),
                new ConcreteItemsFactory(),
                database
        );


        Item item4 = identityMap.retrieveById(item.getId());
        Item item5 = identityMap.retrieveById(item.getId());
        item4.setQuantity(42);

        System.out.println("with identity map " + item4.equals(item5));
        */
        launch();
    }
}