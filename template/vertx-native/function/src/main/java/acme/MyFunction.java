package acme;

/*
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import xyz.jetdrone.vertx.lambda.Lambda;

/**
 * This is your main function, implement the handle method with your function.
 *
 * If function composition is required, add more functions and register them
 * in the META-INF/services/io.vertx.core.Handler
 */
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
