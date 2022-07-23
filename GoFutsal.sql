-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 06, 2022 at 05:01 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `GoFutsal`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` char(5) NOT NULL,
  `id_karyawan` char(5) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `id_karyawan`, `username`, `password`) VALUES
('AD001', 'KAR01', 'admin01', 'planet210'),
('AD002', 'KAR02', 'admin02', 'planet020'),
('AD003', 'KAR03', 'admin03', 'planet030'),
('AD004', 'KAR04', '1121', '1212'),
('AD005', 'KAR04', 'wewe', 'wewe'),
('AD006', 'KAR04', 'sdsd', 'sdsd');

-- --------------------------------------------------------

--
-- Stand-in structure for view `booking`
-- (See below for the actual view)
--
CREATE TABLE `booking` (
`id_sewa` varchar(6)
,`id_member` varchar(5)
,`nama_team` varchar(30)
,`telepon` varchar(12)
,`id_lapangan` varchar(5)
,`tanggal` date
,`mulai` time
,`selesai` time
,`harga` int(11)
,`status` enum('lunas','belum lunas','dibatalkan')
);

-- --------------------------------------------------------

--
-- Table structure for table `harga_detail`
--

CREATE TABLE `harga_detail` (
  `id_hd` varchar(4) DEFAULT NULL,
  `ukuran` varchar(2) DEFAULT NULL,
  `hari` enum('weekdays','weekend') DEFAULT NULL,
  `waktu` enum('pagi','malam') DEFAULT NULL,
  `harga` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` varchar(4) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `id_lapangan` varchar(5) DEFAULT NULL,
  `durasi` int(11) DEFAULT NULL,
  `mulai` time DEFAULT NULL,
  `selesai` time DEFAULT NULL,
  `status` enum('dibooking','aktif') DEFAULT NULL,
  `id_sewa` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `tanggal`, `id_lapangan`, `durasi`, `mulai`, `selesai`, `status`, `id_sewa`) VALUES
('JD01', '2022-01-11', 'LAP03', 1, '20:00:00', '21:00:00', 'dibooking', 'SW0001'),
('JD02', '2022-01-11', 'LAP01', 1, '14:00:00', '15:00:00', 'dibooking', 'SW0002'),
('JD03', '2022-01-13', 'LAP02', 1, '13:00:00', '14:00:00', 'dibooking', 'SW0003'),
('JD05', '2022-01-13', 'LAP02', 1, '13:00:00', '14:00:00', 'dibooking', 'SW0005'),
('JD06', '2022-01-05', 'LAP01', 2, '19:00:00', '21:00:00', 'dibooking', 'SW0006');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` char(5) NOT NULL,
  `nama_karyawan` varchar(40) DEFAULT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `alamat` varchar(20) DEFAULT NULL,
  `no_telp` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `jenis_kelamin`, `alamat`, `no_telp`) VALUES
('KAR01', 'Gonzales', 'Laki-Laki', 'Mojoroto', '082123456789'),
('KAR02', 'Bambang', 'Laki-Laki', 'Semampir', '082456789123'),
('KAR03', 'Pamungkas', 'Laki-Laki', 'Bujel', '082789123456');

-- --------------------------------------------------------

--
-- Table structure for table `lapangan`
--

CREATE TABLE `lapangan` (
  `id_lapangan` char(5) NOT NULL,
  `ukuran` varchar(10) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `status` enum('Belum','Disewa','Aktif') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lapangan`
--

INSERT INTO `lapangan` (`id_lapangan`, `ukuran`, `jenis`, `status`) VALUES
('LAP01', 'L', 'VINYL', 'Belum'),
('LAP02', 'L', 'SINTETIS', 'Disewa'),
('LAP03', 'XL', 'VINYL', 'Disewa'),
('LAP04', 'XL', 'SINTETIS', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_member` char(5) NOT NULL,
  `nama_team` varchar(20) DEFAULT NULL,
  `no_telp` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `nama_team`, `no_telp`) VALUES
('MBR01', 'GARUDA FC', '081123456789'),
('MBR02', 'MATAHARI FC', '081456789123'),
('MBR03', 'BULAN FC', '08178923456'),
('MBR04', 'BINTANG FC', '081123789456'),
('MBR05', 'METEOR FC', '081264829462'),
('MBR06', 'PLUTO FC', '081749164829'),
('MBR07', 'MARS FC', '081234654231'),
('MBR08', 'GAGAK FC', '081381725189');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(4) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `dp` int(11) DEFAULT NULL,
  `sisa` int(11) DEFAULT NULL,
  `id_sewa` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `tanggal`, `total`, `dp`, `sisa`, `id_sewa`) VALUES
('PB01', '2021-12-31', 60000, 30000, 30000, 'SW001'),
('PB02', '2022-01-11', 70000, 40000, 30000, 'SW002');

-- --------------------------------------------------------

--
-- Table structure for table `sewa`
--

CREATE TABLE `sewa` (
  `id_sewa` varchar(6) NOT NULL,
  `tgl_input` date DEFAULT NULL,
  `id_member` varchar(5) DEFAULT NULL,
  `nama_team` varchar(30) DEFAULT NULL,
  `telepon` varchar(12) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `status` enum('lunas','belum lunas','dibatalkan') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sewa`
--

INSERT INTO `sewa` (`id_sewa`, `tgl_input`, `id_member`, `nama_team`, `telepon`, `harga`, `status`) VALUES
('SW0001', '2021-12-31', 'MBR02', 'MATAHARI FC', '081456789123', 60000, 'belum lunas'),
('SW0002', '2021-12-31', 'MBR04', 'BINTANG FC', '081123789456', 70000, 'belum lunas'),
('SW0003', '2021-12-31', 'MBR03', 'BULAN FC', '08178923456', 70000, 'belum lunas'),
('SW0004', '2021-12-31', 'MBR03', 'BULAN FC', '08178923456', 70000, 'lunas'),
('SW0005', '2021-12-31', 'MBR06', 'PLUTO FC', '081749164829', 70000, 'belum lunas'),
('SW0006', '2022-01-06', 'MBR01', 'GARUDA FC', '081123456789', 80000, 'dibatalkan');

-- --------------------------------------------------------

--
-- Structure for view `booking`
--
DROP TABLE IF EXISTS `booking`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `booking`  AS SELECT `s`.`id_sewa` AS `id_sewa`, `s`.`id_member` AS `id_member`, `s`.`nama_team` AS `nama_team`, `s`.`telepon` AS `telepon`, `j`.`id_lapangan` AS `id_lapangan`, `j`.`tanggal` AS `tanggal`, `j`.`mulai` AS `mulai`, `j`.`selesai` AS `selesai`, `s`.`harga` AS `harga`, `s`.`status` AS `status` FROM (`sewa` `s` join `jadwal` `j`) WHERE `j`.`id_sewa` = `s`.`id_sewa` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `lapangan`
--
ALTER TABLE `lapangan`
  ADD PRIMARY KEY (`id_lapangan`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indexes for table `sewa`
--
ALTER TABLE `sewa`
  ADD PRIMARY KEY (`id_sewa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
