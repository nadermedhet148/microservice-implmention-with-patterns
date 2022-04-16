package com.payments.service.Aapplication.interfaces;

import com.payments.service.Domain.Events.DomainEvent;

public interface IEventProducer<T extends DomainEvent> {

    void sendMessage(T event);
}
