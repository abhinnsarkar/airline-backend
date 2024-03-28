# airline-backend

a full backend application for airline reservation systems

## APIs

-   retrieve available flights
    -   Inputs :
        -   origin city(assuming a method to find current location is not implemented) [required]
        -   destination city [required]
        -   date of flight departure [required]
    -   Output :
        -   List of all flights with the chosen origin and destination on the given date :
            -   departure time
            -   layovers
            -   total flight duration
            -   remaining seats available
-

## INFO

-   local runtime uses port 8080
-   docker runtime uses port 80 meaning just localhost, ie: Swagger accessible at localhost directly(http://localhost/swagger) no port number needed
