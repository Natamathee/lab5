package utils;

import item.Book;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.RootPane;
import pane.SearchPane;

public class Goto {
	private static RootPane rootPane;

	public static void setRootPane(RootPane rootPane) {
		Goto.rootPane = rootPane;
	}
	public static void clear() {
		if(rootPane.getChildren().size() > 1) {
			rootPane.getChildren().retainAll(rootPane.getChildren().get(0));
		}
	}
	public static void mainPage() {
		clear();
		BookListPane bookListPane = BookListPane.getInstance();
		ScrollPane scrollPane = new ScrollPane(bookListPane);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
        
        rootPane.getChildren().addAll(new SearchPane(), scrollPane);
	}
	public static Button backToMainPageButton() {
		Button button = new Button("Back");
		button.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,new BorderWidths(2))));
		button.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,null)));
		button.setTextFill(Color.DARKCYAN);
		button.setPrefWidth(300);
		button.setOnAction(e -> mainPage());
		return button;
	}
	public static void bookPage(Book book) {
		clear();
		Text bookName = GetDisplay.name(book,28, 336, TextAlignment.CENTER);
		Text bookAuthor = new Text("By " + GetDisplay.author(book, 24, 336, TextAlignment.CENTER));
		ImageView imageView = GetDisplay.image(book, 320);
		Text bookDescription = GetDisplay.Description(book, 16, 336);
		Text bookStars = GetDisplay.stars(book, 24);
		
		rootPane.getChildren().add(backToMainPageButton());
		rootPane.getChildren().addAll(bookName, bookAuthor, imageView, bookStars, bookDescription);
	}
	public static void addNewBookPage() {
		clear();
		rootPane.getChildren().add(backToMainPageButton());
		NewBookPane newBookPane = new NewBookPane();
		rootPane.getChildren().add(newBookPane);
	}
}
