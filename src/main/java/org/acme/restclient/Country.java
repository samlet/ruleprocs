package org.acme.restclient;

import java.util.List;

public class Country {

    public String name;
    public String alpha2Code;
    public String capital;
    public List<Currency> currencies;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", capital='" + capital + '\'' +
                ", currencies=" + currencies +
                '}';
    }

    public static class Currency {
        public String code;
        public String name;
        public String symbol;

        @Override
        public String toString() {
            return "Currency{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }
    }
}
