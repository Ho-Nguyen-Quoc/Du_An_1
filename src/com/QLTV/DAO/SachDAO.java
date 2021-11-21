package com.QLTV.DAO;
import com.QLTV.entities.Sach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.QLTV.utils.XJdbc;
import java.sql.SQLException;

public class SachDAO extends QLTVDAO<Sach, String>{
     String insert = "insert into sach(masach,tensach,tacgia,nhaxuatban,namxuatban,theloai,gia,mota,anh,daysach,o) values\n" +
                 "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String select = "select * from sach";
    String delete = "delete from sach where masch = ?";
    String Update = "update sach set tensach = ?, tacgia = ?, nhaxuatban = ?, namxuatban = ?,theloai = ?,gia = ?"
            + ",mota = ?,anh = ?,daysach = ?,o = ? ";
    String selectbyid = "select * from sach where MaNV = ?";
    
    @Override
    public void insert(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sach selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sach> selectAll() {
        return this.selectBySql(select);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
          List<Sach> list = new ArrayList<>();
          try {
            ResultSet rs = null;
              try {
                  rs = XJdbc.query(sql, args);
                  while(rs.next()){
                      Sach enity = new Sach();
                      enity.setMaSach(rs.getString("MaSach"));
                      enity.setTenSach(rs.getString("tenSach"));
                      enity.setNhaXB(rs.getString("nhaxuatban"));
                      enity.setNamXB(rs.getDate("namXuatban"));
                      enity.setTheLoai(rs.getString("TheLoai"));
                      enity.setTacGia(rs.getString("TacGia"));
                      enity.setDaySach(rs.getString("DaySach"));
                      enity.setO(rs.getString("O"));
                      enity.setGia(rs.getInt("Gia"));
                      enity.setAnh(rs.getString("Anh"));
                      enity.setMoTa(rs.getString("MoTa"));
                      list.add(enity);
                  }
              } finally {
                  rs.getStatement().getConnection().close();
              }
        } catch (SQLException ex) {
                ex.printStackTrace();
            throw new RuntimeException(ex);
        }
         return list;
    }
}
