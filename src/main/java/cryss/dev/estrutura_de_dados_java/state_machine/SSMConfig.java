package cryss.dev.estrutura_de_dados_java.state_machine;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class SSMConfig extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
      states.withStates ()
              .initial (OrderStates.NEW)
              .states (EnumSet.allOf (OrderStates.class))
              .end (OrderStates.COMPLETED)
              .end (OrderStates.CANCELLED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions) throws Exception {
        transitions
                .withExternal ().source (OrderStates.NEW).event (OrderEvents.VALIDATE).target (OrderStates.VALIDATED)
                .action (validateOrderAction())
                .and ()
                .withExternal ().source (OrderStates.VALIDATED).event (OrderEvents.PAY).target (OrderStates.PAID)
                .action (payOrderAction())
                .and ()
                .withExternal ().source (OrderStates.PAID).event (OrderEvents.SHIP).target (OrderStates.SHIPPED)
                .action (shipOrderAction())
                .and ()
                .withExternal ().source (OrderStates.SHIPPED).event (OrderEvents.COMPLETE).target (OrderStates.COMPLETED)
                .and ()
                .withExternal ().source (OrderStates.VALIDATED).event (OrderEvents.CANCEL).target (OrderStates.CANCELLED)
                .and ()
                .withExternal ().source (OrderStates.PAID).event (OrderEvents.CANCEL).target (OrderStates.CANCELLED);
    }

    @Bean
    Action<OrderStates, OrderEvents> validateOrderAction() {
        return stateContext -> {
            System.out.println ("Validating order");
        };
    }

    @Bean
    Action<OrderStates, OrderEvents> payOrderAction() {
        return stateContext -> {
            System.out.println ("paying order");
        };
    }

    @Bean
    Action<OrderStates, OrderEvents> shipOrderAction() {
        return stateContext -> {
            System.out.println ("shipping order");
        };
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderStates, OrderEvents> config) throws Exception {
       config.withConfiguration ().listener (stateMachineListener());
    }

    @Bean
    StateMachineListener<OrderStates, OrderEvents> stateMachineListener() {
        return new StateMachineListenerAdapter<> () {
            @Override
            public void transition(Transition<OrderStates, OrderEvents> transition) {
               if(transition.getSource () != null){
                   System.out.println ("Transition from " + transition.getSource ().getId () + " to " + transition.getTarget ().getId ());
               }
            }
        };
    }


}
