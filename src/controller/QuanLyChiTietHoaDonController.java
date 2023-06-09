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
import mode.ChiTietHoaDon;
import service.ChiTietHoaDonService;
import service.ChiTietHoaDonServiceImpl;
import shop.ChiTietHoaDonJFrame;
import ublity.ClassModelChiTietHoaDon;


/**
 *
 * @author FPT SHOP
 */
public class QuanLyChiTietHoaDonController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private ChiTietHoaDonService chiTietHoaDonService = null;
   private String[] listColumn = {"STT", "Mã chi tiết hóa đơn ",  "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Giá"};
   
   private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyChiTietHoaDonController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.chiTietHoaDonService = new ChiTietHoaDonServiceImpl();
    }
    public void setDataToModel(){
        List<ChiTietHoaDon> listItem = chiTietHoaDonService.getList();
        
        DefaultTableModel model = new ClassModelChiTietHoaDon().setTableChiTietHoaDon(listItem, listColumn);
        
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
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
                if(e.getClickCount() == 2 && table.getSelectedRow()!= -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);   
                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                    chiTietHoaDon.setMa_chi_tiet((int) model.getValueAt(selectedRowIndex, 0));
                    chiTietHoaDon.setMa_hoa_don((int)model.getValueAt(selectedRowIndex, 2));
                    chiTietHoaDon.setMa_sp((int)model.getValueAt(selectedRowIndex, 3));
                    chiTietHoaDon.setSo_luong((int) model.getValueAt(selectedRowIndex, 4));
                    chiTietHoaDon.setGia((int) model.getValueAt(selectedRowIndex, 5));
                    
                    ChiTietHoaDonJFrame frame = new ChiTietHoaDonJFrame(chiTietHoaDon);
                    frame.setTitle("Thông tin chi tiết hóa đơn");
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
                ChiTietHoaDonJFrame jframe = new ChiTietHoaDonJFrame (new ChiTietHoaDon());
                jframe.setTitle("Thêm thông tin hóa đơn");
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
