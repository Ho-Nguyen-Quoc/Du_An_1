package entities;

import java.sql.Date;

public class NhanVien {

    private String NvID;
    private String MatKhau;
    private String HoTen;
    private Date NgaySinh;
    private String DiaChi;
    private String SoDT;
    private String Email;
    private int ChucVu;
    private String HinhAnh;

    public NhanVien() {
    }

    public NhanVien(String NvID, String MatKhau) {
        this.NvID = NvID;
        this.MatKhau = MatKhau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "NvID=" + NvID + ", HoTen=" + HoTen + '}';
    }

    public void setNhanVien(
            String NvID, String MatKhau, String HoTen, Date NgaySinh,
            String DiaChi, String SoDT, String Email, int ChucVu) {
        this.NvID = NvID;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.Email = Email;
        this.ChucVu = ChucVu;
    }

    public String getNvID() {
        return NvID;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public String getEmail() {
        return Email;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public void setNvID(String NvID) {
        this.NvID = NvID;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

}
