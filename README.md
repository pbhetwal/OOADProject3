# OOADProject3
# Team Members: Aaron Steiner, Kyle Schultz, Parikshit Bhetwal
### Prerequisites
* java and junit must be installed on your local machine 
* junit should be in the same CLASSPATH as this program 

## Instructions to run program:
From the same directory as the Main.java file open a terminal 
	
**To Compile:** `javac Main.java`  
**To Run:** `java Main`  
The program will then execute and print out proper statements.

## Running the tests from AllTests.java (using junit-4)
**Compiling on MacOS/Linux:** `javac -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar AllTests.java`

**Compiling on Windows:** `javac -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar AllTests.java`

**Running on MacOS/Linux:** `java -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore AllTests`

**Running on Windows:** `java -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore AllTests`

