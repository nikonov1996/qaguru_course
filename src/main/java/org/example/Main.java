package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        System.out.println(prepareStringList("Ava","Kolya","Asya","Polya","Pol","Ava","Bobby"));
//        System.out.println(UpFirstLetterInEachWord("Hello my dear friend! I'am very happy to see you!"));
//        System.out.println(UpFirstLetterInWordFromCicle("Hello my dear friend! I'am very happy to see you!"));
//        System.out.println(
//                LeetCodeExamples.removeDuplesInArray(new int[]{1,2,2,2,3,4,5,5})
//        );
//        System.out.println(
//                LeetCodeExamples.isContainsDuplicates(new int[]{1,2,3})
//        );
       // System.out.println(LeetCodeExamples.singleNum(new int[]{1,1,2,3,2}));

        /*
        * [4, 3, 2, 7, 8, 2, 3, 1]
        * [1, 2, 2, 3, 3, 4, 7, 8]
        * 1  2  3  4  7  8
        * 1  2  3  4  5  6  7  8
        * */

//        System.out.println(
//                LeetCodeExamples.backspaceStringCompare("xywrrmp","xywrrmu#p")
//        );
     //   List<String> sl = Arrays.stream(a.split("")).collect(Collectors.toList());

        char[] str = new char[]{'h','e','l','l','o'};
        System.out.println(
                LeetCodeExamples.strStr2("hello","el")
        );

    }

}

class LeetCodeExamples{

    // Find the Index of the First Occurrence in a String

