package com.yunhui;

import org.junit.Before;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

import java.util.stream.Stream;

/**
 * @Date : 2019-08-05 09:11
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Test {


    private Driver driver;


    @Before
    public void before(){
        driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic("neo4j", "1230"));
    }


    @org.junit.Test
    public void test(){
        StatementResult result = driver.session().run("match(p:Person)-[r:IS_MARRIED_TO]->(s:Person) return p,r,s");

        for (Record record : result.list()) {
//            System.out.println(record.get(0));
//            System.out.println(record.get(1));
//            System.out.println(record.get(2));
            Relationship r= record.get("r").asRelationship();
            Node person1=  record.get("p").asNode();
            Node person2= record.get("s").asNode();

            System.out.println(r.asMap());
            System.out.println(person1.asMap());
            System.out.println(person2.asMap());
        }
    }


    @org.junit.Test
    public void test2(){
        StatementResult result = driver.session().run("match(model:CarModel{series:\"奥迪\"})-[s:series_to]-(series:CarSeries) return model,s,series");
        for (Record record : result.list()) {

            Relationship r= record.get("s").asRelationship();
            Node person1=  record.get("model").asNode();
            Node person2= record.get("series").asNode();

            System.out.println(r.asMap());
            System.out.println(person1.asMap());
            System.out.println(person2.asMap());
        }
    }
}
