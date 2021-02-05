CREATE TABLE `test` (
                        `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                        `a` int(11) NOT NULL,
                        `b` bigint(20) UNSIGNED NOT NULL,
                        `c` bigint(20) UNSIGNED NOT NULL,
                        `d` int(10) UNSIGNED NOT NULL,
                        `e` int(10) UNSIGNED NOT NULL,
                        `f` int(10) UNSIGNED NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `a_b` (`a`, `b`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARSET = utf8