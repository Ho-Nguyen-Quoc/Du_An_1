/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Owner
 */
public class TruongPhong extends NhanVien{
    public double trachNhiem;
      @Override
    //khai báo phương thức
    //trưởng phòng thì củng chỉ là nhân viên
    public double getThuNhap(){
        double ln = luong + trachNhiem - getThueTN();
        return ln;
    }

    @Override
    public double getThueTN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xuatThongTin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
