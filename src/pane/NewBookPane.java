package pane;


import item.Book;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;

public class NewBookPane extends GridPane{
	public NewBookPane() {
		this.setPadding(new Insets(12));
		this.setVgap(8);
		TextField nameInput = input();
		TextField authorInput = input();
		TextField ratingInput = input();
		TextField imageInput = input();
		TextField descriptionInput = input();
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(25);
		col1.setHalignment(HPos.RIGHT);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(75);
		Button addButton = new Button("Add");
		addButton.setMaxWidth(430);
		addButton.setPrefHeight(32);
		addButton.setTextFill(Color.WHITE);
		addButton.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		addButton.setOnMouseClicked(event -> handleClick(nameInput.getText(), authorInput.getText(), ratingInput.getText(), imageInput.getText(), descriptionInput.getText()));
		this.getColumnConstraints().addAll(col1,col2);
		
		this.add(label("Title: "), 0, 0);
		this.add(label("Author: "), 0, 1);
		this.add(label("Rating: "), 0, 2);
		this.add(label("Image: "), 0, 3);
		this.add(label("Description: "), 0, 4);
		this.add(nameInput, 1, 0);
		this.add(authorInput, 1, 1);
		this.add(ratingInput, 1, 2);
		this.add(imageInput, 1, 3);
		this.add(descriptionInput, 1, 4);
		
		this.add(addButton, 0, 5, 2, 1);
	}
	
	private Text label(String s) {
		Text labelText = new Text(s);
		labelText.setFont(Font.font(16));
		return labelText;
	}
	private TextField input() {
		TextField inputText = new TextField();
		inputText.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(16), Insets.EMPTY)));
		inputText.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, new CornerRadii(16), BorderWidths.DEFAULT)));
		return inputText;
	}
	private void handleClick(String name, String author, String rating, String image, String description) {
		if (name.isBlank() || author.isBlank() || rating.isBlank() || image.isBlank() || description.isBlank()) {
            return;
        }
		
		Book newBook = new Book(name,author,rating,image,description);
		BookListPane.getInstance().getBooks().add(newBook);
		
		BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
		Goto.mainPage();
	}
}
