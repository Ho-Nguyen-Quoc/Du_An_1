/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Owner
 */
public interface IDao {
    public boolean insert(Object nv);
    public boolean update();
    public boolean delete();
}
