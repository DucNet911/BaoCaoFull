package model;
import java.time.*;
import java.math.BigDecimal;
public class MovieStat5 extends Movie5 {
 private LocalDate NgayBatDau;
 public LocalDate getNgayBatDau() { return NgayBatDau; }
 public void setNgayBatDau(LocalDate value) { NgayBatDau=value; }
 private LocalDate NgayKetThuc;
 public LocalDate getNgayKetThuc() { return NgayKetThuc; }
 public void setNgayKetThuc(LocalDate value) { NgayKetThuc=value; }
 private int SoVeBan;
 public int getSoVeBan() { return SoVeBan; }
 public void setSoVeBan(int value) { SoVeBan=value; }
 private BigDecimal TongDoanhThu;
 public BigDecimal getTongDoanhThu() { return TongDoanhThu; }
 public void setTongDoanhThu(BigDecimal value) { TongDoanhThu=value; }
}
