/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import mode.KhachHang;
import mode.SanPham;
import service.SanPhamService;
import service.SanPhamServiceImpl;
//import shop.KhachHangJFrame;
import shop.SanPhamJFrame;
import ublity.ClassModelSanPham;


/**
 *
 * @author FPT SHOP
 */
public class QuanLySanPhamController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private SanPhamService sanPhamService = null;
    
    private String[] listColumn = {"Mã sản phẩm", "STT", "Tên sản phẩm", "Giá", "Số lượng", "Tình trạng"};
    
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLySanPhamController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.sanPhamService = new SanPhamServiceImpl();
    }
    
    public void setDataModel(){
        List<SanPham> listItem = sanPhamService.getList();
        
        DefaultTableModel model = new ClassModelSanPham().setTableSanPham(listItem, listColumn);
        
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            
        });
        table.getTableHeader().setFont(new Font("Arial",Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.setRowHeight(50);
        
        table.validate();
        table.repaint();
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2 &&table.getSelectedRow() !=-1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                    
                    SanPham sanPham = new SanPham();
                    sanPham.setMa_sp((int) model.getValueAt(selectedRowIndex, 0));
                    sanPham.setTen_sp(model.getValueAt(selectedRowIndex, 2).toString());
                    sanPham.setSo_luong((int) model.getValueAt(selectedRowIndex, 3));
//                    sanPham.setSo_luong(((Float) model.getValueAt(selectedRowIndex, 3)).intValue());
//                    sanPham.setSo_luong(((Float) model.getValueAt(selectedRowIndex, 3)).intValue());


//                    sanPham.setGia((Float) model.getValueAt(selectedRowIndex, 4));
//                    sanPham.setGia((float) model.getValueAt(selectedRowIndex, 4));
//                    sanPham.setGia(Float.parseFloat(model.getValueAt(selectedRowIndex, 4).toString()));
                    sanPham.setGia((int) model.getValueAt(selectedRowIndex, 4));


                    sanPham.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 5));
                    
                    SanPhamJFrame frame = new SanPhamJFrame(sanPham);
                    frame.setTitle("Thông tin sản phẩm");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300,400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
        
    }
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                SanPhamJFrame jframe = new SanPhamJFrame (new SanPham());
                jframe.setTitle("Thêm thông tin sản phẩm");
                jframe.setLocationRelativeTo(null);
                jframe.setResizable(false);
                jframe.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                btnAdd.setBackground(new Color(0,200,83));
            }
            @Override
            public void mouseExited(MouseEvent e){
                btnAdd.setBackground(new Color(100,221,23));
            }
        });
    }
}
