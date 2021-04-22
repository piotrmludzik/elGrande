package com.codecool.geekofplanets.network.websocket.controller;

import com.codecool.geekofplanets.game.controller.GameController;
import com.codecool.geekofplanets.network.websocket.messages.ClientMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {
    private final GameController gameController;

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketController(GameController gameController, SimpMessagingTemplate messagingTemplate) {
        this.gameController = gameController;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/playerMovement")
    public void receiveMessage(Principal principal, ClientMsg clientMsg) throws  Exception {
        System.out.println("WebSocket | " + clientMsg);  // NOTE: dev code: console log
        gameController.receiveMessage(principal.getName(), clientMsg);
    }

//    @MessageMapping("/playerMovement")
//    public void greeting(Principal principal, ClientPlayerMovement clientPlayerMovement) throws  Exception {
//        System.out.println("WebSocket | " + clientPlayerMovement);  // NOTE: dev code: console log
//
//        gameLogic.movePlayer(principal.getName(), Direction.getDirection(clientPlayerMovement.getDirection()));
//        Player movingPlayer = gameController.getPlayer(principal.getName());
//        ServerPlayerMovement serverPlayerMovement = new ServerPlayerMovement(movingPlayer.getName(), movingPlayer.getField().getX(), movingPlayer.getField().getY());
//
//        System.out.println("WebSocket | " + serverPlayerMovement);  // NOTE: dev code: console log
//        messagingTemplate.convertAndSendToUser(movingPlayer.getName(), "/queue/reply", serverPlayerMovement);
//    }

}
