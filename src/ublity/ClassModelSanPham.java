///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */

package ublity;
//
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mode.SanPham;

public class ClassModelSanPham {
    public DefaultTableModel setTableSanPham(List<SanPham> listItem, String[] listColumn){
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
                SanPham sanPham = listItem.get(i);
                obj = new Object[6];
                obj[0] = sanPham.getMa_sp();
                obj[1] = i + 1;
                obj[2] = sanPham.getTen_sp();
                obj[3] = sanPham.getGia();
                obj[4] = sanPham.getSo_luong();
                obj[5] = sanPham.isTinh_trang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
