package model;
import java.time.*;
import java.math.BigDecimal;
public class CustomerStat5 extends Customer5 {
 private LocalDate NgayBatDau;
 public LocalDate getNgayBatDau() { return NgayBatDau; }
 public void setNgayBatDau(LocalDate value) { NgayBatDau=value; }
 private LocalDate NgayKetThuc;
 public LocalDate getNgayKetThuc() { return NgayKetThuc; }
 public void setNgayKetThuc(LocalDate value) { NgayKetThuc=value; }
 private int SoLuongGiaoDich;
 public int getSoLuongGiaoDich() { return SoLuongGiaoDich; }
 public void setSoLuongGiaoDich(int value) { SoLuongGiaoDich=value; }
 private BigDecimal TongChiTieu;
 public BigDecimal getTongChiTieu() { return TongChiTieu; }
 public void setTongChiTieu(BigDecimal value) { TongChiTieu=value; }
}
