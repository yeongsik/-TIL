package book.effective.item2;

public class NutritionFactsByJavaBeansPattern {

    /*
        자바빈즈 패턴
        setter 메서드를 사용해서 읽기 쉬운 코드를 만들 수 있다.
        어떤 필드가 세팅되는지 세터메서드로 알기 쉬움
        단점 : 점층적 생성자 패턴의 장점이었던 불변성이 깨진다.
        -> 객체가 완전히 생성되기 전 일관성이 무너진 상태에 놓인다. 스레드 안정성이 없음
     */
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
