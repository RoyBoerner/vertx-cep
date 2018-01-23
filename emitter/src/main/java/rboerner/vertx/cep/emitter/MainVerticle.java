package rboerner.vertx.cep.emitter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The application entry point.
 *
 * @author rboerner
 */
public class MainVerticle extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(this::accept).listen(8080);
    }

    private void accept(HttpServerRequest req) {
        logger.info("handle {} request", req.method());
        vertx.eventBus().publish("event.example", "Message from Emitter.");
        req.response().end("Hello from Sender!");
    }

}
