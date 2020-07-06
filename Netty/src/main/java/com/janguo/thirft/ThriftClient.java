package com.janguo.thirft;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport tTransport = new TFastFramedTransport(new TSocket("localhost",8899),600);
        TCompactProtocol protocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(protocol);

        try{
            tTransport.open();
            Person person = client.getPersonByUserName("张三");
            System.out.println(person);

            Person person1 = new Person();
            person1.setUsername("李四");
            person1.setAge(55);
            person1.setMarried(true);

            client.savePerson(person1);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }finally {
            tTransport.close();
        }
    }
}
