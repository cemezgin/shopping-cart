# Shopping Cart Case Study

#### Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

#### Requirements

* Java version: 14.0.1
* Apache Maven 3.6.3


#### Execute

Go to the root folder of the application:

```bash
$ mvn clean package
$ mvn install
$ java -classpath target/classes com.app.Main
```

#### Test

```bash
$ mvn test
```

#### Sample Output:
```bash

------ Category: Food ------
|||-- Product: Almond--|||
Quantity: 4.0
Unit Price: 150.0
Total Price: 600.0
|||-- Product: Apple--|||
Quantity: 10.0
Unit Price: 100.0
Total Price: 1000.0
------ Category: Phones ------
|||-- Product: Huawei--|||
Quantity: 8.0
Unit Price: 1000.0
Total Price: 8000.0
-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-
+Total Amount: 9600.0
-Total Coupon Discount: 960.0
-Total Campaign Discount: 1080.0
+Delivery Cost: 7.99
=
Final Price: 7567.99

```

You can change the Main.java file for other cases.
