-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2023 at 01:19 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentdata`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateStudentStatus` (IN `studentId_param` INT)   BEGIN
    UPDATE student
    SET status = 'INACTIVE'
    WHERE studentId = studentId_param AND status = 'ENROLLED';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateUserStatus` (IN `userId_param` INT)   BEGIN
    UPDATE user
    SET status = 'INACTIVE'
    WHERE userId = userId_param AND status = 'ACTIVE';
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `all_female`
-- (See below for the actual view)
--
CREATE TABLE `all_female` (
`firstName` varchar(255)
,`middleName` varchar(255)
,`lastName` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `all_male`
-- (See below for the actual view)
--
CREATE TABLE `all_male` (
`studentId` int(11)
,`year` varchar(255)
,`course` varchar(255)
,`firstName` varchar(255)
,`middleName` varchar(255)
,`lastName` varchar(255)
,`suffix` varchar(255)
,`gender` varchar(255)
,`birth` date
,`status` varchar(255)
,`image` varchar(500)
,`date` date
);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `course` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `degree` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseId`, `course`, `description`, `degree`) VALUES
(1, 'BSIT', 'BACHELOR OF SCISASASAENCE IN INFORMATION TECHNOLOGY', 'FOUR-YEAR DEGREE PROGRAM'),
(2, 'BSA', 'BACHELOR OF SCIENCE IN AGRICULTURE', 'FOUR-YEAR DEGREE PROGRAM'),
(3, 'BSED-TLE', 'BACHELOR IN SECONDARY EDUCATION MAJOR IN TECHNOLOGY', 'FOUR-YEAR DEGREE PROGRAM'),
(4, 'BSBAD', 'BACHELOR OF SCIENCE IN BUSINESS ADMINISTRATION', 'FOUR-YEAR DEGREE PROGRAM');

-- --------------------------------------------------------

