/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.raven.Model2.nguoiDung;
import java.sql.*;
import com.raven.dbConnect.DBConnect;
/**
 *
 * @author LENOVO
 */
public class NguoiDung_Service {
    Connection con = DBConnect.getConnection();

    public List<nguoiDung> getAll_KH() {
        String sql = "select*from NhanVien";
        try (PreparedStatement prs = con.prepareStatement(sql)) {
            ResultSet rs = prs.executeQuery();
            List<nguoiDung> ppp = new ArrayList<>();
            while (rs.next()) {
                nguoiDung kh = new nguoiDung(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getString(8), 
                        rs.getInt(9), 
                        rs.getString(10), 
                        rs.getString(11), 
                        rs.getInt(12), 
                        rs.getString(13));
                ppp.add(kh);
            }
            return ppp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean add(nguoiDung nv) {
        String sql = "insert into NhanVien(username,password,ten_nv,hinh_anh,email,cccd,ngay_dangki,gioi_tinh,sdt,ngay_sinh,id_vaitro,trang_thai)Values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getUsername());
            ps.setObject(2, nv.getPassword());
            ps.setObject(3, nv.getTen_nv());
            ps.setObject(4, nv.getHinh_anh());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getCccd());
            ps.setObject(7, nv.getNgay_dangki());
            ps.setObject(8, nv.getGioi_tinh());
            ps.setObject(9, nv.getSdt());
            ps.setObject(10, nv.getNgay_sinh());
            ps.setObject(11, nv.getId_vaitro());
            ps.setObject(12, nv.getTrang_thai());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(String cccd) {
        int check = 0;
        String sql = "delete from NhanVien where cccd=?";
        try (PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, cccd);
            check = prs.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean updateNhanVien(nguoiDung nd) {
        String sql = "UPDATE NhanVien SET username=?, password=?, ten_nv=?, gioi_tinh=?, id_vaitro=?, trang_thai=? WHERE cccd=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nd.getUsername());
            ps.setString(2, nd.getPassword());
            ps.setString(3, nd.getTen_nv());
            ps.setInt(4, nd.getGioi_tinh());
            ps.setInt(5, nd.getId_vaitro());
            ps.setString(6, nd.getTrang_thai());
            ps.setString(7, nd.getCccd());
            int updatedRows = ps.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
