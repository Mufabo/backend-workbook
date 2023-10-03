# Exercise 07

Implement this task in the package `square`located `SquareController`-category the following functionality:

* A request for a path`/square`counts as a parameter`num`the
  second power of the value of the variable to be obtained and returns it
  to the user.  Note that the value is a number, and it should also be
  treated as a number.

---



The types of parameters can be defined in the method
handling the request.  If we know that the method receives an integer
value as a parameter, it can be defined as an integer.  For example, the
method receiving name and age would be defined in the following way.

```java
@GetMapping("/tervehdi")
@ResponseBody
public String tervehdi(@RequestParam String nimi, @RequestParam Integer ika) {
    return "Hei " + nimi + ", olet " + ika + " vuotta vanha.";
}
```

Note!  Above the integer parameter is defined `Integer`-type.  This is because in this case the value can in principle be `null`.  For elementary reading type `int`- variable cannot be set `null`-value, which could appear as a very cryptic error message.
