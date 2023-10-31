# Exercise 02 06: Hello Form

Tldr: Implement a HTML form with a submit button, that changes the title on the web page

The task base has functionality that allows you to
display information on the page, and with which information sent from
the page can also be processed.  However, a form is needed for the page
to send information.

Implement the assignment template in the folder `src/main/resources/templates`to be `index.html`form to the file.  The form must have a text field whose name must be `content`.
In addition to this, the form must also have a button that can be used
to send the form.  The form information should be sent to the root
address with a POST-type request.

When the application is working correctly, you can change the title displayed on the page using the form.

---

---

can be defined for HTML pages [Forms ](http://www.w3schools.com/html/html_forms.asp) , with which the user can send information to the server.   The definition of the form takes place `form`-
element, which is given as attributes the path to which the form is
sent (action), and the type of request (method).  We keep the request
type as POST for now.

The form can define e.g.  text fields ( `<input type="text"...`) and a button to send the form ( `<input type="submit"...`).  Below the text field `name`- attribute is set to value `nimi`.  This means that when the form's information is sent to the server, it will appear in the request `nimi`- named parameter whose value is the text written in the text field.

```xml
<form action="/" method="POST">
    <input type="text" name="nimi"/>
    <input type="submit"/>
</form>
```

When the above form is shown to the user in the browser, the user sees a
text field and a button.  When the user presses the button, the form
data is sent as a POST-type request to the server to the root address of
the server (action="/").  If you want to change the address to which
the form information is sent, you need an attribute `action`modify the value accordingly.

Web applications are not all located at the root of the server.  The server can have several applications — for example `https://palvelin.net/sovellus1/`and `https://palvelin.net/sovellus2/`can point to different applications.  If at `https://palvelin.net/sovellus2/`"/" is defined as the sending address of the form in the form, the form is sent to the address `https://palvelin.net/`.  This is not desired, because the application of the form is located in the path `https://palvelin.net/sovellus2/`.

With Thymeleaf and Spring, forms can be made independent of the root path of the application.  This is done by defining a form `action`-attribute using Thymeleaf in the form `th:action="@{/}"`.
In this case, when creating the form, the path of the form is defined
based on the location of the application, regardless of the location of
the application.

```xml
<form th:action="@{/}" method="POST">
    <input type="text" name="nimi"/>
    <input type="submit"/>
</form>
```

Now, if the application is located in the path `https://palvelin.net/sovellus2/`, the form visible to the user is changed by Thymeleaf `action`- attribute to "/sovellus2/".  Correspondingly, if the application is located on the server in the path `https://palvelin.net/sovellus1/`, the above definition modifies the form `action`- attribute to the value of the path "/sovellus1/".

The information sent using the form — if the sending method is set to "POST" — will receive an annotation `@PostMapping`through.  Annotation is like `@GetMapping`, but the annotation indicates that the method attached to the path listens for POST-type requests.

For example, the data from the form above, i.e. the parameter sent by the form `nimi`, can be processed with the following method.

```java
@PostMapping("/")
public String post(@RequestParam String nimi) {
    System.out.println(nimi);
    return "index";
}
```

The above method listens for POST type requests to the root path of the application.  It gets a string type `nimi`along with the request for a parameter named  The method prints the value of the parameter `System.out.println`-call and ask Thymeleaf to show the folder `src/main/resources/templates/`file `index.html`.
