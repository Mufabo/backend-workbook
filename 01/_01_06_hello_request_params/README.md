# Exercise 06

Implement in packaging `hellorequestparams`to the existing class `HelloRequestParamsController`the following functionality:

* A request for a path`/hello`returns the string "Hello " appended to the user`param`the value contained in the named parameter.
* A request for a path`/params`returns to the user the names and values of all parameters that come with the request.

The picture below shows an example of a situation where the browser has made a request to the path `/params?hello=world&it=works`

![](assets/20230913_201525_params-it-works.webp)

---

If the parameters are not known, the parameters in the request can be used, e.g. `@RequestParam`-annotation, what follows `Map`-data structure.  In the example below, the parameters of the request are set `Map`-data structure, after which all the keys of the request parameters are returned to the requester.

```java
// pakkaus ja importit

@Controller
public class PyyntoParametrienNimetController {

    @GetMapping("/nimet")
    @ResponseBody
    public String nimet(@RequestParam Map<String, String> parametrit) {
        return parametrit.keySet().toString();
    }
}
```

This parameter manipulation may seem like magic at first.  In reality,
however, a significant amount of logic has been implemented in the
application framework, on the basis of which the parameters in the
request are identified and added as parameters of the method intended
for processing the request.
