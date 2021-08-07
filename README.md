# BasicStore
This is a Java Springboot backend server representing a Basic Store. 
This project was developed using Spring Tools Suite and MySQL database.

In order to build and run, you should create a database called basicstore, configured in file application.properties.
Also in the file application.properties, you need to change the value of property "spring.jpa.hibernate.ddl-auto" to "create" when building the project for the first time. Right after, change the value to "update" again.

Following some JSON examples to use when testing the system:

Create Client:
{
    "name" : "Tester",
    "email" : "tester@gmail.com",
    "cpf" : "123.123.123-12"
}


Create Item:
{
    "name" : "Item1",
    "price" : 1.0
}

Create Request:
{
    "client": {
        "id": GENERATED_ID_OF_CREATE_CLIENT_OPERATION,
        "name": "Tester",
        "email": "tester@gmail.com",
        "cpf": "123.123.123-12"
    },
    "items" : [
        {
            "id" : GENERATED_ID_OF_CREATE_ITEM_OPERATION,
            "name" : "Item1",
            "price" : 1.0
        }
    ]
}
