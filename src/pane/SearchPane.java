package pane;


import java.util.ArrayList;

import item.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SearchPane extends HBox{
	public SearchPane() {
		this.setAlignment(Pos.CENTER);
		TextField textField = new TextField();
		textField.setPromptText("Find the book");
		textField.setPrefWidth(250);
		Button searchButton = new Button("Search");
		searchButton.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY, Insets.EMPTY)));
		searchButton.setTextFill(Color.WHITE);
		searchButton.setOnAction(event -> {
			ArrayList<Book> filterBook = new ArrayList<>(BookListPane.getInstance().getBooks());
			if(!textField.getText().isBlank()) {
				String searchText = textField.getText();
				filterBook.removeIf(book -> !book.getName().contains(searchText));
			}
			//TO-DO
		});
		this.getChildren().addAll(textField, searchButton);
	}
}
