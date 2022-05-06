# Library

This app is my first work with Spring Boot.

I use there **Liquibase**:
- for switch on watching it you need to uncomment code in *src/main/java/com/samsung/App.java*:


        try {
            Console.main(args);
            
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
