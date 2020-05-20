package domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        Validator.isUniquePlayer(players, player);
        players.add(player);
    }

    public boolean checkPlayers(List<Player> target) {
        return target.equals(players);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
