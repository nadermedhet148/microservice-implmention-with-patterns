package com.inventory.service.Aapplication.interfaces;

import com.inventory.service.Domain.Events.DomainEvent;

public interface IEventProducer<T extends DomainEvent> {

    void sendMessage(T event);
}
