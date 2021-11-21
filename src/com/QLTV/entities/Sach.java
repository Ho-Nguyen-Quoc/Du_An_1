package com.QLTV.entities;

import java.sql.Date;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String nhaXB;
    private Date namXB;
    private String theLoai;
    private double gia;
    private String moTa;
    private String anh;
    private String daySach;
    private String o;

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public void setNamXB(Date namXB) {
        this.namXB = namXB;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public void setDaySach(String daySach) {
        this.daySach = daySach;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public Date getNamXB() {
        return namXB;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public double getGia() {
        return gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getAnh() {
        return anh;
    }

    public String getDaySach() {
        return daySach;
    }

    public String getO() {
        return o;
    }
    
}
