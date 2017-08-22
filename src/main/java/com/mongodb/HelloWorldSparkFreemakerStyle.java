package com.mongodb;

import static spark.Spark.get;

/**
 * Created by andre on 14/08/2017.
 */
public class HelloWorldSparkFreemakerStyle {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hello World From Spark");
    }
}
