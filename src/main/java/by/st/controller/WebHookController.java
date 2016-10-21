package by.st.controller;

import by.st.util.FbBotConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Kramar_YA on 21/10/2016.
 */
@RestController
public class WebHookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebHookController.class);

    /**
     * Verify webhook
     */
    @RequestMapping(value = "/webHook", method = RequestMethod.GET)
    public void webHookGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String queryString = request.getQueryString();
        String msg = "";
        if (queryString != null) {
            String verifyToken = request.getParameter("hub.verify_token");
            String challenge = request.getParameter("hub.challenge");
            if (StringUtils.equals(FbBotConstant.FB_VERIFY_TOKEN, verifyToken) && !StringUtils.isEmpty(challenge)) {
                msg = challenge;
            }
        }
        response.getWriter().write(msg);
        response.getWriter().flush();
        response.getWriter().close();
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/webHook", method = RequestMethod.POST)
    public void webHookPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuilder jb = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FbMsgRequest fbMsgRequest = new Gson().fromJson(jb.toString(),
                FbMsgRequest.class);
        if (fbMsgRequest == null) {
            System.out.println("fbMsgRequest was null");
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }


    }

}
