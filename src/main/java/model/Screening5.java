package model;
import java.time.*;
import java.math.BigDecimal;
public class Screening5 {
 private int id;
 public int getId() { return id; }
 public void setId(int value) { id=value; }
 private LocalDateTime GioBatDau;
 public LocalDateTime getGioBatDau() { return GioBatDau; }
 public void setGioBatDau(LocalDateTime value) { GioBatDau=value; }
 private LocalDateTime GioKetThuc;
 public LocalDateTime getGioKetThuc() { return GioKetThuc; }
 public void setGioKetThuc(LocalDateTime value) { GioKetThuc=value; }
 private String TrangThai;
 public String getTrangThai() { return TrangThai; }
 public void setTrangThai(String value) { TrangThai=value; }
 private Movie5 Phim;
 public Movie5 getPhim() { return Phim; }
 public void setPhim(Movie5 value) { Phim=value; }
}
