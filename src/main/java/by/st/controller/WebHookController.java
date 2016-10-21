package by.st.controller;

import by.st.util.FbBotConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kramar_YA on 21/10/2016.
 */
@RestController
public class WebHookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebHookController.class);

    @RequestMapping("/")
    public String index() {
        return "Greetings from fbbot!";
    }

    @RequestMapping(value = "/webHook", method = RequestMethod.GET)
    public void webHook(/*@RequestParam String accessToken, @RequestParam SocialNetwork socialNetwork*/){


    }

}
