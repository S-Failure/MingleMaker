-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2022 at 12:14 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minglemaker`
--

-- --------------------------------------------------------

--
-- Table structure for table `appsettings`
--

CREATE TABLE `appsettings` (
  `AppSettingId` int(11) NOT NULL,
  `AppKey` varchar(100) DEFAULT NULL,
  `AppValue` varchar(1000) DEFAULT NULL,
  `CreationDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appsettings`
--

INSERT INTO `appsettings` (`AppSettingId`, `AppKey`, `AppValue`, `CreationDate`) VALUES
(1, 'SiteName', 'Mingle Maker', '2022-03-04 22:48:18'),
(2, 'SiteNameInitial', 'MM', '2022-03-04 22:49:02'),
(3, 'SiteURL', 'http://localhost:8080/MingleMaker/', '2022-03-04 22:49:15'),
(4, 'DefaultPassword', 'DRftgyhu@12', '2022-03-06 21:01:59');

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

CREATE TABLE `countries` (
  `CountryId` int(11) NOT NULL,
  `CountryName` varchar(50) DEFAULT NULL,
  `CountryCode` varchar(50) DEFAULT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `CreationDate` datetime DEFAULT current_timestamp(),
  `ModificationDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `countries`
--

INSERT INTO `countries` (`CountryId`, `CountryName`, `CountryCode`, `IsDeleted`, `CreationDate`, `ModificationDate`) VALUES
(1, 'China', '+92', b'1', '2022-03-06 16:59:55', '2022-03-06 17:18:13'),
(2, 'India', '+91', b'0', '2022-03-06 17:06:46', NULL),
(3, 'Russia', '+7', b'0', '2022-03-06 23:21:48', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `documents`
--

CREATE TABLE `documents` (
  `DocumentId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  `BureoId` int(11) DEFAULT NULL,
  `Document` varchar(1000) DEFAULT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `CreationDate` datetime DEFAULT current_timestamp(),
  `ModificationDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `familybrackground`
--

CREATE TABLE `familybrackground` (
  `FamilyBrackgroundId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  `BureoId` int(11) DEFAULT NULL,
  `FatherName` varchar(250) DEFAULT NULL,
  `FatherOccupation` varchar(250) DEFAULT NULL,
  `MotherName` varchar(250) DEFAULT NULL,
  `Sibilings` int(11) DEFAULT NULL,
  `ContactNumber` varchar(20) DEFAULT NULL,
  `ContactEmail` varchar(250) DEFAULT NULL,
  `CreationDate` datetime DEFAULT current_timestamp(),
  `ModificationDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `marriagebureos`
--

CREATE TABLE `marriagebureos` (
  `BureoId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  `BureoName` varchar(250) DEFAULT NULL,
  `BureoAddress` varchar(250) DEFAULT NULL,
  `ContactEmail` varchar(250) DEFAULT NULL,
  `RegNo` varchar(20) DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `CreationDate` datetime DEFAULT current_timestamp(),
  `ModificationDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `marriagebureos`
--

INSERT INTO `marriagebureos` (`BureoId`, `UserId`, `BureoName`, `BureoAddress`, `ContactEmail`, `RegNo`, `Description`, `IsDeleted`, `CreationDate`, `ModificationDate`) VALUES
(7, 8, 'Surat Bureo', NULL, 'suratbureo@gmail.com', 'BJW143', NULL, b'0', '2022-03-06 21:02:59', '2022-03-08 21:20:35'),
(9, 12, 'Jill Bureo', NULL, 'jill@gmail.com', 'JB456', NULL, b'0', '2022-03-09 01:38:54', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `requests`
--

CREATE TABLE `requests` (
  `RequestId` int(11) NOT NULL,
  `UserFromId` int(11) DEFAULT NULL,
  `UserToId` int(11) DEFAULT NULL,
  `BureoFromId` int(11) DEFAULT NULL,
  `BureoToId` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT 0,
  `IsDeleted` bit(1) DEFAULT b'0',
  `CreationDate` datetime DEFAULT current_timestamp(),
  `ModificationDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `RoleId` int(11) NOT NULL,
  `RoleName` varchar(50) DEFAULT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `CreationDate` datetime DEFAULT current_timestamp(),
  `ModificationDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`RoleId`, `RoleName`, `IsDeleted`, `CreationDate`, `ModificationDate`) VALUES
(1, 'Super Admin', b'0', '2022-03-04 22:51:09', '2022-03-04 18:20:34'),
(2, 'Bureo Admin', b'0', '2022-03-04 22:51:09', '2022-03-04 18:20:34'),
(3, 'User', b'0', '2022-03-04 22:51:22', '2022-03-04 18:21:13'),
(4, 'Test3', b'1', '2022-03-06 15:54:22', '2022-03-06 16:17:07'),
(5, 'Test2', b'0', '2022-03-06 15:54:53', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `UserDetailId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  `BureoId` int(11) DEFAULT NULL,
  `EyeColour` varchar(50) DEFAULT NULL,
  `HairColour` varchar(50) DEFAULT NULL,
  `Height` varchar(50) DEFAULT NULL,
  `Education` varchar(50) DEFAULT NULL,
  `MeritalStatus` varchar(50) DEFAULT NULL,
  `MotherTongue` varchar(50) DEFAULT NULL,
  `RequiredChild` bit(1) DEFAULT b'1',
  `LookingFor` varchar(50) DEFAULT NULL,
  `Address` varchar(250) DEFAULT NULL,
  `Salary` varchar(250) DEFAULT NULL,
  `Occupation` varchar(250) DEFAULT NULL,
  `WorkAddress` varchar(250) DEFAULT NULL,
  `Creationdate` datetime DEFAULT current_timestamp(),
  `Modificationdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`UserDetailId`, `UserId`, `BureoId`, `EyeColour`, `HairColour`, `Height`, `Education`, `MeritalStatus`, `MotherTongue`, `RequiredChild`, `LookingFor`, `Address`, `Salary`, `Occupation`, `WorkAddress`, `Creationdate`, `Modificationdate`) VALUES
(1, 7, 7, NULL, NULL, NULL, NULL, NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, '2022-03-08 21:12:52', '2022-03-09 00:56:15'),
(2, 9, 7, NULL, NULL, NULL, NULL, NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, '2022-03-08 23:58:54', NULL),
(3, 10, 7, NULL, NULL, NULL, NULL, NULL, NULL, b'1', NULL, NULL, NULL, NULL, NULL, '2022-03-09 00:38:51', '2022-03-09 00:55:00');

-- --------------------------------------------------------

--
-- Table structure for table `userinroles`
--

CREATE TABLE `userinroles` (
  `UserInRoleId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  `RoleId` int(11) DEFAULT NULL,
  `CreationDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userinroles`
--

INSERT INTO `userinroles` (`UserInRoleId`, `UserId`, `RoleId`, `CreationDate`) VALUES
(1, 1, 1, '2022-03-06 18:13:29'),
(7, 7, 3, '2022-03-06 20:12:01'),
(8, 8, 2, '2022-03-06 21:02:59'),
(10, 9, 3, NULL),
(11, 10, 3, NULL),
(13, 12, 2, '2022-03-09 01:38:54');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserId` int(11) NOT NULL,
  `FirstName` varchar(250) DEFAULT NULL,
  `LastName` varchar(250) DEFAULT NULL,
  `Email` varchar(250) DEFAULT NULL,
  `Password` varchar(250) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Photo` varchar(10000) DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `ZipCode` varchar(50) DEFAULT NULL,
  `CountryId` int(11) DEFAULT NULL,
  `IsDeleted` bit(1) DEFAULT b'0',
  `Creationdate` datetime DEFAULT current_timestamp(),
  `Modificationdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserId`, `FirstName`, `LastName`, `Email`, `Password`, `Phone`, `Photo`, `Gender`, `Age`, `City`, `State`, `ZipCode`, `CountryId`, `IsDeleted`, `Creationdate`, `Modificationdate`) VALUES
(1, 'Utkarsh', 'Patil', 'minglemaker@manage.in', 'Mingle@143', NULL, NULL, 'Male', 1, 'Surat', 'Gujarat', '394210', 2, b'0', '2022-03-06 18:12:46', '2022-03-08 20:34:04'),
(7, 'User', 'User', 'user@gmail.com', 'User@123', NULL, NULL, 'Male', 7, 'Surat', 'Gujarat', '394210', 2, b'0', '2022-03-06 20:12:01', '2022-03-09 01:55:29'),
(8, 'John', 'Wick', 'johnwick@gmail.com', 'DRftgyhu@12', NULL, NULL, 'Male', 8, 'Surat', 'Gujarat', '394210', 2, b'0', '2022-03-06 21:02:59', '2022-03-09 01:12:06'),
(9, 'Emily', 'Wick', 'emilywick@gmail.com', 'DRftgyhu@12', '1234567890', NULL, 'Female', 21, 'Surat', 'Gujarat', '394210', 2, b'0', '2022-03-08 23:58:54', NULL),
(10, 'Test', 'Test', 'test@gmail.com', NULL, '1234567890', NULL, 'Male', 21, 'Surat', 'Gujarat', '394012', 2, b'0', '2022-03-09 00:38:51', '2022-03-09 00:55:00'),
(12, 'Jill', 'Shukla', 'jill@gmail.com', 'Jill@123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-03-09 01:38:54', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appsettings`
--
ALTER TABLE `appsettings`
  ADD PRIMARY KEY (`AppSettingId`);

--
-- Indexes for table `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`CountryId`);

--
-- Indexes for table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`DocumentId`),
  ADD KEY `documents_ibfk_1` (`BureoId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `familybrackground`
--
ALTER TABLE `familybrackground`
  ADD PRIMARY KEY (`FamilyBrackgroundId`),
  ADD KEY `BureoId` (`BureoId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `marriagebureos`
--
ALTER TABLE `marriagebureos`
  ADD PRIMARY KEY (`BureoId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`RequestId`),
  ADD KEY `BureoFromId` (`BureoFromId`),
  ADD KEY `BureoToId` (`BureoToId`),
  ADD KEY `UserFromId` (`UserFromId`),
  ADD KEY `UserToId` (`UserToId`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`RoleId`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`UserDetailId`),
  ADD KEY `BureoId` (`BureoId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `userinroles`
--
ALTER TABLE `userinroles`
  ADD PRIMARY KEY (`UserInRoleId`),
  ADD KEY `RoleId` (`RoleId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appsettings`
--
ALTER TABLE `appsettings`
  MODIFY `AppSettingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `countries`
--
ALTER TABLE `countries`
  MODIFY `CountryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `documents`
--
ALTER TABLE `documents`
  MODIFY `DocumentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `familybrackground`
--
ALTER TABLE `familybrackground`
  MODIFY `FamilyBrackgroundId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `marriagebureos`
--
ALTER TABLE `marriagebureos`
  MODIFY `BureoId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `requests`
--
ALTER TABLE `requests`
  MODIFY `RequestId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `RoleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `UserDetailId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `userinroles`
--
ALTER TABLE `userinroles`
  MODIFY `UserInRoleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
