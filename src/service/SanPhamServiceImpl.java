/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import dao.SanPhamDao;
import dao.SanPhamDaoImpl;
import java.util.List;
import mode.SanPham;

/**
 *
 * @author FPT SHOP
 */
public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamDao sanPhamDao = null;
    
    public SanPhamServiceImpl(){
        sanPhamDao = new SanPhamDaoImpl();
    }
    @Override
    public List<SanPham> getList() {
        return sanPhamDao.getList();
    }
    
}
