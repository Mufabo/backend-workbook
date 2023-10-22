# Exercise 02 04: Hello Lists

The task base is the starting point for the application, to which you can add data and which can list data.

Add (1) functionality to the method that handles GET type incoming to the root path, which makes the list variable in the controller available to Thymeleaf. After that, add (2) to the application related HTML page to print the values in the list th:each- command.

The task base also shows functionality for sending data to the server. We will delve into this in more detail in the next subsection.

---

---


## Displaying collections on Thymeleaf

Collections
of values can also be set for the Model object.  Below, we create a
list in the "main program" that is set to the Model object that
Thymeleaf handles with each request to the root path.

```java
package thymeleafdata;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListaController {
    private List<String> lista;

    public ListaController() {
        this.lista = new ArrayList<>();
        this.lista.add("Hello world!");
        this.lista.add("+[-[<<[+[--->]-[<<<]]]>>>-]>-.---.>..>.<<<<-.<+.>>>>>.>.<<.<-.");
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("lista", lista);
        return "index";
    }
}
```

Traversing the list in Thymeleaf is done by attribute `th:each`through.
Its definition gets the name of the variable in which the item to be
taken from the collection is stored at each iteration, as well as the
collection to be traversed.  In terms of basic syntax `th:each`is as follows.

```xml
<p th:each="alkio : ${lista}">
    <span th:text="${alkio}">hello world!</span>
</p>
```

Above we use an attribute named `lista`and
for each element it contains, we create a p-element, inside which there
is a span element whose text is the value of the element.  Attribute `th:each`can be set to virtually any repeatable element.  For example, an HTML list could be made in the following way.

```xml
<ul>
    <li th:each="alkio : ${lista}">
        <span th:text="${alkio}">hello world!</span>
    </li>
</ul>
```

More about going through collections can be found in the Thymeleaf documentation, see [ https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#iteration ](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#iteration) .

The classic mistake `th:each`when using ia, the set to be iterated over is defined as a string `th:each="alkio : lista"`.  This obviously doesn't work.
