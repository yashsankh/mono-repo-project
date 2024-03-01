# mono-repo-project
Design, implement and test a software system that allows travel agencies to maintain their travel packages' itinerary and passengers.

## Travel Agency Software
This is a Java project implementing software for travel agencies to manage their travel packages' itinerary and passengers. It allows agencies to create and manage packages, destinations, activities, and passengers, while also providing functionality for printing package details, passenger lists, individual passenger details, and available activities.

### Specifications
Each travel package has a name, passenger capacity, itinerary (list of destinations), and list of passengers.
Each destination has a name and a list of available activities.
Each activity has a name, description, cost, and capacity, available at one destination only.
Passengers can sign up for activities at each destination.
Passengers can be standard, gold, or premium, with different payment rules.
Classes provide functions to print itinerary, passenger lists, individual passenger details, and available activities.
Sub-Tasks
Higher Level Diagram (HLD): A block diagram indicating interaction between different sub-blocks.
Lower Level Diagram (LLD): A UML class diagram of all the classes to be implemented, designed with suitable attributes and methods.
Implementation: Java programming language is used for implementation.

travelplanner/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── models/          # Contains classes representing travel packages, destinations, activities, and passengers
│   │       ├── services/        # Contains services for managing travel packages and passengers
│   │       └── Main.java        # Main class to run the application
└── diagrams/                    # Folder containing diagrams
    ├── Higher_Level_diagram.png    # HLD diagram image
    └── Lower_Level_diagram.png     # LLD diagram image

## Contributors
Yash Sankh
