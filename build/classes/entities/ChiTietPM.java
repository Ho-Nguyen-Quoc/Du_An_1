/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dao.AbstractDAO;
import entities.PhieuMuon;
import java.sql.ResultSet;

public class ChiTietPM extends AbstractDAO<PhieuMuon.ChiTietPM, Integer> {

    private String SachID;
    private int SoLuong;

    public String getSachID() {
        return SachID;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSachID(String SachID) {
        this.SachID = SachID;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
}
