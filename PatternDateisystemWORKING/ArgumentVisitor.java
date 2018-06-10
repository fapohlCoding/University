package PatternDateisystem;

/**
 * Fabian Pohl
 */
public interface ArgumentVisitor {

    public static enum Result {
        NEXT, IGNORE, EXIT
    }

    public void visitArgumentType(boolean option);
    public ArgumentVisitor.Result visitArgument(String argument);
    public void onVisitAllArguments();

}