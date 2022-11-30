package book.effective.item2;

import lombok.Builder;

@Builder
public class LombokExample {

    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

//    public LombokExample(int servingSize) {
//        this.servingSize = servingSize;
//    }
    /*
        클래스 레벨의 빌더를 사용하는 중 다른 생성자가 존재했을 경우 오류 발생할 가능성이 있다.
        constructor LombokExample in class LombokExample cannot be applied to given types;
        @Builder
        ^
          required: int
          found: int,int,int,int,int,int
          reason: actual and formal argument lists differ in length
     */

    LombokExample(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static LombokExampleBuilder builder() {
        return new LombokExampleBuilder();
    }

    public static class LombokExampleBuilder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        LombokExampleBuilder() {
        }

        public LombokExampleBuilder servingSize(int servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public LombokExampleBuilder servings(int servings) {
            this.servings = servings;
            return this;
        }

        public LombokExampleBuilder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public LombokExampleBuilder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public LombokExampleBuilder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public LombokExampleBuilder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public LombokExample build() {
            return new LombokExample(this.servingSize, this.servings, this.calories, this.fat, this.sodium, this.carbohydrate);
        }

        public String toString() {
            return "LombokExample.LombokExampleBuilder(servingSize=" + this.servingSize + ", servings=" + this.servings + ", calories=" + this.calories + ", fat=" + this.fat + ", sodium=" + this.sodium + ", carbohydrate=" + this.carbohydrate + ")";
        }
    }
}
