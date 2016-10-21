package by.st.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Kramar_YA on 10/21/2016.
 */
public final class FbBotConstant {

//    @Value("${fbBotVerifyToken}")
    public static final String FB_VERIFY_TOKEN = "fb_token_for_verify_P@ssw0rd";
//    @Value("${fbPageToken}")
    public static final String FB_PAGE_TOKEN = "EAAYet92FaRMBADz5wyyATHsn4GZCo1UHIA1ribtlZCW3Szwy1iR6YeLXJoYhPRc68HWq6HZCA7psVQVopWecKZCZCJw3a2ylegOSdtbmMqNDq9kgZBdUecNSmuLLklLrtZCvl7dSNHDNanlYjVuZAnigZAb1ddYsZABFcuTG02n9vZCJwZDZD@ssw0rd";
//    @Value("${fbMessageUrl}")
    public static final String FB_MESSAGE_URL = "https://graph.facebook.com/v2.6/me/messages?access_token=";


    public static final HttpClient httpClient = HttpClientBuilder.create().build();
    public static final HttpPost httpPost = new HttpPost(FB_MESSAGE_URL + FB_PAGE_TOKEN);

    private FbBotConstant() {
    }
}
