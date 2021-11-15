package com.QLTV.unity;
public class DocGia {
    private String maPM;
    private String hoTen;
    private boolean gioiTinh;
    private String diaChi;
    private String email;
    private String soDT;
    private String ngayDK;
    private String ngayHH;

    public DocGia(String maPM, String hoTen, boolean gioiTinh, String diaChi, String email, String soDT, String ngayDK, String ngayHH) {
        this.maPM = maPM;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.soDT = soDT;
        this.ngayDK = ngayDK;
        this.ngayHH = ngayHH;
    }

    public DocGia(){
    }
    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setNgayDK(String ngayDK) {
        this.ngayDK = ngayDK;
    }

    public void setNgayHH(String ngayHH) {
        this.ngayHH = ngayHH;
    }

    public String getMaPM() {
        return maPM;
    }

    public String getHoTen() {
        return hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getNgayDK() {
        return ngayDK;
    }

    public String getNgayHH() {
        return ngayHH;
    }
    
}
