package com.QLTV.DAO;

import com.QLTV.entities.DocGia;
import com.QLTV.entities.NhanVien;
import com.QLTV.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocGiaDAO extends QLTVDAO<DocGia, Object> {
 final String select = "Select * from dbo.DocGia ";
        final String insert = "INSERT into dbo.DocGia "
                + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
                + "values (?,?,?,?,?,?,?);";
        final String update = "UPDATE dbo.DocGia set "
                + "HoTen=?,Email=?,SoDT=?,GioiTinh=?,"
                + "Hinh=?,NvID=? where DgID= ?";
        final String delete = "DELETE FROM dbo.DocGia where DgID = ?";
        final String selectByID = select + " where DgID = ?";
  
    @Override
    public void insert(DocGia entity) {
//  final String insert = "INSERT into dbo.DocGia "
//                + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
//                + "values (?,?,?,?,?,?,?);";
            XJdbc.update(insert, 
                    entity.getDgID(),
                    entity.getHoTen(),
                    entity.getEmail(),
                    entity.getSoDT(),
                    entity.isGioiTinh(),
                    entity.getHinh(),
                    entity.getNvID()
                    );
    }

    @Override
    public void update(DocGia entity) {
         final String update = "UPDATE dbo.DocGia set "
                + "HoTen=?,Email=?,SoDT=?,GioiTinh=?,"
                + "Hinh=?,NvID=? where DgID= ?";
        XJdbc.update(update,
                entity.getHoTen(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.isGioiTinh(),
                entity.getHinh(),
                entity.getNvID(),
                entity.getDgID()
             );
    }

    @Override
    public void delete(Object MaNV) {
        XJdbc.update(delete, MaNV);
    }

    @Override
    public DocGia selectById(Object manv) {
        List<DocGia> list = this.selectBySql(selectByID, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DocGia> selectAll() {
        return this.selectBySql(select);
    }

    @Override
    protected List<DocGia> selectBySql(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
//                      final String insert = "INSERT into dbo.DocGia "
//                + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
//                + "values (?,?,?,?,?,?,?);";
                    DocGia enity = new DocGia();
                    enity.setDgID(rs.getString("dgid"));
                    enity.setHoTen(rs.getString("hoten"));
                    enity.setEmail(rs.getString("email"));
                    enity.setSoDT(rs.getString("sodt"));
                    enity.setGioiTinh(rs.getBoolean("gioitinh"));
                    enity.setHinh(rs.getString("Gioitinh"));
                    enity.setNvID(rs.getString("nvid"));
                   
               
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
