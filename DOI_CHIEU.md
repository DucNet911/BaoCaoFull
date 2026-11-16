# Đối chiếu FULL(2)

Nguồn chuẩn tên thuộc tính: hình “Biểu đồ lớp thực thể pha thiết kế” trong FULL(2). Phần chữ của tài liệu còn tên tiếng Anh; code chọn tên trong hình theo chỉ dẫn người dùng.

- Giữ `Username`, `Password`, `HoVaTen`, `DiaChi`, `NgaySinh`, `Email`, `SDT`, `GhiChu` của Member5. Password lưu chuỗi PBKDF2, không đổi tên thành passwordHash.
- Cinema5.MaRap là int theo hình; các mã phim/phòng/ghế vẫn String theo hình.
- **Bổ sung NgayPhatHanh: LocalDate** vào Movie5 và cột DATE tương ứng vì biểu mẫu và kịch bản nhập ngày phát hành nhưng hình thực thể bỏ sót. Đây là bổ sung duy nhất về thuộc tính nghiệp vụ, được thông báo khi thực hiện.
- MovieStat5 kế thừa Movie5, CustomerStat5 kế thừa Customer5. Không thêm tham chiếu movie thừa trong MovieStat5; các thuộc tính phim được kế thừa. Không tạo bảng thống kê.
- `Order5.ThanhVien`, `The`, `Ve[]`, `ThanhToan[]`; Ticket5.SuatChieu/Ghe; Screening5.Phim; Customer5.The; Cinema5.ListPhongChieu[]; ScreeningRoom5.ListGhe[]/ListSuatChieu[] đều có getter/setter và DAO đọc tham chiếu.
- Order5 chứa MaHoaDon, NgayLap, TongTien. TongTien được tính từ Ve[].Gia, không lưu cột dẫn xuất trong bảng.
- Bảng con kế thừa dùng id vừa PK vừa FK, không thêm cột Column hoặc khóa phụ dư. Dùng tên FK dạng tbl...id nhất quán.
- Luồng online bắt buộc khách đăng nhập. Thẻ phải thuộc khách hiện tại, còn hạn và HIEU_LUC. Không tự thêm giảm giá.
- Phiên chọn vé và đơn tạm lưu theo khóa riêng để hạn chế ghi đè khi mở nhiều tab. Vé chỉ ghi DB sau thanh toán thành công; đơn chờ vẫn được lưu theo bước createOrder.
- Thanh toán dùng dữ liệu mô phỏng, hai giá theo kịch bản 50.000/75.000. CSDL unique(suất,ghế) chặn bán trùng; khóa suất khi checkout đảm bảo kiểm tra và phát hành tuần tự. Bản này không có chức năng hủy vé/bán lại ghế.
- Ngày suất trong seed dùng ngày mai để demo chạy được, thay vì ngày 09/08/2026 đã qua. Dữ liệu nhập Siêu nhân gao dùng 128 phút theo kịch bản.
- Tên thành phần giao diện, biến cục bộ movie/order/customer và phương thức DAO giữ theo kịch bản. Không coi các biến này là đổi tên thuộc tính thực thể.
- Poster xử lý qua servlet hỗ trợ để đọc multipart; nghiệp vụ lưu vẫn MovieDAO5.saveMovie(movie). Các JSP giữ tên trong bài.
