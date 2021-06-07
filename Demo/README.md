# CoviC Website

## Introduction
Website CoviC là hệ thống quản lý người cách ly Covid-19 do sinh viên làm trong đồ án tốt nghiệp. Hệ thống giúp quản lý các thông tin của người cách ly, của nhân viên trong khu và các thông tin liên quan đến dịch bệnh.
Đồ án này trình bày quy trình thiết kế Website CoviC, các tài liệu liên quan như SRS,SDD, source code của chương trình.

## Folder Structure
Project bao gồm các thư mục:

- `Documents`:
	+ Tai lieu thiet ke: Kết quả của bước phân tích và thiết kế dựa theo yêu cầu phần mềm bao gồm các tài liệu SRS,SDD.
	+ Database: Chứa mô hình của cơ sở dữ liệu và file script để tạo lại CSDL này.
	+ UI: Chứa file Figma - file thiết kế giao diện cho website.
- `Demo`: Chứa video demo cách tạo chương trình từ lúc download tài liệu này từ github. Và giới thiệu các tính năng của Website CoviC.
- `Code`: Chứa source code của chương trình.

## Installation 
### Brief description
Source được viết bằng java 8, sử dụng các thư viện zxing( thư viện tạo và chạy mã QR), EclipseLink( JPA 2.1 ), Persistence( api-2.2), MySQL. Sau khi clone repository về máy, trong thư mục Code:
- src: main source
- lib: chứa các thư viện của chương trình
- web: chứa các file cấu hình view cho website

### Working with MySQL WorkBench
- Vào thư mục Documents -> Database -> `database-script.sql`.
- Khởi chạy MySQL WorkBench  -> Run file `database-script.sql` để khởi tạo cơ sở dữ liệu.
- DB_NAME = "datn";
- DB_USERNAME = "root";
- DB_PASSWORD = "12345";

### Working with Apache Netbeans
Trong Apache Netbeans: `File` -> `Open Project` và chọn thư mục `Code` vừa clone từ Github.
Netbeans sẽ tự động thêm một project Java web mới có tên là `datn` vào phần mềm của bạn.

#### Add libary
Tôi đã link trực tiếp các thư viện cần thiết vào thư mục `Code/lib` nên bạn không cần phải thêm các thư viện gì nữa.
Để chắc chắn, hãy kiểm tra lại các thư viện lần nữa ở phần Libraries của Project xem có dấu tích lỗi chỗ nào không và sửa lại.
Lưu ý đến thư viện EclipseLink( JPA 2.1 ) đã có trong Java 8 của bạn chưa.


#### Run
- Chọn Clean and Build để biên dịch chương trình.
- Chọn Run để chạy chương trình khi đã biên dịch thành công.
