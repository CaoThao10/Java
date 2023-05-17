/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ublity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import mode.HoaDon;

/**
 *
 * @author FPT SHOP
 */
public class ClassModelHoaDon {
    public DefaultTableModel setTableHoaDon(List<HoaDon> listItem, String[] listColumn){
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
                HoaDon hoaDon = listItem.get(i);
                obj = new Object[6];
                obj[0] = hoaDon.getMa_hoa_don();
                obj[1] = i + 1;
                obj[2] = hoaDon.getTong_tien();
                obj[3] = hoaDon.getMa_khach_hang();
                obj[4] = hoaDon.getNgay_tao();
                obj[5] = hoaDon.isTinh_trang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
