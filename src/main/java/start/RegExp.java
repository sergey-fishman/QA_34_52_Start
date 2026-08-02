package start;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        String str1 = "123a!brgty";
        String regExp = "a.b";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str1);
        // проверяем что кусок строки подходит под условие паттерна true
        System.out.println(matcher.find());
        // проверяем что вся строка подходит под условие паттерна false
        System.out.println(matcher.matches());

        System.out.println("= = = = = = = = = = =");
        String str2 = "a b tygfhvj";
        Pattern pattern1 = Pattern.compile("^a.b");
        Matcher matcher1 = pattern1.matcher(str2);
        System.out.println(matcher1.find());

        System.out.println("= = = = = = = = = = =");
        System.out.println("isDigit? " + isDigit("123"));
        System.out.println("isPhoneNumber? " + isPhoneNumber
                ("+972-55-287-68-58"));
        System.out.println("isEmail? "+ isEmail
                ("fisher.sar@gmail.com"));
        System.out.println("isFullName? "+isFullName
                ("Sergey Sergeev"));
    }
    public static boolean isDigit(String str){
//        \+\ -> 1 or more  of \d\ -> digits
        Pattern pattern = Pattern.compile("\\d+");
//        \*\ -> 0 or more  of \d\ -> digits
//        Pattern pattern = Pattern.compile("\\d*");
//        Pattern  pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean isPhoneNumber(String str){
        String regExp = "^\\+\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean isEmail(String str){
        String regExp = "^\\w+\\.?\\w+@\\w+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean isFullName(String str){
        String regExp = "^[A-Z]{1}[a-z]+\\s{1}[A-Z]{1}[a-z]+$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
/*
.  - любой  символ  a.b  --> asb  aAb ....
\.  --> .
^  - начало строки  ^hello --> hello my friend
$  - конец строки   $end -->  this is the end
\d -  0,1 ..9
\D - кроме 0,1 ..9 --> A,b ....
a-z   a,b,c,d ... z abcd...z
A-Z   A,B .....
\s    пробелы
\w    A-Za-z0-9_
\W    все оcтальные символы
+   символ встречается 1 или более раз
?   символ встречается 0 или 1 раз
{ } Диапазон
 */