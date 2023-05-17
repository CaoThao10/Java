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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import mode.HoaDon;
import service.HoaDonService;
import service.HoaDonServiceImpl;
import shop.HoaDonJFrame;
import ublity.ClassModelHoaDon;

/**
 *
 * @author FPT SHOP
 */
public class QuanLyHoaDonController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private HoaDonService hoaDonService = null;
    
    
   private String[] listColumn = { "Mã hóa đơn ","STT",  "Tổng tiền", "Mã khách hàng", "Ngày tạo", "Tình trạng"};
   
   private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHoaDonController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.hoaDonService = new HoaDonServiceImpl();
    }
    public void setDataToModel(){
        List<HoaDon> listItem = hoaDonService.getList();
        
        DefaultTableModel model = new ClassModelHoaDon().setTableHoaDon(listItem, listColumn);
        
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
                    
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setMa_hoa_don((int) model.getValueAt(selectedRowIndex, 0));
                    hoaDon.setTong_tien((int)model.getValueAt(selectedRowIndex, 2));
                    hoaDon.setMa_khach_hang((int)model.getValueAt(selectedRowIndex, 3));
//                    hoaDon.setNgay_tao((date)model.getValueAt(selectedRowIndex, 4).toString());
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                    Date ngayTao = formatter.parse(model.getValueAt(selectedRowIndex, 4).toString());
//                    hoaDon.setNgay_tao(ngayTao);
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                    java.util.Date ngayTaoUtil = formatter.parse(model.getValueAt(selectedRowIndex, 4).toString());
//                    java.sql.Date ngayTaoSql = new java.sql.Date(ngayTaoUtil.getTime());
//                    hoaDon.setNgay_tao(ngayTaoSql);
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date ngayTao = formatter.parse(model.getValueAt(selectedRowIndex, 4).toString());
                        hoaDon.setNgay_tao(ngayTao);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    hoaDon.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 5));

                    HoaDonJFrame frame = new HoaDonJFrame(hoaDon);
                    frame.setTitle("Thông tin hóa đơn");
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
                HoaDonJFrame jframe = new HoaDonJFrame (new HoaDon());
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