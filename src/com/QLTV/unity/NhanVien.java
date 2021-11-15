package com.QLTV.unity;
public class NhanVien {
    private String maNV;
    private String matKhau;
    private String tenNV;
    private boolean chucvu;


    public NhanVien(String maNV, String matKhau, String tenNV, boolean chucvu) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.tenNV = tenNV;
        this.chucvu = chucvu;
    }

    public NhanVien() {
    }



   
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setChucvu(boolean chucvu) {
        this.chucvu = chucvu;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public boolean isChucvu() {
        return chucvu;
    }
    
}
