package com.codecool.elgrande.websocket;

import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.websocket.messages.ClientPlayerMovement;
import com.codecool.elgrande.websocket.messages.ServerPlayerMovement;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    private final GameLogic gameLogic;

    public WebSocketController(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @MessageMapping("/playerMovement")
    @SendTo("/topic/playerMovement")
    public ServerPlayerMovement receiveUserEventData(ClientPlayerMovement clientPlayerMovement) {
        System.out.println("WebSocket | " + clientPlayerMovement);  // NOTE: dev code: console log

//        gameLogic.movePlayer(clientPlayerMovement.getPlayerId(), clientPlayerMovement.getDirection());
//        Player movingPlayer = gameLogic.getPlayer(clientPlayerMovement.getPlayerId());
//        ServerPlayerMovement serverPlayerMovement = new ServerPlayerMovement(movingPlayer.getId(), movingPlayer.getX(), movingPlayer.getY());
//
//        System.out.println("WebSocket | " + serverPlayerMovement);  // NOTE: dev code: console log
//        return serverPlayerMovement;
        return null;  // FIXME: update the game with a targetX and a targetY data received from the client
    }

//    NOTE: the code below is an example for sending messages to all active clients
//    @MessageMapping("/playerMovement")
//    @SendTo("/topic/playerMovement")
//    public ServerPlayerMovement receiveUserEventData(ClientPlayerMovement clientPlayerMovement) {
//        System.out.println("WebSocket | " + clientPlayerMovement);  // NOTE: dev code: console log
//        var serverPlayerMovement = new ServerPlayerMovement(0, 0, 0);
//        System.out.println("WebSocket | " + serverPlayerMovement);  // NOTE: dev code: console log
//        return serverPlayerMovement;
//    }
}
