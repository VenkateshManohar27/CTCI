package com.ven.ctci.chapter7.oodesign.parkinglot;

import com.ven.ctci.chapter7.oodesign.parkinglot.processor.FileProcessor;
import com.ven.ctci.chapter7.oodesign.parkinglot.processor.InputProcessor;
import com.ven.ctci.chapter7.oodesign.parkinglot.processor.RequestProcessor;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class BootUp {

	public static void main(String[] args) {
		RequestProcessor requestProcessor = null;
		
		switch (args.length) {
		case 0:
			requestProcessor = new InputProcessor();
			
			break;

		case 1:
			requestProcessor = new FileProcessor();
			break;

		default:
			throw new IllegalArgumentException();
		}
	}
}
