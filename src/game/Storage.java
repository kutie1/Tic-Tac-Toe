package game;

import java.util.List;

public class Storage {
    private List<String> players;
    private static final String filepath;

    static {
        filepath = "./assets/storage.bin";
    }
}
