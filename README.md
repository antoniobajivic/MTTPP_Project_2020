# Testing project

# Introduction
This project that we got for our project assingment consists of couple tests. It was made for Methods and Techniques of Software Testing course purposes at the Faculty of Electrical Engineering, Computer Science and Information Technology Osijek. Tests were made on one of the most famouse websites, Internet Movie Database a.k.a. IMDb ( https://www.imdb.com/ ).

Used libraries:
        - Selenium - framework for testing web applications
        - TestNG - testing framework for the Java programming language (inspired by JUnit and NUnit)
        
# Set up
# Set web driver:
Before you install everything required download one of drivers you want to work with, Google Chrome driver (https://chromedriver.chromium.org/downloads) or Mozzila Firefox driver (https://github.com/mozilla/geckodriver/releases). Select one of the offered versions and download it. Extract downloaded file, go to disk C, create new folder and name it (e.g. drivers) and then put your driver file in that folder.

# Set JDK
To get this started first you need to download JDK on https://jdk.java.net/13/. Then you'll need to unpack ZIP file. After      extracting you'll have to add JDK to the PATH variable. 
Steps for adding JDK to the PATH:
        - Open This PC
        
        - Right click and select Properties 
        
        - When new window opens select Advanced system settings on the right 
        
        - After openning of new window click on Environment Variables... in bottom right corner
        
        - On "User variables for (your PC username)" find Path and click Edit
        
        - New window should display some environment variables and then you click New 
        
        - After clicking on New, browse and select your bin java directory
        (e.g. C:\Program Files\Java\jdk1.8.0_231\bin)
        
        - When the directory is selected click OK
        
        - To get sure your path variable is ready, reboot your PC

In some cases it's better to be sure that you added your variable, so you can test that through CMD.

Checking your JDK path through CMD:
        - type "java -version" command, expected is:
    java version "1.8.0_231" 
    Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
    Java HotSpot(TM) 64-Bit Server VM (build 25.231-b11, mixed mode) )

# Set Maven
Secondly for this project, similar as setting JDK, you'll need to download maven on https://maven.apache.org/download.cgi and extract file. After extracting, follow previous steps for adding JDK to the PATH except when you are browsing maven file it will be different directory (location of extracted file). 
If you want to get sure you've done it all right, go to CMD and type "mvn -version" command. You will get this message if everything is ok:

    Apache Maven 3.6.2 (40f52333136460af0dc0d7232c0dc0bcf0d9e117; 2019-08-27T17:06:16+02:00)
    Maven home: C:\Program Files\apache-maven-3.6.2\bin\..
    Java version: 1.8.0_231, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_231\jre
    Default locale: en_GB, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

# Set IntelliJ
To get started with writing tests for your project you'll need to download and install IntelliJ IDEA, visit https://www.jetbrains.com/idea/download/. IntelliJ IDEA is an integrated development environment (IDE) for developing computer software. If you are student/professor you choose Ultimate version and it's for free, but if you are not one of these IntelliJ has a community version. For beginnners follow recommended instructions for installing and set your look in environment. IntelliJ should automatically recognize JDK but you can always add different versions manually.

# Create Maven project
Steps for creating maven project:
        - Run IntelliJ IDEA

        - Click on Create New Project

        - JDK should be recognized automatically, and if it is press Next. 
        
        - (Optional) If it's not recognized click on New button next to the Project SDK lable. 
        Find your JDK bin directory, select it and press OK. 
        After finding your directory click on Next.
        
        - You can name GroupId and ArtifactId whatever you want.
    
        - Click on Next
    
        - Click on Finish


When your project is created you should see a pop up window in bottom right corner. Click on Enable Auto-Import because it will automatically import all Maven dependcies in your project.

# Set pom.xml
You'll see that your project is now created. Broaden your project by clickin on your_project_name text in the top left corner. Find pom.xml file and open it. Before you write anything add this in your code "<dependecies></dependecies>" and in between that you'll add some dependecies required for your project.
Adding dependecies: 
    -Selenium: select on of the versions on https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java, copy that code and paste it in the pom.xml
    
    - TestNG: select on of the versions on https://mvnrepository.com/artifact/org.testng/testng, copy that code and paste it in the pom.xml
    
    - Maven Surefire: select on of the versions on https://mvnrepository.com/artifact/org.apache.maven.surefire/surefire-api, copy that code and paste it in the pom.xml
    
    - Webdriver Manager: select on of the versions on https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager, copy that code and paste it in the pom.xml
        
# Create tests
To get started with tests you'll need to find src/test/java inside your project and add new file.
Create class and add code:
    - Right click on src/test/java
    - Write name for your class (e.g. ProjectTest)
    - Select Class 
    - Click Ok
    - Inside this git repository you'll find java files that contains a code for certain test
    
For every test you'll need to repeat steps above but with different name for your classes.

# Set surefire report
After creating classes you'll need to add Maven Surefire Plugin for surefire report but before that you need to ,,design" your Test Suite.
Adding test suite:
    - Select Project and then click right click and add new file
    - Name file "testng.xml"
    - You should insert a code like code in "testng.xml" on this repository
    - Name of the suite is optional, just like test name, but classes names must be the same you named your certain class
    
Adding Maven Surefire Plugin:
    - Go to pom.xml inside this repository and copy the code between </dependecies> and </project> then past it into your pom.xml

In this step be cautious of your classes names, maven version, and how you named your xml suite file (usually it's testng.xml)

# Understanding code
When you open one of the classes code, first you'll see what is imported. Those are build-in data that we use for our tests. 
Before we start test, usually we will declared variables and @BeforeMethod. In that method you should add instructions usually for setting everything before test (e.g. open browser). 
In this project we will use WebDriver Manager.  Defining web driver looks like this "WebDriver driver;" (in this repository it's named "wDriver") and then in "setTest()" method, or some other name for your before test method, you'll create Google Chrome driver by writing "wDriver = new ChromeDrier();" and then if you want to go on homepage of Google and maximize your Google window you should write other two lines of code inside "setTest()".
In this repository function "setPageMethod()" is used for searching different websites and "setWEandClick()" method is to open searched website with right xpath. If you want to get xpath of some element, add Ranorex Selocity extension in your browser then right click on wanted element and find "Copy xpath".
Everything we want to test we add below @Test method.
Usually there is @AfterMethod for closing browser and we close are browser by writing "wDriver.quit();"

Tests:
    - ProjectTest is for comparing text between your search string and websites (IMDb's) title
    - ProjectTest2 is for comparing location between selected "IMDb Rating" element and tested selected element
    - ProjectTest3 is for comparing URL's when searching different strings for the same website
    - ProjectTest4 is for comparing tag name after searching some information on the website
    - ProjectTest5 is for comparing between website's home page icon size after inputing different search strings

# Make Surefire report
Instructions:
    - Open CMD
    - Change directory to your project with command cd and writing your directory (e.g. cd C:\Users\YourPC\IdeaProjects\YourProject)
    - Now write "mvn test"
    - When your tests are done go into project directory, open target folder, then open surefire-report and open index.html

After opening index.html it will open your tests suite in your browser and you will get visual presentation of your test results.

