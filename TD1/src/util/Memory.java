package util;

import java.io.*;
import java.util.logging.Logger;

/**
 * Based on http://www.jmdoudoux.fr/java/dej/chap-serialisation.htm
 *
 * @author Mireille Blay
 */

public class Memory {

    static Logger monLog = Logger.getLogger(Memory.class.getName());

    private Memory() {
        super();
    }

    /**
     * @param o        to save in a file, it must be serializable
     * @param fileName Name where to write the "object"
     * @throws IOException if input/output error
     */
    public static void save(Object o, String fileName) throws IOException {
        ObjectOutputStream oos = null;
        try (FileOutputStream fichier = new FileOutputStream(fileName)) {
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(o);
            oos.flush();
        }
    }

    /**
     * @param fileName the file to read
     * @return an object corresponding to the serialization written in the file.
     * @throws IOException            if input/output error
     * @throws ClassNotFoundException if class not found
     */
    public static Object read(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        Object o = null;
        File f = new File(fileName);
        if (!(f.isFile())) {
            return null;
        }
        try (FileInputStream fichier = new FileInputStream(fileName)) {
            ois = new ObjectInputStream(fichier);
            o = ois.readObject();
        }
        return o;
    }

}