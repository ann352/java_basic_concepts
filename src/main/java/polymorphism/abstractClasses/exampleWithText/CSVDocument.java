package polymorphism.abstractClasses.exampleWithText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVDocument {
    //we have text -> list of lists(rows)
    private List<List<String>> linesOfText = new ArrayList<>();
    private String delimeter = ",";

    //'String...' it means that zero or more String objects (or a single array of them) may be passed as the argument
    //we add new row to the list

    public void addNewLine(String... columnValues) { //we add by that method new rows
        linesOfText.add(Arrays.asList(columnValues));//we add to list new line of strings
    }

    public String asText() { //we change all the lines to text
        if (!linesOfText.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (List<String> singleLine : linesOfText) {
                stringBuilder
                        .append(rowToString(singleLine)) //we use here private method below
                        .append("\n");
            }
            return stringBuilder.toString();
        }
        return "";
    }

    private String rowToString(List<String> row) { //we change single row to text
        return String.join(delimeter, row);
    }
}
