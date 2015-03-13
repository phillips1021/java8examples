/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * See: http://www.voxxed.com/blog/2015/03/swerving-away-from-loops-in-java-8/
 *
 * @author brucephillips
 */
public class LoopExampleApp {

    public static void main(String[] args) {

        LoopExampleApp app = new LoopExampleApp();

        app.run();

    }

    public void run() {

        List<String> tags1 = new ArrayList<>();
        tags1.add("Java");

        List<Article> articles = new ArrayList<>();

        Article article1 = new Article("Java Examples", "Bruce Phillips", tags1);

        articles.add(article1);

        List<String> tags2 = new ArrayList<>();
        tags2.add("Perl");

        Article article2 = new Article("Perl Examples", "Bob Smith", tags2);
        articles.add(article2);

        Article javaArticle = getFirstJavaArticle(articles);

        System.out.println("Title of Java article is " + javaArticle.getTitle());
        
        Optional<Article> javaArticleJava8 = getFirstJavaArticleJava8(articles);
        
        System.out.println("Title of Java article is using Java 8 is " + javaArticleJava8.get().getTitle());

    }

    private Article getFirstJavaArticle(List<Article> articles) {

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }

        return null;
    }

    private Optional<Article> getFirstJavaArticleJava8(List<Article> articles) {
        
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
        
    }

    private class Article {

        private final String title;
        private final String author;
        private final List<String> tags;

        private Article(String title, String author, List<String> tags) {
            this.title = title;
            this.author = author;
            this.tags = tags;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public List<String> getTags() {
            return tags;
        }
    }

}
