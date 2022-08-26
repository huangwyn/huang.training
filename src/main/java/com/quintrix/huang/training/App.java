package com.quintrix.huang.training;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    // lets do a lambda here
    System.out.println("Lets do some lambda!");
    // with a map
    HashMap<String, String> locations = new HashMap<String, String>();
    locations.put("Thanalan", "Ul'Dah");
    locations.put("Black Shroud", "Gridania");
    locations.put("La Noscea", "Limsa Lominsa");
    locations.put("Coerthas", "Ishgard");
    locations.forEach((key, value) -> {
      System.out.println(value + " is in " + key);
    });

    // an alternate usage

    // a stream here
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 31; i++) {
      numbers.add(i);
    }

    // a demo of map
    List<Integer> mapTester = numbers.stream().map(x -> x * x).collect(Collectors.toList());
    System.out.println(mapTester);
    // a demo of filter
    List<Integer> filterTester =
        numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    System.out.println(filterTester);
    System.out.println("mapTester holds " + mapTester.stream().count() + " elements");

    // some messing with the time space continuum here
    LocalTime time = LocalTime.now();
    System.out.println("Time at run: " + time);
    System.out.println("In 8 hours it will be: " + time.plusHours(8));

    // lets try hopping some time zones
    LocalTime japanTokyo = LocalTime.now(ZoneId.of("Japan"));
    System.out.println("It is now " + japanTokyo + " in Japan");

    SqlTest.TrySql();
    SqlTest.InitSql();
    ArrayList<String> departments = new ArrayList<String>();
    departments.add("R&D");
    departments.add("Marketing");
    departments.add("HR");
    departments.add("Accounting");
    for (String dept : departments) {
      SqlTest.SqlUpdate("INSERT INTO departments (dept_name) VALUES ('" + dept + "');");
    }

    SqlTest.SqlUpdate(
        "INSERT INTO employees (department_id, employee_name) VALUES (" + 1 + ",'guy');");
    SqlTest.SqlUpdate(
        "INSERT INTO employees (department_id, employee_name) VALUES (" + 2 + ",'joe');");
    SqlTest.SqlUpdate(
        "INSERT INTO employees (department_id, employee_name) VALUES (" + 3 + ",'billy');");
    SqlTest.SqlUpdate(
        "INSERT INTO employees (department_id, employee_name) VALUES (" + 1 + ",'man');");
    SqlTest.SqlQuery();
    SqlTest.SqlUpdate("DROP TABLE employees");
    SqlTest.SqlUpdate("DROP TABLE departments");

  }
}
