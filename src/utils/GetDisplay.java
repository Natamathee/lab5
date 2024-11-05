package utils;


import item.Book;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;

public class GetDisplay {
	public static Text Description(Book book, int fontSize, int wrappingWidth) {
		Text text = new Text(book.getDescription());
		text.setFont(new javafx.scene.text.Font(fontSize));
		text.setWrappingWidth(wrappingWidth);
		return text;
	}
	
	public static ImageView image(Book book, int fitHeight) {
		ImageView imageView = new ImageView(book.getImage());
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(fitHeight);
		return imageView;
	}
	
	public static Text name(Book book, int fontSize, int WrappingWidth, TextAlignment textAlignment) {
		Text name = new Text(book.getName());
		name.setFont(new javafx.scene.text.Font(fontSize));
		name.setWrappingWidth(WrappingWidth);
		name.setTextAlignment(textAlignment);
		return name;
	}
	
	public static Text author(Book book,int fontSize, int wrappingWidth, TextAlignment textAlignment) {
		Text author = new Text(book.getAuthor());
		author.setFill(Color.GRAY);
		author.setFont(new javafx.scene.text.Font(fontSize));
		author.setWrappingWidth(wrappingWidth);
		author.setTextAlignment(textAlignment);
		return author;
	}
	
	public static Text stars(Book book, int fontSize) {
		int rating = book.getStars();
		String stars = "\u2605".repeat(rating) + "\u2606".repeat(5 - rating);
		Text text = new Text(stars);
		text.setFill(Color.DARKRED);
		text.setFont(new javafx.scene.text.Font(fontSize));
		return text;
	}
}
