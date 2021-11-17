package markup;

import java.util.List;

public class Paragraph extends MarkupElement {

    public Paragraph(List<InsideParagraph> elements) {
        super(elements);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        toMarkdown(stringBuilder, "");
    }
}
