-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 08, 2023 lúc 04:17 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `market3`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `CatagoryID` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`CatagoryID`, `Name`, `Description`) VALUES
(1, 'Fruit', 'The kind that can be eaten without cooking'),
(2, 'Green Vegetables', 'The kind used to make salads or soups'),
(3, 'Spices', 'The kind used to enhance the taste of food');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Fullname` varchar(40) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customers`
--

INSERT INTO `customers` (`CustomerID`, `Password`, `Fullname`, `Address`, `City`) VALUES
(1, 'Abcd1234', 'John Smith', '30 Broadway', 'London'),
(2, 'Abcd1234', 'Jonny English', '99 River View', 'Reading'),
(3, 'Abcd1234', 'Elizabeth', '23 Buckinghamshire', 'York'),
(4, 'Abcd1234', 'Beatrix', '66 Royal Crescent', 'Bath'),
(6, '123', 'Huong', 'Thu Duc', 'HCM'),
(7, '', 'John Smith', '30 Broadway 1111', 'London 1111'),
(8, '123', 'thanh', 'q5', 'binh duong');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `OrderID` int(10) UNSIGNED NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Total` float NOT NULL,
  `Note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`OrderID`, `CustomerID`, `Date`, `Total`, `Note`) VALUES
(0, 1, '2021-08-15', 150000, 'Use environmental protection bags'),
(1, 2, '2021-08-16', 235000, ''),
(2, 3, '2021-08-16', 65000, 'Need fast delivery'),
(3, 3, '2021-08-17', 80000, ''),
(10, 6, '2023-05-08', 10000, 'Test'),
(11, 6, '2023-05-10', 135000, ''),
(12, 6, '2023-05-19', 195000, 'asasas'),
(13, 6, '2023-05-19', 315000, ''),
(14, 6, '2023-05-19', 315000, '21231231asdfasda'),
(15, 6, '2023-05-20', 30000, '111'),
(16, 6, '2023-05-20', 3000000, 'Giao nhanh'),
(17, 6, '2023-05-20', 370000, 'Giao cham'),
(18, 6, '2023-05-20', 230000, '123213123123'),
(19, 6, '2023-05-20', 440000, ''),
(20, 6, '2023-05-20', 1975000, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `OrderID` int(10) UNSIGNED NOT NULL,
  `VegetableID` int(10) NOT NULL,
  `Quantity` tinyint(4) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderdetail`
--

INSERT INTO `orderdetail` (`OrderID`, `VegetableID`, `Quantity`, `Price`) VALUES
(0, 1, 1, 30000),
(0, 8, 1, 120000),
(1, 4, 1, 80000),
(1, 2, 1, 35000),
(1, 3, 1, 150000),
(2, 5, 1, 35000),
(2, 7, 2, 30000),
(3, 6, 2, 80000),
(10, 2, 2, 5000),
(11, 1, 1, 30000),
(11, 2, 3, 35000),
(12, 1, 3, 30000),
(12, 2, 3, 35000),
(13, 5, 4, 140000),
(13, 6, 1, 40000),
(13, 7, 1, 15000),
(13, 8, 1, 120000),
(14, 5, 4, 140000),
(14, 6, 1, 40000),
(14, 7, 1, 15000),
(14, 8, 1, 120000),
(15, 1, 1, 30000),
(16, 1, 100, 3000000),
(17, 1, 1, 30000),
(17, 2, 1, 35000),
(17, 3, 1, 150000),
(17, 4, 1, 80000),
(17, 5, 1, 35000),
(17, 6, 1, 40000),
(18, 1, 3, 90000),
(18, 2, 4, 140000),
(19, 2, 3, 105000),
(19, 3, 2, 300000),
(19, 5, 1, 35000),
(20, 2, 1, 35000),
(20, 3, 12, 1800000),
(20, 5, 4, 140000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vegetable`
--

CREATE TABLE `vegetable` (
  `VegetableID` int(11) NOT NULL,
  `CatagoryID` int(10) NOT NULL,
  `Vegetable_Name` varchar(50) DEFAULT NULL,
  `Unit` varchar(20) NOT NULL,
  `Amount` int(10) NOT NULL,
  `Image` varchar(50) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `vegetable`
--

INSERT INTO `vegetable` (`VegetableID`, `CatagoryID`, `Vegetable_Name`, `Unit`, `Amount`, `Image`, `Price`) VALUES
(1, 1, 'Tomato', 'kg', 896, 'images/tomato.jpg', 30000),
(2, 1, 'potato', 'kg', 141, 'images/potato.jpg', 35000),
(3, 1, 'Apple', 'bag', 35, 'images/apple.jpg', 150000),
(4, 1, 'Water melon', 'per fruit', 19, 'images/watermelon.jpg', 80000),
(5, 2, ' broccoli', 'kg', 44, 'images/broccoli.jpg', 35000),
(6, 2, 'celery', 'kg', 79, 'images/celery.jpg', 40000),
(7, 3, ' spring onion', 'bunch', 50, 'images/springonion.jpg', 15000),
(8, 3, 'garlic', 'kg', 30, 'images/garlic.jpg', 120000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatagoryID`);

--
-- Chỉ mục cho bảng `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Chỉ mục cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `VegetableID` (`VegetableID`);

--
-- Chỉ mục cho bảng `vegetable`
--
ALTER TABLE `vegetable`
  ADD PRIMARY KEY (`VegetableID`),
  ADD KEY `CatagoryID` (`CatagoryID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `vegetable`
--
ALTER TABLE `vegetable`
  MODIFY `VegetableID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `FKlsthx2huofyos18y08qyn6lcb` FOREIGN KEY (`OrderID`) REFERENCES `order` (`OrderID`);

--
-- Các ràng buộc cho bảng `vegetable`
--
ALTER TABLE `vegetable`
  ADD CONSTRAINT `FK8rnbuo3x1kdkxx2894q5lgut1` FOREIGN KEY (`CatagoryID`) REFERENCES `category` (`CatagoryID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
