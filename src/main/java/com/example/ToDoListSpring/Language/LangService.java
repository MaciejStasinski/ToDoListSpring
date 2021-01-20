package com.example.ToDoListSpring.Language;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
class LangService {
     private LanguageRepository repository;

      LangService(LanguageRepository repository) {
         this.repository= repository;
     }

     List<LangDTO> findAll(){
         return repository
                 .findAll()
                 .stream()
                 .map(LangDTO::new)
                 .collect(toList());
     }
 }