--
-- Stand-in structure for view `course_table`
-- (See below for the actual view)
--
CREATE TABLE `course_table` (
`courseId` int(11)
,`course` varchar(255)
,`description` varchar(255)
,`degree` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `male_course`
-- (See below for the actual view)
--
CREATE TABLE `male_course` (
`course` varchar(255)
,`lastName` varchar(255)
);

-- --------------------------------------------------------

--
-- Table structure for table `medicalinformation`
--

CREATE TABLE `medicalinformation` (
  `medicalinformationId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `medicalinformation_col_name` varchar(255) NOT NULL,
  `height` varchar(255) NOT NULL,
  `weight` varchar(255) NOT NULL,
  `bloodType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicalinformation`
--

INSERT INTO `medicalinformation` (`medicalinformationId`, `studentId`, `medicalinformation_col_name`, `height`, `weight`, `bloodType`) VALUES
(1, 1, 'EFREL JEAN REAMBONANZA LONGAO N/A', '0', '0', '0'),
(2, 2, 'REX GAMOT PONCE N/A', '0', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentId` int(11) NOT NULL,
  `year` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `middleName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `suffix` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `birth` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentId`, `year`, `course`, `firstName`, `middleName`, `lastName`, `suffix`, `gender`, `birth`, `status`, `image`, `date`) VALUES
(1, '3RD YEAR', 'BSIT', 'EFREL JEAN', 'REAMBONANZA', 'LONGAO', 'N/A', 'FEMALE', '2023-12-12', 'ENROLLED', 'C:\\\\Users\\\\User\\\\Documents\\\\bb\\\\studentManagementSystemFINALL\\\\src\\\\studentImages\\\\‏girl.jpg', '2023-12-29'),
(2, '3RD YEAR', 'BSIT', 'REX', 'GAMOT', 'PONCE', 'N/A', 'MALE', '2023-12-13', 'ENROLLED', 'C:\\\\Users\\\\User\\\\Documents\\\\bb\\\\studentManagementSystemFINALL\\\\src\\\\studentImages\\\\rexx.jpg', '2023-12-29');

--
-- Triggers `student`
--
DELIMITER $$
CREATE TRIGGER `after_insert_male_female_total_enrolled_count` AFTER INSERT ON `student` FOR EACH ROW BEGIN
    DECLARE isMale BOOLEAN;
    DECLARE isFemale BOOLEAN;

    SET isMale = NEW.gender = 'Male';
    SET isFemale = NEW.gender = 'Female';

    IF NEW.status = 'Enrolled' THEN
        IF isMale THEN
            -- Increment the male_total_enrolled count in the student_count table
            UPDATE student_count SET male_total_enrolled = male_total_enrolled + 1;
        END IF;
        
        IF isFemale THEN
            -- Increment the female_total_enrolled count in the student_count table
            UPDATE student_count SET female_total_enrolled = female_total_enrolled + 1;
        END IF;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_insert_student_total_enrolled_count` AFTER INSERT ON `student` FOR EACH ROW BEGIN
    IF NEW.status = 'Enrolled' THEN
        UPDATE student_count
        SET total_enrolled = total_enrolled + 1;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_male_or_female_student_status_total_count` AFTER UPDATE ON `student` FOR EACH ROW BEGIN
    DECLARE isMale BOOLEAN;
    DECLARE isFemale BOOLEAN;

    SET isMale = NEW.gender = 'Male';
    SET isFemale = NEW.gender = 'Female';

    -- Check if the status is changed from 'Enrolled' to 'Not Enrolled'
    IF OLD.status = 'Enrolled' AND NEW.status = 'Not Enrolled' THEN
        IF isMale THEN
            -- Decrement the male_total_enrolled count in the student_count table
            UPDATE student_count SET male_total_enrolled = male_total_enrolled - 1;
        END IF;

        IF isFemale THEN
            -- Decrement the female_total_enrolled count in the student_count table
            UPDATE student_count SET female_total_enrolled = female_total_enrolled - 1;
        END IF;
    END IF;

    -- Check if the status is changed from 'Not Enrolled' to 'Enrolled'
    IF OLD.status = 'Not Enrolled' AND NEW.status = 'Enrolled' THEN
        IF isMale THEN
            -- Increment the male_total_enrolled count in the student_count table
            UPDATE student_count SET male_total_enrolled = male_total_enrolled + 1;
        END IF;

        IF isFemale THEN
            -- Increment the female_total_enrolled count in the student_count table
            UPDATE student_count SET female_total_enrolled = female_total_enrolled + 1;
        END IF;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_student_status_total_enrolled_count` AFTER UPDATE ON `student` FOR EACH ROW BEGIN
    IF NEW.status = 'Enrolled' AND OLD.status = 'Not Enrolled' THEN
        -- Increment the total_enrolled count in the student_count table
        UPDATE student_count SET total_enrolled = total_enrolled + 1;
    ELSEIF NEW.status = 'Not Enrolled' AND OLD.status = 'Enrolled' THEN
        -- Decrement the total_enrolled count in the student_count table
        UPDATE student_count SET total_enrolled = total_enrolled - 1;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `studentcontactaddress`
--

CREATE TABLE `studentcontactaddress` (
  `studentContactAddressId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `studentContactAddress_col_name` varchar(255) NOT NULL,
  `contactNumber` int(11) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `parentsContactNumber` int(11) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentcontactaddress`
--

INSERT INTO `studentcontactaddress` (`studentContactAddressId`, `studentId`, `studentContactAddress_col_name`, `contactNumber`, `emailAddress`, `parentsContactNumber`, `address`) VALUES
(1, 1, 'EFREL JEAN REAMBONANZA LONGAO N/A', 0, '0', 0, '0'),
(2, 2, 'REX GAMOT PONCE N/A', 0, '0', 0, '0');

-- --------------------------------------------------------

--
-- Table structure for table `studentgrade`
--

CREATE TABLE `studentgrade` (
  `StudentGradeId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `year` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `firstSem` double NOT NULL,
  `secondSem` double NOT NULL,
  `final` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentgrade`
--

INSERT INTO `studentgrade` (`StudentGradeId`, `studentId`, `year`, `course`, `firstSem`, `secondSem`, `final`) VALUES
(1, 1, '3RD YEAR', 'BSIT', 0, 0, 0),
(2, 2, '3RD YEAR', 'BSIT', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_count`
--

CREATE TABLE `student_count` (
  `total_enrolled` int(11) NOT NULL,
  `male_total_enrolled` int(11) NOT NULL,
  `female_total_enrolled` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_count`
--

INSERT INTO `student_count` (`total_enrolled`, `male_total_enrolled`, `female_total_enrolled`) VALUES
(2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `middleName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `suffix` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `image` varchar(500) NOT NULL,
  `privilage` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL DEFAULT 'Active',
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `firstName`, `middleName`, `lastName`, `suffix`, `gender`, `username`, `email`, `password`, `image`, `privilage`, `status`, `date`) VALUES
(1, 'REX', 'GAMOT', 'PONCE', 'NONE', 'MALE', 'rexkie12', 'rex.ponce46@yahoo.com', 'rex123', 'C:\\\\Users\\\\User\\\\Documents\\\\bb\\\\studentManagementSystemFINALL\\\\src\\\\studentImages\\\\rexx.jpg', 'ADMIN', 'ACTIVE', '2001-08-12'),
(2, 'JAY MARC', 'HEY', 'CANO', 'JR', 'LGBTQIA+', 'juser', 'juser@yahoo.com', '092700', 'C:\\\\\\\\Users\\\\\\\\User\\\\\\\\Documents\\\\\\\\bb\\\\\\\\studentManagementSystemFINALL\\\\\\\\src\\\\\\\\studentImages\\\\\\\\sad boi.jpg', 'INSTRUCTOR', 'ACTIVE', '2023-12-29');

-- --------------------------------------------------------

--
-- Structure for view `all_female`
--
DROP TABLE IF EXISTS `all_female`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `all_female`  AS SELECT `student`.`firstName` AS `firstName`, `student`.`middleName` AS `middleName`, `student`.`lastName` AS `lastName` FROM `student` WHERE `student`.`gender` = 'Female' ORDER BY `student`.`firstName` ASC  ;

-- --------------------------------------------------------

--
-- Structure for view `all_male`
--
DROP TABLE IF EXISTS `all_male`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `all_male`  AS SELECT `student`.`studentId` AS `studentId`, `student`.`year` AS `year`, `student`.`course` AS `course`, `student`.`firstName` AS `firstName`, `student`.`middleName` AS `middleName`, `student`.`lastName` AS `lastName`, `student`.`suffix` AS `suffix`, `student`.`gender` AS `gender`, `student`.`birth` AS `birth`, `student`.`status` AS `status`, `student`.`image` AS `image`, `student`.`date` AS `date` FROM `student` WHERE `student`.`gender` = 'Male\'Male\'Male\'Male''Male\'Male\'Male\'Male'  ;

-- --------------------------------------------------------

--
-- Structure for view `course_table`
--
DROP TABLE IF EXISTS `course_table`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `course_table`  AS SELECT `course`.`courseId` AS `courseId`, `course`.`course` AS `course`, `course`.`description` AS `description`, `course`.`degree` AS `degree` FROM `course``course`  ;

-- --------------------------------------------------------

--
-- Structure for view `male_course`
--
DROP TABLE IF EXISTS `male_course`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `male_course`  AS SELECT `student`.`course` AS `course`, `student`.`firstName` AS `lastName` FROM `student` WHERE `student`.`gender` = 'Male' ORDER BY `student`.`firstName` ASC  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseId`);

--
-- Indexes for table `medicalinformation`
--
ALTER TABLE `medicalinformation`
  ADD PRIMARY KEY (`medicalinformationId`),
  ADD KEY `studentId` (`studentId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentId`);

--
-- Indexes for table `studentcontactaddress`
--
ALTER TABLE `studentcontactaddress`
  ADD PRIMARY KEY (`studentContactAddressId`),
  ADD KEY `studentId` (`studentId`);

--
-- Indexes for table `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD PRIMARY KEY (`StudentGradeId`),
  ADD KEY `studentId` (`studentId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `medicalinformation`
--
ALTER TABLE `medicalinformation`
  MODIFY `medicalinformationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `studentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `studentcontactaddress`
--
ALTER TABLE `studentcontactaddress`
  MODIFY `studentContactAddressId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `studentgrade`
--
ALTER TABLE `studentgrade`
  MODIFY `StudentGradeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
