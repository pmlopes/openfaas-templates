## Vert.x SVM Function

Implement your functions [MyFunction](src/main/java/acme/MyFunction.java):

```java
public class MyFunction implements Lambda<JsonObject> {

  @Override
  public void handle(Message<JsonObject> event) {
    System.out.println("HEADERS: " + event.headers());
    System.out.println("BODY: " + event.body());
    // Here your business logic...
    event.reply(
      new JsonObject()
        .put("message", "Hello OpenFaaS!"));
  }
}
```

If you rename the function file you will need to update the `META-INF/services`.

### Advanced setup

If your function requires custom GraalVM configuration, update the `pom.xml`.

For more information please consult the GraalVM [native image](http://www.graalvm.org/docs/reference-manual/aot-compilation/) documentation.
