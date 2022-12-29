package book.jungsuk.ch07;

interface Parseable {
    // 구문 분석 작업을 수행
    public abstract void parse(String fileName);
}
class ParserManager {
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
            // 나중에 새로운 종류의 XML 구문분석기인 NewXMLParser클래스가 나와도 ParserTest 수정을 안해도된다.
            // return new NewXMLParser();
        } else {
            Parseable p = new HTMLParser();
            return p;
        }

    }
}
class XMLParser implements Parseable {
    @Override
    public void parse(String fileName) {
        /* 구문 분석작업을 수행하는 코드 */
        System.out.println(fileName + "-XML parsing completed.");
    }
}
class HTMLParser implements Parseable {
    @Override
    public void parse(String fileName) {
        /* 구문 분석작업을 수행하는 코드 */
        System.out.println(fileName + "-HTML parsing completed.");
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
