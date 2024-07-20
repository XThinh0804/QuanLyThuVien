package model;

public class Book {
	/*
	 * + mã sách + tựa sách + tên tác giả + thể loại + năm xb
	 * 
	 */
	private String id;
	private String title;
	private String author;
	private String type;
	private String publishYear;

	private static int currentID = 0;

	public Book(String line) {
		String[] parts = line.split(";");
		this.id = parts[0];
		this.title = parts[1];
		this.author = parts[2];
		this.type = parts[3];
		this.publishYear = parts[4];

		if (Integer.valueOf(id) > currentID) {
			currentID = Integer.valueOf(id);
		}
	}

	public Book(String title, String author, String type, String publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.publishYear = publishYear;
		currentID++;
		this.id = currentID + "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getLine() {
		return String.format("%s;%s;%s;%s;%s", id, title, author, type, publishYear);
	}

	public int compareID(Book b) {
		int id1 = Integer.valueOf(id);
		int id2 = Integer.valueOf(b.id);
		return id1 - id2;
	}

	@Override
	public String toString() {
		return String.format("%s %s    %s   %s  %s", id, title, author, type, publishYear);
	}

	public boolean containInTitle(String keyWord) {
		String upperTitle = title.toUpperCase();
		keyWord = keyWord.toUpperCase();
		return upperTitle.contains(keyWord);
	}
}
