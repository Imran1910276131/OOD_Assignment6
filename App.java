
interface WebPage {
    void display();
}
class BasicWebPage implements WebPage {
    private String content;

    public BasicWebPage(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println("Basic Web Page Content: " + content);
    }
}
class AuthenticatedWebPage implements WebPage {
    private WebPage webPage;

    public AuthenticatedWebPage(WebPage webPage) {
        this.webPage = webPage;
    }

    @Override
    public void display() {
        authenticateUser();
        webPage.display();
    }

    private void authenticateUser() {
        System.out.println("User authentication performed.");
    }
}
class PaginatedWebPage implements WebPage {
    private WebPage webPage;

    public PaginatedWebPage(WebPage webPage) {
        this.webPage = webPage;
    }

    @Override
    public void display() {
        webPage.display();
        paginateResults();
    }

    private void paginateResults() {
        System.out.println("Results paginated across multiple pages.");
    }
}

public class App {
    public static void main(String[] args) {
        WebPage basicWebPage = new BasicWebPage("This is the main content.");
        WebPage authenticatedPage = new AuthenticatedWebPage(basicWebPage);
        WebPage paginatedPage = new PaginatedWebPage(authenticatedPage);
        System.out.println("Displaying Authenticated and Paginated Web Page:");
        paginatedPage.display();
    }
}
