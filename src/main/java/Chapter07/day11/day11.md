### π‘Day 11 μ€λ²λΌμ΄λ©(overriding)
> μ΄ κΈμ λ¨κΆμ±λμ μλ°μ μ μ 3/eλ₯Ό κΈ°λ°μΌλ‘ κ³΅λΆν λ΄μ©μ μ λ¦¬ν κΈμλλ€.
>
> **μμ€μ λ¦¬**: https://github.com/qudalsrnt3x/javaStandard

<br>

### βοΈμ€λ²λΌμ΄λ©μ΄λ?
> μμν΄λμ€μμ μνΌν΄λμ€ λ©μλμ λ΄μ©λ§μ μλ‘ μμ±νλ κ²


#### μ€λ²λΌμ΄λ© μ‘°κ±΄
- μ΄λ¦μ΄ κ°μμΌ νλ€.
- λ§€κ°λ³μκ° κ°μμΌ νλ€.
- λ°ννμμ΄ κ°μμΌ νλ€.

μ‘°μ ν΄λμ€μ λ©μλμ μ μΈλΆκ° μΌμΉν΄μΌ νλ€.

#### λ¨, μ κ·Ό μ μ΄μ(access modifier)μ μμΈ(exception)λ μ νλ μ‘°κ±΄ νμμλ§ λ€λ₯΄κ² λ³κ²½ν  μ μλ€.

- μ κ·Ό μ μ΄μλ μ‘°μ ν΄λμ€μ λ©μλλ³΄λ€ μ’μ λ²μλ‘ λ³κ²½κ°λ₯
```java
public, protected, (default), private

μ‘°μ ν΄λμ€μ μ κ·Ό μ μ΄μκ° protectedλ©΄
μμ ν΄λμ€μ μ κ·Ό μ μ΄μλ protected or publicμ΄μ΄μΌ νλ€.
```
- μ‘°μ ν΄λμ€μ λ©μλλ³΄λ€ λ§μ μμ μμΈλ₯Ό μ μΈν  μ μλ€.
```java
class Parent {
    void parentMethod() exception IOException, SQLException {
    	...
    }
}

class Child extends Parent {

    @Overriding
    void parentMethod() {
    	...
    }
}
```
> 1. μ κ·Ό μ μ΄μλ₯Ό μ‘°μ ν΄λμ€μ λ©μλλ³΄λ€ μ’μ λ²μλ‘ λ³κ²½ν  μ μλ€.
> 2. μμΈλ μ‘°μ ν΄λμ€μ λ©μλλ³΄λ€ λ§μ΄ μ μΈν  μ μλ€.
> 3. μΈμ€ν΄μ€λ©μλλ₯Ό staticλ©μλλ‘ λλ κ·Έ λ°λλ‘ λ³κ²½ν  μ μλ€.

### βοΈμ€λ²λ‘λ© vs μ€λ²λΌμ΄λ©

> **μ€λ²λ‘λ©** κΈ°μ‘΄μ μλ μλ‘μ΄ λ©μλλ₯Ό μ μνλ κ² (new)
> **μ€λ²λΌμ΄λ©** μμλ°μ λ©μλμ λ΄μ©μ λ³κ²½νλ κ² (change, modify)

```java
class Parent {
    void parentMethod(){}
}

class Child extends Parent {

    void parentMethod(){} // μ€λ²λΌμ΄λ©
    void parentMethod(int i) {} // μ€λ²λ‘λ©
}
```

### βοΈsuper
> μμ ν΄λμ€μμ μ‘°μ ν΄λμ€λ‘λΆν° μμλ°μ λ©€λ²λ₯Ό μ°Έμ‘°νλλ° μ¬μ©λλ μ°Έμ‘°λ³μ

- μ‘°μ ν΄λμ€λ‘λΆν° μμλ°μ λ©€λ²λ μμ ν΄λμ€ μμ μ λ©€λ²μ΄λ―λ‘ superλμ  thisλ₯Ό μ¬μ©ν  μ μλ€.
- μ‘°μ ν΄λμ€μ λ©€λ²μ μμν΄λμ€μ λ©€λ²κ° μ€λ³΅ μ μλμ΄ μλ‘ κ΅¬λ³ν΄μΌνλ κ²½μ°μλ§ superλ₯Ό μ¬μ©νλ κ²μ΄ μ’λ€.

```java
class SuperTest {
    public static void main(String[] args) {
    	Child c = new Child();
        c.method();
    }
}

class Parent {
    int x = 10;
}

class Child extends Parent {
    void method(){
    	System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}
```
μ€νκ²°κ³Ό
```
x = 10
this.x = 10
super.x = 10
```

#### λ³μμ λ©μλ λ λ€ superλ‘ νΈμΆ κ°λ₯
```java
class Point {
    int x;
    int y;
    
    String getLocation(){
    	return "x : " + x + ", y : " + y;
    }
}

class Point3D extends Point {
    int z;
    
    @Override
    String getLocation(){
    	return super.getLocation() + ", z : " + z;
        // λΆλͺ¨μ λ©μλ νΈμΆ
    }
}
```

#### * staticλ©μλ(ν΄λμ€λ©μλ)λ μΈμ€ν΄μ€μ κ΄λ ¨μ΄ μλ€. κ·Έλμ thisμ λ§μ°¬κ°μ§λ‘ superμ­μ staticλ©μλμμλ μ¬μ©ν  μ μκ³  μΈμ€ν΄μ€λ©μλμμλ§ μ¬μ©ν  μ μλ€.

### βοΈsuper() - μ‘°μ ν΄λμ€μ μμ±μ

this()μ λ§μ°¬κ°μ§λ‘ super()λ μμ±μ.

> **this()** κ°μ ν΄λμ€μ λ€λ₯Έ μμ±μ νΈμΆ<br>
> **super()** λΆλͺ¨ν΄λμ€μ μμ±μ νΈμΆ

```java
public class PointTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D(1, 2, 3);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
        // μμ±μ μ²« μ€μ λ€λ₯Έ μμ±μλ₯Ό νΈμΆνμ§ μκΈ° λλ¬Έμ μ»΄νμΌλ¬λ
        // super()λ₯Ό μ½μνλ€.
        this.x = x;
        this.y = y;
        this.z = z;
    }

    String getLocation() {
        return super.getLocation() + ", z :" + z;
    }
}
```
μ€νκ²°κ³Ό
```
PointTest.java:22: cannot resolve symbol
symbol : contructor Point()
location: class Point
Point3D(int x, int y, int z) {
^ 
1 error
```

μ»΄νμΌλ¬λ μμ±μκ° μμΌλ©΄ κΈ°λ³Έμμ±μλ₯Ό μ§μ ν΄μ£Όλλ° Point ν΄λμ€μμ μμ±μλ₯Ό μ§μ ν΄μ€¬μΌλ―λ‘ κΈ°λ³Έμμ±μκ° μλ€.

Point3D ν΄λμ€μ μμ±μμμ μ‘°μ ν΄λμ€μ μμ±μμΈ Point()λ₯Ό μ°Ύμ μ μλ€λ λ΄μ©


```java
Point3D(int x, int y, int z) {
    super(x, y);
}
```
super(x, y)λ₯Ό ν΅ν΄ μ‘°μ ν΄λμ€μ μμ±μλ₯Ό νΈμΆνλ€.

> μ‘°μ ν΄λμ€μ λ©€λ²λ³μλ μ΄μ²λΌ μ‘°μμ μμ±μμ μν΄ μ΄κΈ°νλλλ‘ ν΄μΌ νλ€.