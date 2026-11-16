package model;
import java.time.*;
import java.math.BigDecimal;
public class Payment5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private BigDecimal SoTien;
 public BigDecimal getSoTien() { return SoTien; }
 public void setSoTien(BigDecimal value) { SoTien=value; }
 private String PhuongThuc;
 public String getPhuongThuc() { return PhuongThuc; }
 public void setPhuongThuc(String value) { PhuongThuc=value; }
 private LocalDateTime ThoiDiem;
 public LocalDateTime getThoiDiem() { return ThoiDiem; }
 public void setThoiDiem(LocalDateTime value) { ThoiDiem=value; }
 private String TrangThai;
 public String getTrangThai() { return TrangThai; }
 public void setTrangThai(String value) { TrangThai=value; }
}
