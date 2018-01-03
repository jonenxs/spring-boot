package com.nxs;

import com.nxs.enums.Events;
import com.nxs.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;

@SpringBootApplication
public class StateMachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StateMachineApplication.class, args);
	}

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... strings) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);
	}
}
