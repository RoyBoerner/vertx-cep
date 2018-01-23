package rboerner.vertx.cep.processor;

import io.vertx.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventProcessorVerticle extends AbstractVerticle {

    Logger log = LoggerFactory.getLogger(EventProcessorVerticle.class);

    @Override
    public void start() {
        vertx.eventBus().consumer("event.example", message -> {
            log.info("received: {}", message.body());
        });
        log.info("deployed");
    }

}
