/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AbstractDAO;
import entities.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Msg;

public interface InterfaceForm<Element> {

    public enum alertType {
        insert1, insert2, insert3, update1, update2,
        update3, delete1, delete2, delete3, custom
    }

    /**
     * Thêm mới nhân viên
     */
    public void Insert();

    /**
     * Sửa thông tin nhân viên
     */
    public void update();

    /**
     * Xóa thông tin nhân viên cần tìm
     */
    public void delete();

    /**
     * @param key mã nhân viên cần được tìm
     * @return vị trí tìm được của danh sách
     */
    public int findList(Object key);

    /**
     * @return trả về đối tượng lấy thông tin từ form
     */
    public Element getForm();

    /**
     * @param data
     */
    public void setForm(Element data);

    /**
     * Xóa thông tin trên form hiển thị
     */
    public void clearForm();

    /**
     * Đổ dữ liệu bảng
     *
     * @param list danh sách dữ liệu
     * @param table bảng cần đổ
     * @param dao
     */
    default void fillTable(List<Element> list, JTable table,
            AbstractDAO<Element, Object> dao) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (list != null) {
            list.forEach((x) -> {
                Object[] rows = dao.convertArray(x);
                model.addRow(rows);
            });
        } else {
            System.err.println("check again constructor elementDAO()!");
        }
    }

    /**
     * #alertType: insert: thêm <br>
     * update: sửa <br>
     * delete: xóa<br>
     * custom: tự chọn (khác)<br>
     * #Phân loại:
     * <ul>
     * <li>Loại 1: báo thành công</li>
     * <li>Loại 2: báo tồn thiếu điều kiện</li>
     * <li>Loại 3: báo lỗi thao tác dữ liệu</li>
     * </ul>
     *
     * @param content // Nội dung thông báo
     * @param mes // Kiểu thông báo
     */
    default void alertGroup(String content, alertType mes) {
        switch (mes) {
            case insert1:
                Msg.Alert("Thêm " + content + " thành công",
                        "Thêm " + content, Msg.MesType.ThongTin);
                break;
            case insert2:
                Msg.Alert(content + " đã tồn tại",
                        "Thêm " + content, Msg.MesType.CanhBao);
                break;
            case insert3:
                Msg.Alert("Thêm " + content + " thất bại!",
                        "Thêm " + content, Msg.MesType.BaoLoi);
                break;
            case update1:
                Msg.Alert("Sửa " + content + " thành công",
                        "Sửa " + content, Msg.MesType.ThongTin);
                break;
            case update2:
                Msg.Alert(content + " không tồn tại",
                        "Sửa " + content, Msg.MesType.CanhBao);
                break;
            case update3:
                Msg.Alert("Sửa " + content + " thất bại!",
                        "Sửa " + content, Msg.MesType.BaoLoi);
                break;
            case delete1:
                Msg.Alert("Xóa " + content + " thành công",
                        "Xóa " + content, Msg.MesType.ThongTin);
                break;
            case delete2:
                Msg.Alert(content + " không tồn tại",
                        "Xóa " + content, Msg.MesType.CanhBao);
                break;
            case delete3:
                Msg.Alert("Xóa " + content + " thất bại!",
                        "Xóa " + content, Msg.MesType.BaoLoi);
                break;
            default:
                System.out.println("Khong ton tai thong bao!");
        }
    }

    /**
     * * <h3>Kiểm tra dữ liệu:</h3>
     * Phương thức sử dụng: Data.check.methods(...)<br>
     * Data.[HẰNG]: các loại định dạng<br>
     * size: độ dài cho phép của kí tự<br>
     * <Strong>Ví dụ: "{5,10}"</Strong> độ dài cho phép từ 5 - 10 kí tự
     * |******************************************************************|
     *
     * @param data dữ liệu thực thể "element" cần kiểm tra
     * @return trả về vị trí lỗi
     */
    public boolean validateData(Element data);

    /**
     * @param tblData dữ liệu bảng
     * @param nameColumn tên cột cần tìm
     * @return vị trí tìm thấy cột
     */
    default int findColumnName(JTable tblData, String nameColumn) {
        for (int i = 0; i < tblData.getColumnCount(); i++) {
            if (tblData.getColumnName(i).equalsIgnoreCase(nameColumn)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param table tên bảng dữ liệu (database)
     * @param findText tìm khớp theo kí tự
     * @return trả câu truy vấn mới được tạo
     */
    @Deprecated
    default String createSqlFindLike(JTable table, String findText) {
        if (sp.checkName(table) != null) {
            Object[] cols = sp.SelectedColsName(table);
            StringBuilder str = new StringBuilder("Select * from ");
            str.append(table.getName());
            if (cols != null) {
                str.append(" where ");
                for (Object col : cols) {
                    str.append(col).append(" like N'%").append(findText);
                    str.append("%'").append(" or ");
                }
                String sql = str.toString();
                return sql.substring(0, sql.lastIndexOf("or"));
            }
            return str.toString();
        } else {
            System.out.println("Name table does not exist!");
        }
        return null;
    }

    class sp {

        // Kiểm tra tên
        static String checkName(JTable table) {
            return table.getName() != null ? table.getName() : null;
        }

        // Kiểm tra cột được chọn
        static Object[] SelectedColsName(JTable table) {
            int[] slds = table.getSelectedColumns();
            if (slds.length > 0) {
                @SuppressWarnings("unchecked")
                ArrayList<String> cols = new ArrayList<>();
                for (int sld : slds) {
                    String name = table.getColumnName(sld);
                    cols.add(convertColName(name));
                }
                return cols.toArray();
            }
            return null;
        }

        private static String convertColName(String name) {
            switch (name) {
                case "NvID":
                    return "NvID";
                case "MẬT KHẨU":
                    return "HoTen";
                case "HỌ VÀ TÊN":
                    return "HoTen";
                case "NGÀY SINH":
                    return "NgaySinh";
                case "ĐỊA CHỈ":
                    return "DiaChi";
                case "SỐ ĐIỆN THOẠI":
                    return "SoDT";
                case "ĐỊA CHỈ EMAIL":
                    return "Email";
                case "CHỨC VỤ":
                    return "ChucVu";
                case "LoaiID":
                    return "LoaiID";
                case "SachID":
                    return "SachID";
                default:
                    return null;
            }
        }
    }
}
