# DAT250: Experience Assignment 1 

### Tasks 
- Install the Software Development Environment
  - JDK
  - IDE
  - Maven
  - Git
- Experiment with Heroku and Platform as a Service (PaaS)

### What to report

- technical problems that you encountered during installation of the software development environment and how you have solved them
- how you have validated (checked) that the software development environment is working
- technical problems encountered with the Heroku platform and how you solved them
- any pending issues with this assignment which you did not manage to solve

## Installing the Software Development Environment

### JDK
I already had a Java Development Environment up and running, which i validated using the command **java -version**
```
$ java -version
java version "1.8.0_171"
Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
```

### IDE
I have been using Visual Studio Code as my IDE for a few years.  
I verified the IDE by making sure that all my extensions were up to date and that I had the newest verison of the IDE.

### Maven
I didnt have this tool installed. I followed the maven installation instructions from [their website](https://maven.apache.org/install.html)
It didnt work at first, and i got the following message when i tried to verify the Maven installation with **mvn -v**
```
$ mvn -v 
'mvn' is not recognized as an internal or external command, operable program or batch file.
```

This happened because I forgot to add the unpacked distrubution's bin directory to the PATH environment variable in my system. Once I fixed this everything worked as it should. 

I verified the installation using the command **mvn -v**
```
$ mvn -v
Apache Maven 3.8.2 (ea98e05a04480131370aa0c110b8c54cf726c06f)
Maven home: C:\Program Files\apache-maven-3.8.2
Java version: 11.0.11, vendor: AdoptOpenJDK, runtime: C:\AppData\Local\Programs\AdoptOpenJDK\jdk-11.0.11.9-hotspot
Default locale: no_NO, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

### Git
I already had Git installed on my computer. I verified it by checking the version installed and by creating a new repository for the course.

```
$ git version
git version 2.21.0.windows.1
```

## Experiment: Heroku and Platform as a Service

### Getting Started on Heroku with Java
Using the [get started guide](https://devcenter.heroku.com/articles/getting-started-with-java)

### Installation
I downloaded the installer and then used the heroku login command to log in to the Heroku CLI

```
$ heroku login
heroku: Press any key to open up the browser to login or q to exit: 
Opening browser to https://cli-auth.heroku.com/auth/cli/browser/40925c36-cb15-4440-94ed-02b81041b826?requestor=SFMyNTY.g2gDbQAAAAs4NC4yMTEuMC42OW4GAGgzFKt7AWIAAVGA._wZ-9OJJZgbGBTK0l6A9Ti0dmgldxTTeqcZKwGlYNqY
Logging in... done
Logged in as scar.os@mymail.com
```

I skipped the **Provision add-ons** part, but other than that I had no issues following the guide and everything went smoothly


### Please make sure your report contains the [URL](https://safe-gorge-99302.herokuapp.com/) to your Heroku app.
