/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mode;

/**
 *
 * @author FPT SHOP
 */
public class KhachHang {
    private int ma_khach_hang;
    private String ten_khach_hang;
    private String dia_chi;
    private String so_dien_thoai;
    private boolean tinh_trang;

    public int getMa_khach_hang() {
        return ma_khach_hang;
    }

    public void setMa_khach_hang(int ma_khach_hang) {
        this.ma_khach_hang = ma_khach_hang;
    }

    public String getTen_khach_hang() {
        return ten_khach_hang;
    }

    public void setTen_khach_hang(String ten_khach_hang) {
        this.ten_khach_hang = ten_khach_hang;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }
    @Override
    public String toString() {
    return "KhachHang{" +
            "ma_khach_hang=" + ma_khach_hang +
            ", ten_khach_hang='" + ten_khach_hang + '\'' +
            ", dia_chi='" + dia_chi + '\'' +
            ", so_dien_thoai='" + so_dien_thoai + '\'' +
            ", tinh_trang=" + tinh_trang +
            '}';
}

    
}
