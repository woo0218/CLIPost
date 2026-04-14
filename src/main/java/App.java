import com.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        int lastId = 0;
        System.out.println("== 자바 텍스트 게시판 시작 ==");
        List<Article> articles = new ArrayList<>();

        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "write" -> {
                    System.out.println("제목 : ");
                    String title = scanner.nextLine().trim();

                    System.out.println("내용 : ");
                    String content = scanner.nextLine().trim();

                    int id = ++lastId;

                    articles.add(new Article(id, title, content));

                    System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
                }
                case "list" -> {
                    System.out.println("번호 | 제목 | 최초 등록일 | 최근 수정일");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");

                    for (int i = 0; i < articles.size(); i++) {
                        Article article = articles.get(i);
                        System.out.printf("%d | %s | %s | %s\n", article.getId(), article.getTitle(), article.getRegDate(), article.getModDate());
                    }

                }




                case "exit" -> {
                    return;
                }
            }
        }
    }
}