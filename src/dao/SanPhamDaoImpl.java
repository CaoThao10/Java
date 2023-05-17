/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import mode.SanPham;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mode.KhachHang;

/**
 *
 * @author FPT SHOP
 */
public class SanPhamDaoImpl implements SanPhamDao {

    @Override
    public List<SanPham> getList() {
        List<SanPham> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM SanPham");
                ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                SanPham sanPham = new SanPham();
                sanPham.setMa_sp(rs.getInt("Item_id"));
//                sanPham.setGia(rs.getFloat("Price"));
                sanPham.setGia(rs.getInt("Price"));
                sanPham.setTen_sp(rs.getString("Name"));
                sanPham.setSo_luong(rs.getInt("Quantity"));
                sanPham.setTinh_trang(rs.getBoolean("Status"));
                list.add(sanPham);
            }
//            ps.close();
//            rs.close();
//            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args){
        SanPhamDao sanPhamDao = new SanPhamDaoImpl();
        List<SanPham> listSanPham = sanPhamDao.getList();
        for (SanPham sanPham : listSanPham) {
        System.out.println(sanPhamDao.toString());
    }
    }
    
}
