package com.lightbend.training.coffeehouse;

import akka.actor.AbstractLoggingActor;

public class CoffeeHouse extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {
        return this.receiveBuilder().matchAny(o -> log().info("Coffee Brewing")).build();
    }
}
