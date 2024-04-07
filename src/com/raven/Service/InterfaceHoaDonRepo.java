/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.Service;

import com.raven.model.HDCTTable;
import com.raven.model.HoaDon;
//import com.raven.model.HoaDonTable;
import com.raven.Model2.HoaDonTable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gosgu
 */
public interface InterfaceHoaDonRepo {

    List<HoaDonTable> getAll();

    List<HDCTTable> getAllCTHD(int idHD);

    List<HoaDonTable> getAllHDChuaHT();
    
    List<HoaDonTable> getAllFromHD();

    int getIDHD(int idHD);

    int getID_CTSP(int idHDCT);

    int getIDNhanVien(String username);
    
    public String getTenNhanVien(int idNV);
    
    int getIDKhachHang(String sdt);

    void addHoaDon(int idNV, int idKH, BigDecimal tongTien, int idVoucher,int PTTT);

    void removeHoaDon(int idHD);

    void addSPHDCT(int idHD, int idCTSP, int soLuong);

    void updateSLSPHDCT(int idHDCT, int soLuong);

    void setSLHDCT(int idHDCT, int soLuong);

    void xoa1SPHDCT(int idHDCT);
    
    void xoaAllSPHDCT(int idHD);

    void thanhToanHD(int idHD, int idKH, double tongTien, int PTTT);

    int getSLSP(int idCTSP, int idHD);

    void updateGiaSPHDCT(int soLuong, int idCTSP, int idHD);

    void updateGiaSPHDCT_btnSua(double giaUpdate, int idHDCT);
    
    double getGiaBan(int idCTSP);
}
