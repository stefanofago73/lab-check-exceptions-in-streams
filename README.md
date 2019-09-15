# Lab: Check-Exceptions in Streams
A simple Project/Lab about managing Checked Exception in Streams  (Java 8)



## Checked Exception in Stream ##

Starting from Java 8, the concept of Stream is introduced</br> 
There are more features and it's considered the main FP Monad</br>
introduced in Java. This abstraction has different methods that</br>
take some Function as argument but these have no checked exception</br>
exception support... How can we do?</br>

In this simple project, I've harvested all main idea about the</br>
argument; these ideas are presented as progression relate to</br>
complexity (going down in the solutions) and purity( going up</br>
in the solutions)</br>


### IDEAs PRESENTED ###

 
1. Nothing more that the simple code-block that use idiomatic</br>
   try/catch to managed the Checked Exception trasforming it in</br>
   a Runtime Exception</br>


2. In this example, a static-factory method is used to produce a Function</br>
   without Checked-Exception. It's also create a specific Runtime-Exception.</br>
   Better than (1) but specific and however not elegant...</br>


3. In this example, a static-factory method is used with the new</br>
   concept of ThrowingFunction that extends Function; using the Java 8</br>
   interface features it's possible to create a better abstraction</br>
   We have the traslatation from Checked to Runtime Exception</br>
  
  
4. Similar to (3) but, this time, we have a Sneaky Throw...</br>
   Using some trick on Generics translation we can retain the</br>
   Checked Exception that can be thrown in the ThrowingFunction.</br>
               

5. Similar to (4) but, this time, the method of Snealy Throw</br>
   it's also responsible to execute the real work...</br>
   Maybe a more effective form but less elegant of (4)</br>


6. This example introduce two abstractions used in FP and one</br>
   also present in Java 8: Optional and Either. Using special</br>
   "catching adapter" the computation become more "pure" but</br>
   also more verbose and maybe... less elegant?</br>


7. Similar to (6) but, this time, it's introduced the concept of</br>
   Collector. Less verbose than (6), in this example it's used a</br>
   custom Collector to "flattening" the Optionals</br>


8. In this example is used the concept of Split Iterator.</br>
   This is a main abstraction in Java Streams and also defined</br>
   as pattern. What we do is decorate the original Spliterator</br>
   as pattern. What we do is decorate the original Spliterator</br>
   to define, together with Throwing Function, the behavior of</br>
   of the Stream related to Checked Exception that can be thrown.</br>
