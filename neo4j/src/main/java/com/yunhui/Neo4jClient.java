package com.yunhui;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;

import java.util.HashSet;
import java.util.Set;

import static org.neo4j.driver.v1.Values.parameters;
/**
 * @Date : 2019-07-16 14:51
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Neo4jClient {

    /**
     * Neo4j Driver, used to create a session that can execute Cypher queries
     */
    private Driver driver;

    /**
     * Create a new Neo4jClient. Initializes the Neo4j Driver.
     */
    public Neo4jClient() {
        // Create the Neo4j driver
        driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic("neo4j", "1230"));
    }


    /**
     * Create a new Person.
     * @param person    The Person to create
     */
    public void createPerson(Person person) {
        // Create a Neo4j session. Because the Session object is AutoCloseable, we can use a try-with-resources statement
        try (Session session = driver.session()) {

            // Execute our create Cypher query
            session.run("CREATE (person: Person {name: {name}, age: {age}})",
                    parameters("name", person.getName(), "age", person.getAge()));
        }
    }

    /**
     * Finds all Person objects in the Neo4j database.
     * @return  A set of all Person objects in the Neo4j database.
     */
    public Set<Person> findAllPeople() {
        // Create a set to hold our people
        Set<Person> people = new HashSet<>();

        // Create a Neo4j session
        try (Session session = driver.session()) {

            // Execute our query for all Person nodes
            StatementResult result = session.run("MATCH(person:Person) RETURN person");

            // Iterate over the response
            for (Record record: result.list()) {
                // Load the Neo4j node from the record by the name "person", from our RETURN statement above
                Node person = record.get("person").asNode();

                // Build a new person object and add it to our result set
                Person p = new Person();
                p.setName(person.get("name").asString());
                if (person.containsKey("age")) {
                    p.setAge(person.get("age").asInt());
                }
                people.add(p);
            }
        }

        // Return the set of people
        return people;
    }

    /**
     * Returns the friends of the requested person.
     *
     * @param person    The person for which to retrieve all friends
     * @return          A Set that contains all Person objects for which there is a FRIEND relationship from
     *                  the specified person
     */
    public Set<Person> findFriends(Person person) {
        // A Set to hold our response
        Set<Person> friends = new HashSet<>();

        // Create a session to Neo4j
        try (Session session = driver.session()) {
            // Execute our query
            StatementResult result = session.run("MATCH (person: Person {name: {name}})-[:FRIEND]-(friend: Person) RETURN friend",
                    parameters("name", person.getName()));

            // Iterate over our response
            for (Record record: result.list()) {

                // Create a Person
                Node node = record.get("friend").asNode();
                Person friend = new Person(node.get("name").asString());

                // Add the person to the friend set
                friends.add(friend);
            }
        }

        // Return the set of friends
        return friends;
    }

    /**
     * Find all movies (with rating) seen by the specified Person.
     *
     * @param person    The Person for which to find movies seen
     * @return          A Set of Movies (with ratings)
     */
    public Set<Movie> findMoviesSeenBy(Person person) {
        Set<Movie> movies = new HashSet<>();
        try (Session session = driver.session()) {
            // Execute our query
            StatementResult result = session.run("MATCH (person: Person {name: {name}})-[hasSeen:HAS_SEEN]-(movie:Movie) RETURN movie.title, hasSeen.rating",
                    parameters("name", person.getName()));

            // Iterate over our response
            for (Record record: result.list()) {

                Movie movie = new Movie(record.get("movie.title").asString());
                movie.setRating(record.get("hasSeen.rating").asInt());
                movies.add(movie);
            }
        }
        return movies;
    }

    /**
     * Helper method that prints a person set to the standard output.
     * @param people    The set of Person objects to print to the standard output
     */
    public static void printPersonSet(Set<Person> people) {
        for (Person person: people) {
            StringBuilder sb = new StringBuilder("Person: ");
            sb.append(person.getName());
            if (person.getAge()>0) {
                sb.append(" is " + person.getAge() + " years old");
            }
            System.out.println(sb);
        }
    }


    /**
     * Test methods
     */
    public static void main(String ... args) {
        Neo4jClient client = new Neo4jClient();
        client.createPerson(new Person("Duke", 22));

        Set<Person> people = client.findAllPeople();
        System.out.println("ALL PEOPLE");
        printPersonSet(people);

        Set<Person> friendsOfMichael = client.findFriends(new Person("Michael"));
        System.out.println("FRIENDS OF MICHAEL");
        printPersonSet(friendsOfMichael);

        Set<Movie> moviesSeenByMichael = client.findMoviesSeenBy(new Person("Michael"));
        System.out.println("MOVIES MICHAEL HAS SEEN:");
        for (Movie movie: moviesSeenByMichael) {
            System.out.println("Michael gave the movie " + movie.getTitle() + " a rating of " + movie.getRating());
        }
    }
}