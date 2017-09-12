package com.lightbend.training.coffeehouse;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

public class Guest extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().
                matchAny(this::unhandled).build();
    }

    public static Props props() {
        return Props.create(Guest.class, Guest::new);
    }
}
