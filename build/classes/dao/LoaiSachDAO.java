/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.LoaiSach;

/**
 *
 * @author abc
 */
@SuppressWarnings("deprecation")
public class LoaiSachDAO extends AbstractDAO<LoaiSach, Object> {

    static {
        final String select = "Select * from dbo.LoaiSach ";
        final String insert = "INSERT into dbo.LoaiSach "
                + "(LoaiID,TenLoai,TuSo) values (?,?,?);";
        final String update = "UPDATE dbo.LoaiSach set "
                + "TenLoai=?,TuSo=? where LoaiID = ?";
        final String delete = "DELETE FROM dbo.LoaiSach "
                + "where LoaiID = ?";
        final String selectByID = select + "where LoaiID = ?";
        // Tạo câu truy vấn dữ liệu
        AbstractDAO.setQuery(ET.LoaiSach, select, insert, update, delete, selectByID);
    }
}
