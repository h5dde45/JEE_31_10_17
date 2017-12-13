package vld.p6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class YetAnotherArchiveWriter implements AutoCloseable {
    private final DataOutputStream outputStream;

    public YetAnotherArchiveWriter(Path outputFile) throws IOException {
        this.outputStream = new DataOutputStream(Files.newOutputStream(
                outputFile,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING
        ));
    }

    public void addDirectoryRecursively(Path directory) throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        addFile(file, directory, attrs);
                        return FileVisitResult.CONTINUE;
                    }
                }
        );
    }

    private void addFile(Path file, Path directory, BasicFileAttributes attrs) throws IOException {
        outputStream.writeUTF(directory.relativize(file).toString());
        outputStream.writeLong(attrs.creationTime().toMillis());
        outputStream.writeLong(attrs.lastModifiedTime().toMillis());
//        try (OutputStream fileContentStream=new EmbeddedO){

        }

    @Override
    public void close() throws Exception {

    }
}
