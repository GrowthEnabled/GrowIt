package view;

import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Region containing all components of the main menu
 */
public class MainMenu extends StdScene {


    public MainMenu() {
        bgImg = new Image("res/GrowItWallpaper.png");
        setupControls();
    }

    public void init() {
        super.init();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(30);
        container.setPrefWidth(getScene().getWidth());
        container.setPrefHeight(getScene().getHeight());
        root.getChildren().addAll(background, container);
        this.getChildren().add(root);
    }

    /**
     * Initializes all event handlers for this view object.
     * Handles the resizing of the window as well.
     */




    //Sets up all the button elements: Feeding schedule, grow tools, prefs, notes ...
    private void setupControls() {
        //Effects
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(2);
        innerShadow.setOffsetY(2);
        innerShadow.setRadius(5);

        //Labels
        Text labelSched = new Text("Schedule");
        labelSched.setEffect(innerShadow);
        labelSched.setFont(new Font("Arial Black", 50));
        labelSched.setFill(Color.WHITE);

        Text labelTools = new Text("Tools");
        labelTools.setEffect(innerShadow);
        labelTools.setFont(new Font("Arial Black", 50));
        labelTools.setFill(Color.WHITE);

        Text labelNotes = new Text("Notes");
        labelNotes.setEffect(innerShadow);
        labelNotes.setFont(new Font("Arial Black", 50));
        labelNotes.setFill(Color.WHITE);

        container.getChildren().addAll(labelSched, labelTools, labelNotes);
    }

}
