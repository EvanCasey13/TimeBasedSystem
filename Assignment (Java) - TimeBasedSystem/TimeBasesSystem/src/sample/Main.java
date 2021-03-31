package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    static AnchorPane root;
    static List<AnchorPane> anchor = new ArrayList<AnchorPane>();
    private static int sceneIndex = 0;

    private static User user = null;



    @Override
    //anchors that allow for changing of scenes using the Arraylist of AnchorPane objects by index
    public void start(Stage primaryStage) throws Exception{
        root = (AnchorPane)FXMLLoader.load(getClass().getResource("Anchor.fxml"));

        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("TimeSystemMainInterface.fxml"))); //index 0
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AdminInterface.fxml"))); //index 1
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("AdminFacilityInterface.fxml"))); //index 2


        root.getChildren().add(anchor.get(0)); // initially set to TimeSystemMainInterface

        primaryStage.setTitle("Evans Time Based System");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void init_app(){
        for(int i=0; i<anchor.size();i++){
            //can be used to initiate some details about each pane

        }
    }

    //Method to return a pane at a particular index
    public static AnchorPane get_pane(int index){
        return anchor.get(index);
    }

    //Method used to change panes by removing the current pane adding the new one and updating the current Index of the Scene
    public static void set_pane(int index) {

            root.getChildren().remove(anchor.get(sceneIndex));  //remove the existing pane from the root
            root.getChildren().add(anchor.get(index));          //add the selected pane to the root
            sceneIndex = index;                                   //update the stored sceneIndex

        }


    public static void main(String[] args) {
        launch(args);
    }
}

