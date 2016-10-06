# IS2545 - DELIVERABLE 2: Unit Testing

![build status](https://travis-ci.org/asphaltpanthers/CitySim9002.svg?branch=master)

When I was coding for the program, the first problem I met was the random number generation. Because the program requires us to enter a seed for the random generator, I had no idea how to use this unchangable seed to generate different values. Since I tried call Random class in my RandomGenerator class, I used to put the it in RandomGenerator's generate method. This, however, made my program to generate same visitor and same places all the time. Later I found out the problem, the reason of continues generating the same value is that every time I called this method, the method will call Random class again and started with the same seed, this would definetely generate the same value each time I used this method. So I moved the call of the Random class out of this method to the very top, ouside the constrcutor to be a global. After that, when I call generate method, it will use the same Random class's object every time so that the generate value changed.

The second problem is that how could I control the visitor's visiting place: He cannot leave the city at the first time and will continue visiting until the random method chooses the leaving option for the visitor. To solve this problem, I put all locations into an array and pick up one of them each time according to the situation.

When I designed test methods, in order to seperate each "unit" in the program, I initialized all classes and moacked them all at the beginning. By doing this, in each testing method I can directly use the method I want conveniently.
