package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Casella {
    int posizione;

    public static List<Casella> inizializzaBoard() {
        List<Casella> board = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            board.add(new Casella(i));
        }
        return board;
    }
}
