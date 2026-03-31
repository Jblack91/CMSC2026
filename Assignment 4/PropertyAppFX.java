/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: FX
 * Due: 3/30/2026
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Julian Black
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application
{
    private ManagementCompany company;

    private TextField propertyNameField;
    private TextField cityField;
    private TextField rentField;
    private TextField ownerField;
    private TextArea outputArea;

    public void start(Stage primaryStage)
    {
        company = new ManagementCompany("Campus Realty", "123-45-6789");

        Label propertyNameLabel = new Label("Property Name:");
        propertyNameField = new TextField();

        Label cityLabel = new Label("City:");
        cityField = new TextField();

        Label rentLabel = new Label("Rent Amount:");
        rentField = new TextField();

        Label ownerLabel = new Label("Owner:");
        ownerField = new TextField();

        Button addButton = new Button("Add Property");
        Button showButton = new Button("Show All Properties");
        Button totalButton = new Button("Show Total Rent");
        Button clearButton = new Button("Clear");
        Button exitButton = new Button("Exit");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefWidth(400);
        outputArea.setPrefHeight(220);

        addButton.setOnAction(e -> addProperty());
        showButton.setOnAction(e -> showProperties());
        totalButton.setOnAction(e -> showTotalRent());
        clearButton.setOnAction(e -> clearFields());
        exitButton.setOnAction(e -> primaryStage.close());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addButton, showButton, totalButton);

        HBox buttonBox2 = new HBox(10);
        buttonBox2.getChildren().addAll(clearButton, exitButton);

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(
                propertyNameLabel, propertyNameField,
                cityLabel, cityField,
                rentLabel, rentField,
                ownerLabel, ownerField,
                buttonBox,
                buttonBox2,
                outputArea
        );

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Property Management Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addProperty()
    {
        String propertyName = propertyNameField.getText();
        String city = cityField.getText();
        String owner = ownerField.getText();

        double rentAmount;

        try
        {
            rentAmount = Double.parseDouble(rentField.getText());
        }
        catch (NumberFormatException e)
        {
            outputArea.setText("Rent must be a number.");
            return;
        }

        Property p = new Property(propertyName, city, rentAmount, owner);
        int result = company.addProperty(p);

        if (result == -1)
        {
            outputArea.setText("Cannot add property. Maximum number reached.");
        }
        else
        {
            outputArea.setText("Property added successfully at index " + result + ".");
        }
    }

    private void showProperties()
    {
        outputArea.setText(company.toString());
    }

    private void showTotalRent()
    {
        outputArea.setText("Total Rent: " + company.totalRent());
    }

    private void clearFields()
    {
        propertyNameField.clear();
        cityField.clear();
        rentField.clear();
        ownerField.clear();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}