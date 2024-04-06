/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author gosgu
 */
public class HoaDonCT {
    
    private Integer id;
    private Integer idHoaDon;
    private Integer idSachCT;
    private int soLuong;

    public HoaDonCT() {
    }

    public HoaDonCT(Integer id, Integer idHoaDon, Integer idSachCT, int soLuong) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idSachCT = idSachCT;
        this.soLuong = soLuong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdSachCT() {
        return idSachCT;
    }

    public void setIdSachCT(Integer idSachCT) {
        this.idSachCT = idSachCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
    
}
