package oop;
// كلاس الدائرة وارث من Shape الأساسي
public class Circle extends Shape {
    private double radius; // نص القطر وده خاص بالدائرة بس (Encapsulation)

    public Circle(double radius) {
        this.radius = radius; // بنستلم نص القطر ونخزنه
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius; // قانون مساحة الدائرة ط نق تربيع
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius; // قانون المحيط
    }

    @Override
    public String howToDraw() {
        return "Draw Circle"; // رسالة بتعرفنا إننا هنرسم دايرة
    }
}