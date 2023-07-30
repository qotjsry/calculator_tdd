package calculrate;

public class SpringAddCalculator {

    public int splitAndSum(String value) throws Exception {
        ValidateUtils validateUtils = new ValidateUtils();
        if (validateUtils.checkNull(value)) {
            return 0;
        }
        return sum(validateUtils.SplitValue(value));
    }

    public int sum(String[] values) throws Exception {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            numberCheck(Integer.parseInt(values[i]));
            result += Integer.parseInt(values[i]);
        }
        return result;
    }

    public void numberCheck(int value){
        if(value < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
