SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for schdlr_registry_entry_types
-- ----------------------------
CREATE TABLE `schdlr_registry_entry_types`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  `java_class` varchar(200) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_registry_entries
-- ----------------------------
CREATE TABLE `schdlr_registry_entries`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  `id_type` int(10) UNSIGNED NOT NULL,
  `active` tinyint(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_type`(`id_type`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE,
  CONSTRAINT `schdlr_registry_entries_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `schdlr_registry_entry_types` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_endings
-- ----------------------------
CREATE TABLE `schdlr_endings`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ends_on` date NULL DEFAULT NULL,
  `ends_after_x_times` smallint(5) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_weekday_places_in_month
-- ----------------------------
CREATE TABLE `schdlr_weekday_places_in_month`  (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schdlr_weekday_places_in_month
-- ----------------------------
INSERT INTO `schdlr_weekday_places_in_month` VALUES (1, 'FIRST');
INSERT INTO `schdlr_weekday_places_in_month` VALUES (2, 'SECOND');
INSERT INTO `schdlr_weekday_places_in_month` VALUES (3, 'THIRD');
INSERT INTO `schdlr_weekday_places_in_month` VALUES (4, 'FOURTH');
INSERT INTO `schdlr_weekday_places_in_month` VALUES (5, 'FIFTH');


-- ----------------------------
-- Table structure for schdlr_weekdays
-- ----------------------------
CREATE TABLE `schdlr_weekdays`  (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schdlr_weekdays
-- ----------------------------
INSERT INTO `schdlr_weekdays` VALUES (1, 'MONDAY');
INSERT INTO `schdlr_weekdays` VALUES (2, 'TUESDAY');
INSERT INTO `schdlr_weekdays` VALUES (3, 'WEDNESDAY');
INSERT INTO `schdlr_weekdays` VALUES (4, 'THURSDAY');
INSERT INTO `schdlr_weekdays` VALUES (5, 'FRIDAY');
INSERT INTO `schdlr_weekdays` VALUES (6, 'SATURDAY');
INSERT INTO `schdlr_weekdays` VALUES (7, 'SUNDAY');


-- ----------------------------
-- Table structure for schdlr_months
-- ----------------------------
CREATE TABLE `schdlr_months`  (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of schdlr_months
-- ----------------------------
INSERT INTO `schdlr_months` VALUES (1, 'JANUARY');
INSERT INTO `schdlr_months` VALUES (2, 'FEBRUARY');
INSERT INTO `schdlr_months` VALUES (3, 'MARCH');
INSERT INTO `schdlr_months` VALUES (4, 'APRIL');
INSERT INTO `schdlr_months` VALUES (5, 'MAY');
INSERT INTO `schdlr_months` VALUES (6, 'JUNE');
INSERT INTO `schdlr_months` VALUES (7, 'JULY');
INSERT INTO `schdlr_months` VALUES (8, 'AUGUST');
INSERT INTO `schdlr_months` VALUES (9, 'SEPTEMBER');
INSERT INTO `schdlr_months` VALUES (10, 'OCTOBER');
INSERT INTO `schdlr_months` VALUES (11, 'NOVEMBER');
INSERT INTO `schdlr_months` VALUES (12, 'DECEMBER');


-- ----------------------------
-- Table structure for schdlr_daily
-- ----------------------------
CREATE TABLE `schdlr_daily`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `business_days_only` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `every_x_days` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
  `start` date NOT NULL,
  `id_ending` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  UNIQUE INDEX `id_ending`(`id_ending`) USING BTREE,
  CONSTRAINT `schdlr_daily_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_daily_ibfk_2` FOREIGN KEY (`id_ending`) REFERENCES `schdlr_endings` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_monthly_on_day
-- ----------------------------
CREATE TABLE `schdlr_monthly_on_day`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `on_day` tinyint(4) NOT NULL,
  `every_x_month` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
  `start` date NOT NULL,
  `id_ending` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  UNIQUE INDEX `schdlr_monthly_on_day_ibfk_2`(`id_ending`) USING BTREE,
  CONSTRAINT `schdlr_monthly_on_day_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_monthly_on_day_ibfk_2` FOREIGN KEY (`id_ending`) REFERENCES `schdlr_endings` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_monthly_on_weekday
-- ----------------------------
CREATE TABLE `schdlr_monthly_on_weekday`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `id_weekday_place_in_month` tinyint(3) UNSIGNED NOT NULL,
  `id_weekday` tinyint(3) UNSIGNED NOT NULL,
  `every_x_month` smallint(6) NOT NULL DEFAULT 1,
  `start` date NOT NULL,
  `id_ending` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  INDEX `id_weekday_place_in_month`(`id_weekday_place_in_month`) USING BTREE,
  INDEX `id_weekday`(`id_weekday`) USING BTREE,
  UNIQUE INDEX `id_ending`(`id_ending`) USING BTREE,
  CONSTRAINT `schdlr_monthly_on_weekday_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_monthly_on_weekday_ibfk_2` FOREIGN KEY (`id_weekday_place_in_month`) REFERENCES `schdlr_weekday_places_in_month` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_monthly_on_weekday_ibfk_3` FOREIGN KEY (`id_weekday`) REFERENCES `schdlr_weekdays` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_monthly_on_weekday_ibfk_4` FOREIGN KEY (`id_ending`) REFERENCES `schdlr_endings` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_on_specific_date
-- ----------------------------
CREATE TABLE `schdlr_on_specific_date`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `when` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  CONSTRAINT `schdlr_on_specific_date_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_weekly
-- ----------------------------
CREATE TABLE `schdlr_weekly`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `every_x_week` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
  `start` date NOT NULL,
  `id_ending` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  UNIQUE INDEX `id_ending`(`id_ending`) USING BTREE,
  CONSTRAINT `schdlr_weekly_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_weekly_ibfk_2` FOREIGN KEY (`id_ending`) REFERENCES `schdlr_endings` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_yearly_on_day
-- ----------------------------
CREATE TABLE `schdlr_yearly_on_day`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `every_x_year` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
  `on_day` date NOT NULL,
  `start` date NOT NULL,
  `id_ending` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  UNIQUE INDEX `id_ending`(`id_ending`) USING BTREE,
  CONSTRAINT `schdlr_yearly_on_day_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_yearly_on_day_ibfk_2` FOREIGN KEY (`id_ending`) REFERENCES `schdlr_endings` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for schdlr_yearly_on_month_day
-- ----------------------------
CREATE TABLE `schdlr_yearly_on_month_day`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_registry_entry` int(10) UNSIGNED NOT NULL,
  `id_weekday_place_in_month` tinyint(3) UNSIGNED NOT NULL,
  `id_weekday` tinyint(3) UNSIGNED NOT NULL,
  `id_month` tinyint(3) UNSIGNED NOT NULL,
  `every_x_year` smallint(5) UNSIGNED NOT NULL DEFAULT 1,
  `start` date NOT NULL,
  `id_ending` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_registry_entry`(`id_registry_entry`) USING BTREE,
  INDEX `id_weekday_place_in_month`(`id_weekday_place_in_month`) USING BTREE,
  INDEX `id_weekday`(`id_weekday`) USING BTREE,
  INDEX `id_month`(`id_month`) USING BTREE,
  UNIQUE INDEX `id_ending`(`id_ending`) USING BTREE,
  CONSTRAINT `schdlr_yearly_on_month_day_ibfk_1` FOREIGN KEY (`id_registry_entry`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_yearly_on_month_day_ibfk_2` FOREIGN KEY (`id_weekday_place_in_month`) REFERENCES `schdlr_weekday_places_in_month` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_yearly_on_month_day_ibfk_3` FOREIGN KEY (`id_weekday`) REFERENCES `schdlr_weekdays` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_yearly_on_month_day_ibfk_4` FOREIGN KEY (`id_month`) REFERENCES `schdlr_months` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `schdlr_yearly_on_month_day_ibfk_5` FOREIGN KEY (`id_ending`) REFERENCES `schdlr_registry_entries` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_roman_ci ROW_FORMAT = Compact;
