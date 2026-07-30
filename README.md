NAMES: ISARO MUHIRWA OLA
ID: 26878


## Software-Testing-Techniques-Final-Project

TOPIC: AUCA Library Management System.

I started by creating the maven project and the PostgreSQL database auca_library_db. I then proceeded to implement the codes to define the Location Hierarchy where I created the enum representing the 5 administrative levels in Rwanda and the java class that maps directly the PostgreSQL database table.

I proceeded to create the location service which will serve as the logic that validates that non-province locations must have a valid parentId. And It also opens a Hibernate database session, starts a transaction, saves the location object into PostgreSQL, and commits the transaction

After I did 4 unit tests that verifies a Province can be saved with null parent, verifies a District saves successfully when linked to an existing Province, verifies the system rejects creating a District if its parent location does not exist in the database and also verifies the database blocks duplicate location codes.

