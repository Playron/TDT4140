# Project to group 5 for the TDT4140 course, spring 2018

### About this app
This will be an app that collects data from individuals and generates statistics for SSB. 
It collects GPS and pulse from people. Individuals using the app will be able to 
see their own statistics and statistics over large cities in Norway. 

### Prerequisites

We develop using Eclipse, but other IDEs should also work. You also need maven, at least a standalone 
install, but you should also install maven support in Eclipse, by means of the m2e plugins, which are 
available in Eclipse's main update site.

We use Java 8 and JavaFX, so both these should be installed.

### Innstallation

To access the project you need to clone the repository and import. 

From already innstalled eclipse you can import by pressing **File > Import...> General > Existing Projects into Workspace**.
Choose this project and make sure you've checked the **Search for nested projects** box.


## How to run the app
To be able to see the app and use what we've made so far find the mainController.java
class. 

The class is located in:
* [05/tdt4140-gr1805/app.ui/src/main/java/app/ui.](https://gitlab.stud.iie.ntnu.no/tdt4140-2018/05/tree/master/tdt4140-gr1805/app.ui/src/main/java/tdt4140/gr1805/app/ui) (in app.ui folder): JavaFX app.

Right click and press **Run as > Java Application**. 

### How the app works
When you've pressed **Run as > Java Application** a new window will open. Here you will get two options:

1) The first option is to click "Registrer new User". From here you can insert your birth
   day, choose gender and city. After doing that you can click "Registrer user". You will 
   then get a ID-number that is unique for this user.

2) The second option is to insert the ID-number of a user and click on "Log Inn". Now you 
  have four options. 

**Record**   
  Click on the record icon to open the workout recording view. This is an interface of what 
  recording workouts will look like. The user would be able to choose what kind of workout 
  they're executing and the app would then start gathering GPS and pulse and add it to workout. 

**Statistics view**  
  Click on the statistics icon to open the statistics view. From here you can
  click on "See personal statistics" or "See city statistics" to view windows that 
  will show personal statistics or city statistics. 

**Profile**    
  Click on the profile icon to open the user view. Here you can let the app know when 
  you’re going to bed, and when you’re waking up. 
  
**Settings**      
  Click on the gear icon to open the settings view. Here you have a variety of options. 
  You can opt out of project, dissable gathering of GPS or delete user and user data
  all together. 
  

In all the different views, there’s an option in the upper left corner to go back 
to the previous menu. 


## Built with
* [JUnit4](https://junit.org/junit4/) - test framework
* [TestFX](https://github.com/TestFX/TestFX) - test framework for JavaFX apps
* [Jackson](https://github.com/FasterXML/jackson) - [JSON](https://www.json.org) library


## Authors
*This project is written by:*
* Anna Bakkebø
* Jonas Sandberg
* Torleif Hensvold
* Per Dahl Haagensen
* Bjørn Rude Jacobsen
* Michael Moen Allport
* Atle Vågen Svendsgaard

