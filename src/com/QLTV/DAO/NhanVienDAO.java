package com.QLTV.DAO;
import com.QLTV.unity.NhanVien;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QLTVDAO<NhanVien, String>{
    String insert = "insert into taikhoan(MaNV,TenNhanVien,MK,Chucvu) values(?,?,?,?)";
    String selectbyid = "select * from taikhoan where MaNV = ?";
    String select = "	select * from taikhoan";
    String delete = "delete from taikhoan where MaNV = ?";
    String update = " update taikhoan set TenNhanVien = ?,Mk =?,Chucvu=? where MaNV =?";
    @Override
    public void insert(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVien selectById(String manv) {
        List<NhanVien> list = this.selectBySql(selectbyid, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(select);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien enity = new NhanVien();
                    enity.setMaNV(rs.getString("MaNV"));
                    enity.setTenNV(rs.getString("TenNhanVien"));
                    enity.setMatKhau(rs.getString("MK"));
                    enity.setChucvu(rs.getBoolean("chucvu"));
                    list.add(enity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
