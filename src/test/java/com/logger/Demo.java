package com.logger;

import org.apache.logging.log4j.*;

public class Demo {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger();
		log.info("This is an info log");
		log.error("This is an error log");
		log.trace("This is an trace log");

	}

}
