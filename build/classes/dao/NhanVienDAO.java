/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NhanVien;

/**
 *
 * @author abc
 */
@SuppressWarnings({"empty-statement", "deprecation"})
public class NhanVienDAO extends AbstractDAO<NhanVien, Object> {

    static {
        // các câu truy vấn
        final String select = "SELECT * FROM dbo.NhanVien ";
        final String insert = "INSERT into dbo.NhanVien"
                + " (NvID,MatKhau,HoTen,NgaySinh,DiaChi,SoDT,Email,ChucVu,HinhAnh)"
                + " values(?,?,?,?,?,?,?,?,?);";
        final String update = "UPDATE dbo.NhanVien set "
                + "MatKhau=?,HoTen=?,NgaySinh=?,DiaChi=?"
                + ",SoDT=?,Email=?,ChucVu=?,HinhAnh=? where NvID = ?";
        final String delete = "DELETE FROM dbo.NhanVien where NvID = ?";;
        // Lấy dữ liệu từ ID 
        final String selectByID = select + "where NvID = ?";
        // Kiểu lớp bao (element) thay thế bằng ET (element type)
        // Tạo câu truy vấn dữ liệu
        AbstractDAO.setQuery(ET.NhanVien, select, insert, update, delete, selectByID);
    }
}
