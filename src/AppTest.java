import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import models.Location;
import models.Region;
import utils.Data;

public class AppTest{
     
    private static String url = Data.SITE_URL;

    public static WebDriver driver;
    
    // @Test
    // public void testSourceData(){
    //     List<Region> regionData = Data.LOCATION_DATA;
    //     assertNotNull("Source data should not be null", regionData);
    // }

    @BeforeClass
    public static void init(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void cleanup(){
        if(driver != null){
            driver.quit();
        }            
    }

    @Test
    public void testTitle(){        
        String title = driver.getTitle();    
        assertTrue("Title should be for contact", title.contains("Contact"));
    }

    @Test
    public void testHeader(){        
        String headerCss = ".cmp-title__text";
        WebElement header = driver.findElement(By.cssSelector(headerCss));
        assertTrue("header should exist", header!=null);
    }

    @Test
    public void testOurLocationsLink(){        
        String ourLocationsLink = "Our locations";
        WebElement link = driver.findElement(By.linkText(ourLocationsLink)); 
        assertTrue("Our Locations link should exist", link!=null);
    }

    @Test
    public void testIfScrollPositionMoved(){        
        String ourLocationsLink = "Our locations";
        WebElement link = driver.findElement(By.linkText(ourLocationsLink)); 
        
        long currentPosition = getCurrentScrollPosition();

        // click the link to trigger scroll
        link.click();

        // wait for delay
        sleep(1000);

        long newPosition = getCurrentScrollPosition();

        assertNotEquals(currentPosition, newPosition);
    }
    
    @Test
    public void testIfDashboardContainsRegions(){        
        
        List<Region> regionData = Data.LOCATION_DATA;
        List<String> regionNames = new ArrayList<String>();
        for (Region region : regionData) {
            regionNames.add(region.getName());
        }
            
        String regionNavBoardCSS = ".cmp-location__nav__items";
        WebElement navboard = driver.findElement(By.cssSelector(regionNavBoardCSS));

        // get list of regions
        List<WebElement> elems = navboard.findElements(By.tagName("li"));

        List<String> currentRegions = new ArrayList<>();
        for (WebElement elem : elems) {
            String navboardRegion = elem.getText().trim();
            currentRegions.add(navboardRegion);    
        }
                
        boolean isSame = isArrayOfStringsEqual(regionNames, currentRegions);
                    
        assertTrue("Dashboard regions must matched stored data", isSame);
    }
        
    @Test
    public void testIfRegionContainsLocations(){                
        List<Region> regionData = Data.LOCATION_DATA;
        HashMap<String, Boolean> regionResults = new HashMap<String, Boolean>();            
        for (Region region : regionData) {
            String regionName = region.getName();
            String xpathOFRegion = String.format("//*[@region='%s']", regionName);        
            
            WebElement regionGrp = driver.findElement(By.xpath(xpathOFRegion));            
            String locationCSS = ".cmp-location__location-container";
            List<WebElement> currentLocations = regionGrp.findElements(By.cssSelector(locationCSS));

            // scrap current location names of region
            List<String> currentLocationNames = new ArrayList<String>();
            for (WebElement loc : currentLocations) {
                String locnameCSS = ".cmp-location__location__name";
                WebElement locname = loc.findElement(By.cssSelector(locnameCSS));
                // still fetch text even its not visible
                String locNameTxt = locname.getAttribute("innerHTML");
                currentLocationNames.add(locNameTxt.trim());                
            }

            // parse names of locations into list
            List<String> locData = region.getLocations().stream().map((loc -> loc.getName())).collect(Collectors.toList());

            
            Boolean isSame = false;
            isSame = isArrayOfStringsEqual(currentLocationNames, locData);

            if(!isSame){
                assertFalse(regionName + " failed to match stored data", false);
            }

            regionResults.put(regionName, isSame);            
        }        
        boolean hasFailedRegion  = regionResults.containsValue(false);
        assertFalse("Region location does not match", hasFailedRegion);
    }

    @Test
    public void testIfMapChanges(){                
        String uniqueIdentifier = "";
        String regionNavBoardCSS = ".cmp-location__nav__items";
        WebElement navboard = driver.findElement(By.cssSelector(regionNavBoardCSS));

        // get list of regions
        List<WebElement> regions = navboard.findElements(By.tagName("li"));

        for (WebElement region : regions) {
            // select region
            region.click();;
            sleep(1000);        
            String xpathOFMap = "//*[@aria-roledescription='map']";                                
            WebElement mapElem = driver.findElement(By.xpath(xpathOFMap));
            // use aria-describedby since this seems to vary upon location
            String currentId = mapElem.getAttribute("aria-describedby");
            
            assertNotEquals(currentId, uniqueIdentifier);
            uniqueIdentifier = currentId;
        }
    }

    @Test
    public void testIfLocationHasCorrectInfo(){
        List<Region> regionData = Data.LOCATION_DATA;
        
        for (Region region : regionData) {
            HashMap<String, Location> locationHash = createLocationHash(region);
            String regionName = region.getName();
            String xpathOFRegion = String.format("//*[@region='%s']", regionName);        
            
            WebElement regionGrp = driver.findElement(By.xpath(xpathOFRegion));            
            String locationCSS = ".cmp-location__location-container";
            List<WebElement> currentLocations = regionGrp.findElements(By.cssSelector(locationCSS));

            
            for (WebElement loc : currentLocations) {
                String locnameCSS = ".cmp-location__location__name";
                String locaddrCSS = ".cmp-location__location__address";
                String loccontactCSS = ".cmp-location__location__phone";
                String locemailCSS = ".cmp-location__location__email";
                WebElement locname = loc.findElement(By.cssSelector(locnameCSS));
                WebElement locaddr = loc.findElement(By.cssSelector(locaddrCSS));
                WebElement loccontact = loc.findElement(By.cssSelector(loccontactCSS));
                WebElement locemail = loc.findElement(By.cssSelector(locemailCSS));

                // still fetch text even its not visible
                String locNameTxt = locname.getAttribute("innerText");
                String locAddressTxt = locaddr.getAttribute("innerText");
                String locContactTxt = loccontact.getAttribute("innerText");;
                String locEmailTxt = locemail.getAttribute("innerText");;;


                // create a temp location obj to store ui values and for comparison
                Location tmpLocation  = new Location(locNameTxt.trim(), locAddressTxt.trim(), locContactTxt.trim(), locEmailTxt.trim());
                Location dataLocation = locationHash.get(locNameTxt.trim());

                boolean isSame = tmpLocation.equals(dataLocation);

                // should be equal by value
                assertTrue("Location on ui should match location on data " + locNameTxt + ":" + regionName ,isSame);

            }            
        }        
        
    }

        
    // helper methods
    private HashMap<String, Location> createLocationHash(Region region) {
        HashMap<String, Location> locationHash = new HashMap<String, Location>();
        for (Location location : region.getLocations()) {
            locationHash.put(location.getName(), location);
        }
        return locationHash;
    }

    private long getCurrentScrollPosition() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // get current position of page
        return (long) js.executeScript("return window.scrollY");  
    }

    private void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean isArrayOfStringsEqual(List<String> s1, List<String> s2){
        Collections.sort(s1);
        Collections.sort(s2);
        return s1.equals(s2);
    }
}