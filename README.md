#### LeasingContract
#Info:
Important : Flyway is not working because of not supporting specific verisons,
 I’ve tried two and didn’t work. So decides to go on .
  I have added the whole configuration but It doesen't migrate because of not
   supported versions. So I added some ways how to create and import some data.

Junit – there was not time to write it . I could and would write .
Open Api – no time to implement.(optional)


#### Prerequisits
java 11
MariaDB 10.7 or 5.5

###Docker DB
 1. go to the root Folder of the Project / LeasingContract-Api
 2. docker build -t leasingcontractmariadb .
 3. check:  docker images , should show you the leasingcontractmariadb image
 4. run the image :  docker run --name leasingcontractmariadb -p 127.0.0.1:3307:3306 -d leasingcontractmariadb
 5. test and build connection to localhost:3307
 6. if any Problem concat (toshe_ilievski@hotmail.com)


##### SetUp Database
#1-way
 1. run the sql script from etc/dc/Database.sql

#2-way
  1. Create new db schema in your local database : leasing_db
  2. Start the Project to create the Tables with ./gradlew bootRun
  2. That the Flyway is not working, import the sql form etc/db/initData.sql

##### Run the App
 1. build the Project ./gradlew build
 2. ./gradlew bootRun
 3. app should work on localhost:8080


###FlyWay Is Not Working
Flyway migration is not working because of incompatible versions with mariadb , so i've tryed with 5.5 , and 10.7 and it
wasn't starting because of not supported db, so decided to continue without.




