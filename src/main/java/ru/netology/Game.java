package ru.netology;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null, player2 = null;

        for (Player player : players) {
            if (playerName1.equals(player.getName())) {
                player1 = player;
                break;
            }
        }

        for (Player player : players) {
            if (playerName2.equals(player.getName())) {
                player2 = player;
                break;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(String.format("Player `%s` not registered", playerName1));
        }

        if (player2 == null) {
            throw new NotRegisteredException(String.format("Player `%s` not registered", playerName2));
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
