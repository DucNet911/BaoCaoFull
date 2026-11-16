package model;
import java.time.*;
import java.math.BigDecimal;
public class Ticket5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private String MaVe;
 public String getMaVe() { return MaVe; }
 public void setMaVe(String value) { MaVe=value; }
 private BigDecimal Gia;
 public BigDecimal getGia() { return Gia; }
 public void setGia(BigDecimal value) { Gia=value; }
 private String TrangThai;
 public String getTrangThai() { return TrangThai; }
 public void setTrangThai(String value) { TrangThai=value; }
 private Screening5 SuatChieu;
 public Screening5 getSuatChieu() { return SuatChieu; }
 public void setSuatChieu(Screening5 value) { SuatChieu=value; }
 private Seat5 Ghe;
 public Seat5 getGhe() { return Ghe; }
 public void setGhe(Seat5 value) { Ghe=value; }
}
