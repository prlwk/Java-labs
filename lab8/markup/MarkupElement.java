package markup;

import java.util.ArrayList;
import java.util.List;

public class MarkupElement {
    private List<InsideParagraph> elements;

    public MarkupElement(List<InsideParagraph> elements) {
        if (elements == null) {
            throw new NullPointerException();
        }
        this.elements = new ArrayList<>();
        this.elements.addAll(elements);
    }

    protected void toMarkdown(StringBuilder stringBuilder, String bound) {
        stringBuilder.append(bound);
        for (InsideParagraph element : elements) {
            element.toMarkdown(stringBuilder);
        }
        stringBuilder.append(bound);
    }
}
