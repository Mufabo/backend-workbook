# Exercise 02

Implement in packaging `hellopath`to the existing class `HelloPathController`the following functionality:

* A request for a path`/path`returns the string "Correct!"

---

---



## Server software paths

The application listens to all requests to the server software if the method used to handle the requests is annotated `@GetMapping`-annotation to which is set as a parameter `"*"`.  In practice `@GetMapping`-annotation
parameter defines the path to which requests to the server can be
directed.  An asterisk indicates that the method in question handles all
requests.  Defining other paths is of course also possible.

By giving `@GetMapping`-annotation path is a string `"/salaisuus"`, all to the web server address `/salaisuus`the requests made are directed to the method with which the annotation in question is.  The example below defines a path `/salaisuus`and tells us that requests to the path return a string `"Kryptos"`.

```java
// pakkaus ja importit

@Controller
public class SalaisuusController {

    @GetMapping("/salaisuus")
    @ResponseBody
    public String home() {
        return "Kryptos";
    }
}
```
