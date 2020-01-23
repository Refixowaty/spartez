package com.spartez.interviews.eventsystem.impl;

import com.spartez.interviews.eventsystem.Event;

public class FakeEvent implements Event {
    @Override
    public String doEvent() {
        return "Haha, it's joke. Nothing happen";
    }
}
