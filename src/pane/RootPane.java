package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

public class RootPane extends VBox {
    private static RootPane instance;

    private RootPane() {
        // TODO: FILL CODE HERE
    	this.setStyle("-fx-background-color: white;");
    	this.setAlignment(Pos.TOP_CENTER);
    	this.setSpacing(16);
    	this.setPadding(new Insets(32,0,0,32));
    	Text text = new Text("Let's Read");
    	text.setFill(Color.DARKCYAN);
    	text.setFont(Font.font("Verdana", FontWeight.BOLD, 32));
    	this.getChildren().add(text);
        ///////////////////////
        Goto.setRootPane(this);
        Goto.mainPage();
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
