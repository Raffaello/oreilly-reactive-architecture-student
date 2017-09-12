package com.lightbend.training.coffeehouse;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

import static com.google.common.base.Preconditions.checkNotNull;

public class Waiter extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(ServeCoffee.class, serveCoffee ->
                        sender().tell(new CoffeeServed(serveCoffee.coffee), self())
                ).build();
    }

    public static Props props() {
        return Props.create(Waiter.class, Waiter::new);
    }

    public static final class ServeCoffee {
        public final Coffee coffee;

        public ServeCoffee(final Coffee coffee) {
            checkNotNull(coffee, "Coffee cannot be null");

            this.coffee = coffee;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServeCoffee that = (ServeCoffee) o;

            return coffee != null ? coffee.equals(that.coffee) : that.coffee == null;
        }

        @Override
        public int hashCode() {
            return coffee != null ? coffee.hashCode() : 0;
        }
    }

    public static final class CoffeeServed {
        public final Coffee coffee;

        public CoffeeServed(final Coffee coffee) {
            this.coffee = coffee;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CoffeeServed that = (CoffeeServed) o;

            return coffee != null ? coffee.equals(that.coffee) : that.coffee == null;
        }

        @Override
        public int hashCode() {
            return coffee != null ? coffee.hashCode() : 0;
        }
    }
}
