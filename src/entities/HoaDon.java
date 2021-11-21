/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.List;

public class HoaDon {

    private int HdID;
    private String NvID;
    private String DgID;
    private Date NgayMua;
    private String GhiChu;
    private List<ChiTietHD> list_ChiTiet;

    public HoaDon() {
    }

    public int getHdID() {
        return HdID;
    }

    public void setHdID(int HdID) {
        this.HdID = HdID;
    }

    public String getNvID() {
        return NvID;
    }

    public void setNvID(String NvID) {
        this.NvID = NvID;
    }

    public String getDgID() {
        return DgID;
    }

    public void setDgID(String DgID) {
        this.DgID = DgID;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public List<ChiTietHD> getList_ChiTiet() {
        return list_ChiTiet;
    }

    public void setList_ChiTiet(List<ChiTietHD> list_ChiTiet) {
        this.list_ChiTiet = list_ChiTiet;
    }
    
    // Chi tiết đơn hàng
    public static class ChiTietHD {

        private int HdID;
        private String SachID;
        private int SoLuong;
        private double GiaCu;

        public int getHdID() {
            return HdID;
        }

        public String getSachID() {
            return SachID;
        }

        public int getSoLuong() {
            return SoLuong;
        }

        public double getGiaCu() {
            return GiaCu;
        }

        public void setHdID(int HdID) {
            this.HdID = HdID;
        }

        public void setSachID(String SachID) {
            this.SachID = SachID;
        }

        public void setSoLuong(int SoLuong) {
            this.SoLuong = SoLuong;
        }

        public void setGiaCu(double GiaCu) {
            this.GiaCu = GiaCu;
        }
    }
}
