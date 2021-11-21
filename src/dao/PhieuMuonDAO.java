/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.PhieuMuon;

/**
 *
 * @author abc
 */
@SuppressWarnings("deprecation")
public class PhieuMuonDAO extends AbstractDAO<PhieuMuon, Object> {

    static {
        final String select = "Select * from dbo.PhieuMuon ";
        final String insert = "INSERT into dbo.PhieuMuon "
                + "(PhieuID,DgID,NvID,NgayMuon,NgayTra,GhiChu) "
                + "values(?,?,?,?,?,?);";
        final String update = "UPDATE dbo.PhieuMuon set "
                + "DgID=?,NvID=?,NgayMuon=?,NgayTra=?,"
                + "GhiChu=? where PhieuID = ?";
        final String delete = "DELETE FROM dbo.PhieuMuon "
                + "where PhieuID = ?";
        final String selectByID = select + "where PhieuID = ?";
        // Tạo câu truy vấn dữ liệu
        AbstractDAO.setQuery(ET.PhieuMuon, select, insert, update, delete, selectByID);
    }
}
