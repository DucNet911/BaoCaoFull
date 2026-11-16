package model;
import java.time.*;
import java.math.BigDecimal;
public abstract class Member5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private String Username;
 public String getUsername() { return Username; }
 public void setUsername(String value) { Username=value; }
 private String Password;
 public String getPassword() { return Password; }
 public void setPassword(String value) { Password=value; }
 private String HoVaTen;
 public String getHoVaTen() { return HoVaTen; }
 public void setHoVaTen(String value) { HoVaTen=value; }
 private String DiaChi;
 public String getDiaChi() { return DiaChi; }
 public void setDiaChi(String value) { DiaChi=value; }
 private LocalDate NgaySinh;
 public LocalDate getNgaySinh() { return NgaySinh; }
 public void setNgaySinh(LocalDate value) { NgaySinh=value; }
 private String Email;
 public String getEmail() { return Email; }
 public void setEmail(String value) { Email=value; }
 private String SDT;
 public String getSDT() { return SDT; }
 public void setSDT(String value) { SDT=value; }
 private String GhiChu;
 public String getGhiChu() { return GhiChu; }
 public void setGhiChu(String value) { GhiChu=value; }
}
