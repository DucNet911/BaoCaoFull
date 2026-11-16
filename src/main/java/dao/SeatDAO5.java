package dao;import model.*;import java.sql.*;
public class SeatDAO5 extends DAO5{public SeatDAO5(Connection c){super(c);}public Seat5[] getSeats(Screening5 s)throws Exception{return query(Seat5.class,"SELECT g.* FROM tblSeat5 g JOIN tblScreening5 s ON g.tblScreeningRoom5id=s.tblScreeningRoom5id WHERE s.id=? ORDER BY g.MaGhe",s.getId()).toArray(new Seat5[0]);}}
