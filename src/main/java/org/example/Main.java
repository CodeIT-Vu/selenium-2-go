package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //OOP THÌ CÁI GÌ CŨNG LÀ OBJ
        // TRÌNH DUYỆT MÌNH SẼ ĐIỀU KHỂN (QUA THƯ VIỆN)
        // SELENIUM + FILE .EXE VỪA TẢI VỀ - WEBDRIVER.EXE
        // CX ĐƯỢC XEM LÀ 1 OBJ
        //CÁC TAGS/THẺ <TAG...> CX ĐC XEM LÀ OBJ
        System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
        // HÃY NẠP CÁI APP.EXE VỪA TẢI VỀ VAO RAM CỦA MÁY ẢO JAVA ĐỂ SẴN SÀNG ĐIỀU KHIỂN TRÌNH DUYỆT
        // Y CHANG CÁI LỆNH Class.forName(thư viện SQL, JDBC môn java web)

//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("--incognito");
//        opt.addArguments("--lang=th-TH");

        WebDriver myBrower = new ChromeDriver();
        myBrower.get("https://google.com");

        // đi tìm cái tag <textarea....> qua name là "q"
        // kĩ thuật định vị 1 tag trong vô số tag của trang web
        // mình tải về
        //tag là 1 obj trong OOP

        WebElement searchBox = myBrower.findElement(By.name("q"));
        searchBox.sendKeys("Quang Linh Vlog");
        searchBox.submit(); // ấn enter

        // biến trỏ vào trình duyệt, mở trình duyệt mới hoàn toàn
        myBrower.manage().window().maximize(); // chấm mà trả về obj thì dc chấm tiếp


        //delay
//        Thread.sleep(5000); //5000 là 5 giây

//        myBrower.quit(); //tắt trình duyệt

    }
}

// TEST CASE 1: TEST SEARCH FUNCTION OF GOOGLE.COM
// STEP:
//      1. OPEN A CERTAIN BROWSER, E.G. CHROME
//      2. TYPE THE URL: HTTPS://GOOGLE.COM
//      3. TYPE THE KEYWORD TO SEARCH: "QUANG LINH VLOG"
//      4. HIT ENTER
//      A LIST OF WEB PAGES THAT CONTAIN THE "QUANG LINH VLOG"
//      KEYWORD IS SHOWN