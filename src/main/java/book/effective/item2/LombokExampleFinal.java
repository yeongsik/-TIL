package book.effective.item2;

import lombok.Builder;

@Builder
public class LombokExampleFinal {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    @Builder.Default
    private int carbohydrate = 100;

    LombokExampleFinal(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }


    /*
        클래스 레벨에서 @Builder 생성하면 디폴트 생성자 생성 ( package-private )
        멤버필드들이 final 변수임에도 컴파일 에러가 나타나지 않았다.
        클래스 레벨의 빌더는 모든 매개변수 생성자를 만들기 때문에

        @Builder.Default 를 사용하게 되면
        빌더로 변경되는 값이 들어오지 않으면 초기화값을
        들어오면 변경값으로 변경해주는 것을 의미한다.

        아래 클래스 파일을 보면 빌더 필드에 boolean 형과 @Builder.Default를 선언한 멤버변수의 value 타입이 선언되어있다.
        carbohydrate 값이 들어온다면 set 변수가 true로 변경된다. ( 수정값이 세팅되었다는 의미 )
        build() 메서드를 보면 boolean 변수가 false이면 초기값이 저장된 carbohydrate() 메서드를 value값으로 지정해주고 있다.

        private boolean carbohydrate$set;
        private int carbohydrate$value;

        private static int carbohydrate() {
            return 100;
        }

        public LombokExampleFinalBuilder carbohydrate(int carbohydrate) {
            this.carbohydrate$value = carbohydrate;
            this.carbohydrate$set = true;
            return this;
        }

        public LombokExampleFinal build() {
            int carbohydrate$value = this.carbohydrate$value;
            if (!this.carbohydrate$set) {
                carbohydrate$value = LombokExampleFinal.carbohydrate();
            }

            return new LombokExampleFinal(this.servingSize, this.servings, this.calories, this.fat, this.sodium, carbohydrate$value);
        }


     */
    public static LombokExampleFinalBuilder builder() {
        return new LombokExampleFinalBuilder();
    }

    private static int carbohydrate() {
        return 100;
    }

    public static class LombokExampleFinalBuilder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private boolean carbohydrate$set;
        private int carbohydrate$value;

        LombokExampleFinalBuilder() {
        }

        public LombokExampleFinalBuilder servingSize(int servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public LombokExampleFinalBuilder servings(int servings) {
            this.servings = servings;
            return this;
        }

        public LombokExampleFinalBuilder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public LombokExampleFinalBuilder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public LombokExampleFinalBuilder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public LombokExampleFinalBuilder carbohydrate(int carbohydrate) {
            this.carbohydrate$value = carbohydrate;
            this.carbohydrate$set = true;
            return this;
        }

        public LombokExampleFinal build() {
            int carbohydrate$value = this.carbohydrate$value;
            if (!this.carbohydrate$set) {
                carbohydrate$value = LombokExampleFinal.carbohydrate();
            }

            return new LombokExampleFinal(this.servingSize, this.servings, this.calories, this.fat, this.sodium, carbohydrate$value);
        }

        public String toString() {
            return "LombokExampleFinal.LombokExampleFinalBuilder(servingSize=" + this.servingSize + ", servings=" + this.servings + ", calories=" + this.calories + ", fat=" + this.fat + ", sodium=" + this.sodium + ", carbohydrate$value=" + this.carbohydrate$value + ")";
        }
    }
}
