package com.company;
import java.io.IOException;
import java.util.LinkedList;

class Crawler {
    private static LinkedList<URLDepthPair> urls = new LinkedList<URLDepthPair>();
    private static LinkedList<URLDepthPair> processedUrls = new LinkedList<URLDepthPair>();

    public static final String LINK_PREFIX = "<a href=" + '"';
    public static final String URL_PREFIX = "http://";

    private int depth = 0;
    private String url = "";
    private int threadNum;

    private int counter = 0;

    public static boolean enabledLogs = false;

    public Crawler(String url, int depth, int threadNum) {
        this.url = url;
        this.depth = depth;
        this.threadNum = threadNum;


    }

    public void work() throws IOException, InterruptedException {
        URLPool urlPool = new URLPool(depth);
        urlPool.addPair(new URLDepthPair(url, 0));
        for (int i = 0; i < threadNum; i++) {
            CrawlerTask ct = new CrawlerTask(urlPool);
            Thread thread = new Thread(ct);
            thread.start();
        }
        while (urlPool.getWait() != threadNum) {
            Thread.sleep(1000);
        }
        System.out.println("\n=============== Links ================");
        for (URLDepthPair pair : urlPool.getProcessedPairs())
            System.out.println(pair.getURL());

    }


    public static void main(String[] args) {
        try {
            Crawler crawler = new Crawler("http://mtuci.theweather.space/", 5, 3);
            crawler.work();
        } catch (ArrayIndexOutOfBoundsException | IOException | InterruptedException e) {
            System.out.println(e);
            System.out.println("usage: java Crawler <url> <depth>");
        }
    }
}