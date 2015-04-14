package com.vlkan.whatismyuseragent.devicemap.attribute;

import lombok.Getter;

import java.util.function.Predicate;

import static com.vlkan.whatismyuseragent.util.Preconditions.checkNotNull;
import static com.vlkan.whatismyuseragent.util.Predicates.alwaysFalse;
import static com.vlkan.whatismyuseragent.util.Predicates.equalsIgnoreCase;
import static com.vlkan.whatismyuseragent.util.Enumerations.parseEnumeration;

public enum InputDevice implements AttributeMatcher {

    CLICKWHEEL  ("ClickWheel",  equalsIgnoreCase("clickwheel")),
    JOYSTICK    ("JoyStick",    equalsIgnoreCase("joystick")),
    STYLUS      ("Stylus",      equalsIgnoreCase("stylus")),
    TOUCHSCREEN ("Touchscreen", equalsIgnoreCase("touchscreen")),
    UNKNOWN     ("Unknown",     alwaysFalse());

    private final String name;

    @Getter
    private final transient Predicate<String> predicate;

    private InputDevice(String name, Predicate<String> predicate) {
        this.name = checkNotNull(name, "name");
        this.predicate = checkNotNull(predicate, "predicate");
    }

    public static InputDevice parse(String name) {
        return parseEnumeration(name, values(), UNKNOWN);
    }

    @Override
    public String toString() { return name; }

}
