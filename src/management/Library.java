package management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import model.Book;

public class Library {
	private ArrayList<Book> listBook;

	public Library(ArrayList<Book> list) {
		this.listBook = list;
	}

	public void showList() {
		Scanner sc = new Scanner(System.in);
		int chon;
		String[] menuItem = { "1. Sắp xếp theo ma", "2. Sắp xếp theo tựa sách", "3. Sắp xếp theo tác giả",
				"4. Sắp xếp theo thể loại", "5. Sắp xếp theo năm xb\n", "0. Quay lại\n", };
		do {
			printMenu("SHOW LIST", menuItem);
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				Comparator<Book> com = (o1, o2) -> o1.compareID(o2);
				printList(com, listBook);
				break;
			case 2:
				Comparator<Book> com2 = (o1, o2) -> o1.getTitle().compareTo(o2.getTitle());
				printList(com2, listBook);
				break;
			case 3:
				Comparator<Book> com3 = (o1, o2) -> o1.getAuthor().compareTo(o2.getAuthor());
				printList(com3, listBook);
				break;
			case 4:
				Comparator<Book> com4 = (o1, o2) -> o1.getType().compareTo(o2.getType());
				printList(com4, listBook);
				break;
			case 5:
				Comparator<Book> com5 = (o1, o2) -> o1.getPublishYear().compareTo(o2.getPublishYear());
				printList(com5, listBook);
				break;
			default:
				break;
			}
		} while (chon != 0);
	}

	private void printList(Comparator<Book> com, ArrayList<Book> data) {
		data.sort(com); // sap xep
		for (Book book : data) {
			String[] titles = lineBreaker(book.getTitle(), 25);
			String[] authors = lineBreaker(book.getAuthor(), 15);
			String[] types = lineBreaker(book.getType(), 15);
			int max = max(titles.length, authors.length, types.length);
			String[] ids = { book.getId() };
			String pYs[] = { book.getPublishYear() };
			for (int i = 0; i < max; i++) {
				System.out.format("%-5s| %-28s| %-15s| %-15s| %4s|\n", i < ids.length ? ids[i] : "",
						i < titles.length ? titles[i] : "", i < authors.length ? authors[i] : "",
						i < types.length ? types[i] : "", i < pYs.length ? pYs[i] : "");
			}
			System.out.println("------------------------------------------------------------------------");
		}
	}

	private int max(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}

	private String[] lineBreaker(String line, int width) {
		StringBuilder sbd = new StringBuilder();
		while (line.length() > width) { //
			int id = line.lastIndexOf(" ", width);
			String s = line.substring(0, id);
			sbd.append(s);
			sbd.append(";");
			line = line.substring(id + 1);
		}
		sbd.append(line);
		return sbd.toString().split(";");
	}

	private void printMenu(String title, String[] menuItem) {
		System.out.println("----" + title + "-----\n");
		for (int i = 0; i < menuItem.length; i++) {
			System.out.println(menuItem[i]);
		}
		System.out.println("Mời chọn:");
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		int chon;
		String[] menuItem = { "\n1. Tìm theo mã", "2. Tìm theo tựa sách", "3. Tìm theo tên tác giả\n",
				"0. Quay lại\n", };
		do {
			printMenu("SEARCH", menuItem);
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				searchById();
				break;
			case 2:
				searchByTitle();
				break;

			default:
				break;
			}
		} while (chon != 0);
	}

	private void searchByTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap tu khoa:");
		String keyWord = sc.nextLine();
		ArrayList<Book> ketQua = new ArrayList<Book>();
		for (Book book : listBook) {
			if (book.containInTitle(keyWord)) {
				ketQua.add(book);
			}
		}
		if (ketQua.size() == 0) {
			System.out.println("Khong tim thay");
		} else {
//			for (Book book : ketQua) {
//				System.out.println(book);
//			}
			printList((o1, o2) -> o1.compareID(o2), ketQua);
		}

	}

	private void searchById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma:");
		String ma = sc.nextLine();

		for (int i = 0; i < listBook.size(); i++) {
			if (ma.equals(listBook.get(i).getId())) {
				System.out.println(listBook.get(i));
				break;
			}
		}

	}

	public void addBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin: tua sach;tac gia;the loai;nam xb");
		String input = sc.nextLine();
		String parts[] = input.split(";");
		Book b = new Book(parts[0], parts[1], parts[2], parts[3]);
		listBook.add(b);
		System.out.println("Them sach thanh cong");

	}
}
