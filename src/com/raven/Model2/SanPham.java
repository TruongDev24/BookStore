/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.Model2;

import java.math.BigDecimal;

/**
 *
 * @author gosgu
 */
public class SanPham {
    private String maSach;
    private String tenSach;
    private String nxb;
    private String tacGia;
    private String theLoai;
    private String moTa;
    private int soLuong;
    private double giaBan;

    public SanPham() {
    }

    public SanPham(String maSach, String tenSach, String nxb, String tacGia, String theLoai, String moTa, int soLuong, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nxb = nxb;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
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

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
