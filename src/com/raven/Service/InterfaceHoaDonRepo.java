/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.Service;

import com.raven.model.HDCTTable;
import com.raven.model.HoaDon;
import com.raven.model.HoaDonTable;
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

    // get id hóa đơn thông qua mã hóa đơn 
    int getIDHD(int idHD);

    // Lấy ID hóa đơn chi tiết thông qua mã hóa đơn chi tiết 
    int getID_CTSP(int idHDCT);

    // lấy ra ID nhân viên  thông qua email 
    int getIDNhanVien(String username);

    // Tạo hóa đơn chờ 
    void addHoaDon(int idNhanVien, int idKH, BigDecimal tongTien, int idVoucher,int PTTT);

    // Hủy hóa đơn 
    void removeHoaDon(int idHD);

    // Tạo ra hóa đơn chi tiết
    void addSPHDCT(int idHD, int idCTSP, int soLuong, double donGia);

    // sửa số lượng sản phẩm hóa đơn chi tiết ( tăng )
    void updateSLSPHDCT(int idHDCT, int soLuong);

    // set số lượng trong hóa đơn chờ 
    void setSLHDCT(int idHDCT, int soLuong);

    // Xóa sản phẩm trong hóa đơn chờ 
    void xoa1SPHDCT(int idHDCT);

    // Thanh toán hóa đơn 
    void thanhToanHD(int idHD, int idKH, double tongTien, int PTTT);

    // Lấy ra số lượng trong hóa dơn chi tiết 
    int getSLSP(int idCTSP, int idHD);

    // update lại giá tiền trong bảng hóa đơn chi tiết 
    void updateGiaSPHDCT(double giaUpdate, int idCTSP, int idHD);

    void updateGiaSPHDCT_btnSua(double giaUpdate, int idHDCT);
    
    double getGiaBan(int idCTSP);
}
