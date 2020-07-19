package pt.jpborges.configserver.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.jpborges.configserver.responses.Response;
import pt.jpborges.configserver.services.PingService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ping")
public class PingController {

    @Autowired
    private PingService pingService;

    @GetMapping(value = "/")
    public ResponseEntity<Response<String>> ping() {
        Response<String> response = new Response<String>();
        response.setData("config: " + pingService.testConfigService() + "\nmongo: " + pingService.testMongoService());

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{service}")
    public ResponseEntity<Response<String>> ping(@PathVariable("service") String service) {

        Response<String> response = new Response<String>();

        switch (service) {
            case "config":
                response.setData("config: " + pingService.testConfigService()); break;
            case "mongo":
                response.setData("mongo: " + pingService.testMongoService()); break;
            default:
                response.setErrors(Arrays.asList("No such service"));
        }

        if(response.getData() == null){
            return ResponseEntity.badRequest().body(response );
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping(value = "/mongodb")
    public ResponseEntity<Response<String>> mongodb()  {
        Response<String> response = new Response<String>();

        String json = new Gson().toJson(pingService.testData() );

        response.setData(json);

        return ResponseEntity.ok(response);
    }


}
