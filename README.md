# JDBC project

Позволяет:
- добавить строку в список,
- вывести все строки на экран,
- редактировать строку (по дабл-клику на ней в таблице),
- удалить выбранные строки,
- искать по id и подстроке.

### Стек технологий:

* Java 8
* Spring Boot
* JDBC
* jQuery
* MySQL
* Thymeleaf
* Flyway
* AJAX

### Запуск проекта:

1. Для приложения необходима БД MySQL. Ее данные нужно указать в application.properties:
~~~~
spring.datasource.url=jdbc:mysql://localhost:3306/DB?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=password
~~~~

2. Далее необходимо установить Maven, если он еще не установлен, и запустить проект из папки, в которой находится проект:
~~~~
cd $HOME_PROJECT
mvn spring-boot:run
~~~~

3. По дефолту сайт будет доступен по порту 8080 (http://localhost:8080).
