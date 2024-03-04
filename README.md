# EntrataCode
Entrata Website : Selenium TestNG Maven Project

1 : Open Eclipse IDE, Select file Create New Java Project => EntrataProject.

2 : For TestNG framework - Convert to TestNG, we get the testng.xml file.

3 : For selenium code - configure=>Convert to maven Project, from this we got pom.xml file.

4 : In pom.xml, add dependancies of Selenium java as,

	<dependencies>
  <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.18.1</version>
  </dependency>
  </dependencies>

  5 : After saving this file we got all the selenium libraries in project => Maven Dependancies.
  6 : Create New package => Entrata.
  
  7 : Create New class => EntrataDemo.
  
  8 : In this write the selenium code, declare the web driver as,
      WebDriver driver;
      
  9 : Declare the @BeforeMethod, to run this code before the method everytime when the method executing this annotation is used.
  
  10 : Do the setup and define the chrome driver in the setUp(),
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
  
  11 : Open the website,
      driver.get("https://www.entrata.com/");
      
  12 : It will wait for 5 seconds, driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  
  13 : Maximizes the current opened window, driver.manage().window().maximize(); 
  
  14 : After every testcase we have to close the browser , for this called the below method in close().
        @AfterMethod
      	public void close() {
	      	driver.quit();
	      }
       And use @AfterMethod annotation to run code after the method.
       
  15 : write testcase for verify the title in method verifyTitle and use @Test annotation,
  
		    String actualTitle = driver.getTitle();
		    String expectedTitle = "Property Management Software | Entrata";
      
	16 : To check testcase pass/fail we use assertion as, 	
		    Assert.assertEquals(actualTitle, expectedTitle);
      
  17 : Testcase for the website logo is present or not using aotaion and asertion,
        @Test
      	public void verifyLogo() {
    		boolean logo = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div/a")).isDisplayed();
	      Assert.assertTrue(logo);
	      }
       
  18 :  Accept the cookies
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[2]/button[2]")).click();  
      
  19 : Hover over on products element.
		    WebElement ele=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[2]/div[1]/div[1]"));
		    Actions a = new Actions(driver);
		    a.moveToElement(ele).build().perform();	
      
  20 : click on Property Management.
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a[1]")).click();

  21 : select the sign in option.
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/div[3]/a[2]")).click();

  22 : select Property manager Login.
		    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div/div[3]/a[1]")).click();

  23 : Click and enter the Username.
		    driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/ul/li[1]/div/input")).sendKeys("abc@gmail.com");
		
	24 : Click and enter the password.
	    	driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/ul/li[2]/input")).sendKeys("12345");
		
  25 : To run testNG project, we have to update class in testng.xml file e.g. name= packegename. classname as,
        <classes>
        <class name="Entrata.EntrataDemo"></class>
        </classes>
	26 : Run the code by using Run As =>TestNG Suite.
		
  
