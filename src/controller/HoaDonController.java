/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import mode.HoaDon;

/**
 *
 * @author FPT SHOP
 */
public class HoaDonController {
      private JButton btnAdd;
    private JTextField jtfMaHoaDon;
    private JTextField jtfMaKhachHang;
    private JTextField jtfTongTien;
    private JTextField jtfNgayTao;
    private JCheckBox jcbTinhTrang;

    public HoaDonController(JButton btnAdd, JTextField jtfMaHoaDon, JTextField jtfMaKhachHang, JTextField jtfTongTien, JTextField jtfNgayTao, JCheckBox jcbTinhTrang) {
        this.btnAdd = btnAdd;
        this.jtfMaHoaDon = jtfMaHoaDon;
        this.jtfMaKhachHang = jtfMaKhachHang;
        this.jtfTongTien = jtfTongTien;
        this.jtfNgayTao = jtfNgayTao;
        this.jcbTinhTrang = jcbTinhTrang;
    }

    public void setView(HoaDon hoaDon){
//        jtfMaHoaDon.setText("#" + hoaDon.getMa_hoa_don());
        jtfMaHoaDon.setText(Integer.toString(hoaDon.getMa_hoa_don()));
        jtfMaKhachHang.setText(Integer.toString(hoaDon.getMa_khach_hang()));
        jtfTongTien.setText(Integer.toString(hoaDon.getTong_tien()));
//        jtfNgayTao.setText(Date.toString(hoaDon.getNgay_tao()));
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String ngayTao = formatter.format(hoaDon.getNgay_tao());
//        jtfNgayTao.setText(ngayTao);
        if(hoaDon.getNgay_tao() != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(hoaDon.getNgay_tao());
            jtfNgayTao.setText(dateString);
        }else{
            jtfNgayTao.setText("");
        }
        
        jcbTinhTrang.setText(Boolean.toString(hoaDon.isTinh_trang()));
    }
    
}
