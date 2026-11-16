package model;
import java.time.*;
import java.math.BigDecimal;
public class Order5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private String MaGiaoDich;
 public String getMaGiaoDich() { return MaGiaoDich; }
 public void setMaGiaoDich(String value) { MaGiaoDich=value; }
 private String HinhThucMua;
 public String getHinhThucMua() { return HinhThucMua; }
 public void setHinhThucMua(String value) { HinhThucMua=value; }
 private LocalDateTime ThoiGianTao;
 public LocalDateTime getThoiGianTao() { return ThoiGianTao; }
 public void setThoiGianTao(LocalDateTime value) { ThoiGianTao=value; }
 private String TrangThai;
 public String getTrangThai() { return TrangThai; }
 public void setTrangThai(String value) { TrangThai=value; }
 private String MaHoaDon;
 public String getMaHoaDon() { return MaHoaDon; }
 public void setMaHoaDon(String value) { MaHoaDon=value; }
 private LocalDateTime NgayLap;
 public LocalDateTime getNgayLap() { return NgayLap; }
 public void setNgayLap(LocalDateTime value) { NgayLap=value; }
 private BigDecimal TongTien;
 public BigDecimal getTongTien() { return TongTien; }
 public void setTongTien(BigDecimal value) { TongTien=value; }
 private Customer5 ThanhVien;
 public Customer5 getThanhVien() { return ThanhVien; }
 public void setThanhVien(Customer5 value) { ThanhVien=value; }
 private MembershipCard5 The;
 public MembershipCard5 getThe() { return The; }
 public void setThe(MembershipCard5 value) { The=value; }
 private Ticket5[] Ve;
 public Ticket5[] getVe() { return Ve; }
 public void setVe(Ticket5[] value) { Ve=value; }
 private Payment5[] ThanhToan;
 public Payment5[] getThanhToan() { return ThanhToan; }
 public void setThanhToan(Payment5[] value) { ThanhToan=value; }
}
