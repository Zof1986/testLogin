import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Logintest {

		
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\OneDrive\\Radna površina\\SeleniumJarfajlovi\\chromedriver.exe");
		
				driver = new ChromeDriver();
				driver.get("https://slobodniigraci.quantox.dev/");
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@type='button']")).click();
				
				
				
		/*	String test =	driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/a")).getText();
			String test1 = "Portal Slobodni Igrai";
			Assert.assertEquals(test, test1);*/
	}
	
		
	@Test(enabled=false)
	public void  IVerifyIfAUserWillBeAbleToLoginWithAValidUsernameAndValidPassword() throws Exception{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(1000);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//img[@src])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class])[3]")).click();
				Thread.sleep(2000);
				String text = driver.findElement(By.xpath("//div[@style=\"display: flex; flex-direction: column;\"]/p")).getText();
				System.out.println(text);
				String text1 ="Username: TestNikolaIgrac1";
				Assert.assertEquals(text, text1);
				
			/*	driver.get("https://slobodniigraci.quantox.dev/profile-page");
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)", "");
      			String FirstName = driver.findElement(By.xpath("(//div)[20]")).getText();
				String LastName = driver.findElement(By.xpath("(//div)[21]")).getText();
				String FirstName1 = "Test";
				String LastName1 = "Igrac";
				Assert.assertEquals(FirstName, FirstName1);
				Assert.assertEquals(LastName, LastName1);*/
				//prolazi jer se levo poklapa sa desnim
	}
	
	@Test(enabled=false)
	public void IIVerifyIfAUserCannotLoginWithAValidUsernameAndAnInvalidPassword() throws Exception{		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		String ErrorMessage = driver.findElement(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']")).getText();
		String error1 = "The provided credentials are incorrect."; 
	    Assert.assertEquals(ErrorMessage, error1);
	}
	
	@Test(enabled=false)
	public void IIIVerifyTheLoginPageForBothWhenTheFieldIsBlankAndSubmitButtonIsClicked() throws Exception{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		String EmailError = driver.findElement(By.xpath("(//p[@class])[1]")).getText();
		String PasswordError = driver.findElement(By.xpath("(//p[@class])[2]")).getText();
		String EmailError1 = "Polje je obavezno!";
		String PasswordError1 = "Polje je obavezno!";
		Assert.assertEquals(EmailError, EmailError1);
		Assert.assertEquals(PasswordError, PasswordError1);
	}
	
	@Test(enabled=false)
	public void IVVerifyTheForgotPasswordFunctionality() throws Exception{
		driver.findElement(By.xpath("//a[@href='/forgotten-password']")).click();
		Thread.sleep(1000);
		//driver.get("https://slobodniigraci.quantox.dev/forgotten-password");
		//moram da proverim da li ovo radi
		String Naslov = driver.findElement(By.xpath("//h2[@id='child-modal-title']")).getText();
		String Naslov1 = "Zaboravili ste lozinku";
		Assert.assertEquals(Naslov, Naslov1);
	}
	
	@Test(enabled=false)
	public void  VVerifyIfThereIsACancelButtonAvailableToEraseTheEnteredText() throws Exception{
		Thread.sleep(1000);
		String test = "test";
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(test);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(test);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		String Email = driver.findElement(By.xpath("//input[@type='email']")).getText();
		String Password = driver.findElement(By.xpath("//input[@type='password']")).getText();
		String Email1 = "";
		String Password1 = "";
		Assert.assertEquals(Email, Email1);
		Assert.assertEquals(Password, Password1);		
	}
	
	@Test(enabled=false)
	public void  VIVerifyIfTheEnterKeyOfTheKeyboardIsWorkingCorrectlyOnTheLoginPage() throws Exception{
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		String Errormessage = driver.findElement(By.xpath("(//p[@class])[1]")).getText();
		String ErrorMessage = driver.findElement(By.xpath("(//p[@class])[2]")).getText();
		String Error = "Polje je obavezno!";
		Assert.assertEquals(Errormessage, Error);
		Assert.assertEquals(ErrorMessage, Error);
		driver.navigate().refresh();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);			
		Assert.assertEquals(Errormessage, Error);
		Assert.assertEquals(ErrorMessage, Error);		
		driver.navigate().refresh();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		Assert.assertEquals(ErrorMessage, Error);	
		driver.navigate().refresh();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		Assert.assertEquals(Errormessage, Error);
		driver.navigate().refresh();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@src])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class])[3]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@style=\"display: flex; flex-direction: column;\"]/p")).getText();
		System.out.println(text);
		String text1 ="Username: TestNikolaIgrac1";
		Assert.assertEquals(text, text1);
		
	/*	driver.get("https://slobodniigraci.quantox.dev/profile-page");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
			String FirstName = driver.findElement(By.xpath("(//div)[20]")).getText();
		String LastName = driver.findElement(By.xpath("(//div)[21]")).getText();
		String FirstName1 = "Test";
		String LastName1 = "Igrac";
		Assert.assertEquals(FirstName, FirstName1);
		Assert.assertEquals(LastName, LastName1);*/
		
	}
	
	@Test(enabled=false)
	public void  VIIVerifyIfTheDataInPasswordFieldIsEitherVisibleAsAsteriskOrBulletSigns() throws Exception{
		//provery po type da li je vidljiv i ako se menja stanje kada kliknemo dugme
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("test");
		String Visible1 = driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).getAttribute("type");
		System.out.println(Visible1);
		String password = "password";
		Assert.assertEquals(Visible1, password);
		String text = "text";
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd css-1nvf7g0']")).click();
		Thread.sleep(1000);
		String Visible = driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).getAttribute("type");
		Assert.assertEquals(Visible, text);
		System.out.println(Visible);
	}
	
	@Test(enabled=false)
	public void  VIIIVerifyTheRememberMeFunctionality() throws Exception{
		//problem kada se izlogujes, ako nisi automatski prijavljen kako dalje da napredujes ? 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy");
		driver.findElement(By.xpath("//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary css-zun73v']")).isSelected();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	//	Verify if a user is able to login with a new password only after he/she has changed the password.
	@Test(enabled=true)
	public void  IXVerifIfAUserIsAbleToLoginWithANewPasswordOnlyAfterChangingThePassword() throws Exception{	
		//prvobitni password je thedoomguy , promenjeni password je thedoomguy1 i nakon toga vracam ga u predjasnje stanje
		//jedino mi je sumnjivo za obavestenje da je sifra promenjena
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@src])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class])[67]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Unesite staru šifru']")).sendKeys("thedoomguy");
		driver.findElement(By.xpath("//input[@placeholder='Unesite novu šifru']")).sendKeys("thedoomguy1");
		driver.findElement(By.xpath("//input[@placeholder='Potvrdite novu šifru']")).sendKeys("thedoomguy1");
		driver.findElement(By.xpath("(//button[@class])[69]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class])[68]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@src])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458@yubua.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@src])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class])[3]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@style=\"display: flex; flex-direction: column;\"]/p")).getText();
		System.out.println(text);
		String text1 ="Username: TestNikolaIgrac1";
		Assert.assertEquals(text, text1);
		//driver.findElement(By.xpath("(//button[@class])[70]")).click();
	}
	//  Verify if email is valid   to radi tako sto ubacis nasumican text bez @ i ostalo 
	@Test(enabled=false)
	public void  XVerifyIfEmailIsValid() throws Exception{		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cicasor458ytyuyubua.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("thedoomguy");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String Error = driver.findElement(By.xpath("(//p[@class='error__message'])[1]")).getText();
		System.out.println(Error);
		String error ="Email nije validan!";
		Assert.assertEquals(Error, error);
	}
			
}
