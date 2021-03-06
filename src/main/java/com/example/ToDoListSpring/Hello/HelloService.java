package com.example.ToDoListSpring.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.ToDoListSpring.Language.Language;
import com.example.ToDoListSpring.Language.LanguageRepository;

import java.util.Optional;

@Service
class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Language FALLBACK_LANGUAGE= new Language(1,"Hello","en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LanguageRepository repository;

    HelloService(LanguageRepository repository){
        this.repository=repository;
    }

    String prepareGreeting(String name, Integer langId){
        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANGUAGE.getId());
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANGUAGE).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}
