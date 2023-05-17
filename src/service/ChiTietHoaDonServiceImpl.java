/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import dao.ChiTietHoaDonDao;
import dao.ChiTietHoaDonDaoImpl;
import java.util.List;
import mode.ChiTietHoaDon;


/**
 *
 * @author FPT SHOP
 */
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {
    private ChiTietHoaDonDao chiTietHoaDonDao = null;
    
    public ChiTietHoaDonServiceImpl(){
        chiTietHoaDonDao = new ChiTietHoaDonDaoImpl();
    }
    @Override
    public List<ChiTietHoaDon> getList() {
        return chiTietHoaDonDao.getList();
    }
}
