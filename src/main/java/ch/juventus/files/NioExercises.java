package ch.juventus.files;

import ch.juventus.object.Person;

import java.io.*;
import java.nio.file.*;

public class NioExercises {

    public static void main(String[] args) throws IOException {
        createDirectory();
        createTextFile();
        writeIntoFile();
        renameTextFile();
        readFromFile();
        listContent();
        deleteAll();
        serialize();
        deserialize();
    }

    private static void createDirectory() throws IOException {
        Path dir = Paths.get("src/main/resources/tmp/newDir");
        Files.createDirectories(dir);
        if(Files.exists(dir)) {
            System.out.println("New directory created");
        }
    }

    private static void createTextFile() throws IOException {
        Path file = Paths.get("src/main/resources/tmp/newDir/newFile.txt");
        Files.createFile(file);
        if(Files.exists(file)) {
            System.out.println("New file created");
        }
    }

    private static void writeIntoFile() throws IOException {
        Path file = Paths.get("src/main/resources/tmp/newDir/newFile.txt");
        Files.writeString(file, "hello world");
        Files.writeString(file, "--append this text--", StandardOpenOption.APPEND);
//        Files.writeString(file, "--overwrite this text--");
    }

    private static void renameTextFile() throws IOException {
        Path file = Paths.get("src/main/resources/tmp/newDir/newFile.txt");
        Path renamed = Paths.get("src/main/resources/tmp/newDir/renamedFile.txt");
        Files.move(file, renamed);
        if(Files.exists(renamed)) {
            System.out.println("Renamed file exists");

        }
    }

    private static void readFromFile() throws IOException {
        Path renamed = Paths.get("src/main/resources/tmp/newDir/renamedFile.txt");
        String content = Files.readString(renamed);
        System.out.println("File content: " + content);
    }

    private static void listContent() throws IOException {
        Path dir = Paths.get("src/main/resources/tmp/newDir");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir)) {
            System.out.println("Directory content:");
            for (Path path : directoryStream) {
                System.out.println(path.toString());
            }
        }
    }

    private static void deleteAll() throws IOException {
        Path dir = Paths.get("src/main/resources/tmp");
        deleteDir(dir);
        System.out.println("All deleted!");
    }

    private static void deleteDir(Path dir) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    deleteDir(path);
                } else {
                    Files.delete(path);
                }
            }
        }
        Files.delete(dir);
    }

    private static void serialize() {
        Person person = new Person("Linda", "Krüger");
        String filePath = "src/main/java/ch/juventus/files/person.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(person);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void deserialize() {
        String filePath = "src/main/java/ch/juventus/files/person.ser";

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Person person = (Person) in.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

}
