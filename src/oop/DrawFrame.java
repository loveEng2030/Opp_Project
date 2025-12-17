package oop;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawFrame extends JFrame {
    private ArrayList<Shape> shapes; // لستة شايلة كل الأشكال اللي قريناها

    public DrawFrame(ArrayList<Shape> shapes) {
        this.shapes = shapes; // بنستلم اللستة من الدرايفر
        // setTitle("dawing shapes"); // اسم الويندوز اللي هتفتح
        setSize(800, 600); // كبرت الحجم شوية عشان المكعبات تاخد راحتها
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // تقفل البرنامج لما ندوس X
        setVisible(true); // خلي الويندوز تظهر
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // بننادي الوظيفة الأصلية عشان يمسح الشاشة ويرسم صح
        int x = 100; // نقطة البداية بالعرض

        for (Shape s : shapes) { // بنلف على كل الأشكال اللي في اللستة (Polymorphism)
            if (s instanceof Circle) { // لو الشكل اللي معانا دايرة
                // بنحسب نص القطر من المساحة عشان الرسم يبقى مظبوط
                int r = (int) Math.sqrt(((Circle)s).getArea() / Math.PI);
                g.drawOval(x, 200, r * 2, r * 2); // ارسم دايرة
            } 
            else if (s instanceof Cube) { // لو الشكل مكعب (ركز هنا في رسمة المكعب)
                // بنجيب طول الضلع من المساحة الكلية للمكعب
                int side = (int) Math.sqrt(((Cube)s).getArea() / 6);
                int y = 200; // الارتفاع
                int d = side / 3; // مقدار العمق بتاع المكعب (الإزاحة)

                // رسم المكعب (مربع قدام ومربع ورا ونوصلهم)
                g.drawRect(x, y, side, side); // المربع الأمامي
                g.drawRect(x + d, y - d, side, side); // المربع الخلفي (متزحزح شوية)
                
                // توصيل الزوايا عشان يبان مجسم
                g.drawLine(x, y, x + d, y - d); // فوق شمال
                g.drawLine(x + side, y, x + side + d, y - d); // فوق يمين
                g.drawLine(x, y + side, x + d, y + side - d); // تحت شمال
                g.drawLine(x + side, y + side, x + side + d, y + side - d); // تحت يمين
            }
            x += 250; // ابعد عن الشكل اللي قبله عشان ميبقوش فوق بعض
        }
    }
}
// javac oop/*.java
// java oop.Driver