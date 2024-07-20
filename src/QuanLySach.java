import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySach {
	private ArrayList<ISach> listSach = new ArrayList<ISach>();
	String line;
	Scanner sc = new Scanner(System.in);
	FileReader fread = null;
	BufferedReader buffR = null;
	FileWriter fwriter = null;
	BufferedWriter buffW = null;

	public void themSach(ISach sach) {
		listSach.add(sach);
	}

	public void sapXepTheoMa() {
		Comparator<ISach> com = (s1, s2) -> s1.getMaSach().compareTo(s2.getMaSach());
		listSach.sort(com);
		listSach.forEach(System.out::println);
	}

	public void sapXepTenTua() {
		Comparator<ISach> com = (s1, s2) -> s1.getTuaSach().compareTo(s2.getTuaSach());
		listSach.sort(com);
		listSach.forEach(System.out::println);
	}

	public void sapXepTenTG() {
		Comparator<ISach> com = (s1, s2) -> s1.getTenTG().compareTo(s2.getTenTG());
		listSach.sort(com);
		listSach.forEach(System.out::println);
	}

	public void sapXepTheLoai() {
		Comparator<ISach> com = (s1, s2) -> s1.getTheLoai().compareTo(s2.getTheLoai());
		listSach.sort(com);
		listSach.forEach(System.out::println);
	}

	public void sapXepNamXB() {
		Comparator<ISach> com = (y1, y2) -> y1.getNamXB().compareTo(y2.getNamXB());
		listSach.sort(com);
		for (ISach Sach : listSach) {
			Sach.getLine();
		}
	}

	public void xoaSach(String maSach) {
		if (listSach.isEmpty()) {
			System.out.println("Không có sách để xóa!");
		}
		boolean xoaSach = false;
		for (int i = 0; i < listSach.size(); i++) {
			if (listSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
				listSach.remove(i);
				System.out.println("Xóa thành công!");
				xoaSach = true;
			}
		}
		if (xoaSach = false) {
			System.out.println("Mã sách bạn cần xóa không tồn tại!");
		}
	}

	public void hienThi() {
		if (listSach.isEmpty()) {
			System.out.println("Hiện chưa có sách!");
			return;
		}
		listSach.forEach(System.out::println);
	}

	public void suaSach(String maSach) {
		boolean suaSach = false;
		for (int i = 0; i < listSach.size(); i++) {
			if (listSach.get(i).getMaSach().equals(maSach)) {
				System.out.println("Nhập thông tin thay đổi:");
				System.out.println("Mã sách: ");
				String suaMaSach = sc.nextLine();
				System.out.println("Tựa sách: ");
				String suaTuaSach = sc.nextLine();
				System.out.println("Tên tác giả: ");
				String suaTenTG = sc.nextLine();
				System.out.println("Thể loại: ");
				String suaTheLoai = sc.nextLine();
				System.out.println("Năm xuất bản: ");
				String suaNamXB_str = sc.nextLine();
				Date suaNamXB = (Date) Sach.String_Date(suaNamXB_str);
				listSach.get(i).suaThongTin(suaMaSach, suaTuaSach, suaTenTG, suaTheLoai, suaNamXB);
				System.out.println("Sửa thành công!");
				System.out.println(listSach.get(i));
				suaSach = true;
			}
		}
		if (!suaSach) {
			System.out.println("Không tìm thấy mã sách bạn cần sửa!");
		}
	}

	public ISach timSachTheoMaSach(String maSach) {
		for (int i = 0; i < listSach.size(); i++) {
			if (listSach.get(i).getMaSach().equals(maSach)) {
				return listSach.get(i);
			}
		}
		System.out.println("Mã sách cần tìm không tồn tại!");
		return null;
	}

	public ISach timSachTheoTuaSach(String tuaSach) {
		for (int i = 0; i < listSach.size(); i++) {
			if (listSach.get(i).getTuaSach().equals(tuaSach)) {
				return listSach.get(i);
			}
		}
		System.out.println("Tựa sách cần tìm không tồn tại!");
		return null;
	}

	public ISach timSachTheoTacGia(String tenTG) {
		for (int i = 0; i < listSach.size(); i++) {
			if (listSach.get(i).getTenTG().equals(tenTG)) {
				return listSach.get(i);
			}
		}
		System.out.println("Tác giả cần tìm không tồn tại!");
		return null;
	}

	public void docSach() {
		try {
			fread = new FileReader(new File("./book_data.txt"));
			buffR = new BufferedReader(fread);
			String line;
			while ((line = buffR.readLine()) != null) {
				ISach sach = new Sach(line);
				listSach.add(sach);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffR != null) {
					buffR.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void ghiSach() {
		try {
			fwriter = new FileWriter(new File("./sach.txt"));
			buffW = new BufferedWriter(fwriter);
			for (ISach iSach : listSach) {
				buffW.write(iSach.getLine());
				buffW.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffW != null)
					buffW.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
