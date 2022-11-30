package book.effective.item2;

import lombok.Builder;

@Builder
public class LombokExampleFinalInit {

    private final int servingSize = 123;
    private final int servings = 1234;
    private final int calories;

    /*
        멤버 final 변수 초기화된 클래스 레벨의 빌더 어노테이션 코드
        초기화된 servingSize , servings  제외해서 빌드를 하는 것을 볼 수 있다.
     */
    LombokExampleFinalInit(int calories) {
        this.calories = calories;
    }

    public static LombokExampleFinalInitBuilder builder() {
        return new LombokExampleFinalInitBuilder();
    }

    public static class LombokExampleFinalInitBuilder {
        private int calories;

        LombokExampleFinalInitBuilder() {
        }

        public LombokExampleFinalInitBuilder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public LombokExampleFinalInit build() {
            return new LombokExampleFinalInit(this.calories);
        }

        public String toString() {
            return "LombokExampleFinalInit.LombokExampleFinalInitBuilder(calories=" + this.calories + ")";
        }
    }
}
