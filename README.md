## LeasingContract

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


##### SetUp Tomcat and Database

 1. Create new db schema in your local database : leasing_db
 2. That the Flyway is not working, import the sql form etc/db/xxx
 3. build the Project
 4. bootRun
 5. app should work on localhost:8080


###FlyWay
Flyway migration is not working because of incompatible versions with mariadb , so i've tryed with 5.5 , and 10.9 and it
wasn't starting because of not supported db, so decided to continue without . Hope makes no big minus in my applicaiton :)




