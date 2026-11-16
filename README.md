# Cinema5 — Java/JSP + MySQL

Bám theo FULL(2): hai module **thêm thông tin phim** và **mua vé trực tuyến**. Có đăng nhập theo vai trò, thêm phim kèm tải áp phích, chọn phim/suất/ghế, thẻ thành viên, thanh toán mô phỏng, phát hành vé, hóa đơn và in. Có lịch sử vé của tài khoản để mở lại sau khi đăng nhập.

## 1. Phần mềm
- JDK 17 hoặc 21 (không chỉ JRE).
- MySQL Server 8.0/8.4 và MySQL Workbench.
- Apache Tomcat **10.1.x**; không dùng Tomcat 9 vì project sử dụng `jakarta.servlet`.
- Maven 3.9 nếu muốn tự biên dịch. Có WAR biên dịch sẵn trong `dist`.

Tương thích Tomcat: https://tomcat.apache.org/migration-10.1.html

## 2. Tạo CSDL
Mở Workbench, kết nối MySQL local bằng tài khoản quản trị. File > Open SQL Script, chạy lần lượt bằng nút tia sét:
1. `sql/01_schema.sql`: tạo database `cinema5` và bảng.
2. `sql/02_seed.sql`: dữ liệu mẫu. Chỉ chạy seed **một lần trên CSDL mới**, chạy lại sẽ trùng khóa.
3. `sql/00_user.sql`: tạo user local và cấp quyền.

Không có lệnh DROP DATABASE. Nếu máy đã có database cinema5 dùng cho bài cũ, hãy đổi tên database trong các file SQL và db.properties trước khi chạy để không trộn schema.

Tài khoản MySQL mẫu: cinema5 / Cinema5_local_2026! . Nếu user đã tồn tại, CREATE USER IF NOT EXISTS không đổi mật khẩu; hãy dùng đúng mật khẩu hiện có trong cấu hình.

Suất mẫu được đặt vào **ngày mai so với ngày chạy seed**. Sau vài ngày, muốn demo tiếp, chạy:
```sql
USE cinema5;
UPDATE tblScreening5 SET GioBatDau=DATE_ADD(GioBatDau,INTERVAL 7 DAY), GioKetThuc=DATE_ADD(GioKetThuc,INTERVAL 7 DAY);
```
Chỉ dùng điều chỉnh này với dữ liệu demo. Không sửa ngày của suất đã bán trong hệ thống thật.

## 3. Cấu hình và chạy nhanh WAR có sẵn (Windows)
1. Giải nén Tomcat vào ví dụ `C:\apache-tomcat-10.1`.
2. Mở CMD trong thư mục `bin` của Tomcat.
3. Khai báo biến môi trường **trong chính cửa sổ CMD này**:
```bat
set JAVA_HOME=C:\Program Files\Java\jdk-17
set DB_URL=jdbc:mysql://localhost:3306/cinema5?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Ho_Chi_Minh
set DB_USER=cinema5
set DB_PASSWORD=Cinema5_local_2026!
```
Đổi JAVA_HOME thành thư mục JDK thật trên máy. Không thêm `\bin` vào JAVA_HOME.
4. Chép `dist\Cinema5.war` vào thư mục `webapps` của Tomcat.
5. Chạy `catalina.bat run`. Giữ cửa sổ CMD mở để xem lỗi.
6. Mở **http://localhost:8080/Cinema5/**.

Nếu không dùng biến môi trường, sửa `src/main/resources/db.properties` và build lại WAR. Không chia sẻ mật khẩu thật trong source.

## 4. Tự build source
Mở terminal tại thư mục chứa pom.xml:
```bat
java -version
mvn -version
mvn clean package
```
Chép `target\Cinema5.war` vào Tomcat/webapps rồi khởi động Tomcat. Khi thay bản WAR: dừng Tomcat, xóa thư mục deploy cũ `webapps/Cinema5` (không phải source/CSDL), chép WAR mới và chạy lại.

