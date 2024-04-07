/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.Service;

import com.raven.dbConnect.DBConnect;
import com.raven.model.HDCTTable;
import com.raven.model.HoaDon;
import com.raven.model.HoaDonTable;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gosgu
 */
public class HoaDonRepository implements InterfaceHoaDonRepo {

    @Override
    public List<HoaDonTable> getAll() {
        List<HoaDonTable> listHoaDon = new ArrayList<>();
        String sql = "SELECT HoaDon.id,\n"
                + " KhachHang.ten_khach,\n"
                + " NhanVien.ten_nv,\n"
                + " HoaDon.ngay_tao,\n"
                + " HoaDon.ghi_chu,\n"
                + " HoaDon.tong_tien,\n"
                + " HoaDon.id_khuyenmai,\n"
                + " HoaDon.id_voucher,\n"
                + " HoaDon.thanh_toan,\n"
                + " HoaDon.trang_thai\n"
                + "FROM     HoaDon INNER JOIN\n"
                + "                  KhachHang ON HoaDon.id_khach = KhachHang.id INNER JOIN\n"
                + "                  NhanVien ON HoaDon.id_tk = NhanVien.id WHERE HoaDon.trang_thai = N'Đã TT'";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTable hd = new HoaDonTable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(9));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    @Override
    public List<HDCTTable> getAllCTHD(int idHD) {
        List<HDCTTable> listHoaDonChiTiet = new ArrayList<>();
        String sql = "SELECT ChiTietHoaDon.id\n"
                + ", ChiTietHoaDon.id_sachct\n"
                + ", Sach.ma_sach\n"
                + ", Sach.ten_sach\n"
                + ", ChiTietHoaDon.so_luong\n"
                + ", ChiTietSach.gia_ban\n"
                //                + ", ChiTietHoaDon.don_gia\n"
                + "FROM     ChiTietHoaDon INNER JOIN\n"
                + "                  HoaDon ON ChiTietHoaDon.id_hoadon = HoaDon.id INNER JOIN\n"
                + "                  ChiTietSach ON ChiTietHoaDon.id_sachct = ChiTietSach.id INNER JOIN\n"
                + "                  Sach ON ChiTietSach.id_sach = Sach.id WHERE HoaDon.id = " + idHD + " AND ChiTietHoaDon.trang_thai = 'Hoat Dong'";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDCTTable hdctTB = new HDCTTable(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
                listHoaDonChiTiet.add(hdctTB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    @Override
    public List<HoaDonTable> getAllHDChuaHT() {
        List<HoaDonTable> listHD = new ArrayList<>();
        String sql = "SELECT HoaDon.id,\n"
                + " KhachHang.ten_khach,\n"
                + " NhanVien.ten_nv,\n"
                + " HoaDon.ngay_tao,\n"
                + " HoaDon.ghi_chu,\n"
                + " HoaDon.tong_tien,\n"
                + " HoaDon.id_khuyenmai,\n"
                + " HoaDon.id_voucher,\n"
                + " HoaDon.thanh_toan,\n"
                + " HoaDon.trang_thai\n"
                + "FROM     HoaDon INNER JOIN\n"
                + "                  KhachHang ON HoaDon.id_khach = KhachHang.id INNER JOIN\n"
                + "                  NhanVien ON HoaDon.id_tk = NhanVien.id WHERE HoaDon.trang_thai = N'Chưa TT'";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTable hd = new HoaDonTable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    @Override
    public int getIDHD(int idHD) {
        int id = 0;
        String sql = "SELECT id FROM HoaDon WHERE id = " + idHD + " ";
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
    public int getID_CTSP(int idHDCT) {
        int id = 0;
        String sql = "SELECT id_sachct FROM ChiTietHoaDon WHERE id = " + idHDCT + " ";
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
    public int getIDNhanVien(String username) {
        int id = 0;
        String sql = "SELECT id FROM NhanVien WHERE username = " + username + " ";
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
    public String getTenNhanVien(int idNV) {
        String ten = "";
        String sql = "SELECT ten_nv FROM NhanVien WHERE id = " + idNV + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ten = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ten;
    }

    @Override
    public void addHoaDon(int idNV, int idKH, BigDecimal tongTien, int idVoucher, int PTTT) {
        String sql = "INSERT INTO HoaDon\n"
                + "(id_tk,\n"
                + "id_khach,\n"
                + "ngay_tao,\n"
                + "ghi_chu,\n"
                + "tong_tien,\n"
                + "id_khuyenmai,\n"
                + "id_voucher,\n"
                + "thanh_toan,\n"
                + "trang_thai)\n"
                + "VALUES\n"
                + "(" + idNV + "\n"
                + "," + idKH + "\n"
                + ",GETDATE()"
                + ",NULL\n"
                + "," + tongTien + "\n"
                + ",NULL\n"
                + "," + idVoucher + "\n"
                + "," + PTTT + "\n"
                + ",N'Chưa TT')";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeHoaDon(int idHD) {
        String sql = "UPDATE HoaDon SET trang_thai = N'Hủy' WHERE id = " + idHD + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSPHDCT(int idHD, int idCTSP, int soLuong) {
        String sql = "INSERT INTO ChiTietHoaDon\n"
                + "(id_hoadon,\n"
                + "id_sachct,\n"
                + "so_luong,\n"
                //                + "don_gia,\n"
                + "trang_thai) \n"
                + "VALUES\n"
                + "(" + idHD + "\n"
                + "," + idCTSP + "\n"
                + "," + soLuong + "\n"
                //                + "," + donGia + "\n"
                + ",'Hoat Dong')";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSLSPHDCT(int idHDCT, int soLuong) {
        String sql = "UPDATE ChiTietHoaDon SET so_luong = so_luong + " + soLuong + " WHERE id = " + idHDCT + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSLHDCT(int idHDCT, int soLuong) {
        String sql = "UPDATE ChiTietHoaDon SET so_luong = " + soLuong + " WHERE id = " + idHDCT + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa1SPHDCT(int idHDCT) {
        String sql = "DELETE ChiTietHoaDon WHERE id = " + idHDCT + "";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void thanhToanHD(int idHD, int idKH, double tongTien, int PTTT) {
        String sql = "UPDATE HoaDon\n"
                + "SET id_khach = " + idKH + " "
                + ", tong_tien = " + tongTien + " "
                + ", thanh_toan = " + PTTT + " "
                + ", trang_thai = N'Đã TT'\n"
                + "WHERE id = " + idHD + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSLSP(int idCTSP, int idHD) {
        int soLuong = 0;
        String sql = "SELECT so_luong FROM ChiTietHoaDon WHERE id_sachct = " + idCTSP + " AND id_hoadon = " + idHD + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    @Override
    public void updateGiaSPHDCT(int soLuong, int idCTSP, int idHD) {
        String sql = "UPDATE ChiTietHoaDon SET so_luong = " + soLuong + " WHERE id_sachct = " + idCTSP + " AND id_hoadon = " + idHD + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getGiaBan(int idCTSP) {
        double gia = 0;
        String sql = "SELECT gia_ban FROM ChiTietSach WHERE id = " + idCTSP + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gia = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
    }

    @Override
    public void updateGiaSPHDCT_btnSua(double giaUpdate, int idHDCT) {
        String sql = "UPDATE ChiTietHoaDon SET don_gia = " + giaUpdate + " WHERE id = " + idHDCT + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaAllSPHDCT(int idHD) {
        String sql = "DELETE FROM ChiTietHoaDon WHERE id_hoadon = " + idHD + " ";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIDKhachHang(String sdt) {
        int id = 0;
        String sql = "SELECT id FROM KhachHang WHERE sdt = '" + sdt + "' ";
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

}
