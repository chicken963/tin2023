package ru.tinkoff.edu.java.linkparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.tinkoff.edu.java.linkparser.domain.StackoverflowData;

public class StackOverflowParserTest {
    private final StackOverflowUrlParser uut = new StackOverflowUrlParser();

    @ParameterizedTest
    @CsvFileSource(resources = "/stackoverflow_url_parse_data.csv")
    public void shouldParseGithubData(String url, Integer questionId) {
        StackoverflowData githubUserData = uut.parse(url);
        Assertions.assertEquals(questionId, githubUserData.questionId());
    }
}
