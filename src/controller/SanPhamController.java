/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import mode.SanPham;

/**
 *
 * @author FPT SHOP
 */
public class SanPhamController {
    private JButton btnAdd;
    private JTextField jtfMaSanPham;
    private JTextField jtfTenSanPham;
    private JTextField jtfSoLuong;
    private JTextField jtfGia;
    private JCheckBox jcbTinhTrang;

    public SanPhamController(JButton btnAdd, JTextField jtfMaSanPham, JTextField jtfTenSanPham, JTextField jtfSoLuong, JTextField jtfGia, JCheckBox jcbTinhTrang) {
        this.btnAdd = btnAdd;
        this.jtfMaSanPham = jtfMaSanPham;
        this.jtfTenSanPham = jtfTenSanPham;
        this.jtfSoLuong = jtfSoLuong;
        this.jtfGia = jtfGia;
        this.jcbTinhTrang = jcbTinhTrang;
    }

    public void setView(SanPham sanPham){
        jtfMaSanPham.setText("#" + sanPham.getMa_sp());
//        jtfMaSanPham.setText("#" + Integer.parseInt(sanPham.getMa_sp()));
        jtfMaSanPham.setText(Integer.toString(sanPham.getMa_sp()));

//        jtfMaSanPham.setText(Integer.toString(sanPham.getMa_sp()));
        jtfTenSanPham.setText(sanPham.getTen_sp());
        jtfSoLuong.setText(Integer.toString(sanPham.getSo_luong()));
        jtfGia.setText(Integer.toString(sanPham.getGia()));
//        jtfSoLuong.setText(String.valueOf(sanPham.getSo_luong()));
//        jtfGia.setText(String.valueOf(sanPham.getGia()));

        jcbTinhTrang.setText(Boolean.toString(sanPham.isTinh_trang()));
    }
    
}
