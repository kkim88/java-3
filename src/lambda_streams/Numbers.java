package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);
    private static int i;

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(nums);

        // isOdd(i) tests: first is false, second is true

        System.out.println(isOdd(0));
        System.out.println(isOdd(3));

        // isEven(i) tests: first is true, second is false

        System.out.println(isEven(0));
        System.out.println(isEven(3));

        // isPrime(i) test: first is false, second is true

        System.out.println(isPrime(0));
        System.out.println(isPrime(3));

        // added() test

        System.out.println(added());

        // subtracted() test

        System.out.println(subtracted());

        // multiplied() test

        System.out.println(multiplied());

        // divided() test

        System.out.println(divided());

        // findMax() test

        System.out.println(findMax());

        // findMin() test

        System.out.println(findMin());

        // compare() tests: first prints -1, second prints 1, third prints 0

        System.out.println(compare(0, 1));
        System.out.println(compare(1, 0));
        System.out.println(compare(0, 13));

        // append() test

        System.out.println(append(120));

        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */


        Index lambdaOdd1 = (i) -> {
            return isOdd(i);
        };
        System.out.println("The number is: " + lambdaOdd1.getBoolean(3));

        Index lambdaEven = (i) -> {
            return isEven(i);
        };
        System.out.println("The number is: " + lambdaEven.getBoolean(0));

        Index lambdaPrime = (i) -> {
            return isPrime(i);
        };
        System.out.println("The number is: " + lambdaPrime.getBoolean(0));

        Math lambdaAdded = () -> {
            return added();
        };
        System.out.println("The sum is: " + lambdaAdded.Calculate());

        Math lambdaSubtracted = () -> {
            return subtracted();
        };
        System.out.println("The difference is: " + lambdaSubtracted.Calculate());

        Multi lambdaMultiplied = () -> {
            return multiplied();
        };
        System.out.println("The product is: " + lambdaMultiplied.Multiply());

        Divide lambdaDivided = () -> {
            return divided();
        };
        System.out.println("The quotient is: " + lambdaDivided.Divided());

        Math lambdaFindMax = () -> {
            return findMax();
        };
        System.out.println("The max number is: " + lambdaFindMax.Calculate());

        Math lambdaFindMin = () -> {
            return findMin();
        };
        System.out.println("The min number is: " + lambdaFindMin.Calculate());

        TwoNums lambdaCompare = (int i, int j) -> {
            return compare(i, j);
        };
        System.out.println(lambdaCompare.Compare(0, 3));

        Change lambdaAppend = (i) -> {
            return append(i);
        };
        System.out.println(lambdaAppend.Modify(250));

    }

    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        if (nums.get(i) % 2 != 0) {
            return true;
        }
        return false;
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        if (nums.get(i) % 2 == 0) {
            return true;
        }
        return false;
    }

    static boolean isPrime(int i) {
         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        // checks if num[i] is divisible by 2
        if (i % 2 == 0)
            return false;
        // checks remaining numbers
        for(int n = 3; n * n <= i; n+=2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    static int added() {
        //add all the elements in the list.  return the sum.
        int sum = nums.stream().reduce(Integer::sum).get().intValue();
        return sum;
    }

    static int subtracted() {
        //subtract all the elements in the list. return the remainder.
        // adds all the numbers together
        int diff = nums.stream().reduce(Integer::sum).get().intValue();
        // turns number negative
        diff = -diff;
        // couldn't find an actual subtraction method using streams

        return diff;
    }

    // fixed multiplied spelling
    // changed int to long because int can't hold the correct number

    static long multiplied() {
        //multiply all the elements in the list. and return the product.
        // initialize to 1 or product will be zero
        long product = 1;
        for (int i = 0; i < nums.size(); i++) {
            product *= nums.get(i);
        }
        return product;
    }

    // technically works, but the decimal spaces are so small and I couldn't get BigDecimal to work so it only displays 0.0 due to rounding

    static double divided() {
        //multiply all the elements in the list. and return the product.
        double div = 10;
        for (int i = 1; i < nums.size(); i++) {
            div %= nums.get(i);
        }
        return div;
    }

    static int findMax() {
         //return the maximum value in the list.
        int max = nums.stream().max(Integer::compare).get();
        return max;
    }

    static int findMin() {
        //return the minimum value in the list.
        int min = nums.stream().min(Integer::compare).get();
        return min;
    }

    static int compare(int i, int j) {
        //compare the values stored in the array at index position i and j.  
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        // set i and j to index numbers
        i = nums.get(i);
        j = nums.get(j);
        if (i > j)
            return 1;
        else if (j > i)
            return -1;
        else
        return 0;
    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        // Create copy of nums as an ArrayList because nums is a fixed size list
        // As a result this is only temporary and doesn't actually modify nums
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.addAll(nums);
        int newInt = n;
        int listEnd = nums1.size();
        nums1.add(listEnd, newInt);
        return nums1.get(nums1.size() - 1);
    }

    @FunctionalInterface
    public interface Index {
        public boolean getBoolean(int i);
    }

    @FunctionalInterface
    public interface Math {
        public int Calculate();
    }

    @FunctionalInterface
    public interface Multi {
        public long Multiply();
    }

    @FunctionalInterface
    public interface Divide {
        public double Divided();
    }

    @FunctionalInterface
    public interface TwoNums {
        public int Compare(int a, int b);
    }

    @FunctionalInterface
    public interface Change {
        public int Modify(int i);
    }

}