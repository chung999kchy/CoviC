/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import dao.BarcodeDAO;
import dao.NguoiCachLyDAO;
import entity.Barcode;
import entity.NguoiCachLy;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import utils.Utils;

/**
 *
 * @author CHUNG
 */
public class QR_CODE {

    public void CREATE_QR(String qrCode, String filePath) {
        try {
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(qrCode.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
            System.out.println("Succeess");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String READ_QR(String filePath) {
        try {
            String charset = "UTF-8";
            Map< EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap< EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(
                            ImageIO.read(new FileInputStream(filePath)))));
            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
            return qrCodeResult.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void addQR_CODE(NguoiCachLy nguoi) {

        int hour = 1;
        BarcodeDAO dao = new BarcodeDAO();
        dao.deleteByNguoi(nguoi);
        Barcode bar = new Barcode();
        bar.setNgCachLy(nguoi);
        String timeBegin = Utils.getToday();
        Date time_begin = null;
        try {
            time_begin = Utils.DATE_FORMATER.parse(timeBegin);
        } catch (ParseException ex) {
            time_begin = new Date();
        }
        bar.setTimeBegin(new java.sql.Timestamp(time_begin.getTime()));
        Date time_end = new Date(time_begin.getTime() + TimeUnit.HOURS.toMillis(hour));
        bar.setTimeEnd(new java.sql.Timestamp(time_end.getTime()));
        String ma = Utils.md5(Utils.getToday() + nguoi.getIdNguoiCachLy());
        bar.setMa(ma);
        dao.create(bar);

        // tao ma qr-code hien thi html
        String link = "localhost:8085/datn/history?ma=" + ma;
        String file = "C:\\Users\\CHUNG\\Documents\\NetBeansProjects\\datn\\web\\assets\\img\\code.png";
        CREATE_QR(link, file);
        System.out.println("da tao ma tai link: " + link);
    }
}
