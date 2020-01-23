package com.spartez.interviews.eventsystem.impl;

import com.spartez.interviews.eventsystem.Event;

public class SingleEvent implements Event {
    @Override
    public String doEvent() {
        return "I am an event for one guy";
    }
}
