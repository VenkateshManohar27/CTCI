package com.ven.ctci.chapter7.oodesign.parkinglot.processor;

import java.util.HashMap;

public class AbstractRequestProcessor implements RequestProcessor {
	HashMap<String, Command> commands;
	
	public AbstractRequestProcessor() {
		super();
		commands = new HashMap<>();
		commands.put(key, Command.CREATE_PARKING_LOT);
	}
	
	
	@Override
	public void process() {
		// TODO Auto-generated method stub

	}

}
