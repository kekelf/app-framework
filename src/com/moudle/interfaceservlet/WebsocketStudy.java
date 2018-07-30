package com.moudle.interfaceservlet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by JiaPeng on 2016/2/15.
 */
@ServerEndpoint("/websocket")
public class WebsocketStudy {
    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {
        System.out.println("Received: " + message);
        session.getBasicRemote().sendText("This is the first server message");

        int sendMessages = 0;
        while (sendMessages < 10) {
            Thread.sleep(1000);
            session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sendMessages);
            sendMessages++;
        }
        session.getBasicRemote().sendText("This is the last server message");
    }

    @OnOpen
    public void OnOpen() {
        System.out.println("Client connected");
    }

    @OnClose
    public void OnClose() {
        System.out.println("Connection closed");
    }
}