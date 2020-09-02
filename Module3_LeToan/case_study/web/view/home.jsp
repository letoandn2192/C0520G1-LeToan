<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/2/2020
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link type="text/css" rel="stylesheet" href="../bootstrap_4/css/bootstrap.min.css">
    <link href="../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="col-12 row bg-info m-0 fixed-top" style="height: 100px">
        <div class="col-2 p-0">
            <img src="../image/codegym.png" class="img-thumbnail" alt="logo" height="100" width="100">
        </div>
        <h2 style="margin-top: 30px">FURAMA RESORT</h2>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top col-12" style="top: 100px">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-home"></span> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-people-arrows"></span> Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="/home?page=customer"><span class="fas fa-user"></span> Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-list"></span> Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-phone"></span> Contract</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="body row position-relative" style="top: 160px">
        <div class="col-2 border position-fixed" style="height: 700px; left: 15px">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Item One</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Item Two</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Item Three</a>
                </li>
            </ul>
        </div>
        <div class="col-10 pl-4" style="left: 16.66%">
            <h2>KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI FURAMA ĐÀ NẴNG, TỰ HÀO LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM</h2>
            <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá
                thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt
                thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách thiết kế
                truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá
                nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách,
                ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.</p>
            <img src="../image/furama.jpg" align="left" class="img-thumbnail mr-1" width="300" height="300">
            <p>Ẩm thực tại khu nghỉ dưỡng là trải nghiệm kết hợp giữa các món ăn Việt Nam, châu Á, Ý và châu Âu cùng
                các món bít tết nhập khẩu hảo hạng. Khu nghỉ dưỡng mang đến cho quý khách những không gian ẩm thực đa
                dạng bao gồm – quầy bar nhìn ra biển, hồ bơi Lagoon được bao quanh bởi khu vườn nhiệt đới, ẩm thực
                truyền thống Ý tại nhà hàng Don Cipriani’s, chất Á Đông tại Café Indochine hay nhà hàng bít tết
                “The Fan – Cái Quạt” nằm ngay trên bãi biển. Khu nghỉ dưỡng Furama Đà Nẵng còn gây ấn tượng và tạo
                nhiều thích thú cho khách thông qua các chương trình vui chơi đầy thú vị như các chuyến du ngoạn, thể
                thao trên nước, lặn biển và chơi golf cũng như các dịch vụ chăm sóc sức khoẻ và sắc đẹp.</p>
            <p>Nằm tại vị trí đắc địa gần trung tâm Đà Nẵng và là nơi kết nối quốc tế thuận tiện đến Singapore, Bangkok,
                Xiêm Riệp, Kuala Lumpur, Đài Loan, Tokyo, Osaka, Busan, Seoul, Tokyo, Osaka và Hồng Kông – Ma Cao, Trung
                Quốc bao gồm: Bắc Kinh, Thượng Hải, Hàng Châu, Quảng Châu, Thành Đô bằng các chuyến bay trực tiếp, khu
                nghỉ dưỡng Furama Đà Nẵng là điểm đến lý tưởng cho các đại lý du lịch, doanh nghiệp, công ty tổ chức sự
                kiện. Cung Hội nghị có thể chứa tới 3000 người, cùng với 10 phòng chức năng khác có sức chứa từ 50 đến
                300 người. Cung hội nghị Ariyana Convention Centre (ACC) được xây dựng để tổ chức sự kiện APEC 2017, kết
                nối với Cung hội nghị Furama (ICP) tạo thành quần thể MICE lớn nhất Việt Nam có sức chứa lên tới 5,000
                khách.</p>
            <p>Một loạt các bữa tiệc theo chủ đề trên bãi biển hoặc xung quanh hồ Lagoon, trong phòng đại tiệc hoặc bên
                ngoài khu nghỉ dưỡng, kết hợp các dịch vụ đặc biệt như VIP xuất hiện từ trực thăng đáp xuống bãi đáp
                riêng của khu nghỉ dưỡng; Thêm vào đó là các hoạt động nhóm và thể thao trên nước, “Trung tâm lặn” đạt
                tiêu chuẩn lặn biển quốc tế, 2 sân golf 18 lỗ, cũng như các dịch vụ chăm sóc sức khoẻ và sắc đẹp đã
                khiến Furama Đà Nẵng trở thành địa điểm lý tưởng cho các nhóm MICE.</p>
            <p>Một loạt các bữa tiệc theo chủ đề trên bãi biển hoặc xung quanh hồ Lagoon, trong phòng đại tiệc hoặc bên
                ngoài khu nghỉ dưỡng, kết hợp các dịch vụ đặc biệt như VIP xuất hiện từ trực thăng đáp xuống bãi đáp
                riêng của khu nghỉ dưỡng; Thêm vào đó là các hoạt động nhóm và thể thao trên nước, “Trung tâm lặn” đạt
                tiêu chuẩn lặn biển quốc tế, 2 sân golf 18 lỗ, cũng như các dịch vụ chăm sóc sức khoẻ và sắc đẹp đã
                khiến Furama Đà Nẵng trở thành địa điểm lý tưởng cho các nhóm MICE.</p>
            <p>Một loạt các bữa tiệc theo chủ đề trên bãi biển hoặc xung quanh hồ Lagoon, trong phòng đại tiệc hoặc bên
                ngoài khu nghỉ dưỡng, kết hợp các dịch vụ đặc biệt như VIP xuất hiện từ trực thăng đáp xuống bãi đáp
                riêng của khu nghỉ dưỡng; Thêm vào đó là các hoạt động nhóm và thể thao trên nước, “Trung tâm lặn” đạt
                tiêu chuẩn lặn biển quốc tế, 2 sân golf 18 lỗ, cũng như các dịch vụ chăm sóc sức khoẻ và sắc đẹp đã
                khiến Furama Đà Nẵng trở thành địa điểm lý tưởng cho các nhóm MICE.</p>
        </div>
    </div>

    <div class="footer col-12 bg-dark text-center fixed-bottom" style="height: 60px">
        <p class="text-light">@CopyRight</p>
    </div>

</div>
<script src="../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>
