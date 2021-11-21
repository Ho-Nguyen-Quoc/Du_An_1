/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author abc
 */
public class Data {

    public static final String CODE = "^[A-Za-z0-9]";
    public static final String PASS = "\\w";
    public static final String NAME
            = "/^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơ"
            + "ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘ"
            + "ỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]";
    public static final String EMAIL = "^[A-Za-z0-9+_.]+@(.+)$";
    public static final String PHONE_NUMBER = "[0-9]";

    /**
     * lớp kiểm tra định dạng
     */
    public static class check {

        // Kiểm tra chuỗi kí tự
        public static boolean String(String str, String regex, String size) {
            return str.matches(regex + size);
        }

        // Kiểm tra độ dài
        public static boolean String(String str, int length) {
            return str.length() < length;
        }

        // Kiểm tra độ dài trong khoảng
        public static boolean String(String str, int min, int max) {
            return str.length() >= min && max > str.length();
        }

        // Kiểm tra ngày sinh
        public static boolean Date(Date NgaySinh, int year) {
            if(NgaySinh == null) return false;
            long min = 31557600000L * year; // 31557600000 = 1 năm
            long now = new java.util.Date().getTime();
            long birth = NgaySinh.getTime();
            return now-birth>min;
        }

    }

    /**
     * lớp chuyển đổi
     */
    public static class convert {

        // Chuyển đổi ngày theo định dạng
        public static Date ToDate(String x, String type) {
            try {
                long ls = new SimpleDateFormat(type).parse(x).getTime();
                return new Date(ls);
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
            return null;
        }

        // Chuyển đổi ảnh theo kích cỡ
        public static ImageIcon Image(ImageIcon image, int wight, int heigh) {
            if(image == null) return null;
            Image img = image.getImage().getScaledInstance(wight, heigh, 4);
            return new ImageIcon(img);
        }
    }
}
