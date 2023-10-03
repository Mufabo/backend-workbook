# Exercise 04

Implement in packaging `hellorequestparam`to the existing class `HelloRequestParamController`the following functionality:

* A request for a path`/hello`returns the string "Hello " appended to the user`param`the value contained in the named parameter.


## Request parameters

Information can be sent to the server as request parameters.  Let's first
familiarize ourselves with the way in which the request parameters are
added to the address.

For example, in a request `http://localhost:8080/salaisuus?onko=nauris`is a parameter called `onko`, whose value is defined as the value `nauris`.

Adding parameters to the request is done by adding a question mark after the
address, followed by the name of the parameter, an equal sign and the
value to be given to the parameter.   The parameters in the request can
be accessed [ using the @RequestParam ](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html) annotation.

The application in the example below greets all requesters.  The program handles the path `/hei`incoming requests and returns a greeting in response.  The following is added to the greeting in the request `nimi`-parameter value.

```java
package parametrit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TervehtijaController {

    @GetMapping("/hei")
    @ResponseBody
    public String tervehdi(@RequestParam String nimi) {
        return "Hei " + nimi + ", mitä kuuluu?";
    }
}
```

Now, for example, to the address `http://localhost:8080/hei?nimi=Ada`the request will receive a string as a response `Hei Ada, mitä kuuluu?`.
