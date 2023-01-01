package sawant.mihir.springk8sready.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
public class StreamController {


    @GetMapping(path = "/stream/data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamData(){
        return Flux.just("Happy New Year", "Happy Birthday", "Merry Christmas", "Happy Ending")
                .delayElements(Duration.ofSeconds(2))
                .repeat();
    }
}
