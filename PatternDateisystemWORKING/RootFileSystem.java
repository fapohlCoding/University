package PatternDateisystem;

//An abstract representation of file and directory pathnames. 
import java.io.File;

/**
 * @author Fabian Pohl
 */
public class RootFileSystem {

    private File file;

    /**
     * Creates a root file system with the specified file.
     * @param file
     */
    public RootFileSystem(File file) {
        setupRoot(file);
    }

    /**
     * Setups the file which represents the root directory where to
     * do the listing on.
     * @param file the root directory
     */
    private void setupRoot(File file) {
        if(file != null && file.exists()) { 		// The java.io.File.exists() method tests the existence 
            this.file = file;						// of the file or directory defined by this abstract pathname.
        } else if(file == null) {
            throw new NullPointerException("root file is null");
        } else if(!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist on file system");
        }
    }

    /**
     * Accepts the file visitor.
     * @param visitor the visitor
     */
    public void accept(FileVisitor visitor) {
        recurse(file, visitor);
    }

    /**
     * Recursively visits the directories and calls the different methods
     * of the passed file visitor.
     * @param current the current directory
     * @param visitor the file visitor
     * @return the instruction to the file system
     */
    private FileVisitor.Result recurse(File current, FileVisitor visitor) {
        //if file or visitor is null
        if(current == null || visitor == null) {
            return FileVisitor.Result.EXIT;
        }
        //if file cant be read
        if(!current.canRead()) {
            return FileVisitor.Result.EXIT;
        }

        if(current.isFile()) {
            return visitor.visit(current);
        } else {
            //pre visit
            FileVisitor.Result result = visitor.onPreVisit(current);
            switch(result) {
                case NEXT:
                    File[] files = current.listFiles();
                    if(files != null) {
                        for(File file : files) {
                            //recursively visit subdirectories and files
                            FileVisitor.Result subResult = recurse(file, visitor);
                            if(subResult == FileVisitor.Result.EXIT) {
                                return FileVisitor.Result.EXIT;
                            }
                        }
                        //post visit
                        result = visitor.onPostVisit(current);
                    }
                    break;
            }
            return result;
        }
    }

}