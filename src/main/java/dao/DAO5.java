package dao;
import java.sql.*;import java.util.*;import java.io.*;import java.lang.reflect.*;import java.time.*;
public class DAO5 {
 protected final Connection con;
 public DAO5(Connection con){this.con=con;}
 public static Connection open() throws Exception {Properties p=new Properties();try(InputStream in=DAO5.class.getResourceAsStream("/db.properties")){p.load(in);}Class.forName("com.mysql.cj.jdbc.Driver");return DriverManager.getConnection(System.getenv().getOrDefault("DB_URL",p.getProperty("url")),System.getenv().getOrDefault("DB_USER",p.getProperty("user")),System.getenv().getOrDefault("DB_PASSWORD",p.getProperty("password")));}
 protected PreparedStatement stmt(String sql,Object...args)throws SQLException{PreparedStatement p=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);for(int i=0;i<args.length;i++)p.setObject(i+1,args[i]);return p;}
 protected int insert(String sql,Object...args)throws SQLException{try(PreparedStatement p=stmt(sql,args)){p.executeUpdate();try(ResultSet r=p.getGeneratedKeys()){return r.next()?r.getInt(1):0;}}}
 protected void update(String sql,Object...args)throws SQLException{try(PreparedStatement p=stmt(sql,args)){p.executeUpdate();}}
 protected <T> T map(ResultSet r,Class<T> type)throws Exception {T x=type.getDeclaredConstructor().newInstance();Set<String> cols=new TreeSet<>(String.CASE_INSENSITIVE_ORDER);for(int i=1;i<=r.getMetaData().getColumnCount();i++)cols.add(r.getMetaData().getColumnLabel(i));for(Class<?> c=type;c!=Object.class;c=c.getSuperclass())for(Field f:c.getDeclaredFields()){if(!cols.contains(f.getName()))continue; Object v=r.getObject(f.getName());if(v==null)continue;if(f.getType()==LocalDate.class)v=r.getDate(f.getName()).toLocalDate();else if(f.getType()==LocalDateTime.class)v=r.getTimestamp(f.getName()).toLocalDateTime();else if(f.getType()==int.class)v=((Number)v).intValue();f.setAccessible(true);f.set(x,v);}return x;}
 protected <T> java.util.List<T> query(Class<T> t,String sql,Object...args)throws Exception{java.util.List<T> out=new ArrayList<>();try(PreparedStatement p=stmt(sql,args);ResultSet r=p.executeQuery()){while(r.next())out.add(map(r,t));}return out;}
}
