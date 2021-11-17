package markup;

import java.util.List;

public class Strikeout extends MarkupElement implements InsideParagraph {

    public Strikeout(List<InsideParagraph> elements) {
        super(elements);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        toMarkdown(stringBuilder, "~");
    }
}
