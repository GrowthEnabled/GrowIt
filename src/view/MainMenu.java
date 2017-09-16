package view;

import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
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
        container.setSpacing(50);
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

        HBox textBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        textBox.setSpacing(30);
        textBox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Text labelSched = makeText("Schedule");

        Text labelTools = makeText("Tools");

        Text labelNotes = makeText("Notes");

        Text labelLive = makeText("Live");

        textBox.getChildren().addAll(labelLive, labelSched, labelTools, labelNotes);

        container.getChildren().addAll(textBox);
    }

    private Text makeText(String text) {
        //Text effect
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(2);
        innerShadow.setOffsetY(2);
        innerShadow.setRadius(5);

        Text label = new Text(text);
        label.setEffect(innerShadow);
        label.setFont(new Font("Arial Black", 50));
        label.setFill(Color.WHITE);
        return label;
    }

}
