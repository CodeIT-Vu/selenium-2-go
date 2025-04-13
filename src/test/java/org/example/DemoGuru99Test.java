package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class DemoGuru99Test {


    //field. biến dùng chung cho các hàm. có câu static chỉ chơi với static
    private static WebDriver myBrower; // = new ChromeDriver();

    @BeforeAll // hàm nào mà có @BeforeAll() thì hàm này sẽ chạy trước tất cả thiên hạ
    // chạy trước tất cả mọi hàm có !@Test, hàm triển trạm
    // Dùng để khởi động các biến, giá trị, kết nối CSDL ... chuẩn bị đồ chơi cho các hàm @Test chạy phía sau!!!!
    public static void setUp() {
        System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
        myBrower = new ChromeDriver();
        myBrower.manage().window().maximize();
    }

    @AfterAll
    // Dùng để khởi động các biến, giá trị, kết nối CSDL ... sau khi @Test đã chạy để làm mọi thứ từa lưa lên!!!!
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000); //5000 là 5 giây

        myBrower.quit(); //tắt trình duyệt
    }

    // 2 thằn này @BeforeAll và @AfterAll đặt chỗ nào trong class này cx ko quan trọng, vì @ mơới quyết định ai trước ai sau !!!

    @Test //@Test biến hàm bất kì thành main() để chạy, thì mới test code, test app được
    public void testLoginDemoGuru99() throws InterruptedException {
        myBrower.get("https://demo.guru99.com/V4");
        //ta đi tìm các tag: ô user, ô pass, nút nhất login
        //F12 của trình duyệt, dễ dùng nhưng có nhược điểm
        //vậy ta dùng extension SelectorHub, ChromePath ... giúp ta đi bắt 1 cái tag, generate câu query ứng với tag này
        // ta đưa câu query này cho myBrowser đi tìm ...
        //bắt đc 1 cái tag bất kì thi đều thuộc về obj/class WedElement
        WebElement userTextBox = myBrower.findElement(By.xpath("//input[@name='uid']"));
        userTextBox.sendKeys("mngr617204");

        WebElement passTextBox = myBrower.findElement(By.xpath("//input[@name='password']"));
        passTextBox.sendKeys("qEnudUr");

        WebElement loginButton = myBrower.findElement(By.xpath("//input[@name='btnLogin']"));
        loginButton.click();

        // HẾT SỨC LƯU Ý, CỰC KÌ QUAN TRỌNG
        // KHI BẠN CÓ CHUYỂN TRANG, VÍ DỤ LOGIN THÀNH CÔNG THÌ CHUYỂN TRANG MỚI
        // ẤN NÚT PAYMENT SANG TRANG KHÁC
        // CODE Ở ĐÂU VÀ VIỆC SANG TRANG LÀ 2 LUỒNG/THREAD ĐỘC LẬP NHAU, BẤT ĐỒNG BỘ
        //CODE SAU KHI  CLICK NÚT LOGIN THÌ NÓ LẬP TỨC CHẠY SANG LỆNH TÌM TAG TD XEM CÂU CHÀO LÀ GÌ
        // THỰC TẾ TRANG SAU LOGIN CHƯA VỀ KỊP, VÌ MẠNG LAG. CODE KO LAG
        // CHO NÊN TÌM TAG 99% BÁO LỖI KO TỒN TẠI. CHỈ VÌ LÝ DO CODE CHẠY NHANH QUÁ KO CHỜ PAGE SAU LOGIN VỀ KỊP TRONG TRÌNH DUYỆT
        // ĐẶC BIỆT KHI CÓ CODE CHUYỂN TRANG, PHẢI BẮT CODE CHỜ VÀI GIÂY CHO TRANG MỚI VỀ KỊP, THÌ MỚI TÌM TAG ĐC
        // => KHÁI NIỆM CHỜ TRANG VỀ MỚI TÌM TAG
        //GỌI LÀ WAIT, CHỜ ĐỢI ĐIỀU GÌ XẢY RA MỚI CHẠY CODE TIẾP !!!!

        // WAIT
        Thread.sleep(5000); //5000 là 5 giây

        WebElement welcomeLabel = myBrower.findElement(By.cssSelector("tr[class='heading3'] td"));

        // lấy text câu chào ra để xem chào đúng ko, lấy đc, chào dc đúng, login thành công
        String welcomeText = welcomeLabel.getText(); // lấy text của td , span , h1
        System.out.println("Welcome Text: " + welcomeText);

        assertEquals("Manger Id : mngr617204", welcomeText);


    }

    public static Object[][] initData() {
        return new Object[][] {
                {"mngr616357", "yqEnygE"},
                {"mngr617204", "qEnudUr"},
                {"mngr617205", "YvahYjU"},
                {"mngr617206", "Asetezy"}
        };
    }

    @ParameterizedTest
    @MethodSource("initData")
    public void testLoginDDTDemoGuru99(String user, String pass) throws InterruptedException {
        myBrower.get("https://demo.guru99.com/V4");
        //ta đi tìm các tag: ô user, ô pass, nút nhất login
        //F12 của trình duyệt, dễ dùng nhưng có nhược điểm
        //vậy ta dùng extension SelectorHub, ChromePath ... giúp ta đi bắt 1 cái tag, generate câu query ứng với tag này
        // ta đưa câu query này cho myBrowser đi tìm ...
        //bắt đc 1 cái tag bất kì thi đều thuộc về obj/class WedElement
        WebElement userTextBox = myBrower.findElement(By.xpath("//input[@name='uid']"));
        userTextBox.sendKeys(user);

        WebElement passTextBox = myBrower.findElement(By.xpath("//input[@name='password']"));
        passTextBox.sendKeys(pass);

        WebElement loginButton = myBrower.findElement(By.xpath("//input[@name='btnLogin']"));
        loginButton.click();

        Thread.sleep(4000);

        WebElement welcomeLabel = myBrower.findElement(By.cssSelector("tr[class='heading3'] td"));

        // lấy text câu chào ra để xem chào đúng ko, lấy đc, chào dc đúng, login thành công
        String welcomeText = welcomeLabel.getText(); // lấy text của td , span , h1
        System.out.println("Welcome Text: " + welcomeText);
        assertEquals("Manger Id : " + user, welcomeText);

    }

}


