/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import mode.KhachHang;

/**
 *
 * @author FPT SHOP
 */
public class KhachHangController {
    private JButton btnAdd;
    private JTextField jtfMaKhachHang;
    private JTextField jtfTenKhachHang;
    private JTextField jtfDiaChi;
    private JTextField jtfSoDienThoai;
    private JCheckBox jcbTinhTrang;

    public KhachHangController(JButton btnAdd, JTextField jtfMaKhachHang, JTextField jtfTenKhachHang, JTextField jtfDiaChi, JTextField jtfSoDienThoai, JCheckBox jcbTinhTrang) {
        this.btnAdd = btnAdd;
        this.jtfMaKhachHang = jtfMaKhachHang;
        this.jtfTenKhachHang = jtfTenKhachHang;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jcbTinhTrang = jcbTinhTrang;
    }

    public KhachHangController(JButton jButton1, JTextField jtfMaKhachHang, JTextField jtfDiaChi, JTextField jtfSoDienThoai, JCheckBox jcbTinhTrang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setView(KhachHang khachHang){
        jtfMaKhachHang.setText("#" + khachHang.getMa_khach_hang());
        jtfTenKhachHang.setText(khachHang.getTen_khach_hang());
        jtfDiaChi.setText(khachHang.getDia_chi());
        jtfSoDienThoai.setText(khachHang.getSo_dien_thoai());
        jcbTinhTrang.setSelected(khachHang.isTinh_trang());
    }
}
