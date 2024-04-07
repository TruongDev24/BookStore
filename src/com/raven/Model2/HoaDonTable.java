/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.Model2;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author gosgu
 */
public class HoaDonTable {

    private Integer idHoaDon;
    private Integer idKhachHang;
    private String tenKhachHang;
    private String tenNhanVien;
    private Date ngayTao;
    private String ghiChu;
    private double tongTien;
    private Integer idKhuyenMai;
    private Integer idVoucher;
    private int ptThanhToan;
    private String trangThai;

    public HoaDonTable() {
    }

    public HoaDonTable(Integer idHoaDon, String tenKhachHang, String tenNhanVien, Date ngayTao, String ghiChu, double tongTien, Integer idKhuyenMai, Integer idVoucher, int ptThanhToan, String trangThai) {
        this.idHoaDon = idHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
        this.tongTien = tongTien;
        this.idKhuyenMai = idKhuyenMai;
        this.idVoucher = idVoucher;
        this.ptThanhToan = ptThanhToan;
        this.trangThai = trangThai;
    }

    public HoaDonTable(Integer idHoaDon, String tenKhachHang, String tenNhanVien, Date ngayTao, double tongTien, int ptThanhToan, String trangThai) {
        this.idHoaDon = idHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.ptThanhToan = ptThanhToan;
        this.trangThai = trangThai;
    }

    public int getPtThanhToan() {
        return ptThanhToan;
    }

    public void setPtThanhToan(int ptThanhToan) {
        this.ptThanhToan = ptThanhToan;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getPTTT() {
        if (ptThanhToan == 0) {
            return "Tiền mặt";
        } else {
            return "Chuyển khoản";
        }
    }
}
