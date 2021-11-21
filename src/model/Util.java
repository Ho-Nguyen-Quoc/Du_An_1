/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author abc
 */
public class Util {

    @SuppressWarnings("unchecked")
    public static String createFile(String title, Object[] arrs) {
        StringBuilder data = new StringBuilder("File save at: ");
        if (arrs.length > 0) {
            data.append(new java.util.Date());
            data.append("\n=======================================================");
            data.append("\nTitle: ").append(title);
            data.append("\nColumn count: ").append(((Vector) arrs[0]).size());
            data.append("\nRows count: ").append(arrs.length);
            data.append("\n=======================================================");

            for (Object arr : arrs) {
                Vector x = (Vector) arr;
                data.append("\n");
                x.forEach((object) -> {
                    data.append(object).append("\t");
                });
            }
        } else {
            data.append(new java.util.Date()).append("\t-\tno data!");
        }
        return data.toString();
    }

    public static void SaveFileChooser(String data) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("TXT", "txt"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            boolean check = file.getName().endsWith(".txt");
            WriteByte(check ? file.getAbsolutePath()
                    : file.getAbsolutePath() + ".txt", data.getBytes());
        }
    }

    // Ghi file trong đường dẫn bằng byte
    public static void WriteByte(String path, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
        } catch (HeadlessException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // Chạy đồng hồ
    public static Timer setTimer(JButton lblThoiGian, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        Timer timer = new Timer(1000, (e) -> {
            lblThoiGian.setText(format.format(e.getWhen()));
        });
        return timer;
    }

    /**
     * <h3>Lớp hỗ trợ đọc ảnh</h3>
     * Hỗ trợ đọc file ảnh, ghi file ảnh, chọn ảnh hoặc file theo đường dẫn
     */
    public static class Image {

        // Lấy ảnh có sẵn đường dẫn
        public static ImageIcon getIcon(String path) {
            if (path.isEmpty()) {
                return null;
            }
            ImageIcon icon = new ImageIcon(path);
            return icon.getImage() == null ? null : icon;
        }

        // Lấy đường dẫn tới file
        public static File ChooserFile(Component Parent) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("PNG, JPG", "png", "jpg"));
                if (chooser.showOpenDialog(Parent) == JFileChooser.APPROVE_OPTION) {
                    return chooser.getSelectedFile();
                }
            } catch (HeadlessException e) {
                System.err.println("Hủy chọn!");
            }
            return null;
        }

        // Lấy file từ đường dẫn
        public static File getFile(String path) {
            if (path == null) {
                return null;
            }
            return new File(path);
        }

        // Lưu ảnh vào project
        public static boolean SaveIcon(String LinkParent, File src, String newName) {
            if (src == null) {
                return false;
            }
            if (src.getName().endsWith("none.png")) {
                return false;
            }
            File dst = new File(LinkParent, newName);
            if (!dst.getParentFile().exists()) {
                dst.getParentFile().mkdirs();
            }
            try {
                Files.copy(
                        Paths.get(src.getAbsolutePath()),
                        Paths.get(dst.getAbsolutePath()),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        // phương thức xóa file trược tiếp theo đường dẫn
        public static void DeleteIcon(File src) {
            try {
                Files.deleteIfExists(src.getAbsoluteFile().toPath());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
