package com.interviewbit.solutions.HeapsAndMaps;

import java.util.*;

public class HeapsPractice {

    //TODO: Max heap root is max..Reverse order...Keep lowest k elements if added and removed
    //TODO: Min heap root has min value..Natural order...Keep highest k elements if added and removed
    //TODO: https://www.youtube.com/watch?v=t0Cq6tVNRBA
    public static void main(String[] args) {
        //int[] input = {7,3,5,9,8,9545,35,66,72,1,15,22,34,66};
        int[] input = {1, 0, 3, 4, 2, 0, 1};
        Integer[] result = highestK(input, 3);
        for (int x : result) {
            System.out.println("highest = " + x);
        }

        result = lowestK(input, 3);
        for (int x : result) {
            System.out.println("lowest = " + x);
        }

        Double[] resultDouble = runningMedian(input);
        for (int i = 0; i < resultDouble.length; i++) {
            System.out.println("Running Median = " + resultDouble[i]);
        }

        int[] arr1 = {0,2,4,5};
        int[] arr2 = {0,34,36,123,555};
        int[] arr3 = {5,55,56,57,66,68,69,71,71};
        ArrayList<Integer> arrList1 = getList(arr1);
        ArrayList<Integer> arrList2 = getList(arr2);
        ArrayList<Integer> arrList3 = getList(arr3);
        ArrayList<ArrayList<Integer>> mergeThese = new ArrayList<>();
        mergeThese.add(arrList1);
        mergeThese.add(arrList2);
        mergeThese.add(arrList3);
        ArrayList<Integer> mergedList = mergeKSortedArrays(mergeThese);
        System.out.println("mergedList = " + mergedList);
    }

    private static ArrayList<Integer> getList(int[] input) {
        ArrayList<Integer> result = new ArrayList<>(input.length);
        for (int i :
                input) {
            result.add(i);
        }
        return result;
    }

    private static Integer[] lowestK(int[] input, int k) {
        Integer[] result = new Integer[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            maxHeap.offer(input[i]);
            if ((maxHeap.size() > k)) {
                maxHeap.poll();
            }
        }
        return maxHeap.toArray(result);
    }

    private static Integer[] highestK(int[] input, int k) {
        Integer[] result = new Integer[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < input.length; i++) {
            minHeap.offer(input[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.toArray(result);
    }

    private static Double[] runningMedian(int[] input) {
        Double[] result = new Double[input.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            minHeap.offer(input[i]);
            maxHeap.offer(minHeap.poll());

            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }

            double median = 0;
            if (maxHeap.size() == minHeap.size()) {
                median = ((double)(minHeap.peek() + maxHeap.peek())) / 2;
            } else {
                median = (double)minHeap.peek();
            }
            result[i] = median;
        }
        return result;
    }


    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    //TODO: mergeKSortedArrays need to have iterator and way to store index and value
    private static ArrayList<Integer> mergeKSortedArrays (ArrayList<ArrayList<Integer>> input) {

        ArrayList<Iterator<Integer>> iterators = new ArrayList<>(input.size());
        for (ArrayList<Integer> list: input) {
            iterators.add(list.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if(iterators.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iterators.get(i).next(), i)); //Adding first elements of each array
            }
        }

        while (!minHeap.isEmpty()) {
            ArrayEntry head = minHeap.poll();
            result.add(head.value);
            if(iterators.get(head.arrayId).hasNext() /*If that array index has anything left*/) {
                minHeap.add(new ArrayEntry(iterators.get(head.arrayId).next(),
                        head.arrayId));
            }
        }
        return result;
    }
}