//TEST CASE #1: CHECK LOGIN WITH MANAGER ROLE
//STEPS:
// 1. OPEN A CERTAIN BROWSER, E.G. CHROME
// 2. TYPE THE FOLLOWING URL: https://demo.guru99.com/V4
// 3. INPUT A MANAGER ACCOUNT TO THE LOGIN PAGE, E.G mngr617204/qEnudUr
// 4. HIT ENTER TO LOGIN


//EXPECTED RESULT
// A WELCOME MESSAGE WILL BE SHOWN WITH THE FORMAT OF (IN CASE OF SUCCESSFUL LOGIN)
//     "Manager Id: <manager account/id>"


//STATUS: CHỜ TEST THỬ, CHỜ ĐƯA DATA THỬ VÀO APP, TEST RUN
//          PASSED | FAILED
// NÔN NÓNG MUỐN TEST LUÔN, DÙNG TAY, CHẠY BẰNG CƠM, ĐỂ MỞ APP, GÕ = TAY ACCOUNT
//NHẤN NÚT LOGIN = TAY, NHÌN BẰNG MẮT COI CHÁO ĐÚNG KO => KĨ THUẬT DÙNG SỨC TRÂU BÒ
// CHẠY BẰNG CƠM ĐỂ TEST APP => GỌI LÀ MANUAL TEST/TESTING

//NẾU ĐỂ APP CHẠY MA NHẬP (ĐẰNG SAU LÀ CODE SELENIUM)  THÌ GỌI LÀ
//TEST AUTOMATION, AUTOMATION TESTING, KIỂM THỬ TỰ ĐỘNG

// TEST AUTOMATION CÓ 2 CÁCH
// CÁCH 1: TỰ VIẾT CODE DÙNG CÁC THƯ VIỆN TỰ ĐỘNG HÓA APP CHẠY NHƯ MA NHẬP
//                      SELENIUM, PLAYWRIGHT, CYPRESS, APPIUM
// CÁCH 2: DÙNG TOOL/PHẦN MỀM THUỘC STYLE RECORD & REPLAY/PLAYBACK
//                      TA DÂN QC LÀM MỒI, LÀM MANUAL 1 LẦN, TOOL NÀY TỰ GHI LẠI THAO TÁC LÀM
//                      CHI CHUỖI DẠNG CÁC BƯỚC, CHỨ KO PHẢI VIDEO, SAU NÀY TA CÓ THỂ PLAY LẠI, ASSERT CÁC GIÁ TRỊ TNG QUÁ TRÌNH PLAY
//                      NÓ CÓ THỂ EXPORT RA CODE Ở CÁCH 1
//                      KATALON*, TELERIK, TEST COMPLETE, RANOREX, AK AT(FSOFT), ....
//                      SELENIUM IDE (HẠNG GỌN NHẸ), EXTENSION