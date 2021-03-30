package Midterm_Practice;

public class main {

    public static void main(String[] args) {

    }

}

/*
* Write a method that would return the 5th element from the end of a non-circular singly linked list of integers in one pass (you are only allowed to traverse the list once), given the data structure as a parameter.  In addition, the size of the linked list is not provided by the linked list class, neither is a tail.  Do not assume that the list has 5 or more elements.  There are several possible solutions to this problem, do not worry about memory constraints.  You are allowed to use other data structures except for any version of a linked list or ArrayList.

* Loop, put each element into a Stack, then pop off the requested number
 * */

/*
* Suppose you had eight identical balls.  One of them is slightly heavier and you are given a balance scale.  What’s the fewest number of times you have to use the scale to guarantee you find the heavier ball? (i.e., finding it on the first try does not count as fewest number of times, your “algorithm” should work all the time!) Explain your answer in detail.

 * */

// Find middle of linked list, have two pointers, one which goes forward every one element, the other goes forward every two elements. Then when the first one gets to the end the second will be pointing at the middle

// Have an array with numbers 1 to 100, one element is duplicated. How can we tell which element is duplicated?
// Find sum of numbers 1 to 100.
// Find sum of array
// Difference in these two values is the number that was duplicated