    static int strStr(String haystack, String needle){

        ArrayList<Character> haystackChars = new ArrayList<>();
        for (Character ch:haystack.toCharArray()){
            haystackChars.add(ch);
        }
        String haystackCur = haystack;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystackCur.startsWith(needle)){
                return i;
            }
            haystackChars.remove(0);
            haystackCur = haystackChars.stream().map(String::valueOf).collect(Collectors.joining());
        }

        return -1;
    }

    static int strStr1(String haystack, String needle){
        int index = haystack.indexOf(needle);
        if(index > 0){
            return index;
        }else {
            return -1;
        }

    }

    static int strStr2(String haystack, String needle){
        String cur = haystack;
        for (int i = 0; i < haystack.length(); i++) {
            if (cur.startsWith(needle)){
                return i;
            }
            cur = cur.substring(1);
        }
        return -1;

    }

    // Remove Element

    static int removeElement(int[] nums, int val){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                arr.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < arr.size()){
                nums[i] = arr.get(i);
            }else{
                nums[i] = val;
            }

        }
        return arr.size();
    }

    // Climbing stars

    static int getAllStepsFroClimbing(int staircaseCount){
        if (staircaseCount == 0) { return 0;}
        if (staircaseCount == 1) { return 1;}
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i < staircaseCount-1; i++) {
            int n3 = n1;
            n1 = n2;
            n2 = n3 + n2;
        }
        return n2;

    }

    // Single Number

    static int singleNum(int[] arr){
        int mask = 0;
        for (int ar:arr){
            mask= mask^ar;
        }
        return mask;
    }

    // Неверное решение
    static int singleNumber(int[] arr){
        Arrays.sort(arr);
        int prev = -1;
        int sum = 0;
        int sum2 = 0;

        if (arr.length == 1){
            return arr[0];
        }

        for (int i = 0; i < arr.length;i++){
            int cur = arr[i];
            if (cur == prev){
                sum+=cur+prev;
            }
            prev = cur;
        }
        for (int a: arr){
            sum2+=a;
        }

        return sum2-sum;
    }

    // Backspace String Compare

    static Boolean backspaceStringCompare(String s1, String s2){
        String finalS1 = "";
        String finalS2 = "";

        Stack<String> count = new Stack<>();
        char[] s1ch = s1.toCharArray();
        for (int i = s1ch.length-1; i>=0;i--){
            if (String.valueOf(s1ch[i]).equals("#")){
                count.push("#");
            }else{
                if (count.isEmpty()){
                    finalS1+=String.valueOf(s1ch[i]);
                }else {
                    count.pop();
                }
            }
        }
        count = new Stack<>();
        char[] s2ch = s2.toCharArray();
        for (int i = s2ch.length-1; i>=0;i--){
            if (String.valueOf(s2ch[i]).equals("#")){
                count.push("#");
            }else{
                if (count.isEmpty()){
                    finalS2+=String.valueOf(s2ch[i]);
                }else {
                    count.pop();
                }
            }
        }
        return finalS1.equals(finalS2);
    }

    // Find All Numbers Disappeared in an Array
    static boolean isNumInArray(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int middle = low + (high-low)/2;
            if (arr[middle]==target){
                return true;
            }
            if (arr[middle] > target){
                high = middle - 1;
            }
            if (arr[middle] < target){
                low = middle + 1;
            }
        }
        return false;
    }

    // Данное решение не проходит на литкод изза времени выполнения
    static List<Integer> gAllNumDisappearInArray(int[] arr){
        int maxValInArray = arr.length;
        Arrays.sort(arr);
        ArrayList<Integer> disappearedValues = new ArrayList<>();
        for (int i = 1; i <= maxValInArray; i++) {
            if (!isNumInArray(arr,i)){
               if (!disappearedValues.contains(i)){
                    disappearedValues.add(i);
               }
            }
        }
        return disappearedValues;
    }
    // Данное решение не проходит на литкод изза времени выполнения
    static List<Integer> getAllNumbersDisappearedInArray(int[] arr){
        int maxArrayValue = arr.length;
        List<Integer> fullListValues = new ArrayList<>();
        for (int i = 1; i <= maxArrayValue; i++) {
            fullListValues.add(i);
        }
        List<Integer> inputArrayListValues = Arrays.stream(arr).distinct().boxed().collect(Collectors.toList());
        fullListValues.removeAll(inputArrayListValues);
        return fullListValues;

    }

    // Missing Number
    static int missingNumber1(int[] arr){
        int n = arr.length;
        int inputArrayValuesSum = 0;
        int fullArraySum = 0;
        for (int ar:arr){
            inputArrayValuesSum+=ar;
        }
        for (int i = 0; i <= n; i++) {
            fullArraySum+=i;
        }
        return fullArraySum-inputArrayValuesSum;
    }
    static int missingNumber(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        while(n>0){
            if(arr[n-1] != n ){
                return n;
            }
            n--;
        }
        return 0;
    }

    // Contains duplicates

    static boolean isContainsDuplicates(int[] arr){
        List<Integer> list = new ArrayList<>();
        for (Integer ar: arr){
            list.add(ar);
        }
        Set<Integer> set = new HashSet<>(list);
        return list.size()!=set.size();
    }

    // НЕ РЕШЕНА ! Мerge linked lists
    
 /*   static void mergeLists(List<Integer> list1, List<Integer> list2){
        List<Integer> mergedList = new ArrayList<>();
        if (list1.size() != 0 || list2.size()!= 0){
            int length = Math.max(list1.size(), list2.size());
            OUTER:for (int i = 0; i < length; i++) {
                int curr = list1.get(i);
                // 1 ,2, 3
                // 1, 3, 4
                for (int j = 0; j < list1.size(); j++) {
                    if (!(list1.get(i) <= list2.get(j))){
                      mergedList.add();
                    }
                }
            }
            System.out.println(mergedList);
        }

    }*/

    //Remove Duplicates from Sorted Array
    static int removeDuplesInArray(int[] arr){
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (!list.contains(curr)){
                list.add(curr);
            }else {
                count++;
            }
        }
        return count;

    }

    // Binary search
    static void binarySearch(int[]arr,int searchVal){
        int resultIndex = -1;
        int low = 0;
        int high = arr.length-1;
        while (low <= high){

            int middle = low + (high - low)/2; // 0 10 - 5 / 0 5 -
            if ( arr[middle] > searchVal){
                high = middle - 1;
            }
            if (arr[middle] < searchVal){
                low = middle + 1;
            }

            if (arr[middle] == searchVal){
                resultIndex = middle;
                break;
            }
        }
        System.out.println("Searched element: " + searchVal + ",on index: " + resultIndex + " in array: " + Arrays.toString(arr));
    }

    // Sort
    static int[] sortArray(int[] arr){
        int[] sortedArray = arr;
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray.length-1; j++) {
                if (sortedArray[j] >= sortedArray[j+1]){
                    int a = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = a;
                }
            }
        }
        return sortedArray;
    }

    // Min elem
    static void findMin(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<=min){
                min = arr[i];
            }
        }
        System.out.println(min);
    }

    // Max elem
    static void findMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    // Find All Duplicates in an Array

    static ArrayList<Integer> getDuplicatedValuesFromArray(int[] arr){
        ArrayList<Integer> duplVals = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (!duplVals.contains(cur)){
                int count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == cur){
                        count++;
                    }
                }
                if (count>1){
                    duplVals.add(cur);
                }
            }
        }
        return duplVals;
    }

    // Valid Parentheses
    // С помощью стека
    static boolean isValidPosledovatelnost(String s){
        Map<String,String> parentheses = new HashMap<>();
        parentheses.put("(",")");
        parentheses.put("{","}");
        parentheses.put("[","]");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            if(parentheses.containsKey(cur)){
                stack.push(cur);
            }else {
                if (!stack.isEmpty() && parentheses.get(stack.peek()).equals(cur)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //НЕКОРРЕКТНОЕ РЕШЕНИЕ!
    static boolean  isValidParentheses1(String s){
        Map<String,String> parentheses = new HashMap<>();
        parentheses.put("(",")");
        parentheses.put("{","}");
        parentheses.put("[","]");

        Boolean result = true;
        ArrayList<String> openPar =  new ArrayList<>();
        ArrayList<String> closePar =  new ArrayList<>();
        String prev = null;

        if (s.length()%2 != 0){ return false;}

        OUTER:for (int i = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));
            if (parentheses.containsKey(curr)){
                openPar.add(curr);
            }
            if(parentheses.containsValue(curr)){
                closePar.add(curr);
                // проверить что prev не равна ключу мапы curr
                for (Map.Entry<String,String> entry: parentheses.entrySet()){
                    if (entry.getValue().equals(curr)){
                        if (!openPar.contains(entry.getKey())){
                            return false;
                        }
                        if( prev != null
                                && parentheses.containsKey(prev)
                                && !entry.getKey().equals(prev)){
                            return false;
                        }
                    }
                }
            }
            if (openPar.size() != closePar.size()){return false;}
            prev = curr;
        }

        return result;
    }

    // Valid Parentheses (без учета если скобки внутри скобок)

    static boolean isValidParentheses(String s){
        Map<String,String> parentheses = new HashMap<>();
        parentheses.put("(",")");
        parentheses.put("{","}");
        parentheses.put("[","]");
        boolean result = true;
        OUTER:for (int i = 0, j = 1; i < s.length(); i+=2,j+=2) {
            String beforeVal = String.valueOf(s.charAt(i));
            String afterVal = String.valueOf(s.charAt(j));
            for (Map.Entry<String,String> entry:parentheses.entrySet()){
                if (entry.getKey().equals(beforeVal) ){
                    if (!entry.getValue().equals(afterVal)){
                        result = false;
                        break OUTER;
                    }
                }
            }
        }
        return result;
    }

    // Longest Common Prefix

    static String getLongestCommonPrefix(String[] strArr){

        String result = "";
        String curPrefix = "";

        OUTER:for (int i = 0; i < strArr[0].length(); i++) {
            curPrefix += String.valueOf(strArr[0].charAt(i));
            INNER:
            for (int j = 0; j < strArr.length; j++) {
                if ( !(strArr[j].startsWith(curPrefix)) ){
                    break OUTER;
                }
            }
            result = curPrefix;
        }

        return result;
    }

    // Roman to int

    static int romanToInt(String roman){
        HashMap<String,Integer> romanValues = new HashMap<>();
        romanValues.put("I",1);
        romanValues.put("V",5);
        romanValues.put("X",10);
        romanValues.put("L",50);
        romanValues.put("C",100);
        romanValues.put("D",500);
        romanValues.put("M",1000);

        int result = 0;
        int previousValue = 0;
        for (int i = roman.length()-1; i >= 0 ; i--) {
            int currValue = romanValues.get(String.valueOf(roman.charAt(i)));
            if (currValue < previousValue){
                result-=currValue;
            }else {
                result+=currValue;
            }
            previousValue = currValue;
        }
        return result;
    }

    // Palindrom Number with LinkedList

    static boolean isPalindromWithLinkedList(int x){
        if (String.valueOf(x).startsWith("-")){
            return false;
        }
        char[] chars = Integer.toString(x).toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
        for (char val: chars){
            list.add(Integer.valueOf(val));
        }
        while (list.size()>0){
            if (list.getFirst() != list.getLast()){
                return false;
            }
            list.pollFirst();
            list.pollLast();
        }
        return true;
    }

    // Palindrom Number with cicle

    static boolean isPalindrom( int x){
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0,j = chars.length-1; i < chars.length; i++,j--) {
            if (chars[i]!=chars[j]){
                return false;
            }
        }
        return true;
    }

    // Вернуть индексы чисел в массиве, которые дают указанную сумму через мар

    static int[] getIndexesFromArrayWitchGetSum(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int currentIndex = target - arr[i];
            if (map.containsKey(currentIndex) && i != map.get(currentIndex)){
                return new int[]{map.get(currentIndex),i};
            }
            map.put(arr[i],i);
        }
        return null;
    }

    // Вернуть индексы чисел в массиве, которые дают указанную сумму через вложенный цикл
    static int[] getIndexesForSum(int[] arr,int target){
        int[] result = new int[2];
        OUTER:for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            INNER:for (int j = 1; j < arr.length; j++) {
                if ((i == j) && (curVal + arr[j]==target)){
                    continue INNER;
                }
                if (target - curVal == arr[j]){
                    result[0] = i;
                    result[1] = j;
                    break OUTER;
                }
            }
        }
        return result;
    }

    // Вернуть стоящие рядом индексы чисел в массиве, которые дают указанную сумму

    static int[] getTwoIndexesWitchGetSumInArray(int[] arr, int target){
        Map<Integer,Integer> resultMap = new HashMap<>();
        int[] result = new int[2]; // 1,2,3,4
        for (int i = 0; i < arr.length; i++) {
            resultMap.put(i,target - arr[i]);

        }
        System.out.println(resultMap);
        int previousKey = 0;
        int previousValue = 0;
        for (Map.Entry<Integer,Integer> entry: resultMap.entrySet()){
            if( (previousValue + entry.getValue()) == target ){
                result[0] = previousKey;
                result[1] = entry.getKey();
                break;
            }
            previousKey = entry.getKey();
            previousValue = entry.getValue();
        }
        return result;
    }

}

