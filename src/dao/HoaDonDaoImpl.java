/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import mode.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT SHOP
 */
public class HoaDonDaoImpl implements HoaDonDao {

    @Override
    public List<HoaDon> getList() {
        List<HoaDon> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM HoaDon");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMa_hoa_don(rs.getInt("Order_id"));
                hoaDon.setTong_tien(rs.getInt("Total_Price"));
                hoaDon.setMa_khach_hang(rs.getInt("Customer_id"));
                hoaDon.setNgay_tao(rs.getDate("Creat_Date"));
                hoaDon.setTinh_trang(rs.getBoolean("Status"));
                list.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        HoaDonDao hoaDonDao = new HoaDonDaoImpl();
        List<HoaDon> listHoaDon = hoaDonDao.getList();
        for (HoaDon hoaDon : listHoaDon) {
            System.out.println(hoaDon.toString());
        }
    }
    
}
