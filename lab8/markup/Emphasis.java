package markup;

import java.util.List;

public class Emphasis extends MarkupElement implements InsideParagraph {
    public Emphasis(List<InsideParagraph> elements) {
        super(elements);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        toMarkdown(stringBuilder, "*");
    }
}
