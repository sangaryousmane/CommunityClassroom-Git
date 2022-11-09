package oops.advance;

public class TextBook {
    private String title;
    private String author;
    private String publisher;

    public TextBook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public TextBook(TextBook textBox) {
        this.author = textBox.author;
        this.publisher = textBox.publisher;
        this.title = textBox.title;
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
