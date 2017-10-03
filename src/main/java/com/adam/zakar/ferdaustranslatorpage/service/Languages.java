package com.adam.zakar.ferdaustranslatorpage.service;

public enum Languages {
    HUN("hu","HU"),ENG("en","EN"),URD("ur","UR"),PAS("pa","PA"),PER("pe","PE");

    private String locale;
    private String country;

    Languages(String locale, String country) {
        this.locale = locale;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getLocale() {
        return locale;
    }
}
