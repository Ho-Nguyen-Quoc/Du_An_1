package model;

import dao.DocGiaDAO;
import entities.DocGia;
import javax.swing.ImageIcon;

/**
 *
 * @author abc
 */
public class Cache_KH {

    private static DocGia dg;

    // Đăng nhập
    public static boolean Login(String DgID) {
        dg = new DocGiaDAO().SelectByID(DgID);
        if (dg != null) {
            return true;
        }
        dg = null;
        return false;
    }

    public static DocGia getDg() {
        return dg;
    }
    

    public static boolean isLogin() {
        return dg != null;
    }

    public static ImageIcon getImage() {
        if (Cache_KH.isLogin()) {
            if (dg.getHinh() != null) {
                return Data.convert.Image(
                    Util.Image.getIcon("images/DocGia/" + dg.getHinh()), 95, 140
                );
            }
        }
        return Data.convert.Image(Util.Image.getIcon("src/icons/none.png"),
                95, 140);
    }
}
