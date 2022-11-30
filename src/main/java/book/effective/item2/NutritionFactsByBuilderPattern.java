package book.effective.item2;

public class NutritionFactsByBuilderPattern {

    /*
        빌더 패턴
        명명된 선택적 매개변수를 흉내낸 것
        빌더를 사용하면 클래스도 불변이며 , 모든 필드 변수들을 가독성있게 생성할 수 있다.
     */
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 필수 매개변수
        private final int servingsSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingsSize, int servings) {
            this.servingsSize = servingsSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFactsByBuilderPattern build() {
            return new NutritionFactsByBuilderPattern(this);
        }
    }

    private NutritionFactsByBuilderPattern(Builder builder) {
        this.servingSize = builder.servingsSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsByBuilderPattern cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();


    }
}
