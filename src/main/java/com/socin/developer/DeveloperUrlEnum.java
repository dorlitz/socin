package com.socin.developer;

import java.util.Arrays;
import java.util.HashMap;

public enum DeveloperUrlEnum {

    UNKNOWN(0, "unknown"),
    GIT_SERVER(1, "https://api.github.com/"),
    URL_SEARCH_DEVS(2, GIT_SERVER.urlValue.concat("search/users"));

    private String urlValue;
    private int position;

    private static HashMap<Integer, DeveloperUrlEnum> enumByPosition = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> enumByPosition.put(e.getPosition(), e));
    }

    public static DeveloperUrlEnum getByPosition(int position) {
        return enumByPosition.getOrDefault(position, UNKNOWN);
    }

    DeveloperUrlEnum(int position, String urlValue){
        this.urlValue = urlValue;
        this.position = position;
    }

    public void setUrlvalue(String urlValue) {
        this.urlValue = urlValue;
    }

    public String getUrlValue() {
        return this.urlValue;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
