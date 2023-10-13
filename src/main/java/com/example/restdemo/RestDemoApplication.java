package com.example.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}
//commit 2
    /*

+--------------------------------------------------------------------------------------+
|                                     com.example.restbackend.model                       |
+--------------------------------------------------------------------------------------+
|                                         Patient                                       |
+--------------------------------------------------------------------------------------+
|- id: Long                                                                            |
|- name: String                                                                       |
|- age: int                                                                      |
|- address: String                                                                        |
|- phoneno: varchar                                                                      |
+--------------------------------------------------------------------------------------+
|+ Patient()                                                                              |
|+ ToDoList(title: String, author: String, isbn: String, pageCount: int)                   |
|+ getId(): Long                                                                       |
|+ setId(id: Long): void                                                               |
|+ getTitle(): String                                                                  |
|+ setTitle(title: String): void                                                       |
|+ getAuthor(): String                                                                 |
|+ setAuthor(author: String): void                                                     |
|+ getIsbn(): String                                                                   |
|+ setIsbn(isbn: String): void                                                         |
|+ getPageCount(): int                                                                 |
|+ setPageCount(pageCount: int): void                                                  |
+--------------------------------------------------------------------------------------+


     */

}
