import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		FileReader fread = null;
		BufferedReader buffR = null;
		FileWriter fwriter = null;
		BufferedWriter buffW = null;
		QuanLySach qliSach = new QuanLySach();
//		đọc từ file
		qliSach.docSach();
		Scanner sc = new Scanner(System.in);
		int n;

		do {
			System.out.println("-----MENU-------");
			System.out.println("1. Hiển thị danh sách");
			System.out.println("2. Tìm kiếm");
			System.out.println("3. Thêm sách");
			System.out.println("4. Sửa thông tin sách");
			System.out.println("5. Xóa sách");
			System.out.println("0. Thoát");
			System.out.println("Mời chọn: ");
			n = sc.nextInt();
			sc.nextLine();
			switch (n) {

			case 1:
				qliSach.hienThi();
				System.out.println("--------Sắp xếp danh sách:--------");
				System.out.println("1.Sắp xếp theo mã");
				System.out.println("2.Sắp xếp theo tên tựa");
				System.out.println("3.Sắp xếp theo tên tác giả");
				System.out.println("4.Sắp xếp theo thể loại");
				System.out.println("5.Sắp xếp theo năm xuất bản");
				System.out.println("0.Quay lại");
				int sx;
				do {
					sx = sc.nextInt();
					switch (sx) {
					case 1:
						qliSach.sapXepTheoMa();
						break;
					case 2:
						qliSach.sapXepTenTua();
						break;
					case 3:
						qliSach.sapXepTenTG();
						break;
					case 4:
						qliSach.sapXepTheLoai();
						break;
					case 5:
						qliSach.sapXepNamXB();
						break;
					case 0:
						System.out.println("Quay lại!");
						break;
					default:
						System.out.println("Nhập sai mời nhập lại");
					}
				} while (sx < 0 || sx > 5);
				break;

			case 2:
				int m;
				do {
					System.out.println("---- SEARCH ----");
					System.out.println("1. Tìm theo mã sách");
					System.out.println("2. Tìm theo tựa sách");
					System.out.println("3. Tìm theo tên tác giả");
					System.out.println("0. quay lại");
					System.out.println("Mời chọn:");
					m = sc.nextInt();
					sc.nextLine();
					switch (m) {
					case 1:
						System.out.println("Nhập mã sách muốn tìm:");
						String maSachTim = sc.nextLine();
						System.out.println(qliSach.timSachTheoMaSach(maSachTim));
						break;
					case 2:
						System.out.println("Nhập tựa sách muốn tìm:");
						String tuaSach = sc.nextLine();
						System.out.println(qliSach.timSachTheoTuaSach(tuaSach));
						break;
					case 3:
						System.out.println("Nhập tác giả muốn tìm:");
						String tenTG = sc.nextLine();
						System.out.println(qliSach.timSachTheoTacGia(tenTG));
						break;
					case 0:
						break;
					default:
						System.out.println("Mời nhập lại!");
					}
				} while (m < 0 || m > 3);
				break;
			case 3:
				System.out.println("Nhập mã sách: ");
				String maSach = sc.nextLine();
				System.out.println("Nhập tựa sách: ");
				String tuaSach = sc.nextLine();
				System.out.println("Nhập tên tác giả: ");
				String tenTG = sc.nextLine();
				System.out.println("Nhập thể loại: ");
				String theLoai = sc.nextLine();
				System.out.println("Nhập năm xuất bản: ");
				String namXB_str = sc.nextLine();
				Date namXB = (Date) Sach.String_Date(namXB_str);
				ISach sach = new Sach(maSach, tuaSach, tenTG, theLoai, namXB);
				qliSach.themSach(sach);
				System.out.println("Thêm sách thành công!");
				break;
			case 4:
				System.out.println("Nhập mã sách bạn muốn sửa:");
				String maSachSearch = sc.nextLine();
				qliSach.suaSach(maSachSearch);
				break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Nhập mã sách bạn cần xóa: ");
				String maSachX = sc.nextLine();
				qliSach.xoaSach(maSachX);
				break;
			case 0:
				System.out.println("Thoát khỏi chương trình!");
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!Vui lòng chọn lại:");
			}
		} while (n != 0);
		// Ghi ra file
		qliSach.ghiSach();
	}

}