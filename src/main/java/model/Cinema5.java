package model;
import java.time.*;
import java.math.BigDecimal;
public class Cinema5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private int MaRap;
 public int getMaRap() { return MaRap; }
 public void setMaRap(int value) { MaRap=value; }
 private String TenRap;
 public String getTenRap() { return TenRap; }
 public void setTenRap(String value) { TenRap=value; }
 private String DiaChi;
 public String getDiaChi() { return DiaChi; }
 public void setDiaChi(String value) { DiaChi=value; }
 private String MoTa;
 public String getMoTa() { return MoTa; }
 public void setMoTa(String value) { MoTa=value; }
 private ScreeningRoom5[] ListPhongChieu;
 public ScreeningRoom5[] getListPhongChieu() { return ListPhongChieu; }
 public void setListPhongChieu(ScreeningRoom5[] value) { ListPhongChieu=value; }
}
