/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package dao;
//
//import java.util.List;
//import mode.KhachHang;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author FPT SHOP
// */
//public class KhachHangDaoImpl implements KhachHangDao{
//
//    @Override
//    public List<KhachHang> getList() {
//        try {
//            Connection cons = DBConnect.getConnection();
//            String sql = "select *from KhachHang";
//            List<KhachHang> list = new ArrayList<>();
//            PreparedStatement ps = cons.prepareCall(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                KhachHang khachHang = new KhachHang();
//                khachHang.setMa_khach_hang(rs.getInt("Customer_id"));
//                khachHang.setTen_khach_hang(rs.getString("Name"));
//                khachHang.setDia_chi(rs.getString("Address"));
//                khachHang.setSo_dien_thoai(rs.getString("Phone"));
//                khachHang.setTinh_trang(rs.getBoolean("Status"));
//                list.add(khachHang);
//            }
//            ps.close();
//            rs.close();
//            cons.close();
//            return list; 
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//    public static void main (String[] args){
//        KhachHangDao khachHangDao = new KhachHangDaoImpl();
//        System.out.println(khachHangDao.getList());
//    }
//}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mode.KhachHang;

public class KhachHangDaoImpl implements KhachHangDao {

    @Override
    public List<KhachHang> getList() {
        List<KhachHang> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM KhachHang");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMa_khach_hang(rs.getInt("Customer_id"));
                khachHang.setTen_khach_hang(rs.getString("Name"));
                khachHang.setDia_chi(rs.getString("Address"));
                khachHang.setSo_dien_thoai(rs.getString("Phone"));
                khachHang.setTinh_trang(rs.getBoolean("Status"));
                list.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        KhachHangDao khachHangDao = new KhachHangDaoImpl();
        List<KhachHang> listKhachHang = khachHangDao.getList();
        for (KhachHang khachHang : listKhachHang) {
            System.out.println(khachHang.toString());
        }
    }

}

