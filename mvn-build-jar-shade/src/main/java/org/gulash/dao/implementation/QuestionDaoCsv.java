package org.gulash.dao.implementation;

import lombok.RequiredArgsConstructor;
import org.gulash.config.TestFileProvider;
import org.gulash.dao.QuestionDao;
import org.gulash.domain.Question;
import org.gulash.exceptions.QuestionReadException;
import org.gulash.mapper.LineMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@RequiredArgsConstructor
public class QuestionDaoCsv implements QuestionDao {
    private final TestFileProvider provider;

    private final LineMapper lineToQuestionMapper;

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();

        try (InputStream iStream = getResourceAsStream(provider.getTestFileName())) {
            Objects.requireNonNull(iStream, String.format("Have no file %s", provider.getTestFileName()));
            Scanner scanner = new Scanner(Objects.requireNonNull(iStream));

            scanner.nextLine(); // skip first line
            while (scanner.hasNextLine()) {
                questions.add(
                    lineToQuestionMapper.toQuestion(
                        scanner.nextLine(),
                        provider.getQuestionTag(),
                        provider.getAnswerTag(),
                        provider.getAnswerSplitter()
                    )
                );
            }
        } catch (Exception e) {
            throw new QuestionReadException(e.getMessage());
        }
        return questions;
    }

    private InputStream getResourceAsStream(String fileName) {
        return getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
    }
}
