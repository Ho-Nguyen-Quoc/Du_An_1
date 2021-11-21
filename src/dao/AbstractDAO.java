/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.*;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import model.Jdbc;

/**
 * @param <Element> thực thể dữ liệu bảng
 * @param <Key> khóa chính bảng
 */
public abstract class AbstractDAO<Element, Key> {

    // enum đại điện thực thể cần thay thế (ET: element type)
    public enum ET {
        NhanVien, DocGia, LoaiSach, KhoSach,
        PhieuMuon, ChiTietPM, HoaDon, ChiTietHD
    }

    // câu truy vấn dữ liệu
    private static String Select;
    private static String Insert;
    private static String Update;
    private static String Delete;
    private static String SelectByID;
    private static String[] custom;
    // Phân loại enum thực thể
    private static ET type;

    /**
     * @param typeElement loại thực thể cần truy vấn
     * @param select sql đọc dữ liệu
     * @param insert sql thêm dữ liệu
     * @param update sql sửa dữ liệu
     * @param delete sql xóa dữ liệu
     * @param selectByID sql đọc từ mã khóa chính
     * @param custom câu truy vấn tự tạo
     */
    @Deprecated // Chỉ dùng trong lớp kế thừa DAO
    protected static void setQuery(ET typeElement, String select, String insert,
            String update, String delete, String selectByID, String... custom) {
        AbstractDAO.Select = select;
        AbstractDAO.Insert = insert;
        AbstractDAO.Update = update;
        AbstractDAO.Delete = delete;
        AbstractDAO.SelectByID = selectByID;
        AbstractDAO.custom = custom;
        AbstractDAO.type = typeElement;
    }

    // Phân loại thực thể từ enum "ET" đại diện thực thể
    @SuppressWarnings("unchecked")
    private Element getType() {
        switch (type) {
            case NhanVien:
                return (Element) new NhanVien();
            case DocGia:
                return (Element) new DocGia();
            case LoaiSach:
                return (Element) new LoaiSach();
            case KhoSach:
                return (Element) new KhoSach();
            case PhieuMuon:
                return (Element) new PhieuMuon();
            case ChiTietPM:
                return (Element) new ChiTietPM();
            case HoaDon:
                return (Element) new HoaDon();
            case ChiTietHD:
                return (Element) new HoaDon.ChiTietHD();
            default:
                return null;
        }
    }

    // Thêm dữ liệu phân loại thực thể
    public boolean insert(Element thucThe) {
        try {
            Jdbc.Query(Insert, convertArray(thucThe));
            System.out.println("insert succesfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("insert failed! -> " + e.getMessage());
        }
        return false;
    }

    // Sửa dữ liệu phân loại thực thể
    public boolean update(Element thucThe) {
        try {
            Object[] arr = convertArray(thucThe);
            if (arr.length > 0) {
                Object first = arr[0];
                arr = Arrays.copyOfRange(arr, 1, arr.length + 1);
                arr[arr.length - 1] = first;
                // Thực hiện cập nhật sau
                Jdbc.Query(Update, arr);
                System.out.println("update succesfully!");
                return true;
            } else {
                System.out.println("update failed!!");
            }
        } catch (SQLException e) {
            System.err.println("update failed! -> " + e.getMessage());
        }
        return false;
    }

    // Xóa dữ liệu từ khóa chính của bảng (database)
    public boolean delete(Key K) {
        try {
            Jdbc.Query(Delete, K);
            System.out.println("delete succesfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("delete failed! -> " + e.getMessage());
        }
        return false;
    }

    // Lấy dữ liệu từ khóa chính
    public Element SelectByID(Key K) {
        List<Element> list = SelectALL(SelectByID, K);
        return list.isEmpty() ? null : list.get(0);
    }

    // lấy toàn bộ dữ liệu dạng danh sách
    public synchronized List<Element> SelectALL() {
        return this.SelectALL(Select);
    }

    /**
     * <h3>Phương thức nạp chồng</h3>
     * thao tác dữ liệu từ câu truy vấn mới
     *
     * @param sql câu truy vấn khác
     * @param cols các cột dữ liệu từ database cần lấy
     * @return danh sách tìm được
     */
    public List<Element> SelectALL(String sql, Object... cols) {
        if (type != null) {
            List<Element> list = new LinkedList<>();
            try {
                ResultSet rs = Jdbc.getResultSet(sql, cols);
                while (rs.next()) {
                    list.add(getData(rs));
                }
                rs.getStatement().getConnection().close();
            } catch (SQLException e) {
                System.err.println("Select failed! -> " + e.getMessage());
            }
            return list;
        }
        return null;
    }

    // Lấy mảng dữ liệu object
    public Object[] SelectArray() {
        return SelectALL().toArray();
    }

    // Dữ liệu theo loại bảng từ "ResultSet"
    @SuppressWarnings("unchecked")
    private Element getData(ResultSet rs) {
        Element element = this.getType();
        try {
            if (type != null) {
                Field[] fields = element.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length;) {
                    fields[i].setAccessible(true);
                    fields[i].set(element, rs.getObject(++i));
                    fields[i - 1].setAccessible(false);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException
                | SecurityException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    // Chuyển đổi kiểu dữ liệu => mảng theo bảng
    public Object[] convertArray(Element data) {
        if (data != null) {
            Field[] x = data.getClass().getDeclaredFields();
            Object[] objs = new Object[x.length];
            for (int i = 0; i < x.length; i++) {
                x[i].setAccessible(true);
                try {
                    objs[i] = x[i].get(data);
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                x[i].setAccessible(false);
            }
            return objs;
        }
        return null;
    }

    // Chuyển đổi từ mảng => thực thể element
    public Element convertElement(Object[] objs, ET typeElement) {
        Element data = this.getType();
        if (data != null) {
            Field[] x = data.getClass().getDeclaredFields();
            for (int i = 0; i < x.length; i++) {
                x[i].setAccessible(true);
                try {
                    x[i].set(data, objs[i]);
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                x[i].setAccessible(false);
            }
            return data;
        }
        return null;
    }

    public String getCustomSQL(int index) {
        if (custom.length > 0) {
            return custom[index];
        } else {
            System.out.println("Cannot found sql query at index: " + index);
            return null;
        }
    }
}
