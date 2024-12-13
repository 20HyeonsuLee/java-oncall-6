package oncall.view;

public class StringBuilderPrinter {
    private final StringBuilder stringBuilder = new StringBuilder();

    public void appendLine(String line) {
        stringBuilder.append(line).append('\n');
    }

    public void print() {
        System.out.println(stringBuilder);
    }
}
