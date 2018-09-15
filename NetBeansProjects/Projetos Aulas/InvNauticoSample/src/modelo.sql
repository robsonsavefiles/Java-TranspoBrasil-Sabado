
CREATE TABLE `brand` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `active` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `active` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `component` (
  `id` int(11) NOT NULL auto_increment,
  `equipment_id` int(11) default NULL,
  `short_name` varchar(32) default NULL,
  `location_id` int(11) default NULL,
  `brand_id` int(11) default NULL,
  `full_description` int(11) default NULL,
  `category_id` int(11) default NULL,
  `container_component` tinyint(1) default NULL,
  `rootcomponent_id` int(11) default NULL,
  `price` decimal(11,2) default NULL,
  `index_equipment` int(11) default '1',
  PRIMARY KEY  (`id`),
  KEY `category_id` (`category_id`),
  KEY `equipment_id` (`equipment_id`),
  KEY `brand_id` (`brand_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `component_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `component_ibfk_2` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  CONSTRAINT `component_ibfk_3` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `component_ibfk_4` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `equipment` (
  `id` int(11) NOT NULL auto_increment,
  `short_name` varchar(32) default NULL,
  `description` varchar(255) default NULL,
  `documentation` varchar(255) default NULL,
  `member_id` int(11) default NULL,
  `location_id` int(11) default NULL,
  `index_membership` int(11) default '0',
  PRIMARY KEY  (`id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `location` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `active` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `membership` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL default '',
  `member_data` varchar(255) default NULL,
  `active` tinyint(1) default NULL,
  `site` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



