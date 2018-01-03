package com.nxs.config;


import com.nxs.enums.Events;
import com.nxs.enums.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

/**
 * @author 57014
 */

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States,Events> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        super.configure(states);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        super.configure(config);
    }




}
