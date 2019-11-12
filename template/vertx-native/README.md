## Template: vertx-native

The vertx-native template uses Eclipse Vert.x as a base framework to build native (no JVM) java functions. The template uses Apache maven as build tool.

Eclipse Vert.x: 3.7.1
GraalVM version: 19.1.0
Maven version: 3.5.0

### Structure

The project is self contained. The `MyFunction.java` source file is a plain java class that implements a vert.x `Lambda`, in the `handle` method you should write your function body and the [event](https://vertx.io/docs/apidocs/io/vertx/core/eventbus/Message.html) will provide you all the information from the request.

For more complex scenarios where you would prefer to organize your code into smaller subfunctions just create more handlers and register them into the service loader and follow vert.x eventbus messaging semantics.

### External dependencies

External dependencies can be specified in `pom.xml` in the normal way using maven.

