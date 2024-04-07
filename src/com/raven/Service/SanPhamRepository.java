/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.Service;

import com.raven.Service.InterfaceSanPhamRepo;
import com.raven.dbConnect.DBConnect;
import com.raven.Model2.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author gosgu
 */
public class SanPhamRepository implements InterfaceSanPhamRepo {

    @Override
    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT Sach.ma_sach,"
                + " Sach.ten_sach,"
                + " NhaXuatBan.ten_nxb,"
                + " TacGia.ten_tacgia,"
                + " TheLoai.ten_theloai,"
                + " ChiTietSach.mota,"
                + " ChiTietSach.so_luong,"
                + " ChiTietSach.gia_ban\n"
                + "FROM     ChiTietSach INNER JOIN\n"
                + "                  NhaXuatBan ON ChiTietSach.id_nxb = NhaXuatBan.id INNER JOIN\n"
                + "                  Sach ON ChiTietSach.id_sach = Sach.id INNER JOIN\n"
                + "                  TacGia ON ChiTietSach.id_tacgia = TacGia.id INNER JOIN\n"
                + "                  TheLoai ON ChiTietSach.id_theloai = TheLoai.id";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPham> timKiemSP(String tk) {
        String sql = "SELECT Sach.ma_sach,\n"
                + " Sach.ten_sach,\n"
                + " NhaXuatBan.ten_nxb,\n"
                + " TacGia.ten_tacgia,\n"
                + " TheLoai.ten_theloai,\n"
                + " ChiTietSach.mota,\n"
                + " ChiTietSach.so_luong,\n"
                + " ChiTietSach.gia_ban\n"
                + "FROM     ChiTietSach INNER JOIN\n"
                + "                  NhaXuatBan ON ChiTietSach.id_nxb = NhaXuatBan.id INNER JOIN\n"
                + "                  Sach ON ChiTietSach.id_sach = Sach.id INNER JOIN\n"
                + "                  TacGia ON ChiTietSach.id_tacgia = TacGia.id INNER JOIN\n"
                + "                  TheLoai ON ChiTietSach.id_theloai = TheLoai.id WHERE Sach.ma_sach like '%" + tk + "%' or Sach.ten_sach like N'%" + tk + "%' ";
        List<SanPham> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getIDCTSP(String maSP) {
        int id = 0;
        String sql = "SELECT ChiTietSach.id\n"
                + "FROM ChiTietSach INNER JOIN Sach ON ChiTietSach.id_sach = Sach.id WHERE ma_sach = '" + maSP + "'";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void reduceSLSP(int idCTSP, int soLuong) {
        String sql = "UPDATE ChiTietSach set so_luong  = so_luong - " + soLuong + " WHERE id = " + idCTSP + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSLSP(int idCTSP, int soLuong) {
        String sql = "UPDATE ChiTietSach SET so_luong  = so_luong + " + soLuong + " WHERE id = " + idCTSP + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int sumSLSP(int idCTSP, int idHDCT) {
        int tongSL = 0;
        String sql = "SELECT ChiTietSach.so_luong + ChiTietHoaDon.so_luong\n"
                + "FROM     ChiTietSach INNER JOIN ChiTietHoaDon ON ChiTietSach.id = ChiTietHoaDon.id_sachct WHERE ChiTietSach.id = " + idCTSP + " AND ChiTietHoaDon.id = " + idHDCT + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tongSL = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongSL;
    }

    @Override
    public void updateSLSP(int idCTSP, int soLuong) {
        String sql = "UPDATE ChiTietSach SET so_luong = " + soLuong + " where id = " + idCTSP + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
