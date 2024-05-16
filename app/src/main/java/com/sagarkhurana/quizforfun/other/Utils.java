package com.sagarkhurana.quizforfun.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.sagarkhurana.quizforfun.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @SuppressLint("WeekBasedYear")
    public static String formatDate(long time){
        SimpleDateFormat formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            formatter = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }

    public static Map<String,String> getMathQuestions(){
        HashMap<String,String> questions = new HashMap<>();
        questions.put("1+1","2");
        questions.put("2+2","4");
        questions.put("3+3","6");
        questions.put("4+4","8");
        questions.put("5+5","10");
        questions.put("6+6","12");
        questions.put("7+7","14");
        questions.put("8+8","16");
        questions.put("9+9","18");
        questions.put("10+10","20");
        questions.put("11+11","22");
        questions.put("12+12","24");
        questions.put("13+13","26");
        questions.put("14+14","28");
        questions.put("15+15","30");

        return questions;
    }

    public static Map<String,String> getRandomMathQuestions(int SIZE){
        HashMap<String,String> questionsMap = new HashMap<>();
        Map<String,String> originalQuestion = getMathQuestions();
        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }



    public static Map<String,Map<String,Boolean>> getLiteratureQuestions(){
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();
        HashMap<String, Boolean> answer11 = new HashMap<>();
        answer11.put("Class", true);
        answer11.put("Interface", false);
        answer11.put("Enum", false);
        answer11.put("Object", false);
        questions.put("What is the blueprint of an object in Java?", answer11);

        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("Polymorphism", true);
        answer12.put("Encapsulation", false);
        answer12.put("Inheritance", false);
        answer12.put("Abstraction", false);
        questions.put("What is the ability of an object to take on many forms in Java?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("Java Virtual Machine (JVM)", true);
        answer13.put("Java Development Kit (JDK)", false);
        answer13.put("Java Runtime Environment (JRE)", false);
        answer13.put("Java Compiler", false);
        questions.put("Which component of Java is responsible for executing Java programs?", answer13);

        HashMap<String, Boolean> answer14 = new HashMap<>();
        answer14.put("FileNotFoundException", true);
        answer14.put("IOException", false);
        answer14.put("FileAlreadyExistsException", false);
        answer14.put("FileNotReadableException", false);
        questions.put("Which exception is thrown when a file is not found during file I/O operations in Java?", answer14);

        HashMap<String, Boolean> answer15 = new HashMap<>();
        answer15.put("ArrayList", true);
        answer15.put("LinkedList", false);
        answer15.put("Vector", false);
        answer15.put("HashSet", false);
        questions.put("Which Java collection class provides dynamic arrays?", answer15);

        HashMap<String, Boolean> answer16 = new HashMap<>();
        answer16.put("super", true);
        answer16.put("this", false);
        answer16.put("extends", false);
        answer16.put("implements", false);
        questions.put("Which keyword in Java is used to access methods or variables of the superclass?", answer16);

        HashMap<String, Boolean> answer17 = new HashMap<>();
        answer17.put("break", true);
        answer17.put("continue", false);
        answer17.put("return", false);
        answer17.put("exit", false);
        questions.put("Which keyword is used to terminate the loop in Java?", answer17);

        HashMap<String, Boolean> answer18 = new HashMap<>();
        answer18.put("try", true);
        answer18.put("catch", false);
        answer18.put("finally", false);
        answer18.put("throw", false);
        questions.put("Which keyword is used to start a block of code that may generate exceptions in Java?", answer18);

        HashMap<String, Boolean> answer19 = new HashMap<>();
        answer19.put("int", true);
        answer19.put("Integer", false);
        answer19.put("double", false);
        answer19.put("String", false);
        questions.put("Which data type is used to represent whole numbers in Java?", answer19);

        HashMap<String, Boolean> answer20 = new HashMap<>();
        answer20.put("System.out.println()", true);
        answer20.put("Console.println()", false);
        answer20.put("print()", false);
        answer20.put("out.println()", false);
        questions.put("Which Java statement is used to print a line to the console?", answer20);

        HashMap<String, Boolean> answer21 = new HashMap<>();
        answer21.put("HashMap", true);
        answer21.put("TreeMap", false);
        answer21.put("LinkedHashMap", false);
        answer21.put("HashTable", false);
        questions.put("Which Java collection class does not maintain the order of elements?", answer21);

        HashMap<String, Boolean> answer22 = new HashMap<>();
        answer22.put("Thread", true);
        answer22.put("Process", false);
        answer22.put("Runnable", false);
        answer22.put("Executor", false);
        questions.put("Which Java class is used to create and manage threads?", answer22);

        HashMap<String, Boolean> answer23 = new HashMap<>();
        answer23.put("private", true);
        answer23.put("protected", false);
        answer23.put("public", false);
        answer23.put("default", false);
        questions.put("Which access modifier restricts access to members within the same class in Java?", answer23);

        HashMap<String, Boolean> answer24 = new HashMap<>();
        answer24.put("equals()", true);
        answer24.put("compareTo()", false);
        answer24.put("compare()", false);
        answer24.put("toString()", false);
        questions.put("Which method is used to check if two objects are equal in Java?", answer24);

        HashMap<String, Boolean> answer25 = new HashMap<>();
        answer25.put("stack", true);
        answer25.put("queue", false);
        answer25.put("heap", false);
        answer25.put("list", false);
        questions.put("Which data structure follows the Last In First Out (LIFO) principle?", answer25);

        return questions;
    }

    public static Map<String,Map<String,Boolean>> getGeographyQuestions(){
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer11 = new HashMap<>();
        answer11.put("Class", true);
        answer11.put("Interface", false);
        answer11.put("Enum", false);
        answer11.put("Object", false);
        questions.put("What is the primary building block of Java programs?", answer11);

        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("Polymorphism", true);
        answer12.put("Encapsulation", false);
        answer12.put("Inheritance", false);
        answer12.put("Abstraction", false);
        questions.put("Which Java feature allows objects to exhibit multiple behaviors?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("Java Virtual Machine (JVM)", true);
        answer13.put("Java Development Kit (JDK)", false);
        answer13.put("Java Runtime Environment (JRE)", false);
        answer13.put("Java Compiler", false);
        questions.put("What component of Java executes Java bytecode?", answer13);

        HashMap<String, Boolean> answer14 = new HashMap<>();
        answer14.put("FileNotFoundException", true);
        answer14.put("IOException", false);
        answer14.put("FileAlreadyExistsException", false);
        answer14.put("FileNotReadableException", false);
        questions.put("Which exception is thrown when a file is not found during file operations?", answer14);

        HashMap<String, Boolean> answer15 = new HashMap<>();
        answer15.put("ArrayList", true);
        answer15.put("LinkedList", false);
        answer15.put("Vector", false);
        answer15.put("HashSet", false);
        questions.put("Which Java collection class provides dynamic resizing of arrays?", answer15);

        HashMap<String, Boolean> answer16 = new HashMap<>();
        answer16.put("super", true);
        answer16.put("this", false);
        answer16.put("extends", false);
        answer16.put("implements", false);
        questions.put("Which keyword is used to access superclass members?", answer16);

        HashMap<String, Boolean> answer17 = new HashMap<>();
        answer17.put("break", true);
        answer17.put("continue", false);
        answer17.put("return", false);
        answer17.put("exit", false);
        questions.put("What keyword is used to exit a loop prematurely?", answer17);

        HashMap<String, Boolean> answer18 = new HashMap<>();
        answer18.put("try", true);
        answer18.put("catch", false);
        answer18.put("finally", false);
        answer18.put("throw", false);
        questions.put("Which block is used to enclose code that might throw exceptions?", answer18);

        HashMap<String, Boolean> answer19 = new HashMap<>();
        answer19.put("int", true);
        answer19.put("Integer", false);
        answer19.put("double", false);
        answer19.put("String", false);
        questions.put("Which primitive data type is used to store integer values in Java?", answer19);

        HashMap<String, Boolean> answer20 = new HashMap<>();
        answer20.put("System.out.println()", true);
        answer20.put("Console.println()", false);
        answer20.put("print()", false);
        answer20.put("out.println()", false);
        questions.put("Which Java statement is used to print output to the console?", answer20);

        HashMap<String, Boolean> answer21 = new HashMap<>();
        answer21.put("HashMap", true);
        answer21.put("TreeMap", false);
        answer21.put("LinkedHashMap", false);
        answer21.put("HashTable", false);
        questions.put("Which Java collection class does not maintain insertion order?", answer21);

        HashMap<String, Boolean> answer22 = new HashMap<>();
        answer22.put("Thread", true);
        answer22.put("Process", false);
        answer22.put("Runnable", false);
        answer22.put("Executor", false);
        questions.put("Which Java class is used to implement multithreading?", answer22);

        HashMap<String, Boolean> answer23 = new HashMap<>();
        answer23.put("private", true);
        answer23.put("protected", false);
        answer23.put("public", false);
        answer23.put("default", false);
        questions.put("Which access modifier restricts access to members within the same class?", answer23);

        HashMap<String, Boolean> answer24 = new HashMap<>();
        answer24.put("equals()", true);
        answer24.put("compareTo()", false);
        answer24.put("compare()", false);
        answer24.put("toString()", false);
        questions.put("Which method is used to compare the contents of two Java objects?", answer24);

        HashMap<String, Boolean> answer25 = new HashMap<>();
        answer25.put("stack", true);
        answer25.put("queue", false);
        answer25.put("heap", false);
        answer25.put("list", false);
        questions.put("Which data structure follows the Last In First Out (LIFO) principle?", answer25);

        return questions;
    }

    public static Map<String,Map<String,Boolean>> getRandomLiteratureAndGeographyQuestions(Context context, String subject, int SIZE){
        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion;
        if (subject.equals(context.getString(R.string.beginner))){
            originalQuestion = getGeographyQuestions();
        }else{
            originalQuestion = getLiteratureQuestions();
        }

        int originalSize =  originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size()<=SIZE){
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)){
                questionsMap.put(question,originalQuestion.get(question));
            }
        }
        return questionsMap;
    }

}