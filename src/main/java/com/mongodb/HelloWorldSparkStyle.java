package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.halt;

/**
 * Created by andre on 14/08/2017.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemakerStyle.class, "/");

        get("/", (req, res) -> {

                    StringWriter writer = new StringWriter();
                    Map<String, Object> helloMap = new HashMap<>();
                    helloMap.put("name","Freemaker");
                    try {
                        Template helloTemplate = configuration.getTemplate("hello.ftl");
                        helloTemplate.process(helloMap, writer);
                    } catch (IOException e) {
                        halt(500);
                    }
                    return writer;
                }
        );
    }
}
