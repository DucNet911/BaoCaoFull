# Kết quả kiểm tra

- Biên dịch toàn bộ Java bằng Eclipse ECJ, target Java 17: đạt.
- Jasper của Tomcat 10.1 biên dịch toàn bộ JSP: 0 lỗi.
- Smoke5 chạy trên H2 chế độ MySQL: 9 kiểm tra đạt, gồm lưu/đọc phim, tổng 150.000, thanh toán thất bại không phát hành vé, hóa đơn trong Order, đọc chuỗi tham chiếu, lịch sử 2 lần thanh toán, gửi lại không ghi thêm vé, ghế đã bán bị chặn, rạp/phòng/ghế được đóng gói.
- Chưa chạy trực tiếp trên MySQL server: môi trường không có MySQL và không có quyền cài dịch vụ. H2 không chứng minh toàn bộ tương thích MySQL hoặc hành vi khóa đồng thời. Cần chạy kịch bản README trên MySQL local.
- Chưa kiểm tra cổng thanh toán/email thật vì không thuộc bản mô phỏng này.

`tests/Smoke5.java` là kiểm tra DAO trên CSDL trong bộ nhớ; cần H2 jar nếu muốn chạy lại. WAR không chứa H2 hay test. Connector đi kèm WAR là MySQL Connector/J 8.4.0.
