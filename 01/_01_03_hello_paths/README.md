# Exercise 03

Implement in package `_01_03_hello_paths`the following functionality:

* A request for a path`/hello`returns the string "Hello" to the user
* A request for a path`/paths`returns the string "Paths" to the user

The picture below shows an example of a situation where the browser has made a request to the path `/hello`

![](assets/20230913_201248_hello.png)

---

Several paths can be defined for one program.  Each path is handled in its own method.  In the example below, three separate
paths are defined for the class receiving requests, each of which
returns a string to the user.

```java
// pakkaus ja importit

@Controller
public class PolkuController {

    @GetMapping("/path")
    @ResponseBody
    public String path() {
        return "Polku (path)";
    }

    @GetMapping("/route")
    @ResponseBody
    public String route() {
        return "Polku (route)";
    }

    @GetMapping("/trail")
    @ResponseBody
    public String trail() {
        return "Polku (trail)";
    }
}
```
