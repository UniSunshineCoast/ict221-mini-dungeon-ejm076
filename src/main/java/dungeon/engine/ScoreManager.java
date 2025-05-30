package dungeon.engine;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScoreManager {
    private static final String SCORE_FILE = "top_scores.txt";
    private static final int MAX_SCORES = 5;

    public static void saveScore(int score) {
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String entry = score + "," + date;

        List<String> scores = loadRawScores();
        scores.add(entry);

        scores.sort((a, b) -> Integer.compare(
                Integer.parseInt(b.split(",")[0]),
                Integer.parseInt(a.split(",")[0])
        ));

        if (scores.size() > MAX_SCORES)
            scores = scores.subList(0, MAX_SCORES);

        try {
            Files.write(Paths.get(SCORE_FILE), scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadTopScores() {
        List<String> raw = loadRawScores();
        List<String> formatted = new ArrayList<>();
        int rank = 1;
        for (String entry : raw) {
            String[] parts = entry.split(",");
            formatted.add("#" + rank + "  " + parts[0] + "  " + parts[1]);
            rank++;
        }
        return formatted;
    }

    private static List<String> loadRawScores() {
        try {
            return Files.exists(Paths.get(SCORE_FILE))
                    ? Files.readAllLines(Paths.get(SCORE_FILE))
                    : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
