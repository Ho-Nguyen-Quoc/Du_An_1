/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DocGia;

/**
 *
 * @author abc
 */
@SuppressWarnings("deprecation")
public class DocGiaDAO extends AbstractDAO<DocGia, Object> {

    static {
        final String select = "Select * from dbo.DocGia ";
        final String insert = "INSERT into dbo.DocGia "
                + "(DgID,HoTen,Email,SoDT,GioiTinh,Hinh,NvID) "
                + "values (?,?,?,?,?,?,?);";
        final String update = "UPDATE dbo.DocGia set "
                + "HoTen=?,Email=?,SoDT=?,GioiTinh=?,"
                + "Hinh=?,NvID=? where DgID= ?";
        final String delete = "DELETE FROM dbo.DocGia where DgID = ?";
        final String selectByID = select + " where DgID = ?";
        // Tạo câu truy vấn dữ liệu
        AbstractDAO.setQuery(ET.DocGia, select, insert, update, delete, selectByID);
    }
}
