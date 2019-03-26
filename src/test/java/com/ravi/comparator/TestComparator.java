package com.ravi.comparator;

import com.ravi.dto.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestComparator {

    private List<Person> getPersonList(){

        List<Person> personList = new ArrayList();
        personList.add(new Person(14,"Dan", "Smith", "dan_smith@mail.com"));
        personList.add(new Person(22, "Andi", "Barrington", "andi_barrington@hotmail.com"));
        personList.add(new Person(19,"Bob", "Fisher", "itsbob@gmail.com"));
        personList.add(new Person(34,"Debby", "Teske", "debby4all@yahoo.com"));
        personList.add(new Person(56, "Bob", "Anderson", "andersonbob@outlook.com"));
        personList.add(new Person(20, "Barry", "Kensington", "kensingtonofficial@rediffmail.com"));
        personList.add(new Person(40,"Cathy", "Amber", "amber_cathie@gmail.com"));
        personList.add(new Person(70,"Bob", "Simpson", "bobbysimpson@aol.com"));
        personList.add(new Person(22,"Barry", "Frank", "frankbarry@hotmail.com"));
        return personList;
    }


    @Test
    public void testOnAgeSort(){
        List<Person> personList = getPersonList();
        Comparator<Person> personComparator = GenericComparator.getComparator(Person.class, "age", true);
        Collections.sort(personList, personComparator);
        System.out.println("The list sorted on age:"+personList);
        assertEquals(personList.get(0).getAge(), 14);
    }

    @Test
    public void testOnAgeSortDescending(){
        List<Person> personList = getPersonList();
        Comparator<Person> personComparator = GenericComparator.getComparator(Person.class, "age", false);
        Collections.sort(personList, personComparator);
        System.out.println("The list sorted on age in descending order:"+personList);
        assertEquals(personList.get(0).getAge(), 70);
    }

    @Test
    public void testOnFirstNameSort(){
        List<Person> personList = getPersonList();
        Comparator<Person> personComparator = GenericComparator.getComparator(Person.class, "firstName", true);
        Collections.sort(personList, personComparator);
        System.out.println("The list sorted on first name:"+personList);
        assertEquals(personList.get(0).getFirstName(), "Andi");
    }

    @Test
    public void testOnEmailSort(){
        List<Person> personList = getPersonList();
        Comparator<Person> personComparator = GenericComparator.getComparator(Person.class, "email", true);
        Collections.sort(personList, personComparator);
        System.out.println("The list sorted on email:"+personList);
        assertEquals(personList.get(0).getEmail(), "amber_cathie@gmail.com");
    }
}
