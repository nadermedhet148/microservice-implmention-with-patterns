package com.order.service.Aapplication.interfaces;

import com.order.service.Domain.Events.DomainEvent;

public interface IEventProducer<T extends DomainEvent> {

    void sendMessage(T event);
}
