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
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import xyz.jetdrone.vertx.lambda.Lambda;

import java.util.ServiceLoader;

@RunWith(VertxUnitRunner.class)
public class MyFunctionTest {

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Before
  public void beforeTest() {
    // register all lambda's into the eventbus
    ServiceLoader<Lambda> serviceLoader = ServiceLoader.load(Lambda.class);
    for (Lambda fn : serviceLoader) {
      fn.init(rule.vertx());
      rule.vertx().eventBus().localConsumer(fn.getClass().getName(), fn);
    }
  }

  @Test
  public void shouldGetAnEchoMessage(TestContext should) {
    final Async test = should.async();
    final EventBus eb = rule.vertx().eventBus();

    eb.<JsonObject>send(MyFunction.class.getName(), new JsonObject(), msg -> {
      if (msg.failed()) {
        should.fail(msg.cause());
      } else {
        // TODO: validate your reply
        test.complete();
      }
    });
  }
}
