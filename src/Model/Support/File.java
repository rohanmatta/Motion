package Model.Support;

/**
 * File system for attaching to messages
 * @author Ryan
 */
public class File {
    private String fileName;
    private java.io.File contents;

    /**
     * Default file constructor
     * @param fileName File Name
     * @param contents File Contents
     */
    public File(String fileName, java.io.File contents) {
        this.fileName = fileName;
        this.contents = contents;
    }

    /**
     * Get name of uploaded file
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set file name of uploaded file
     * @param fileName fileName to be used
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get File contents
     * @return File contents
     */
    public java.io.File getContents() {
        return contents;
    }

    /**
     * Set file contents for uploaded file
     * @param contents File Contents
     */
    public void setContents(java.io.File contents) {
        this.contents = contents;
    }

    /**
     * Generic toString implementation
     * @return String representation of file
     */
    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", contents=" + contents +
                '}';
    }
}
