package pl.project.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import pl.project.calculator.exchanger.NbpExchangeRateDownloader;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

    @Test
    public void contextLoads() {
        NbpExchangeRateDownloader downloader = new NbpExchangeRateDownloader(new RestTemplate());
        downloader.downloadCurrentCourses(LocalDate.parse("2018-10-17"));
    }

}
