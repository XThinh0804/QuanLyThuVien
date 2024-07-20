package chua_bai;

import java.util.ArrayList;
import java.util.Scanner;

import dataio.DataIO;
import management.Library;
import model.Book;

public class Main {

	private static String root = "./book_data.txt";

	public static void main(String[] args) {
		// Đọc + ghi file : module riêng
		ArrayList<Book> list = DataIO.loadData(root);
		Library library = new Library(list);

		// Book: model

		// Management: module riêng

		// Menu chọn: class main

		Scanner sc = new Scanner(System.in);
		int chon;
		do {
			printMenu();
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				library.showList();
				break;
			case 2:
				library.search();
				break;
			case 3:
				library.addBook();
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				break;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (chon != 0);

		// lưu data vào file
		DataIO.saveData(root, list);

	}

	private static void printMenu() {
		System.out.println("-----MENU-------");
		System.out.println("\n1. Hiển thị danh sách");
		System.out.println("2. Tìm kiếm");
		System.out.println("3. Thêm sách");
		System.out.println("4. Sửa thông tin sách");
		System.out.println("5. Xóa sách");
		System.out.println("\n0. Thoát");
		System.out.println("\nmời chọn: ");

	}
}
