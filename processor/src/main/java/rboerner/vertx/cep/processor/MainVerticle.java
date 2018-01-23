package rboerner.vertx.cep.processor;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rboerner
 */
public class MainVerticle extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start() {
        vertx.deployVerticle(new EventProcessorVerticle());
        vertx.createHttpServer().requestHandler(this::handleRequest).listen(config().getInteger("http.port", 8081));
    }

    private void handleRequest(HttpServerRequest httpServerRequest) {
        httpServerRequest.response().end("Hello from Processor!");
    }

}