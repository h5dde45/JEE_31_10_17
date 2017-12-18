package slq.n199200;

import java.io.*;

public class Serialization {
    public boolean serialization(Stud stud, String fileName) {
        boolean flag = false;
        File file = new File(fileName);
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(stud);
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Stud deSerialization(String fileName) throws InvalidObjectException {
        File file = new File(fileName);
        try (
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Stud  s = (Stud) ois.readObject();
            return s;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new InvalidObjectException("Object not deserialization");
    }


}
