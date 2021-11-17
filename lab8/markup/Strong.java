package markup;

import java.util.List;

public class Strong extends MarkupElement implements InsideParagraph {
    public Strong(List<InsideParagraph> elements) {
        super(elements);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        toMarkdown(stringBuilder, "__");
    }
}
