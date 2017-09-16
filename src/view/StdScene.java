package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Basic design for every scene.
 */
public abstract class StdScene extends Region {

    VBox container = new VBox();
    Pane root = new Pane();
    ImageView background = new ImageView();
    Image bgImg;

    void init() {
        background.setImage(bgImg);

        updateAfterResize(getScene().getWidth(), getScene().getHeight());
    }

    public void initHandlers() {
        Stage myStage = (Stage)this.getScene().getWindow();
        ChangeListener<Number> changeListener = new ChangeListener<Number> () {
            Timer t = new Timer();
            TimerTask task = null;
            long delayTime = 200;

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                if (task != null) {
                    task.cancel();
                }

                task = new TimerTask() {
                    @Override
                    public void run() {
                        updateAfterResize(myStage.getWidth(), myStage.getHeight());
                    }
                };
                // schedule new task
                t.schedule(task, delayTime);
            }
        };

        myStage.widthProperty().addListener(changeListener);
        myStage.heightProperty().addListener(changeListener);
    }


    private void updateAfterResize(double width, double height) {

        container.setAlignment(Pos.CENTER);
        container.setSpacing(30);
        container.setPrefWidth(width);
        container.setPrefHeight(height);

        double imgRatio = bgImg.getWidth() / bgImg.getHeight();
        if (imgRatio < (width / height)) {
            background.setFitWidth(width);
        } else {
            background.setFitHeight(height);
        }
        background.setPreserveRatio(true);

        background.setLayoutY(height - background.getBoundsInLocal().getHeight() - 28);
        System.out.println("Y set to: " + height + " - " +  background.getBoundsInParent().getHeight());
    }
}
