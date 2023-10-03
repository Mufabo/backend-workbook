# Exercise 05

Implement in packaging `greeting`to the existing class `GreetingController`the following functionality:

* A request for a path`/greet`get the parameters`name`and`greeting`.
  As a response to the request, a string is returned, which first
  contains the greeting and then the name.  These are separated by a
  comma.

For example, a request `/greet?greeting=Greetings&name=Earthling`returns a string `Greetings, Earthling`.  Accordingly, the request `/greet?greeting=Oi&name=Mate`returns a string `Oi, Mate`.  The order of the parameters does not matter.