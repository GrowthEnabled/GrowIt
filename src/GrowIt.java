import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import view.MainMenu;

/**
 * Starter class for the program. Loads all components and displays the main menu.
 */
public class GrowIt extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Controller controller = new Controller();
        Model model = new Model();
        MainMenu mainMenu = new MainMenu();

        Scene startUp = new Scene(mainMenu, 1000, 650);

        mainMenu.init();

        primaryStage.setScene(startUp);
        primaryStage.setTitle("GrowIt - Plant cultivation Tool");
        primaryStage.show();

        mainMenu.initHandlers();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
