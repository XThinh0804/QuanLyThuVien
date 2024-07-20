import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sach implements ISach {
	private String maSach;
	private String tuaSach;
	private String tenTG;
	private String theLoai;
	private Date namXB;

	public Sach(String line) {
		String parts[] = line.split(";");
		maSach = parts[0];
		tuaSach = parts[1];
		tenTG = parts[2];
		theLoai = parts[3];

		namXB = (Date) String_Date(parts[4]);
	}

	public Sach(String maSach, String tuaSach, String tenTG, String theLoai, Date namXB) {
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tenTG = tenTG;
		this.theLoai = theLoai;
		this.namXB = namXB;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public String getTenTG() {
		return tenTG;
	}

	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public Date getNamXB() {
		return namXB;
	}

	public void setNamXB(Date namXB) {
		this.namXB = namXB;
	}

	public void suaThongTin(String maSach, String tuaSach, String tenTG, String theLoai, Date namXB) {
		this.setMaSach(maSach);
		this.setTuaSach(tuaSach);
		this.setTenTG(tenTG);
		this.setTheLoai(theLoai);
		this.setNamXB(namXB);

	}

	public String getLine() {
		return maSach + ";" + tuaSach + ";" + tenTG + ";" + theLoai + ";" + Date_String(namXB);
	}

	@Override
	public String toString() {
		return maSach + ";" + tuaSach + ";" + tenTG + ";" + theLoai + ";" + Date_String(namXB);
	}

	public static String Date_String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String str = sdf.format(date);
		return str;
	}

	public static Date String_Date(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		sdf.applyPattern("yyyy");
		try {
			Date date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
