/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.NhanVien;
import model.TruongPhong;

/**
 *
 * @author Owner
 */
public class NhanVienDao implements IDao{

    @Override
    public boolean insert() {
        NhanVien nv = new TruongPhong();
        NhanViencontroller.ds.add(nv);
        return true;
    }

    @Override
    public boolean update() {
    return true;
    }

    @Override
    public boolean delete() {
    return true;
    }
    
}
