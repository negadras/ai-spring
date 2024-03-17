package com.hahu.springai.controller;

import com.hahu.springai.dto.Article;
import com.hahu.springai.dto.Summary;
import com.hahu.springai.service.SummaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ArticleSummaryController {

    private final SummaryService summaryService;

    public ArticleSummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @PostMapping("/summary")
    Summary summary(@RequestBody Article article) {

        String promptTemplate = """
                    **Input:**
                    - **Article Title:** %s
                    - **Article URI:** %s
                
                    **Instructions:**
                    1. Read the article thoroughly to understand the main points, arguments, and conclusions.
                    2. Identify key facts, figures, and statements that are crucial to the article's narrative.
                    3. Avoid including trivial details or overly specific data that are not central to the article's main message.
                    4. Maintain the original tone and intent of the article, ensuring that the summary is a true representation of the source.
                    5. The summary should be concise, aiming for a length of about 10-15 percent of the original article.
                
                    **Output:**
                    - **Summary:** Provide a clear, concise, and accurate summary of the article, capturing the essential points and main conclusions
                                   in the format of Dr. Seuss writing
                """;

        String prompt = String.format(promptTemplate, article.title(), article.uri());

        var reply = summaryService.getSummary(prompt);

        return new Summary(article.title(), article.uri(), reply);
    }
}
