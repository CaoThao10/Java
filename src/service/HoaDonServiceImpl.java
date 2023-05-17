/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.HoaDonDao;
import dao.HoaDonDaoImpl;
import java.util.List;
import mode.HoaDon;


/**
 *
 * @author FPT SHOP
 */
public class HoaDonServiceImpl implements HoaDonService {
    private HoaDonDao hoaDonDao = null;
    
    public HoaDonServiceImpl(){
        hoaDonDao = new HoaDonDaoImpl();
    }
    @Override
    public List<HoaDon> getList() {
        return hoaDonDao.getList();
    }
}
