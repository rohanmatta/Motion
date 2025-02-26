package Model.Support;

public class File {
    private String fileName;
    private java.io.File contents;

    public File(String fileName, java.io.File contents) {
        this.fileName = fileName;
        this.contents = contents;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public java.io.File getContents() {
        return contents;
    }

    public void setContents(java.io.File contents) {
        this.contents = contents;
    }
}