class Stroki{




    // Метод который выводит целое число повторяющиеся в нескольких массивах

    static Integer getNumberRepeatedInArrays(int[]...arrays){
        Integer repeatedValue = null;
        int repeatedCount=arrays.length;
        OUTER:
        for (int val:arrays[0]){
            if (repeatedCount == 0){
                break OUTER;
            }
            INNER:
            for (int i = 0; i < arrays.length; i++) {
                int[] curArray = arrays[i];
                if (isNumInArray(curArray,val)){
                    repeatedValue = val;
                    repeatedCount-=1;
                }else{
                    repeatedCount = arrays.length;
                    repeatedValue = null;
                    break INNER;
                }
            }
        }
        return repeatedValue;
    }
    static boolean isNumInArray(int[] array, int value){
        boolean result = false;
        for (int currValue:array){
            if (currValue == value){
                result = true;
                break;
            }
        }
        return result;
    }
    static Integer getRepeatedNumberFromArrays(int[] arr1,int[] arr2, int[] arr3){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);


        List<Integer> arr1List = new ArrayList<>();
        List<Integer> arr2List = new ArrayList<>();
        List<Integer> arr3List = new ArrayList<>();
        Integer repeatVal = null;
        for (int i = 0; i < arr1List.size(); i++) {
            Integer val = arr1List.get(i);
            if (arr2List.contains(val)){
                if (arr3List.contains(val)){
                    repeatVal = val;
                    break;
                }
            }
        }
        return repeatVal;

    }

    // Реверс строки
    public static String reverse(String str){
        char[] chars = str.toCharArray();
        char[] reversChars = new char[chars.length];
        for (int i = 0; i <= chars.length-1; i++) {
            reversChars[chars.length-(i+1)] = chars[i];
        }
        return new String(reversChars);
    }

    // Реверс строки через StringBuilder
    public static String reverse2(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    // Палиндром
    public static boolean isPalindrom(String str) {
        Boolean isPalindom = true;
        char[] chars = str
                .toLowerCase()
                .replace(" ","")
                .toCharArray();
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i <= chars.length-1; i++) {
            isPalindom = String.valueOf(chars[i])
                    .equals( String.valueOf(chars[chars.length-(i+1)]));
            if (!isPalindom) break;
        }
        return isPalindom;
    }

    // Палиндром через реверс метод StringBuilder
    public static boolean isPalindrom2(String str) {
        String clearedStr = str
                .toLowerCase()
                .replaceAll("[?!,.|\\s|\\d]","");
        return clearedStr
                .equals(new StringBuilder(clearedStr).reverse().toString());
    }

    // Метод возвращает отсортированный список без дубликатов. На вход n- строк

    static List<String>  prepareStringList(String...strings){
        return new HashSet<>(List.of(strings))
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Метод возвращает копию строки где каждое слово начинается с заглавной буквы через стрим

    static String UpFirstLetterInEachWord(String word){
        String[] splitedWord = word.split(" ");
       return Arrays.stream(new String(word).split(" ")).map(w ->{
                   Character c = w.toCharArray()[0];
                   return w.replaceFirst(c.toString(),c.toString().toUpperCase());

               })
               .reduce((a,b)-> a+" "+b).get().toString();
    }

    // Метод возвращает копию строки где каждое слово начинается с заглавной буквы через циклы

    static String UpFirstLetterInWordFromCicle(String word){
        String[] splitedWord = new String(word).split(" ");
        String resultStr = "";
        for (String str: splitedWord){
            String c = Character.toString(str.toCharArray()[0]);
            resultStr += " " + str.replace(c,c.toUpperCase());
        }

        return resultStr.strip();
    }


}