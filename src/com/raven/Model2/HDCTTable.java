/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.math.BigDecimal;

/**
 *
 * @author gosgu
 */
public class HDCTTable {

    private Integer id;
    private Integer idSachCT;
    private String maSach;
    private String tenSach;
    private int soLuong;
    private double giaBan;

    public HDCTTable() {
    }

    public HDCTTable(Integer id, Integer idSachCT, String maSach, String tenSach, int soLuong, double giaBan) {
        this.id = id;
        this.idSachCT = idSachCT;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
//        this.thanhTien = thanhTien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSachCT() {
        return idSachCT;
    }

    public void setIdSachCT(Integer idSachCT) {
        this.idSachCT = idSachCT;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

}
