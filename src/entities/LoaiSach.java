/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class LoaiSach {

    private String LoaiID;
    private String TenLoai;
    private int TuSo;

    public LoaiSach() {
    }

    public String getLoaiID() {
        return LoaiID;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public int getTuSo() {
        return TuSo;
    }

    public void setLoaiID(String LoaiID) {
        this.LoaiID = LoaiID;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public void setTuSo(int TuSo) {
        this.TuSo = TuSo;
    }
}
