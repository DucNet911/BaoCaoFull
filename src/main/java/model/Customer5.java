package model;
import java.time.*;
import java.math.BigDecimal;
public class Customer5 extends Member5 {
 private String MaKhachHang;
 public String getMaKhachHang() { return MaKhachHang; }
 public void setMaKhachHang(String value) { MaKhachHang=value; }
 private MembershipCard5 The;
 public MembershipCard5 getThe() { return The; }
 public void setThe(MembershipCard5 value) { The=value; }
}
