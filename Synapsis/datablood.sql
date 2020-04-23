-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2019 at 12:36 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datablood`
--
CREATE DATABASE IF NOT EXISTS `datablood` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `datablood`;

-- --------------------------------------------------------

--
-- Table structure for table `blood`
--

CREATE TABLE `blood` (
  `id` int(11) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `district` varchar(255) NOT NULL,
  `bank_name` varchar(255) NOT NULL,
  `bank_address` varchar(255) NOT NULL,
  `book` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blood`
--

INSERT INTO `blood` (`id`, `blood_group`, `state`, `district`, `bank_name`, `bank_address`, `book`) VALUES
(1, 'O+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, MMG District Hospital', 'Blood Bank, MMG District Hospital, Ghaziabad', 'bloodbook.php'),
(2, 'A+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, MMG District Hospital', 'Blood Bank, MMG District Hospital, Ghaziabad', 'bloodbook.php'),
(3, 'O+', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(4, 'A+', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(5, 'B+', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(6, 'AB+', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(7, 'O-', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(8, 'A-', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(9, 'AB-', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(10, 'B-', 'Uttar Pradesh', 'ghaziabad', 'Modern Pathology & Blood Bank, SA-96, Shastri Nagar,\r\nGhaziabad.\r\n', 'Shastri Nagar,\r\nGhaziabad.\r\n', 'bloodbook.php'),
(11, 'O+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(12, 'A+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(13, 'B+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(14, 'AB+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(15, 'O-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(16, 'A-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(17, 'B-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(18, 'AB-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Narendra Mohan Hospital & Research Centre,\r\nMohan Nagar, Ghaziabad\r\n', 'Mohan Nagar, Ghaziabad', 'bloodbook.php'),
(19, 'O+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(20, 'A+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(21, 'B+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(22, 'AB+', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(23, 'O-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(24, 'A-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(25, 'B-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php'),
(26, 'AB-', 'Uttar Pradesh', 'Ghaziabad', 'Blood Bank, Santosh Medical & Dental College Hospital,\r\nNo. 1, Ambedkar Road, Ghaziabad\r\n', 'No. 1, Ambedkar Road, Ghaziabad', 'bloodbook.php');

-- --------------------------------------------------------

--
-- Table structure for table `blood_orders`
--

CREATE TABLE `blood_orders` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `aadhar` int(255) NOT NULL,
  `delivery_address` varchar(255) NOT NULL,
  `mobile_number` int(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blood_orders`
--

INSERT INTO `blood_orders` (`id`, `name`, `address`, `aadhar`, `delivery_address`, `mobile_number`, `blood_group`, `amount`) VALUES
(1, 'deepak', 'shivam vihar', 123456789, 'ITS', 98765432, 'O+', '1 Unit'),
(2, 'Rishav', 'Address', 2147483647, 'Something', 1234567890, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `docs`
--

CREATE TABLE `docs` (
  `id` int(40) NOT NULL,
  `sid` int(40) NOT NULL,
  `docname` varchar(100) NOT NULL,
  `doccontact` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `docs`
--

INSERT INTO `docs` (`id`, `sid`, `docname`, `doccontact`) VALUES
(1, 1, 'Dr Arun Chauhan', '9919288179'),
(2, 2, ' Dr Arun chauhan', '9828181181'),
(3, 3, 'Dr Ashish sharma ', '9828181181'),
(4, 4, 'Dr Batra', '9828181121'),
(5, 5, 'Dr Pallavi Goyal', '9129192819'),
(6, 6, 'Dr Pallavi Goyal', '9429192819'),
(7, 7, 'Dr Priya Mishra', '9429192819'),
(8, 8, 'Dr Priya Mishra', '9529192819'),
(9, 9, 'Dr Priya Mishra', '9529192819'),
(10, 10, 'Dr Rishav Singh', '91129192819'),
(11, 11, 'Dr Rishav Singh', '9629192819'),
(12, 12, 'Dr Harsh Rawat', '9829192819'),
(13, 13, 'Dr Vikas Gautam', '9929192819'),
(14, 14, 'Dr Vikas Gautam', '9029192819'),
(26, 16, 'Dr Ashutosh Chaterjee', '9929192819'),
(27, 15, 'Dr Arun Chauhan', '9919288179'),
(28, 16, ' Dr Arun Chauhan', '9828181181'),
(29, 17, 'Dr Ashish sharma ', '9828181181'),
(30, 18, 'Dr Batra', '9828181121'),
(31, 19, 'Dr Pallavi', '9129192819'),
(32, 20, 'Dr Pallavi', '9429192819'),
(33, 21, 'Dr Priya ', '9429192819'),
(34, 22, 'Dr Priya', '9529192819'),
(35, 23, 'Dr Priya', '9529192819'),
(36, 24, 'Dr Rishav Singh', '91129192819'),
(37, 11, 'Dr Rishav', '9629192819'),
(38, 12, 'Dr Harsh', '9829192819'),
(39, 13, 'Dr Vikas', '9929192819'),
(40, 14, 'Dr Vikas', '9029192819'),
(41, 15, 'Dr Ashutosh', '9929192819'),
(42, 25, 'Dr Rishav', '7287228129'),
(43, 26, 'Dr Rishav', '7287228129'),
(44, 27, 'Dr Aayushi', '89872281'),
(45, 28, 'Dr Aayushi', '8987228129'),
(46, 29, 'Dr Brad', '7387228129'),
(47, 30, 'Dr Brad', '7287228129'),
(48, 31, 'Dr Rishav', '9287228129'),
(49, 32, 'Dr Brad', '9387228129'),
(50, 33, 'Dr Aashis ', '9287228129'),
(51, 34, 'Dr Aashis', '9287228129'),
(52, 36, 'Dr Lalit Pachal', '6007228129'),
(53, 37, 'Dr Lalit Pachal', '7907228129'),
(54, 38, 'Dr Vikas takral', '9907228129'),
(55, 39, 'Dr Vikas Pachal', '9907228129'),
(56, 40, 'Dr Neeraj wadhwa', '6007228129'),
(57, 41, 'Dr Neeraj Wadhwa ', '7007228129'),
(58, 42, 'Dr Tarun Kapoor', '8007228129'),
(59, 43, 'Dr Tarun Kapoor', '8007228129'),
(60, 44, 'Dr shalini kumari', '9907228129'),
(61, 45, 'Dr Shalini Kumari', '9907228129'),
(62, 46, 'Dr Saloni gupta', '7007228129'),
(63, 47, 'Dr Saloni gupta ', '7007228129'),
(64, 48, 'Dr saloni gupta ', '7007228129');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `body` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `title`, `date`, `body`) VALUES
(1, 'The FDA approve esketamine nasal spray for severe depression', '2019-03-09 07:04:25', 'The Food and Drug Administration (FDA) have just granted approval of the drug esketamine (Spravato) to the Johnson & Johnson company Janssen Pharmaceuticals Inc.\r\n\r\nThe fast-acting nasal spray is for use in conjunction with an oral antidepressant in adults with treatment-resistant depression, note the federal agency.\r\n\r\nAccording to its developer, the drug uses the \"first new mechanism of action in decades to treat\" major depressive disorder.\r\n\r\nThe aim is that healthcare providers will prescribe the nasal spray to people with major depressive disorder who have tried and received no benefit from at least two antidepressant treatments.\r\n\r\nThe FDA also say that the drug will only be available through a system of tight distribution and monitoring.'),
(2, 'Could a smartphone app detect diabetes?', '2019-03-09 07:19:16', 'According to the Centers for Disease Control and Prevention (CDC), more than 30 million people in the U.S. have diabetes.\r\n\r\nWorryingly, almost one in four people in the U.S. are living with diabetes but do not know.\r\n\r\nWithout treatment, diabetes can have serious health consequences, including kidney problems, eye conditions, heart disease, and stroke.\r\n\r\nCurrently, a doctor needs to take a blood sample to diagnose diabetes, which generally requires a trip to the clinic.\r\n\r\nFor a wide range of reasons, many people do not have easy access to healthcare, so it is important to find simpler ways of detecting diabetes.'),
(3, 'IBD: A low-calorie plant diet relieves inflammation, repairs gut', '2019-03-09 07:19:16', 'Scientists at the University of Southern California in Los Angeles recently tested what they describe as the \"fasting-mimicking\" diet on a mouse model of inflammatory bowel disease (IBD).\r\n\r\nIn a study paper that now features in the journal Cell Reports, they describe how, compared with water-only fasting, periodic 4-day cycles of the fasting-mimicking diet \"partially reversed\" hallmarks of IBD in the mice.\r\n\r\nThey saw that the diet reduced inflammation and increased populations of stem cells in the mice\'s intestines. Stem cells are essential for tissue repair and regeneration.\r\n\r\nIn addition, the team observed that these effects appeared, in part, to be due to an increase in beneficial gut bacteria.\r\n\r\nResults from humans also showed that the diet reduced markers of inflammation and associated immune cells.\r\n\r\nTaking these results together, the researchers conclude that a low-calorie, plant-based, fasting-mimicking diet has potential as an effective treatment for IBD.\r\n\r\nCorresponding study author Valter Longo, a professor of biological sciences, says that their investigation is the first IBD study to bring together \"two worlds of research.\"\r\n\r\n\"The first [world],\" he explains, \"is about what you should eat every day, and many studies point to a diet rich in vegetables, nuts, and olive oil. The second is fasting and its effects on inflammation, regeneration, and aging.\"\r\n\r\nHe and his colleagues suggest that the reason that water-based fasting does not seem to be as effective as the fasting-mimicking diet could be because while fasting produces many of the desired effects, the body still needs essential nutrients to do the rest.\r\n\r\n'),
(4, 'MMR vaccine does not cause autism, even in those most at risk', '2019-03-09 07:20:13', 'The furor surrounding vaccines and their relationship with autism has been rumbling along for decades.\r\n\r\nA paper published in 1998 first described a link between the measles, mumps, and rubella (MMR) vaccine and autism.\r\n\r\nBoth the findings and the lead researchers have since been entirely discredited.\r\n\r\nAnyone who takes an interest in science might be asking whether we need to carry out any more research in defense of the MMR jab. After all, strong evidence has already been collected, confirmed, and replicated.\r\n\r\nFacts upon facts\r\nThe author of the study that sparked the storm, Andrew Wakefield, has since been stripped of his clinical and academic credentials.\r\n\r\nVaccination rates dropped after the panic began, and they still have not returned to the levels needed to protect children from disease adequately.\r\n\r\nThe authors of the latest study write that \"Measles outbreaks are not uncommon in Europe and in the United States, and vaccine hesitancy or avoidance has been identified as a major cause.\"\r\n\r\nClearly, not everyone is convinced that the MMR vaccine is safe; scare stories are difficult to forget and worryingly easy to perpetuate.\r\n\r\nBy continuing to publish high-quality evidence, the fears surrounding vaccines might, one day, be extinguished once and for all.'),
(5, 'Being overweight or obese may improve stroke survival', '2019-03-09 07:20:13', 'Obesity is a \"serious medical condition\" that can lead to various complications.\r\n\r\nThese might include atherosclerosis and heart disease, diabetes, cancer, and even sleep disorders.\r\n\r\nBeing overweight may also raise the risk of all-cause mortality and mental health conditions such as depression and anxiety.\r\n\r\nDespite this, some researchers maintain that excessive body fat can have a protective cardiovascular effect.\r\n\r\nIn fact, the authors of a 2002 reference paper coined the phrase \"obesity paradox\" to describe the observation that people with a higher body mass index (BMI) are less likely to die from cardiovascular conditions than people with a normal weight.\r\n\r\nSince then, the theory has been the subject of much controversy. However, new evidence appears to support it.\r\n\r\nDr. Zuolu Liu — from the University of California, Los Angeles — and her colleagues wanted to see how the obesity paradox applies to stroke. Previous research into the same issue, explain the researchers, yielded mixed results.\r\n\r\nThey will present their new findings at the American Academy of Neurology\'s 71st Annual Meeting, which this year takes place in Philadelphia, PA.'),
(6, 'Cocoa may help treat common MS symptom', '2019-03-09 07:22:00', 'According to the latest estimates, multiple sclerosis (MS) is an autoimmune disorder that affects almost 1 million people in the United States and approximately 2.5 million people worldwide.\r\n\r\nMS affects the central nervous system. Symptoms often include muscle weakness, burning sensations, numbness, chronic pain, poor balance and coordination, fatigue, and difficulty concentrating.\r\n\r\nIn fact, as many as 9 out of 10 people with MS have fatigue, and the symptom is usually difficult to treat. Older research has suggested that a daily dose of 45 grams of dark chocolate may improve chronic fatigue syndrome. Dark chocolate contains 70–85 percent cocoa.\r\n\r\nBased on these previous findings, Shelly Coe, who works in the Department of Sport, Health Sciences and Social Work at the Oxford Brookes Centre for Nutrition and Health in the United Kingdom, and a team of scientists set out to examine whether cocoa would have the same beneficial effects on fatigue in people with MS.'),
(7, 'The unexpected dangers of gum disease', '2019-03-09 07:22:00', 'Plaque — a sticky substance that contains bacteria — builds up on teeth. If it is not brushed away, the bacteria can irritate the gums.\r\n\r\nThe gums may then become swollen, sore, or infected; this is referred to as gingivitis.\r\n\r\nIn general, gum disease can be treated or prevented by maintaining a good oral health regime.\r\n\r\nHowever, if it is left to develop, it can result in periodontitis, which weakens the supporting structures of the teeth.\r\n\r\nGum disease, which is also called periodontal disease, is widespread. According to the Centers for Disease Control and Prevention (CDC), almost half of adults in the United States have some degree of gum disease.\r\n\r\nThe mechanisms behind periodontal disease are relatively well-understood, and newer research shows that this health problem may play a role in the development of a number of other conditions, including Alzheimer\'s disease, cancer, and respiratory disease.\r\n\r\nIn this Spotlight, we will cover some of the surprising links between gum disease and disparate health issues.'),
(8, 'This sleep disorder puts people at \'very high risk\' of Parkinson\'s', '2019-03-09 07:25:01', 'Data from the National Institutes of Health (NIH) indicate that every year, approximately 50,000 people in the United States learn that they have Parkinson\'s disease, a neurological condition that affects a person\'s motor function and exposes them to other neurodegenerative problems, such as Alzheimer\'s disease.\r\n\r\nResearchers still do not fully understand exactly what causes Parkinson\'s disease, but they have identified a few risk factors that can predispose a person to develop this condition.\r\n\r\nThese include a person\'s age and sex as well as some genetic factors. Still, it remains a challenge to establish early on who is likely to develop Parkinson\'s disease at some point in their life.\r\n\r\nHowever, a team of researchers from McGill University in Montreal, Canada decided to see if one particular factor — a sleep disorder called REM sleep behavior disorder (RBD) — could be a good predictor of risk.\r\n\r\nThis sleep problem is called RBD because it occurs during the REM phase of sleep, in which a person\'s body becomes effectively paralyzed. This inability to move prevents the person from physically acting out any dream that they may be experiencing and thus stops them from potentially harming themselves or others.\r\n\r\nPeople with RBD do not have this paralysis, which means that they end up acting out their dreams without any notion that they are doing so.\r\n\r\nResearch has shown that many people with RBD go on to develop Parkinson\'s disease, so the McGill University team decided to find out whether an RBD diagnosis could accurately predict Parkinson\'s risk.\r\n\r\nAs lead author Dr. Ron Postuma and colleagues explain, establishing that this sleep disorder is a good predictor of Parkinson\'s could, in the future, allow specialists to identify at-risk people and offer them experimental therapies that could delay or prevent the onset of this neurological condition.'),
(9, 'How to improve and protect eyesight without glasses', '2019-03-09 07:25:01', 'The Centers for Disease Control and Prevention (CDC) estimate that in the United States around 12 million people of 40 years of age and older have some form of vision impairment. This includes:\r\n\r\n3 million people with vision impairment following correction\r\n8 million people with vision impairment from an uncorrected refractive error\r\n1 million people or more who have a type of blindness\r\nHowever, poor eyesight does not have to be an inevitable consequence of getting older. There are some natural ways and lifestyle interventions that can help a person improve and protect their eyesight.\r\n\r\nIn this article, we present 4 ways to improve eyesight and eye health without corrective glasses.\r\n\r\n<ol>\r\n<li>Protective eyewear</li>\r\n<li>Sunglasses</li>\r\n<li>Regular eye exams</li>\r\n<li>Screen breaks</li>\r\n</ol>');

-- --------------------------------------------------------

--
-- Table structure for table `organs`
--

CREATE TABLE `organs` (
  `id` int(11) NOT NULL,
  `bodypart` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `district` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `pincode` int(11) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `Book` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organs`
--

INSERT INTO `organs` (`id`, `bodypart`, `state`, `district`, `address`, `pincode`, `contact`, `Book`) VALUES
(1, 'kidney', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(2, 'liver', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(3, 'lungs', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(4, 'lungs', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(5, 'Heart', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(6, 'Bone Marrow', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(7, 'Eye Tissue', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(8, 'Hair Transplant', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(9, 'Pancreas', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(10, 'Tendons', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(11, 'Skin Tissue', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(12, 'Bones', 'uttar pradesh', 'ghaziabad', 'MMG Hospital ', 201205, '5565564754', 'organbook.php'),
(13, 'lungs', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(14, 'liver', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(15, 'Heart', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(16, 'Kidney', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(17, 'Bone Marrow', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(18, 'Eye Tissue', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(19, 'Hair Transplant', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(20, 'Pancreas', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(21, 'Tendons', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php'),
(22, 'Skins', 'uttar pradesh', 'ghaziabad', 'ITS Hospital ', 201205, '5565564754', 'organbook.php');

-- --------------------------------------------------------

--
-- Table structure for table `organ_orders`
--

CREATE TABLE `organ_orders` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `aadhar` int(255) NOT NULL,
  `delivery_address` varchar(255) NOT NULL,
  `mobile_number` int(255) NOT NULL,
  `body_part` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organ_orders`
--

INSERT INTO `organ_orders` (`id`, `name`, `address`, `aadhar`, `delivery_address`, `mobile_number`, `body_part`) VALUES
(1, 'deepak', 'shivam vihar', 1324532626, 'ITS', 987654321, 'kidney'),
(2, 'deepak', 'shivam vihar', 1324532626, 'ITS', 987654321, 'kidney'),
(3, 'deepak', 'shivam vihar', 2147483647, 'ITS ', 123456987, 'Kidney'),
(4, 'sumit', 'shivam vihar', 2147483647, 'ITS ', 123456987, 'Kidney');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `query` longtext NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `name`, `email`, `query`, `time`) VALUES
(1, 'Rishav', 'rishav@gmail.com', 'THis THisTHisTHisTHisTHisTHisTHisTHisTHis', '2019-03-09 10:44:07');

-- --------------------------------------------------------

--
-- Table structure for table `symptoms`
--

CREATE TABLE `symptoms` (
  `sid` int(100) NOT NULL,
  `body_part` varchar(40) NOT NULL,
  `symptom` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `symptoms`
--

INSERT INTO `symptoms` (`sid`, `body_part`, `symptom`) VALUES
(1, 'Problems On Brains', 'Learning Disabilities'),
(2, 'Problems On Brains', 'Head Injury'),
(3, 'Problems On Brains', 'MELAS Syndrome'),
(4, 'Problems On Brains', 'Motion Sickness'),
(5, 'Problems On Brains', 'Multiple Sclerosis'),
(6, 'Problems On Brains', 'Neuropathic Pain'),
(7, 'Problems On Brains', 'Stroke'),
(8, 'Problems On Brains', 'Spinal Cord Injury'),
(9, 'Problems On Brains', 'Stroke Prevention'),
(10, 'Problems On Brains', 'Sinus Headache'),
(11, 'Problems On Brains', 'Seizure'),
(12, 'Problems On Brains', 'Pinched Nerve'),
(13, 'glands_and_harmones', 'Weakness'),
(14, 'glands_and_harmones', 'Fatigue'),
(15, 'glands_and_harmones', 'Abdominal pain'),
(16, 'glands_and_harmones', 'Nausea'),
(17, 'glands_and_harmones', 'Weight loss'),
(18, 'glands_and_harmones', 'Low blood pressure'),
(19, 'glands_and_harmones', 'Darkened skin (in the case of Addison’s disease)'),
(20, 'glands_and_harmones', 'Dizziness upon standing'),
(21, 'ENT', 'Squamous cell carcinoma of the oral cavity, pharynx and larynx'),
(22, 'ENT', 'Oral cancer'),
(23, 'ENT', 'Skin cancer of the head and neck'),
(24, 'ENT', 'Thyroid cancer'),
(25, 'ENT', 'Endocrine surgery of the head and neck'),
(26, 'ENT', 'Microvascular free flap reconstruction'),
(27, 'ENT', 'Skull base surgery'),
(28, 'ENT', 'Salivary gland cancer'),
(29, 'ENT', 'Dizziness'),
(30, 'ENT', 'BPPV – benign paroxysmal positional vertigo'),
(31, 'ENT', 'Pituitary tumor'),
(32, 'ENT', 'Empty nose syndrome'),
(33, 'EYE', 'Recurrent pain in or around the eye'),
(34, 'EYE', 'Hazy, blurred, or double vision'),
(35, 'EYE', 'Seeing flashes of light or sudden bright floating spots'),
(36, 'EYE', 'Seeing rainbows or halos around lights'),
(37, 'EYE', 'Seeing floating \"spider webs\"'),
(38, 'EYE', 'Seeing a \"curtain coming down\" over one eye'),
(39, 'EYE', 'Sensing a \"cup filling up with ink\" in one eye'),
(40, 'EYE', 'Unusual, even painful, sensitivity to light or glare'),
(41, 'EYE', 'Swollen, red eyes'),
(42, 'EYE', 'Changes in the color of the iris'),
(43, 'EYE', 'White areas in the pupil of the eye'),
(44, 'EYE', 'Sudden development of persistent floaters'),
(45, 'EYE', 'Itching, burning, or a heavy discharge in the eyes'),
(46, 'EYE', 'Any sudden change in vision'),
(47, 'EYE', 'See also Normal Vision Changes to help you understand normal age-related changes in the eyes and your vision.'),
(48, 'EYE', 'Severe, sudden eye pain');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `aadhar` int(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `consult` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `loginas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `aadhar`, `gender`, `consult`, `password`, `loginas`) VALUES
(1, 'Rishav', 'rishav@gmail.com', 132454253, 'Male', 'Yes', ' b4a7927a2c39e8e653247e129314420e', 'Admin'),
(2, 'Rishav User', 'rishavuser@gmail.com', 2147483647, 'Male', 'Yes', ' b4a7927a2c39e8e653247e129314420e', 'User'),
(3, 'Rishav', 'rishav107@gmail.com', 2147483647, 'Male', 'Yes', 'b4a7927a2c39e8e653247e129314420e', 'User'),
(4, 'admin', 'admin@gmail.com', 2147483647, 'Male', 'Yes', '21232f297a57a5a743894a0e4a801fc3', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blood`
--
ALTER TABLE `blood`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `blood_orders`
--
ALTER TABLE `blood_orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `docs`
--
ALTER TABLE `docs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `organs`
--
ALTER TABLE `organs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `organ_orders`
--
ALTER TABLE `organ_orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `symptoms`
--
ALTER TABLE `symptoms`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blood`
--
ALTER TABLE `blood`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `blood_orders`
--
ALTER TABLE `blood_orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `docs`
--
ALTER TABLE `docs`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `organs`
--
ALTER TABLE `organs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `organ_orders`
--
ALTER TABLE `organ_orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `symptoms`
--
ALTER TABLE `symptoms`
  MODIFY `sid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
