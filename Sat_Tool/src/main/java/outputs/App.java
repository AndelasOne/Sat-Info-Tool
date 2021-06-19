/**
 * @author : Andreas Weber, Philip Linkewitz, Marissa Eichhorn
 * @matrikelnummern: 1540399, 3306922, 4249633
 * @created : 12.06.2021, Samstag
 *
 * Copyright (c) 2021 DHBW Stuttgart
 **/
package outputs;

import dhbw.swe.AbstractNode;
import dhbw.swe.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static AbstractNode<String> data;

    /**
     * start the app
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(), 800, 600);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    /**
     * set data to show in GUI
     * @param input data to show
     */
    public static void setData(AbstractNode<String> input){
        data = input;
    }

    /**
     * load the fxml file to show in the GUI
     * @return Parent object
     * @throws IOException
     */
    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("primary" + ".fxml"));
        Parent parent = fxmlLoader.load();
        PrimaryController controller = fxmlLoader.getController();
        controller.setData(data);
        return parent;
    }
}