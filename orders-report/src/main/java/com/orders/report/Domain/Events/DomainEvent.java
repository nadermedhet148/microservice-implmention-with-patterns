package com.orders.report.Domain.Events;

public abstract class DomainEvent {
    public String eventName;

    public String getEventName() {
        return eventName;
    }
}
