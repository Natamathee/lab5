package pane;

import item.Book;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import utils.GetDisplay;
import utils.Goto;

public class BookPane extends GridPane{
	public BookPane(Book book) {
		this.setPrefWidth(428);
		this.setHgap(8);
		this.setPadding(new Insets(4));
		ImageView image = GetDisplay.image(book, 160);
		this.add(image, 0, 0, 1, 3);
		Text name = GetDisplay.name(book, 18, 250, TextAlignment.LEFT);
		this.add(name, 1, 0);
		Text author = GetDisplay.author(book, 16, 250, TextAlignment.LEFT);
		this.add(author, 1, 1);
		Text stars = GetDisplay.stars(book, 16);
		this.add(stars, 1, 3);
		this.setOnMouseClicked(event -> Goto.bookPage(book));
	}
}
