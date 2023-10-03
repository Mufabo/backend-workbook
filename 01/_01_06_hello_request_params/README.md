# Exercise 06

Implement in packaging `hellorequestparams`to the existing class `HelloRequestParamsController`the following functionality:

* A request for a path`/hello`returns the string "Hello " appended to the user`param`the value contained in the named parameter.
* A request for a path`/params`returns to the user the names and values of all parameters that come with the request.

The picture below shows an example of a situation where the browser has made a request to the path `/params?hello=world&it=works`

![](assets/20230913_201525_params-it-works.webp)