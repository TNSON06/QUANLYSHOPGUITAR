-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2024 at 01:52 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopghita`
--

-- --------------------------------------------------------

--
-- Table structure for table `ctsanpham`
--

CREATE TABLE `ctsanpham` (
  `ID` int(10) NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctsanpham`
--

INSERT INTO `ctsanpham` (`ID`, `MaSP`, `SoLuong`, `Gia`) VALUES
(18, 'B123', 3, 36000000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `ID` int(10) NOT NULL,
  `NgayDat` date NOT NULL,
  `ThanhTien` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`ID`, `NgayDat`, `ThanhTien`) VALUES
(1, '2022-01-12', 1000000),
(8, '2024-01-11', 140000000),
(9, '2024-01-23', 140000000);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ID` int(11) NOT NULL,
  `MaNV` varchar(50) NOT NULL,
  `TenNV` varchar(50) NOT NULL,
  `ChucVu` varchar(50) NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` bit(1) DEFAULT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `SDT` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Luong` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`ID`, `MaNV`, `TenNV`, `ChucVu`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SDT`, `Email`, `Luong`) VALUES
(1, 'BV123', 'Son', '(BV) Bảo Vệ', '2004-01-12', b'1', 'Đà Nẵng', '0394216189', 'son@gmail.com', 10000000),
(3, 'BH123', 'Tai', '(BH) Bán Hàng', '2004-01-09', b'1', 'Quảng Trị', '0987654786', 'tai123@gmail.com', 5000000),
(4, 'QL123', 'Len', '(QL) Quản Lý', '2002-01-11', b'1', 'Đà Nẵng', '0978567347', 'len1223@gmail.com', 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `ID` int(10) NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  `TenSP` varchar(50) DEFAULT NULL,
  `Loai` varchar(50) DEFAULT NULL,
  `SoLuong` int(10) DEFAULT NULL,
  `Gia` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`ID`, `MaSP`, `TenSP`, `Loai`, `SoLuong`, `Gia`) VALUES
(1, 'CL123', 'suzuki', 'Classic', 20, 15000000),
(2, 'CL124', 'Fender', 'Classic', 30, 10000000),
(3, 'CL125', 'Sigmaa', 'Classic', 150, 25000000),
(4, 'AC122', 'Martin', 'Acoustic', 10, 10000000),
(5, 'D123', 'Gibson', 'Điện', 50, 20000000),
(6, 'D124', 'PRS', 'Điện', 10, 50000000),
(7, 'AC256', 'Taylorr', 'Acoustic', 20, 20000000),
(8, 'B123', 'Yamaha', 'Bass', 50, 12000000),
(9, 'B124', 'Samick', 'Bass', 100, 17000000),
(14, 'T123', 'Washburn', 'Torres', 1000, 17000000),
(18, 'S123', 'Enya', 'Silent', 100, 1000000),
(19, 'T124', 'Martin', 'Torres', 250, 19000000),
(20, 'S124', 'Donner', 'Silent', 40, 40000000),
(21, 'R123', 'Takamine', 'Resonator', 150, 150000000),
(22, 'R124', 'Ibanez', 'Resonator', 24, 13000000),
(23, 'D125', 'Taylor', 'Điện', 50, 100000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