## 5. Kịch bản chạy thử
**Thêm phim**: đăng nhập `quanly / 123456` → Quản lý thông tin phim → Thêm phim mới → nhập Siêu nhân gao, Lê Minh Đức, thể loại, 128 phút, ngày phát hành, mô tả, chọn ảnh nếu có → Lưu → Quay lại. Phim mới được lưu nhưng chưa mở bán vì chưa có suất chiếu; đây là đúng sự phân biệt phim/suất chiếu.

**Mua vé**: đăng xuất → đăng nhập `khachhang / 123456` → Mua vé → Phim 1 → suất ngày mai → E5,E6 (VIP) → Xác nhận → nhập TV001 hoặc để trống → Thanh toán → chọn phương thức → Xác nhận trả tiền → In vé và hóa đơn → Hoàn tất. Tổng là 150.000 đồng. Quay lại chọn cùng suất: hai ghế đã bị khóa.

**Thất bại**: chọn phương thức “Mô phỏng thất bại”; hệ thống lưu lần thử thất bại, không phát hành vé. Chọn thử lại và phương thức thành công.

**Trùng ghế**: mở hai phiên trình duyệt, chọn cùng ghế trước khi thanh toán. Phiên thanh toán sau bị chặn sau khi kiểm tra lại ghế dưới khóa giao dịch.

**Kiểm tra dữ liệu**:
```sql
SELECT * FROM tblOrder5 ORDER BY id DESC;
SELECT * FROM tblTicket5 ORDER BY id DESC;
SELECT * FROM tblPayment5 ORDER BY id DESC;
```
`MaHoaDon`, `NgayLap` nằm trong tblOrder5. Không có Receipt5/ReceiptDAO5/tblReceipt5.

## 6. Cấu trúc và đối chiếu
- `src/main/java/model`: 16 lớp thực thể, getter/setter, đúng chuỗi kế thừa và tên thuộc tính trong hình.
- `src/main/java/dao`: JDBC, đóng gói đối tượng và phương thức theo bài.
- `src/main/webapp/view/management`: 4 JSP của thêm phim.
- `src/main/webapp/view/customer`: 7 JSP của mua vé.
- `util/Poster5`: xử lý multipart tải ảnh; ảnh được chuyển sang PNG lưu ngoài WAR tại `Tomcat/cinema5-uploads`. `ApPhich` lưu tên file.
- `Checkout5`: điều phối chung Connection/transaction cho xác nhận thanh toán, phát hành vé, lập hóa đơn. Lập hóa đơn vẫn là `OrderDAO5.createReceipt(order)`.
- `CinemaDAO5`: đóng gói rạp → phòng → ghế và suất → phim.
- `StatisticsDAO5`: hàm truy vấn hai lớp thống kê; không có trang thống kê trong phạm vi hai module.
- `DOI_CHIEU.md`: quyết định xử lý các điểm chưa thống nhất của bản FULL(2).

## 7. Phạm vi và giới hạn
Đây là ứng dụng bài tập cho **hai module được thiết kế chi tiết**, không phải triển khai toàn bộ use case của rạp. Chưa có trang quản lý suất/phòng, bán tại quầy, đăng ký, đổi mật khẩu, email/SMS. CSDL và model có các thực thể toàn hệ thống. Thanh toán hoàn toàn mô phỏng, không nhập số thẻ và không thu tiền thật. In dùng hộp thoại trình duyệt.

## 8. Xử lý lỗi
- Access denied: kiểm tra DB_USER/DB_PASSWORD và user trong MySQL.
- Communications link failure: khởi động MySQL, kiểm tra cổng 3306.
- Unknown database/table/column: chạy schema đúng bản, không dùng SQL cũ có các cột Column.
- HTTP 404: kiểm tra WAR đã được triển khai, đúng `/Cinema5/` và cổng Tomcat.
- jakarta.servlet / UnsupportedClassVersionError: dùng Tomcat 10.1 và JDK 17+.
- Cổng 8080 bận: sửa Connector port trong Tomcat/conf/server.xml rồi truy cập cổng mới.
- Không thấy phim mở bán: suất chiếu phải có TrangThai='MO_BAN' và GioBatDau ở tương lai.

## 9. Kiểm tra đã thực hiện
Xem `KIEM_TRA.md`. Không coi kiểm thử H2 là thay thế cho kiểm thử MySQL thật.
