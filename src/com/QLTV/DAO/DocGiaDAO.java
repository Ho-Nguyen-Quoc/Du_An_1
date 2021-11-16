package com.QLTV.DAO;

import com.QLTV.unity.DocGia;
import com.QLTV.unity.NhanVien;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocGiaDAO extends QLTVDAO<DocGia, Object> {

    String insert = "	insert into DocGia(mapm,hoten,gioitinh,diachi,email,sodt) values\n"
            + "	(?,?,?,?,?,?)";
    String select = "select * from docgia ";
    String update = " update docgia set hoten = ?,gioiTinh = ?,diachi = ?,email = ? where mapm = ?";
    String selectbyid = " select * from docgia where mapm = ?";
    String delete = "delete from docgia where mapm = ?";

    @Override
    public void insert(DocGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DocGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DocGia selectById(Object manv) {
        List<DocGia> list = this.selectBySql(selectbyid, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DocGia> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<DocGia> selectBySql(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    DocGia enity = new DocGia();
                    enity.setMaPM(rs.getString("mapm"));
                    enity.setHoTen(rs.getString("hoten"));
                    enity.setGioiTinh(rs.getBoolean("gioitinh"));
                    enity.setDiaChi(rs.getString("diachi"));
                    enity.setEmail(rs.getString("email"));
                    enity.setSoDT(rs.getString("sodt"));
                    //String insert = "	insert into DocGia(mapm,hoten,gioitinh,diachi,email,sodt) values\n"
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
