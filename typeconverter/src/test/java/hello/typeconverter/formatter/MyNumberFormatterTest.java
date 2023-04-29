package hello.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static java.util.Locale.KOREA;
import static org.assertj.core.api.Assertions.assertThat;

class MyNumberFormatterTest {

  MyNumberFormatter formatter = new MyNumberFormatter();

  @Test
  void parse() throws ParseException {
    Number result = formatter.parse("1,000", KOREA);
    assertThat(result).isEqualTo(1000L); // Long 타입 주의
  }

  @Test
  void print() {
    String result = formatter.print(1000, KOREA);
    assertThat(result).isEqualTo("1,000");
  }

}