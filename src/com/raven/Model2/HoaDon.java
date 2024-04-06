/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author gosgu
 */
public class HoaDon {
    
    private Integer id;
    private Integer idTaiKhoan;
    private Integer idKhach;
    private Date ngayTao;
//    private Integer idKhuyenMai;
    private Integer idVoucher;
    private BigDecimal tongTien;
    private String ghiChu;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(Integer id, Integer idTaiKhoan, Integer idKhach, Date ngayTao, Integer idVoucher, BigDecimal tongTien, String ghiChu, String trangThai) {
        this.id = id;
        this.idTaiKhoan = idTaiKhoan;
        this.idKhach = idKhach;
        this.ngayTao = ngayTao;
//        this.idKhuyenMai = idKhuyenMai;
        this.idVoucher = idVoucher;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public Integer getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(Integer idKhach) {
        this.idKhach = idKhach;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

//    public Integer getIdKhuyenMai() {
//        return idKhuyenMai;
//    }
//
//    public void setIdKhuyenMai(Integer idKhuyenMai) {
//        this.idKhuyenMai = idKhuyenMai;
//    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
