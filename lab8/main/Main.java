package main;

import markup.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph(List.of(
                new Strong(List.of(
                        new Text("1"),
                        new Strikeout(List.of(
                                new Text("2"),
                                new Emphasis(List.of(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                        )),
                        new Text("6")
                ))
        ));
        StringBuilder stringBuilder = new StringBuilder();
        paragraph.toMarkdown(stringBuilder);
        String first = stringBuilder.toString();
        System.out.println(first);
    }
}
