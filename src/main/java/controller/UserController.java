package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/oauth2/token", method = RequestMethod.POST,
        consumes = "application/json")
    public ResponseEntity<String> authorize(@RequestParam(value = "client_id") Long id,
                                            @RequestParam(value = "secret") String secret) {

        return new ResponseEntity<>(userService.authentificate(id, secret), HttpStatus.OK);
    }
}
