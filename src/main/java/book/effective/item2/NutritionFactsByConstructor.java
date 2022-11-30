package book.effective.item2;

public class NutritionFactsByConstructor {

    /*
        점층적 생성자 패턴
        장점 : 불변성 (생성할 때 이외의 객체 필드 데이터 변경 불가능)
        단점 : 가독성 (생성자 매개변수가 많아 질수록 가독성이 떨어진다. 어떤 데이터가 어떤 필드가 들어가는지 알기가 쉽지 않음)
     */
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFactsByConstructor(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsByConstructor(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsByConstructor(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsByConstructor(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsByConstructor(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
