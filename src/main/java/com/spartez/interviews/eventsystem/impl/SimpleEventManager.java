package com.spartez.interviews.eventsystem.impl;

import com.spartez.interviews.eventsystem.Event;
import com.spartez.interviews.eventsystem.EventListener;
import com.spartez.interviews.eventsystem.EventManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simplistic implementation for project structure illustration only.
 *
 * <p>This is <b>not</b> the code you will be working on.
 *
 * <p>When the test starts you will receive a different copy of the project that will contain a much more advanced
 * implementation of the EventManager.
 * It will still be relatively simple (under 100 lines of code in the class) but in contrast to this example class
 * it will actually implement the contract.
 */
public class SimpleEventManager implements EventManager {

    private static final Map<String, EventListener> eventListenersMap = new HashMap<>();

    @Override
    public void publishEvent(Event event) {
        eventListenersMap.forEach((key, value) -> {
            System.out.println("Event was published for: " + key);
            value.handleEvent(event);
        });
    }

    @Override
    public void registerListener(String listenerKey, EventListener listener) {
        eventListenersMap.put(listenerKey, listener);
    }

    @Override
    public void unregisterListener(String listenerKey) {
        eventListenersMap.remove(listenerKey);
    }

    public static void main(String[] args) {

        List<String> keys = Arrays.asList("filip", "kasia", "artur");

        SimpleEventManager simpleEventManager = new SimpleEventManager();

        keys.forEach(it ->
                simpleEventManager.registerListener(it, new EventListenerImpl())
        );

        List<Event> events = Arrays.asList(new GroupEvent(), new SingleEvent(), new FakeEvent());

        events.forEach(simpleEventManager::publishEvent);
    }
}


