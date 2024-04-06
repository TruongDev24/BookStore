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
public class HoaDonForm {
    private Integer id;
    private Integer id_nv;
    private Integer id_khach;
    private Date ngay_tao;
    private String ghi_chu;
    private BigDecimal tong_tien;
//    private Integer id_khuyenmai;
    private Integer id_voucher;
    private String trang_thai;

    public HoaDonForm() {
    }

    public HoaDonForm(Integer id, Integer id_nv, Integer id_khach, Date ngay_tao, String ghi_chu, BigDecimal tong_tien, Integer id_voucher, String trang_thai) {
        this.id = id;
        this.id_nv = id_nv;
        this.id_khach = id_khach;
        this.ngay_tao = ngay_tao;
        this.ghi_chu = ghi_chu;
        this.tong_tien = tong_tien;
//        this.id_khuyenmai = id_khuyenmai;
        this.id_voucher = id_voucher;
        this.trang_thai = trang_thai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_nv() {
        return id_nv;
    }

    public void setId_nv(Integer id_nv) {
        this.id_nv = id_nv;
    }

    public Integer getId_khach() {
        return id_khach;
    }

    public void setId_khach(Integer id_khach) {
        this.id_khach = id_khach;
    }

    public Date getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(Date ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public BigDecimal getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(BigDecimal tong_tien) {
        this.tong_tien = tong_tien;
    }

//    public Integer getId_khuyenmai() {
//        return id_khuyenmai;
//    }
//
//    public void setId_khuyenmai(Integer id_khuyenmai) {
//        this.id_khuyenmai = id_khuyenmai;
//    }

    public Integer getId_voucher() {
        return id_voucher;
    }

    public void setId_voucher(Integer id_voucher) {
        this.id_voucher = id_voucher;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    
}
