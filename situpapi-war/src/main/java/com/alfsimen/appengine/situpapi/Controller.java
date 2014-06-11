package com.alfsimen.appengine.situpapi;

import com.alfsimen.appengine.situpapi.domain.Event;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

@Api(name = "situp", version = "v1")
public class Controller {

    private static List<Event> events = new ArrayList<Event>();

    static {
        events.add(new Event(0, "Event", "Fæst", "med hæst!", new DateTime(2014, 6, 30, 17, 0), new DateTime(2014, 6, 30, 23, 59), "Håvard Halse", "Innebandy", "Håvard Halse", "http://anewlifeinnorway.files.wordpress.com/2009/11/innebandy.gif", "1337", new DateTime(2014, 6, 10, 0, 0)));
        events.add(new Event(1, "Event", "Ælj", "det er hælj!", new DateTime(2014, 7, 5, 17, 0), new DateTime(2014, 7, 5, 23, 59), "Skogen", "Innebandy", "Æljen", "http://www.photosight.org/up/2006/10/23/45689.jpg", "1337", new DateTime(2014, 6, 22, 0, 0)));
        events.add(new Event(2, "Event", "Bowling", "Kom og smell ned noen pinner med oss da vel :D", new DateTime(2014, 7, 5, 17, 0), new DateTime(2014, 7, 5, 23, 59), "Oslo Bowling", "Spillgruppa", "Hilde Drange", "http://www.robbinsdalelanes.com/assets/images/uploads/bowling-action.jpg", "1337", new DateTime(2014, 6, 22, 0, 0)));
    }

    @ApiMethod(path = "event/{id}")
    public Event getEvent(@Named("id") Integer id) {
        return events.get(id);
    }

    @ApiMethod(path = "events")
    public List<Event> getEvents() {
        return events;
    }
}
