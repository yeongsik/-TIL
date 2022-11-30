package book.effective.item2;

import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LombokExampleContructor {

    private int servingSize;
    private int servings;
    private int calories;
    private List<Integer> fatList;

    @Builder
    /*
        생성자에 있는 매개변수만을 사용해서 빌더클래스를 생성
     */
    public LombokExampleContructor(int servingSize, int calories, @Singular("fatList") List<Integer> fatList) {
        this.servingSize = servingSize;
        this.calories = calories;
        this.fatList = fatList;
    }

    public static LombokExampleContructorBuilder builder() {
        return new LombokExampleContructorBuilder();
    }

    // servings가 빠져있는 것을 알 수 있다. 빌더로 설정하는 항목을 생성자로 고를 수 있다.
    // JPA 엔티티 경우 영속 되기 전에 식별자를 가질 수 없기 때문에
    // 식별자를 null 세팅하기 보다는 매개변수를 선택할 수 있는 생성자 빌더로 구성하는 것이 좋다.

    /*
        @Singular
        리스트 같은 자료구조 필드에 빌더 패턴을 사용할 경우
        객체 자체를 넘기는 것 뿐만아니라 해당 리스트에 요소들을 추가할 수 있는 메서드까지 구현해주는 어노테이션

        사용법
        클래스 레벨의 @Builder 사용시
        필드에 있는 변수에 @Singular 사용
        생성자 레벨의 @Builder 사용시
        생성자 파라미터 변수 앞에 @Singular 사용


     */
    public static class LombokExampleContructorBuilder {
        private int servingSize;
        private int calories;
        private ArrayList<Integer> fatList;

        LombokExampleContructorBuilder() {
        }

        public LombokExampleContructorBuilder servingSize(int servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public LombokExampleContructorBuilder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public LombokExampleContructorBuilder fatList(Integer fatList) {
            if (this.fatList == null) {
                this.fatList = new ArrayList();
            }

            this.fatList.add(fatList);
            return this;
        }

        public LombokExampleContructorBuilder fatList(Collection<? extends Integer> fatList) {
            if (fatList == null) {
                throw new NullPointerException("fatList cannot be null");
            } else {
                if (this.fatList == null) {
                    this.fatList = new ArrayList();
                }

                this.fatList.addAll(fatList);
                return this;
            }
        }

        public LombokExampleContructorBuilder clearFatList() {
            if (this.fatList != null) {
                this.fatList.clear();
            }

            return this;
        }

        public LombokExampleContructor build() {
            List fatList;
            switch (this.fatList == null ? 0 : this.fatList.size()) {
                case 0:
                    fatList = Collections.emptyList();
                    break;
                case 1:
                    fatList = Collections.singletonList((Integer) this.fatList.get(0));
                    break;
                default:
                    fatList = Collections.unmodifiableList(new ArrayList(this.fatList));
            }

            return new LombokExampleContructor(this.servingSize, this.calories, fatList);
        }

        public String toString() {
            return "LombokExampleContructor.LombokExampleContructorBuilder(servingSize=" + this.servingSize + ", calories=" + this.calories + ", fatList=" + this.fatList + ")";
        }
    }
}
