package sawant.mihir.springk8sready.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class WelcomeController {

    @GetMapping("/")
    public Mono<String> sayHello(){
        var dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));
        String welcome = String.format("Hello World, " + dateTime);
        return Mono.just(welcome);
    }
}
