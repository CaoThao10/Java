/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import shop.SanPhamJPanel;
import shop.HoaDonJPanel;
import shop.KhachHangJPanel;
import shop.ChiTietHoaDonJPanel;

/**
 *
 * @author FPT SHOP
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "ChiTietHoaDon";
        
//        jpnItem.setBackground(new Color(96,100,191));
//        jlbItem.setBackground(new Color(96,100,191));
        jpnItem.setBackground(new Color(255, 99, 71));
        jlbItem.setBackground(new Color(255, 99, 71));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ChiTietHoaDonJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "ChiTietHoaDon":
                    node = new ChiTietHoaDonJPanel();
                    break;
                case "SanPham":
                    node = new SanPhamJPanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    break;
                case "KhachHang":
                    node = new KhachHangJPanel();
                    break;
                default:
                    node = new ChiTietHoaDonJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(255, 99, 71));
            jlbItem.setBackground(new Color(255, 99, 71));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255, 99, 71));
            jlbItem.setBackground(new Color(255, 99, 71));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(250, 128, 114));
                jlbItem.setBackground(new Color(250, 128, 114));
            }
        }
        private void setChangeBackground(String kind){
            for(DanhMucBean item : listItem){
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setBackground(new Color(255, 99, 71));
                    item.getJpn().setBackground(new Color(255, 99, 71));
                }else{
                    item.getJlb().setBackground(new Color(250, 128, 114));
                    item.getJpn().setBackground(new Color(250, 128, 114));
                }
            }
        }
    }
}

