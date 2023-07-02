package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private final Game game = new Game();

    public GameTest() {
        game.register(new Player(1, "Андрей", 10));
        game.register(new Player(2, "Иван", 20));
        game.register(new Player(3, "Костя", 30));
        game.register(new Player(4, "Кирилл", 20));
    }

    @Test
    public void shouldWinPlayer1() {
        int actual = game.round("Иван", "Андрей");
        assertEquals(1, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        int actual = game.round("Андрей", "Иван");
        assertEquals(2, actual);
    }

    @Test
    public void shouldDeadHeatPlayers() {
        int actual = game.round("Иван", "Кирилл");
        assertEquals(0, actual);
    }

    @Test
    public void notRegisteredException() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Андрей", "Саша");
        });

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Андрей");
        });
    }
}
