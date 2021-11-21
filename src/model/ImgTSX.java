/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import javax.swing.JLabel;

/**
 * <h3>Thêm sửa xóa ảnh</h3>
 */
public class ImgTSX {

    public static int wight = 151, height = 288;
    private File file;
    private JLabel img;
    private final String defaultIconPath;
    private final String defaltFolder;

    // ________________________________________________________________PRIVATE
    // set jlabel images
    private void setImg(JLabel img) {
        this.img = img;
        this.img.setText(file.getName());
        this.img.setIcon(Data.convert.Image(
                Util.Image.getIcon(file.getPath()),
                wight, height)
        );
    }

    // Kiểm tra file tồn tại
    private void checkSetFile() {
        if (this.file == null) {
            this.file = Util.Image.getFile(defaultIconPath);
        } else if (!file.canExecute()) {
            this.file = Util.Image.getFile(defaultIconPath);
        }
    }
    // _________________________________________________________________PUBLIC

    // Contructer
    public ImgTSX(JLabel img, String defaultIconPath, String defaltFolder) {
        this.img = img;
        this.defaultIconPath = defaultIconPath;
        this.defaltFolder = defaltFolder;
    }

    // get file
    public File getFile() {
        return file;
    }

    // set file
    public void setFile(File file, JLabel lblImages) {
        this.file = file;
        this.checkSetFile();
        this.setImg(lblImages);
    }

    // @Overload
    public void setFile(String name, JLabel lblImages) {
        this.file = Util.Image.getFile(this.defaltFolder + name);
        this.checkSetFile();
        this.setImg(lblImages);
    }

    // validate -> select file
    public void alertCheck(String mes, JLabel img) {
        int cf = Msg.Confirm(mes, "Chọn hình ảnh", Msg.OptiType.Yes_Cancel);
        if (cf == 0) {
            file = Util.Image.getFile(defaultIconPath);
        } else {
            file = Util.Image.ChooserFile(null);
            this.setImg(img);
            if (file == null) {
                Util.Image.getFile(defaultIconPath);
            }
        }
    }

    // check file -> form custom
    public boolean checkFile() {
        if (this.getFile() == null) {
            return false;
        } else if (!this.getFile().canExecute()
                || this.getFile().getName().endsWith("none.png")) {
            return false;
        }
        return true;
    }
    // ______________________________________________________ADD_UPDATE_DELETE

    // Lưu sửa ảnh
    public void saveUpIcon(String fileName) {
        if (this.checkFile()) {
            Util.Image.SaveIcon(defaltFolder, file, fileName + ".png");
        }
    }

    // Xóa ảnh
    public void deleteIcon() {
        if (this.checkFile()) {
            Util.Image.DeleteIcon(file);
        }
    }
}
