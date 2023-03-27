package ru.tinkoff.edu.java.linkparser;

import ru.tinkoff.edu.java.linkparser.domain.GithubUserData;
import ru.tinkoff.edu.java.linkparser.domain.UserData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public non-sealed class GithubUrlParser implements UrlParser {
    private final String userGroup = "user";
    private final String repoGroup = "repo";
    private final Pattern githubPattern = Pattern.compile(String.format("https?://github.com/(?<%s>[\\w-]+)/(?<%s>[\\w-]+)/?", userGroup, repoGroup));

    @Override
    public GithubUserData parse(String url) {
        Matcher matcher = githubPattern.matcher(url);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Unable to parse url " + url);
        }
        return new GithubUserData(matcher.group(userGroup), matcher.group(repoGroup));
    }
}
