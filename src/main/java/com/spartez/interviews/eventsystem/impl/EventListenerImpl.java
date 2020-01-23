package com.spartez.interviews.eventsystem.impl;

import com.spartez.interviews.eventsystem.Event;
import com.spartez.interviews.eventsystem.EventListener;

public class EventListenerImpl implements EventListener {

    @Override
    public void handleEvent(Event event) {
        System.out.println("Handling event...: " + event.doEvent());
    }

    @Override
    public Class[] getHandledEventClasses() {
        Class[] tab = new Class[3];
        tab[0] = GroupEvent.class;
        tab[1] = SingleEvent.class;
        tab[2] = FakeEvent.class;
        return tab;
    }
}
