# EcoBikeRental App

## Introduction
Trong khu đô thị Ecopark có dịch vụ cho thuê xe đạp theo giờ với nhiều bãi để xe để thuê/trả xe tự
động. EcoBikeRental App giúp khách hàng có thể thuê xe tự động thông qua việc quét mã vạch, cũng 
như việc trả xe và thanh toán. \
Project này trình bày quy trình thiết kế EcoBikeRental App, các tài liệu liên quan như SRS,SDD, source code của chương trình

## Folder Structure
Project bao gồm các thư mục:

- `RequirementAnalysis`: Kết quả của bước phân tích yêu cầu phần mềm (SRS) bao gồm: Biểu đồ use case tổng quan, các đặc tả use case
- `ArchitectureDesign`: Kết quả của bước thiết kế kiến trúc bao gồm: Biểu đồ tương tác, biểu đồ phân tích, biểu đồ phân
tích gộp
- `DetailedDesign`: Kết quả của bước thiết kế chi tiết bao gồm: Giao diện, thiết kế lớp, thiết kế mô hình dữ liệu
- `Project`: Chứa source code của chương trình

## Installation 
### Brief description
Source được viết bằng java 11, sử dụng các thư viện JavaFX, JUnit, MySQL. Sau khi clone repository về máy,
trong thư mục Project:
src: main source
- lib: chứa các thư viện của JavaFx, Junit, MySQL
- assets: chứa các dữ liệu cố định (ví dụ ảnh)
- DBModel: chứa file script để tạo bảng với giá trị mẫu

### Working with MySQL WorkBench
Tạo mới một connection  -> Run file `all_scripts.sql` trong thư mục DBModel.
- DB_NAME = "capstone_project";
- DB_USERNAME = "root";
- DB_PASSWORD = "1234";

### Working with Intellij
Trong Intellij: `File` -> `Open` và chọn thư mục Project

#### Add libary
Trong Intellij: `File` -> `Project Structure` -> `Libaries`
Note: Kiểm tra các thư viện đã được thêm tự động chưa.
Click `+` icon -> `java` rồi chọn đến thư mục `Project/lib` cho junit và mysql-connection,`Project/lib/win/javafx-sdk-15/lib`
cho javafx.

Intellij sẽ tự động thêm các file **.jar** trong thư mục vào intellij project. 

#### Add VM arguments
Trong Intellij: `Run` -> `Edit configurations..`. Khi cửa sổ mới hiện lên click icon `+` -> `Application` -> `modify options` -> `Add VM options`.

Sau đó đặt:
- `Main class` = `App`
- `VM Options` = `--module-path lib/win/javafx-sdk-15/lib --add-modules javafx.controls,javafx.fxml`

