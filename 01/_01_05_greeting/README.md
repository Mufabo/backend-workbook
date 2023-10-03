# Exercise 05

Implement in packaging `greeting`to the existing class `GreetingController`the following functionality:

* A request for a path`/greet`get the parameters`name`and`greeting`.
  As a response to the request, a string is returned, which first
  contains the greeting and then the name.  These are separated by a
  comma.

For example, a request `/greet?greeting=Greetings&name=Earthling`returns a string `Greetings, Earthling`.  Accordingly, the request `/greet?greeting=Oi&name=Mate`returns a string `Oi, Mate`.  The order of the parameters does not matter.

---

If there are several parameters, they are separated from each other `&`with a sign.  The address below has three parameters, `eka`,  `toka`and `kolmas`, whose values are `1`,  `2`and `3`respectively.

```
http://localhost:8080/salaiusus?eka=1&toka=2&kolmas=3
 
```

An application dealing with several parameters
can be implemented by separating the parameters with commas.  The above
address could be handled, for example, in the following way.

```java
// pakkaus ja importit

@Controller
public class SalaisuusController {

    @GetMapping("/salaisuus")
    @ResponseBody
    public String vastaa(@RequestParam String eka,
                         @RequestParam String toka,
                         @RequestParam String kolmas) {
        return "eka: " + eka + ", toka: " + toka + ", kolmas: " + kolmas;
    }
}
```
