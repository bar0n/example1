-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.29 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              7.0.0.4384
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Дамп данных таблицы exercice1.clients: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`ID`, `LAST_NAME`, `FIRST_NAME`, `PHOTO_PATH`) VALUES
	(1, 'Baron', 'Dmytro', '1.jpg'),
	(2, 'Obama', 'Barak', '2.png');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Дамп данных таблицы exercice1.clients_debt: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `clients_debt` DISABLE KEYS */;
INSERT INTO `clients_debt` (`id`, `client_id`, `debt`) VALUES
	(1, 1, 100.00),
	(2, 2, 122.55);
/*!40000 ALTER TABLE `clients_debt` ENABLE KEYS */;

-- Дамп данных таблицы exercice1.client_details: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `client_details` DISABLE KEYS */;
INSERT INTO `client_details` (`ID`, `CLIENT_ID`, `TEL_TYPE`, `TEL_NUMBER`, `UR_ADDRESS`, `FIZ_ADDRESS`, `EMAIL`, `CITY`, `INN`, `EDRPO`, `COMMENTS`) VALUES
	(1, 1, 'aaa', '211231', 'str Reshil', 'shevchenko', '1@q.1', 'Odessa', '12123124', '234r325', 'very impotant comment'),
	(3, 2, 'aaa', '1231231', 'Stroiteley 3 app 5', '1231', 'supe@kna.com', 'Kiev', '3424', '234242', 'bla bla bla ');
/*!40000 ALTER TABLE `client_details` ENABLE KEYS */;

-- Дамп данных таблицы exercice1.wordtemplate: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `wordtemplate` DISABLE KEYS */;
INSERT INTO `wordtemplate` (`id`, `name`) VALUES
	(1, 'debt temlate 1'),
	(2, 'debt template 2');
/*!40000 ALTER TABLE `wordtemplate` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
