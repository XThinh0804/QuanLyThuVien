package dataio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Book;

public class DataIO {
	public static ArrayList<Book> loadData(String path) {
		File target = new File(path);
		ArrayList<Book> list = new ArrayList<Book>();

		FileReader fread = null;
		BufferedReader buffR = null;

		try {
			fread = new FileReader(target);
			buffR = new BufferedReader(fread);

			String line;
			while ((line = buffR.readLine()) != null) {
				Book b = new Book(line);
				list.add(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffR != null)
					buffR.close();
			} catch (Exception e) {
			}
		}

		return list;
	}

	public static void saveData(String path, ArrayList<Book> data) {
		File target = new File(path);

		FileWriter fwite = null;
		BufferedWriter buffW = null;

		try {
			fwite = new FileWriter(target);
			buffW = new BufferedWriter(fwite);

			for (Book book : data) {
				buffW.write(book.getLine());
				buffW.newLine(); // xuong dong
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffW != null)
					buffW.close();
			} catch (Exception e) {
			}
		}
	}
}
