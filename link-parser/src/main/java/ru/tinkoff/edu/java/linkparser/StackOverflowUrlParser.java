package ru.tinkoff.edu.java.linkparser;

import ru.tinkoff.edu.java.linkparser.domain.StackoverflowData;
import ru.tinkoff.edu.java.linkparser.domain.UserData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StackOverflowUrlParser implements UrlParser {
    private final String questionIgGroup = "questionId";
    private final Pattern stackOverflowPattern = Pattern.compile(String.format("https?://stackoverflow.com/questions/(?<%s>\\d+)/?", questionIgGroup));

    @Override
    public StackoverflowData parse(String url) {
        Matcher matcher = stackOverflowPattern.matcher(url);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Unable to parse url " + url);
        }
        String questionIdStringLiteral = matcher.group(questionIgGroup);
        return new StackoverflowData(Integer.parseInt(questionIdStringLiteral));
    }
}
