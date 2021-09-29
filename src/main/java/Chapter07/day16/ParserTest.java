package Chapter07.day16;

interface Parseable {
    // 구문 분석작업을 수행한다.
    void parse(String fileName);
}

class ParserManager {
    // 리턴타입이 Parseable 인터페이스이다.
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
            Parseable p = new HTMLParser();
            return p;
            // return new HTMLParser();
        }
    }
}

class XMLParser implements Parseable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - XML parsing completed.");
    }
}

class HTMLParser implements Parseable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - HTML parsing completed.");
    }
}

public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");
        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");
    }
}
