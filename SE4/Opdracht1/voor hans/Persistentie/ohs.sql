-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 19 mrt 2019 om 17:03
-- Serverversie: 10.1.38-MariaDB
-- PHP-versie: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ohs`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `matten`
--

CREATE TABLE `matten` (
  `id` int(11) NOT NULL,
  `aankoopPrijs` double NOT NULL,
  `laatstGecheckt` date NOT NULL,
  `status` varchar(10) NOT NULL,
  `productNummer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `matten`
--

INSERT INTO `matten` (`id`, `aankoopPrijs`, `laatstGecheckt`, `status`, `productNummer`) VALUES
(1, 100, '2019-12-12', 'Goed', 123),
(2, 99, '1999-02-02', 'status', 129),
(3, 99, '1999-02-02', 'status', 129),
(4, 555, '1999-02-02', 'status', 129),
(5, 555, '1999-02-02', 'status', 129),
(6, 555, '1999-02-02', 'Goed', 129),
(7, 555, '1999-02-02', 'Goed', 129),
(8, 555, '1999-02-02', 'Goed', 129),
(9, 555, '1999-02-02', 'Goed', 129);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `matten`
--
ALTER TABLE `matten`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `matten`
--
ALTER TABLE `matten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
