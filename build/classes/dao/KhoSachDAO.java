/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.KhoSach;

/**
 *
 * @author abc
 */
@SuppressWarnings("deprecation")
public class KhoSachDAO extends AbstractDAO<KhoSach, Object> {

    static {
        final String select = "Select * from dbo.KhoSach ";
        final String insert = "INSERT into dbo.KhoSach "
                + "(SachID,TenSach,nhaxb,TacGia,Hinh,SoLuong,DonGia,"
                + "ngayNhap,KeSo,LoaiID) values (?,?,?,?,?,?,?,?,?,?);";
        final String update = "UPDATE dbo.KhoSach set "
                + "TenSach=?,nhaxb=?,TacGia=?,Hinh=?,SoLuong=?,DonGia=?,"
                + "ngayNhap=?,KeSo=?,LoaiID=? where SachID = ?";
        final String delete = "DELETE FROM dbo.KhoSach "
                + "where SachID = ?";
        final String selectByID = select + "where SachID = ?";
        // Câu truy vấn thêm
        final String custom1 = select + " where LoaiID = ?";
        // Tạo câu truy vấn dữu liệu
        AbstractDAO.setQuery(ET.KhoSach, select, insert, update, delete,
                selectByID, custom1);
    }
}
