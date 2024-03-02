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
