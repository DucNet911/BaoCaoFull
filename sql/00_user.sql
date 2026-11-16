-- Chạy bằng tài khoản quản trị MySQL, chỉ dùng cho máy local.
CREATE USER IF NOT EXISTS 'cinema5'@'localhost' IDENTIFIED BY 'Cinema5_local_2026!';
GRANT SELECT,INSERT,UPDATE,DELETE ON cinema5.* TO 'cinema5'@'localhost';
