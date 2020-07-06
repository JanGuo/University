package com.janguo.thirft;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import thrift.generated.DataExcption;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {


    @Override
    public Person getPersonByUserName(String username) throws DataExcption, TException {
        System.out.println("Got Client Param: " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataExcption, TException {

        System.out.println("Got Client Param: ");
        System.out.println(person.getAge());
        System.out.println(person.getUsername());
        System.out.println(person.isMarried());
    }
}
