/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import mode.HoaDon;
import mode.ChiTietHoaDon;

/**
 *
 * @author FPT SHOP
 */
public class ChiTietHoaDonDaoImpl implements ChiTietHoaDonDao{

    @Override
    public List<ChiTietHoaDon> getList() {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM ChiTietHoaDon");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setMa_chi_tiet(rs.getInt("OrderDetail_id"));
                chiTietHoaDon.setMa_hoa_don(rs.getInt("Order_id"));
                chiTietHoaDon.setMa_sp(rs.getInt("Item_id"));
                chiTietHoaDon.setSo_luong(rs.getInt("Quantity"));  
                chiTietHoaDon.setGia(rs.getInt("Price"));
                list.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDaoImpl();
        List<ChiTietHoaDon> listChiTietHoaDon = chiTietHoaDonDao.getList();
        for (ChiTietHoaDon chiTietHoaDon : listChiTietHoaDon) {
            System.out.println(chiTietHoaDon.toString());
        }
    }
    
    }
    

