import java.util.Date;

public interface ISach {

	public String getMaSach();

	public String getTuaSach();

	public String getTenTG();

	public String getTheLoai();

	public Date getNamXB();

	public String getLine();

	public void suaThongTin(String maSach, String tuaSach, String tenTG, String theLoai, Date namXB);
}
