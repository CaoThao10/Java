/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;;
import javax.swing.JTextField;
import mode.ChiTietHoaDon;


/**
 *
 * @author FPT SHOP
 */
public class ChiTietHoaDonController {
    private JButton btnAdd;
    private JTextField jtfMaChiTiet;
    private JTextField jtfMaHoaDon;
    private JTextField jtfMaSanPham;
    private JTextField jtfSoLuong;
    private JTextField jtfGia;

    public ChiTietHoaDonController(JButton btnAdd, JTextField jtfMaChiTiet, JTextField jtfMaHoaDon, JTextField jtfMaSanPham, JTextField jtfSoLuong, JTextField jtfGia) {
        this.btnAdd = btnAdd;
        this.jtfMaChiTiet = jtfMaChiTiet;
        this.jtfMaHoaDon = jtfMaHoaDon;
        this.jtfMaSanPham = jtfMaSanPham;
        this.jtfSoLuong = jtfSoLuong;
        this.jtfGia = jtfGia;
    }

    public void setView(ChiTietHoaDon chiTietHoaDon){
        jtfMaChiTiet.setText(Integer.toString(chiTietHoaDon.getMa_chi_tiet()));
        jtfMaHoaDon.setText(Integer.toString(chiTietHoaDon.getMa_hoa_don()));
        jtfMaSanPham.setText(Integer.toString(chiTietHoaDon.getMa_sp()));
        jtfSoLuong.setText(Integer.toString(chiTietHoaDon.getSo_luong()));
        jtfGia.setText(Integer.toString(chiTietHoaDon.getGia()));
        
        
    }
    
}
