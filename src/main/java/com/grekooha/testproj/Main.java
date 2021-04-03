package com.grekooha.testproj;

public class Main {

    public static void main(String[] args) {
        WorkWithDataBase.addATableIfNone();
        WorkWithDataBase.clearDataFromTheTableTest();
        WorkWithDataBase.fillingInTheTable(500);
        XMLBuilder.build();
        XMLBuilder.Xmlt();
        XMLParser.sumField();
    }
}
