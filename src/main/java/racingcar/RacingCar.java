package racingcar;

import java.util.Objects;
import java.util.Random;

/**
 * 경주용 자동차 클래스
 */
public class RacingCar {

    private final int moveCount;    // 이동횟수
    private int advancedCount;      // 전진횟수
    private CarName carName;

    // 전진 조건 숫자
    private final static int ADVANCED_CONDITION_NUMBER = 4;

    public RacingCar(int moveCount) {
        this.moveCount = moveCount;
    }

    public RacingCar(int moveCount, CarName carName) {
        this.moveCount = moveCount;
        this.carName = carName;
    }

    public int getAdvancedCount() {
        return advancedCount;
    }

    public CarName getCarName() {
        return carName;
    }

    /**
     * 경주 시작
     */
    public void race() {
        Random random = new Random();
        for (int i = 0; i < moveCount; i++) {
            int randomNumber = random.nextInt(10);
            checkAdvancedCondition(randomNumber);
        }
    }

    /**
     * 전진 조건 체크 (랜덤 숫자가 4이상일 경우 전진)
     * @param randomNumber 램덤 숫자
     */
    public void checkAdvancedCondition(int randomNumber) {
        if (randomNumber >= ADVANCED_CONDITION_NUMBER) {
            advancedCount++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacingCar racingCar = (RacingCar) o;

        if (moveCount != racingCar.moveCount) return false;
        if (advancedCount != racingCar.advancedCount) return false;
        return Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        int result = moveCount;
        result = 31 * result + advancedCount;
        result = 31 * result + (carName != null ? carName.hashCode() : 0);
        return result;
    }

    public boolean isExistName() {
        return this.carName != null;
    }
}