# Exercise 01

When the server receives a request for any path, the server should return the string "Hello World!"


![](assets/20230913_202211_hello-world.webp)

---
---



Inversion of Control and Dependency Injection

Inversion of Control is a principle found in software frameworks, where the responsibility for creating program parts and communication between program parts is transferred to the software framework. In practice, this means that the application framework is responsible for the control of the created things and the execution of the program. In this case, the programmer does not have to pay attention to all the details. At the same time, on the other hand, understanding the execution of the program requires some kind of understanding of the operation of the application framework.

In the Spring application framework, Inversion of Control shows e.g. in that the programmer implements classes within the application framework, but does not, for example, create objects from them. The creation of objects is mainly the responsibility of the Spring application framework.

Dependency Injection is a design model where dependencies are injected into the application. In the simplest terms, this means that object variables of classes are not created in e.g. constructors, but are given as a parameter of the constructor or as a parameter of e.g. a setter.

In the case of the Spring application framework, Inversion of Control and Dependency Injection together create a situation where the application framework creates objects from classes and injects them for use by the application. This reduces the unnecessary dependencies of objects, which makes it easier to test applications, for example.
Read more on the subject in James Shore 's blog and Martin Fowler's article.
Creating a Spring Boot project
New Spring Boot projects are typically created on the Spring Initializr page, where the user can select the tool used for translation ( Maven , Gradle ), the programming language used by the project (Java, Kotlin, Groovy), the version of Spring Boot, and the components used by the project (e.g. databases, login , ...).

In the course, we use Maven to compile the applications and Java as the programming language. We use Spring Boot version 2.3.2. The components used by our projects grow with our projects.
Maven and the project base
In this course, we use Maven to retrieve ready-made libraries and manage projects. In new projects, however, you should use the Spring Initializr service mentioned above, but the task templates used in the course contain the necessary dependencies.

When the Spring application is configured correctly (e.g. using the Spring Initializr service), the Spring project can be started from the command line with the command mvn spring-boot:run. project is used In this case — when a Spring Devtools — the application automatically restarts in connection with changes.

The programs can also be downloaded to NetBeans, where they work like the tasks of other programming courses.
The first server software

The first server software — or application code — can seem a bit complicated at first. An application that starts the server and returns the text "Hello World!" to the user when viewed through a browser looks like the following.


```java
package heimaailma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HeiMaailmaController {

@GetMapping("*")
@ResponseBody
public String home() {
    return "Hei Maailma!";
}

public static void main(String[] args) throws Exception {
    SpringApplication.run(HeiMaailmaController.class, args);
}
}
```

The class also contains what is needed to start the application framework main-method that is used to process requests home-method. Let's break the application into smaller parts and separate the class that receives requests and the class used to start the application from each other.

```java
package heimaailma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeiMaailmaApplication {

public static void main(String[] args) throws Exception {
    SpringApplication.run(HeiMaailmaApplication.class, args);
}
}
```

Spring Boot applications need to start main-method in which is called SpringApplication-class runmethod. The method is given as a parameter a class that contains @SpringBootApplication-annotation — the annotation is used to configure the application; here we go with the default settings.

Launching the application looks for the classes that it will load for its use. The categories are marked e.g. @Controller- annotation, which indicates that the class contains methods that handle requests to the server.

Below is an example of such a class.

```java
package heimaailma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeiMaailmaController {

@GetMapping("*")
@ResponseBody
public String home() {
    return "Hei Maailma!";
}
}
```

A class that receives requests HeiMaailmaControllerhas been marked @Controller- annotation. Based on this, the Spring application framework knows that the methods of the class may handle requests made from the browser, and Spring takes responsibility for directing the requests to the methods of the class.

To class HeiMaailmaControlleris a defined method home, which has two annotations: @GetMappingand @ResponseBody. Annotation @GetMappingis used to define the listening path and the request method of the HTTP protocol. All HTTP GET requests are directed to that method because of the annotation @GetMappingis an additionally defined parameter "*". Instead of a star, you could also define, for example, a path as a parameter.

Annotation @ResponseBodytells the application framework that the method's response should be displayed as a response as is.
