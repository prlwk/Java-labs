package markup;

public class Text implements InsideParagraph {
    private String text;

    public Text(String text) {
        if (text == null) {
            throw new NullPointerException();
        }
        this.text = text;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(text);
    }
}
