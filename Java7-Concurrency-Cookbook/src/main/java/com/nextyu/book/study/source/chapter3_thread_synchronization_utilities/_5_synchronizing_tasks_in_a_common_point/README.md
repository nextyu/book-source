We have a big matrix of random integer
numbers and you want to know the total number of occurrences of a number in this matrix.
To get a better performance, we use the divide and conquer technique. We divide the matrix
in fie subsets and use a thread to look for the number in each subset. These threads are
objects of the Searcher class.

We use a CyclicBarrier object to synchronize the completion of the fie threads and to
execute the Grouper task to process the partial results, and calculate the final one.