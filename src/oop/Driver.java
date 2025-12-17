package oop;
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        // بنفتح ملف المدخلات
        Scanner sc = new Scanner(new File("oop/input.txt"));
        ArrayList<Shape> shapes = new ArrayList<>(); // لستة سحرية بتشيل أي شكل

        while (sc.hasNext()) { // طول ما فيه كلام في الملف.. كمل
            String type = sc.next(); // اقرأ نوع الشكل (دايرة ولا مكعب)
            double value = sc.nextDouble(); // اقرأ الرقم اللي جنبه

            if (type.equalsIgnoreCase("circle"))
                shapes.add(new Circle(value)); // لو دايرة ضيفها للستة
            else if (type.equalsIgnoreCase("cube"))
                shapes.add(new Cube(value)); // لو مكعب ضيفه للستة
        }
        sc.close(); // اقفل الملف

        double sum = 0;
        for (Shape s : shapes)
            sum += s.getArea(); // بنجمع مساحات كل الأشكال اللي لميناها

        // بنكتب المجموع في ملف لوحده
        PrintWriter out = new PrintWriter("sumAreas.txt");
        out.println("Sum of Areas = " + sum);
        out.close();

        new DrawFrame(shapes); // ابعت اللستة لكلاس الرسم عشان يوريهم لنا
    }
}