/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public  class NhanVien {
    //các biến
    public String maNV;
    public String tenNV;
    int tuoi;
    public String email;
    public String luong;
    public String chucVu;
    //phương thức
    public  double getThuNhap(){
     return 0;
    }
        //nếu abtract thì k cần return
        //tổng thu nhập = thuế getThueTN
        //khai báo phương thức phải return

    public NhanVien(String maNV, String tenNV, int tuoi, String email, String luong, String chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoi = tuoi;
        this.email = email;
        this.luong = luong;
        this.chucVu = chucVu;
    }

    public  double getThueTN(){
        return 0;
                
    }
   
    public  void xuatThongTin(){
        
    }

}
