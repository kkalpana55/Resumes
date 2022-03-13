package stepdefinitions;


	
	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

	 import java.net.MalformedURLException; 
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.javafx.binding.Logging;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
/*import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
	*/
	public class logstepdefinition {
		
			WebDriver driver;
					
		

	@Given("^User is in login page$")
	
	public void user_is_in_login_page() {
		WebDriverManager.chromedriver().setup();   
		driver=new ChromeDriver();
		driver.get("https://qa.agilityhealthradar.com/account/login");
	    // Write code here that turns the phrase above into concrete actions
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^title of the page is Agile-AH$")
	public void title_of_the_page_is_Agile_AH() {
		String t=driver.getTitle();
		Assert.assertEquals(t, "Log in - AH");
	    
	}
	@Then("^user enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("Email")).sendKeys(username);;
		driver.findElement(By.id("Password")).sendKeys(password);
	}


	@Then("^click on the login button$")
	public void click_on_the_login_button() throws InterruptedException {
		System.out.println("click on the login button")  ;
		driver.findElement(By.xpath("//input[@class='btn login-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/form/div[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='company-list']"));
		Actions act = new Actions(driver);
		WebElement complist=driver.findElement(By.xpath("//ul[@id='company_listbox']/li[1]"));
		act.moveToElement(complist).click().perform();
		driver.findElement(By.xpath("//input[@value='Select']")).click();
	   
	}
	@Then("^user is on the Home page$")
	public void user_is_on_the_Home_page() throws InterruptedException {
		System.out.println("User successfully landed on the teampage")  ;
	    // Write code here that turns the phrase above into concrete actions
	  Thread.sleep(2000);
	}

	@Then("^find all the broken links$")
	public void find_all_the_broken_links() throws MalformedURLException, IOException, InterruptedException {
		 List <WebElement> list1=driver.findElements(By.tagName("a"));
		  
		   list1.addAll(driver.findElements(By.tagName("img")));
		    System.out.println("totallinks"+list1.size());
		   
		    List<WebElement> actuallist = new ArrayList<WebElement>();
		    for(int i=0;i<list1.size();i++)
		   			    {
		    	
		    	 System.out.println(list1.get(i).getAttribute("href"));
		    	if(list1.get(i).getAttribute("href")!=null &&(!list1.get(i).getAttribute("href").contains("javascript")))			    			{
		    		
		    		actuallist.add(list1.get(i));
		    			    		
		    	}
		    		    			
		    }
		    System.out.println("totalactuallist"+actuallist.size());		   
		    			    //check the connect of each url
		    for(int j=0;j<actuallist.size();j++)
		  try  { 
		    	
		    	HttpURLConnection connec= (HttpURLConnection) new URL(actuallist.get(j).getAttribute("href")).openConnection();
		    	connec.connect();
		    	int response=connec.getResponseCode();
		    	if(response==200) {
		    		
		    		System.out.println(actuallist.get(j).getAttribute("href")+"---->"+connec.getResponseMessage());
		    		    		
		    	}
		    	else
		    	{
		    		System.out.println(actuallist.get(j).getAttribute("href")+"---->"+connec.getResponseMessage());
		    	
		    	}
		    	
		    	connec.disconnect();
		  } catch (MalformedURLException error) {
	            // Output expected MalformedURLExceptions.
	            Logging.getLogger();	  	
		    
		}
		    	catch (IOException e)  {
			        e.printStackTrace();
			      
			    }
		    System.out.println("The Good Links"+actuallist.size());
	    // Write code here that turns the phrase above into concrete actions
	    
	}


	@Then("^find the word assessments$")
	public void find_the_word_assessments() throws InterruptedException, AWTException {
		String assessment=driver.getPageSource();
		 String windowhandle1=driver.getWindowHandle();
		if (assessment.contains("Dashboard")){
			
			System.out.println("found assessments");
			
		}
		else {System.out.println("there is no goggle");
		
			
		}
		//growthitems-tab
		driver.findElement(By.xpath("//button[@id='btnState']")).click();
		driver.findElement(By.xpath("//span[@id='showArchived']")).click();
 
		  // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		//Team table
		driver.findElement(By.xpath("//*[@id='Teams']/table"));
		WebElement dc2= driver.findElement(By.xpath("//*[@id='Teams']/div[2]/ul"));
		//list->dropdown
		List <WebElement> dc3 =dc2.findElements(By.xpath("//*[@id='Teams']/div[2]/ul/li"));  
		WebElement li=driver.findElement(By.xpath(("//*[@id='Teams']/div[2]/ul/li[1]")));
		//to display the size of the list
		System.out.println("The number of pages"+ dc3.size());
		//dd1->next button
		/*try {
	    WebElement	dd1=driver.findElement(By.xpath("//*[@id='Teams']/div[2]/a[3]/span"));
		 for(WebElement element:dc3)
	    //counting the rows ->on click of next button
			 for (int x =0;x< dc3.size();x++){
			 Thread.sleep(2000);
			 Actions act=new Actions(driver);
		     act.moveToElement(dd1).click().perform();
				
		        Thread.sleep(2000);
		        //count the rows ->current page
		        List<WebElement> nrows1= driver.findElements(By.tagName("tr"));
		        Thread.sleep(2000);
			    System.out.println("The total number of rows of "+dc3.get(x).getText()+  nrows1.size());
		    }}
		catch(org.openqa.selenium.StaleElementReferenceException ex){
			
			 WebElement	dd1=driver.findElement(By.xpath("//*[@id='Teams']/div[2]/a[3]/span"));
			 for(WebElement element:dc3)
		    //counting the rows ->on click of next button
				 for (int x =0;x< dc3.size();x++){
				 Thread.sleep(2000);
				 Actions act=new Actions(driver);
			     act.moveToElement(dd1).click().perform();
					
			        Thread.sleep(2000);
			        //count the rows ->current page
			        List<WebElement> nrows1= driver.findElements(By.tagName("tr"));
			        Thread.sleep(2000);
				    System.out.println("The total number of rows of "+dc3.get(x).getText()+  nrows1.size());
			
		}*/
		
		 
		
		  driver.findElement(By.xpath("/html/body/div[4]/div[1]/a[4]")).click();
		  
		
		 
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//span[@aria-owns='categories_listbox']")).click();
		  Thread.sleep(2000);
		 Actions action = new Actions(driver); 
		  WebElement dc=driver.findElement(By.xpath("//*[@id='categories_listbox']/li[3]"));
		 action.moveToElement(dc).click().perform();
		 Thread.sleep(2000);
		
		 driver.findElement(By.xpath("//span[@aria-owns='surveytype_listbox']")).click();
		 Thread.sleep(2000);
		 WebElement txtbox1=driver.findElement(By.xpath("//input[@aria-owns='surveytype_listbox']"));
		 txtbox1.sendKeys("ent");
		 Actions action1 =new Actions(driver);
		 WebElement dc1=driver.findElement(By.xpath("//*[@id='surveytype_listbox']/li[3]"));
		 action1.moveToElement(dc1).click().perform();
		 Thread.sleep(2000);
		
			 
		 
		 driver.findElement(By.xpath("/html/body/header/section/div/div[3]/span[2]/a")).click();
		 
		 
		Set<String> stringhandles=driver.getWindowHandles();
		System.out.println("child window handle is"+stringhandles);
		Iterator<String> i1=stringhandles.iterator();
			while(i1.hasNext())
			{
				 String childWindow=i1.next();
				 if(!windowhandle1.equals(childWindow)) {
					 
						driver.switchTo().window(childWindow);
			 System.out.println(driver.getTitle());
			 Thread.sleep(2000);
			// WebElement dc4= driver.findElement(By.xpath("//button[@id='businessoutcomes__categoryFilterChevron']"));
			 //dc4.click();
			/* WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']")));
					ele .click();*/
			 //WebElement bo1=driver.findElement(By.xpath("//*[@id='menu-']/div[3]/ul/li[1]"));
			
			 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='CompanySelect']/div")).click();
			 Select s1=  new Select(driver.findElement(By.xpath("//*[@id='CompanySelect']/div/select")));
							 
			 List<WebElement> options = s1.getOptions();
			 System.out.println("The total number of companies---->"+options.size());
			 for(int i=0;i<options.size();i++) {
				 
				 System.out.println(options.get(i).getText());
				 
			 }
			 driver.manage().window().maximize();
			 Thread.sleep(2000);
		WebElement	bl1= driver.findElement(By.xpath("//*[@id='businessoutcomes__categoryFilterChevron']"));
		bl1.click();
		 Thread.sleep(2000);
			 List<WebElement> UL=driver.findElements(By.xpath(("//*[@id='categoriesFilterDropdownInput']/div[2]")));
			System.out.println( UL.size());
			 for(int i=0;i<UL.size();i++){

			 System.out.println(""+UL.get(i).getText());

			 }
		 
			 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='businessoutcomes__view__selector']")).click();
			
				List<WebElement> bolist=driver.findElements(By.xpath("//*[@id='menu-']/div[3]/ul"));
			Thread.sleep(2000);
				System.out.println("The total items in the drop down list :"+bolist.size());
				for(int i=0;i<bolist.size();i++) {
					System.out.println("The businessoutcome dropdown list:"+bolist.get(i).getText());
				}
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='menu-']/div[3]/ul/li[1]")).click();
				Thread.sleep(2000);
				WebElement bo=driver.findElement(By.xpath("//*[@id='swimlanesWrapper']"));
				List<WebElement> nrows1bo= driver.findElements(By.tagName("h1"));
				System.out.println("The total Headers are:"+nrows1bo.size());
				Thread.sleep(2000);
				int k=0;
							
					/* WebElement scroll=driver.findElement(By.xpath("//*[@id='swimlanesWrapper']/div[1]/div"));
					JavascriptExecutor js=  (JavascriptExecutor)driver;*/
					
						
						for(int i=0;i<nrows1bo.size();i++) {
								
							Robot  robot =new Robot();
							robot.keyPress(KeyEvent.VK_RIGHT);
							robot.keyRelease(KeyEvent.VK_RIGHT);
							WebElement scroll=driver.findElement(By.xpath("//*[@id='swimlanesWrapper']/div[1]/div"));
							
					Thread.sleep(2000);	
					System.out.println("The headers------>"+nrows1bo.get(i).getText());
					
				}
				//driver.findElement(By.xpath("//*[@id='0']")).click();
				}	
				 
			
			
			
			
			}
			//scenario -on selecting the color it should display the cards of that color.
	
			driver.findElement(By.xpath("//*[@id='color__filter__button']/span[1]")).click();
		
			WebElement c1=driver.findElement(By.xpath("//div[contains(@title,'#7E6BA0')]"));
			c1.click();
			
			String bc1=c1.getCssValue("background-color");
			
			System.out.println("The Checked color is "+bc1);
			WebElement c2=driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div/div[4]/div[2]"));
			c2.click();
			String bc2=c2.getCssValue("background-color");
			System.out.println("The Checked color is "+bc2);	
			WebElement c3 =driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div/div[6]/div[3]"));
			c3.click();
			String bc3=c3.getCssValue("background-color").trim();
			System.out.println("The Checked color is "+bc3);	
			//String s1=color1.getCssValue("color");
			/*String s2=color2.getCssValue("color");
			String s3=color3.getCssValue("color");
			System.out.println("The colors checked are"+s2+s3);*/
			WebElement b1=driver.findElement(By.xpath("/html/body/div[5]/div[3]"));
			List <WebElement> colorlist=b1.findElements(By.xpath("//*[@data-icon='check']"));
			/*
			for(int i=0;i<colorlist.size();i++) {
			System.out.println("The checked colors are "+colorlist.get(i).getCssValue("color"));
			}*/
			WebElement bo1=driver.findElement(By.xpath("//*[@id='swimlanesWrapper']"));
			
       List<WebElement> cardListcolor=bo1.findElements(By.xpath("//div[contains(@class,'jss219')]"));
       
System.out.println("The number of cards "+cardListcolor.size());
		
for(int i=0;i<cardListcolor.size();i++) {
	String colorcard=cardListcolor.get(i).getCssValue("background-color").trim();
					
			System.out.println("The card--->"+cardListcolor.get(i).getText());
			
			System.out.println("color of the card---->"+colorcard);
				
	if(colorcard.contains(bc1)) {
		System.out.println("The color is red");	}
	else if
			( colorcard.contains(bc2)) 
	{ System.out.println("The color is green");  }
	else if (colorcard.contains(bc3)){
		System.out.println("The color  blue");}
				else {
					System.out.println("The color doesnt matches with the checked colors");	}
	}		
}
	}		
		
		
			
	
	
	
	
	
	
	
	
	
	
		
		

			 
		
		 
		
		

	

	

	


