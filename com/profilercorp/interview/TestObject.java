package com.profilercorp.interview;

import java.util.ArrayList;
import java.util.List;

public class TestObject {

    private int id = 1;
    protected String name = "Joe";
    public List<Double> times = new ArrayList<Double>() {{
        add(1.9);
        add(2.5);
        add(5.6);
    }};
    private static final long modificationTime = 2L;

    private final String __cantmodify = "I'm safe";

    public TestObject(String name) {
        this.name = name;
    }

    public String printDescription() {
        StringBuffer description = new StringBuffer();
        description.append("Id=");
        description.append(id);
        description.append("\nName=");
        description.append(name);
        description.append("\nTimes=");
        description.append(times);
        description.append("\nModification time=");
        description.append(modificationTime);
        description.append("\nSafety=");
        description.append(__cantmodify);
        return description.toString();
    }

    public static long getModificationTime() {
        return modificationTime;
    }

    public String amISafe() {
        return __cantmodify;
    }
}
