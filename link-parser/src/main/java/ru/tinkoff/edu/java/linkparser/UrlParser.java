package ru.tinkoff.edu.java.linkparser;

import ru.tinkoff.edu.java.linkparser.domain.UserData;

public sealed interface UrlParser permits GithubUrlParser, StackOverflowUrlParser {
    UserData parse(String url);
}
