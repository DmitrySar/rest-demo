package com.example.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Person addMeesageToPerson(int personId, Message message) {
        Person person = repository.findById(personId).get();
        message.setPerson(person);
        message.setTime(LocalDateTime.now());
        person.addMessage(message);
        return repository.save(person);
    }
}
