/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.HoaDon;

/**
 *
 * @author abc
 */
@SuppressWarnings("deprecation")
public class HoaDonDAO extends AbstractDAO<HoaDon, Object> {

    static {
        final String select = "Select * from dbo.HoaDon ";
        final String insert = "INSERT into dbo.HoaDon "
                + "(HdID,NvID,DgID,NgayMua,GhiChu) "
                + "values (?,?,?,?,?);";
        final String update = "UPDATE dbo.HoaDon set "
                + "NvID=?,DgID=?,NgayMua=?,GhiChu=? where HdID = ?";
        final String delete = "DELETE FROM dbo.HoaDon where HdID = ?";
        final String selectByID = select + "where HdID = ?";
        // Tạo câu truy vấn dữ liệu
        AbstractDAO.setQuery(ET.HoaDon, select, insert, update, delete, selectByID);
    }

    @SuppressWarnings("deprecation")
    static class ChiTietHD extends AbstractDAO<Object, Object> {

        static {
            final String select = "Select * from dbo.ChiTietHD ";
            final String insert = "Select into dbo.ChiTietHD "
                    + "(HdID,SachID,SoLuong,GiaCu)"
                    + "values HdID=?,SachID=?,SoLuong=?,GiaCu=?";
            final String update = null;
            final String delete = null;
            final String selectByID = select + "where HdID = ? "
                    + "and SachID = ? and SoLuong = ? and GiaCu = ?";
            AbstractDAO.setQuery(ET.HoaDon, select, insert, update, delete, selectByID);
        }
    }
}
