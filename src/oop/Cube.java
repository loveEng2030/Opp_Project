package oop;
// المكعب وارث من ThreeDShape عشان هو شكل مجسم
public class Cube extends ThreeDShape {
    private double side; // طول الضلع (Encapsulation)

    public Cube(double side) {
        this.side = side; // بنستلم الضلع ونخزنه
    }

    @Override
    public double getArea() {
        return 6 * side * side; // مساحة أوجه المكعب الستة
    }

    @Override
    public double getPerimeter() {
        return 12 * side; // مجموع أطوال أحرف المكعب
    }

    @Override
    public double getVolume() {
        return side * side * side; // حجم المكعب (طول الضلع في نفسه في نفسه)
    }

    @Override
    public String howToDraw() {
        return "Draw Cube"; // رسالة بتعرفنا إن ده مكعب
    }
}