package dotoSpring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

@RestController
class HelloServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService service;

    HelloServlet(HelloService service) {
        this.service = service;
    }

    @GetMapping(value = "/api")
    String welcome(@RequestParam(value = "lang", required = false) Integer langId, @RequestParam(required = false) String name) {
        logger.info("Got request");
        return service.prepareGreeting(name, langId);
    }
}
