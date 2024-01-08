package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<PlayerAccount> players;
    /**
     * Оскільки склад завжди 1, то він має бути 1 на всю програму один
     */
    private static Storage singleInstance;
    private static final String filepath = "./assets/storage.bin";

    // pattern singleton
    public static Storage getInstance() {
        // create single Instance
        if (Storage.singleInstance == null) {
            Storage.singleInstance = new Storage();
        }
        return Storage.singleInstance;
    }

    private Storage() {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.players = (List<PlayerAccount>) ois.readObject();
        } catch (IOException e) {
            this.players = new ArrayList<>();
        }  catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPlayerPresent(String nickname) {
        // TODO: isPlayerPresent()
        return false;
    }

    public PlayerAccount getPlayer(String nickname) {
        // TODO: getPlayer()
        return null;
    }

    public void saveNewPlayer(PlayerAccount player) {
        // TODO: saveNewPlayer()
    }

    public void saveChanges() {
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(players);

            oos.flush();
            fos.flush();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
