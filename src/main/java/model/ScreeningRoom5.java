package model;
import java.time.*;
import java.math.BigDecimal;
public class ScreeningRoom5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private String MaPhong;
 public String getMaPhong() { return MaPhong; }
 public void setMaPhong(String value) { MaPhong=value; }
 private int SucChua;
 public int getSucChua() { return SucChua; }
 public void setSucChua(int value) { SucChua=value; }
 private String SoDoGhe;
 public String getSoDoGhe() { return SoDoGhe; }
 public void setSoDoGhe(String value) { SoDoGhe=value; }
 private Seat5[] ListGhe;
 public Seat5[] getListGhe() { return ListGhe; }
 public void setListGhe(Seat5[] value) { ListGhe=value; }
 private Screening5[] ListSuatChieu;
 public Screening5[] getListSuatChieu() { return ListSuatChieu; }
 public void setListSuatChieu(Screening5[] value) { ListSuatChieu=value; }
}
