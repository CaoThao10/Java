/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ublity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import mode.ChiTietHoaDon;


/**
 *
 * @author FPT SHOP
 */
public class ClassModelChiTietHoaDon {
    public DefaultTableModel setTableChiTietHoaDon(List<ChiTietHoaDon> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(listColumn, 0){
//        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        if (listItem != null) {
            int rows = listItem.size();
            Object[] obj = null;
// sửa
        
//        hết sửa
            for(int i = 0; i < rows; i++){
                ChiTietHoaDon chiTietHoaDon = listItem.get(i);
                obj = new Object[6];
                obj[0] = chiTietHoaDon.getMa_chi_tiet();
                obj[1] = i + 1;
                obj[2] = chiTietHoaDon.getMa_hoa_don();
                obj[3] = chiTietHoaDon.getMa_sp();
                obj[4] = chiTietHoaDon.getSo_luong();
                obj[5] = chiTietHoaDon.getGia();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
