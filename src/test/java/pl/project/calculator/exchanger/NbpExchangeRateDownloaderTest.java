package pl.project.calculator.exchanger;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class NbpExchangeRateDownloaderTest {

    @Test
    public void testDownloadCurrentDate(){
        NbpExchangeRateDownloader downloader = new NbpExchangeRateDownloader(new RestTemplate());
        downloader.downloadExchangeRate("EUR", LocalDate.parse("2018-10-12"));


    }

    @Test
    public void testDownloadFutureDate(){
        NbpExchangeRateDownloader downloader = new NbpExchangeRateDownloader(new RestTemplate());
        downloader.downloadExchangeRate("EUR", LocalDate.parse("2018-10-14"));
    }

}