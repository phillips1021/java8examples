/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

        List<Article> articles = getArticles();

        Article javaArticle = getFirstJavaArticle(articles);

        System.out.println("Title of Java article is " + javaArticle.getTitle());

        Optional<Article> javaArticleJava8 = getFirstJavaArticleJava8(articles);

        System.out.println("Title of Java article is using Java 8 is " + javaArticleJava8.get().getTitle());

        List<Article> javaArticles = getAllJavaArticles(articles);

        System.out.println("All Java articles: " + javaArticles);

        Map<String, List<Article>> authorArticleMap = groupByAuthor(articles);

        System.out.println("Articles grouped by author: " + authorArticleMap);
        
        Set<String> tagsUsedInArticles = getDistinctTags(articles) ;
         
        System.out.println("Tags used in articles: " + tagsUsedInArticles );

    }

    /**
     * Demonstrate the old for loop to find first Article object that has Java
     * as a tag.
     *
     * @param articles
     * @return
     */
    private Article getFirstJavaArticle(List<Article> articles) {

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }

        return null;
    }

    /**
     * Demonstrates new way of using stream and filter and findFirst to find
     * first Article object that has Java as a tag.
     *
     * @param articles
     * @return
     */
    private Optional<Article> getFirstJavaArticleJava8(List<Article> articles) {

        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();

    }

    /**
     * Use new Java 8 stream, filter, and collect methods to get all Article
     * objects from collection that have a tag of Java.
     *
     * @param articles
     * @return
     */
    private List<Article> getAllJavaArticles(List<Article> articles) {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

    /**
     * Use new Java 8 stream, collect, and groupingBy methods to create a map
     * where the key is the author name and the value is collection of Articles
     * by that author.
     *
     * @param articles
     * @return
     */
    private Map<String, List<Article>> groupByAuthor(List<Article> articles) {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }
    
    /**
     * Use stream, flatMap, and collect to create a Set of Strings
     * where each String is an Article tag value.
     * @param articles
     * @return 
     */
    public Set<String> getDistinctTags(List<Article> articles) {
    return articles.stream()
        .flatMap(article -> article.getTags().stream())
        .collect(Collectors.toSet());
}

    private List<Article> getArticles() {

        List<String> tags1 = new ArrayList<>();
        tags1.add("Java");

        List<Article> articles = new ArrayList<>();

        Article article1 = new Article("Java Examples", "Bruce Phillips", tags1);

        articles.add(article1);

        List<String> tags2 = new ArrayList<>();
        tags2.add("Perl");

        Article article2 = new Article("Perl Examples", "Bob Smith", tags2);
        articles.add(article2);

        Article article3 = new Article("Java 8 For Dummies", "Bruce Phillips", tags1);
        articles.add(article3);

        Article article4 = new Article("Perl for Dummies", "Bob Smith", tags2);
        articles.add(article4);

        return articles;

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

        @Override
        public String toString() {
            return "Article{" + "title=" + title + ", author=" + author + ", tags=" + tags + '}';
        }

    }

}
