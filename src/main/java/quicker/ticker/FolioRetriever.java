package quicker.ticker;

import java.util.Scanner;

import java.io.IOException;
import java.math.BigDecimal;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class FolioRetriever {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter a Stock Ticker: ");
        String ticker = inputTicker();
        System.out.println("");
        System.out.println("Loading, please wait... ");

        String url_link = "https://finance.yahoo.com/quote/" + ticker + "/history";

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        try {
            HtmlPage page = webClient.getPage(url_link);

            String title = page.getTitleText().toString().replace(" Stock Historical Prices & Data - Yahoo Finance", "") + ":".trim() + " ";
            String price = page.asNormalizedText();

            int firstIndex = price.indexOf("9M");
            price = price.substring(firstIndex, firstIndex + 45).toString();

            price = price.replace("-", "+");

            int secondIndex = price.indexOf("(+");
            price = price.substring(0, secondIndex);

            int lastIndex = price.indexOf("+");
            price = price.substring(0, lastIndex).trim();

            price = price.replace("9M", "");
            price = price.replaceAll("[^0-9.]", "");

            BigDecimal formattedPrice = new BigDecimal(price);

            webClient.getCurrentWindow().getJobManager().removeAllJobs();

            clearScreen();
            Thread.sleep(300L);

            System.out.println(title + formattedPrice);

            webClient.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

    public static String inputTicker() {
        Scanner tickerInquiry = new Scanner(System.in);
        String ticker;

        ticker = tickerInquiry.nextLine().toString();
        tickerInquiry.close();

        return ticker;
    }

    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
