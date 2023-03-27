package ru.tinkoff.edu.java.linkparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.tinkoff.edu.java.linkparser.domain.GithubUserData;

public class GithubParserTest {

    private final GithubUrlParser uut = new GithubUrlParser();

    @ParameterizedTest
    @CsvFileSource(resources = "/github_url_parse_data.csv")
    public void shouldParseGithubData(String url, String user, String repo) {
        GithubUserData githubUserData = uut.parse(url);
        Assertions.assertEquals(user, githubUserData.user());
        Assertions.assertEquals(repo, githubUserData.repo());
    }
}
