package studentmanagement.user;

public class Student extends User {
    private int koreanScore;
    private int mathScore;
    private int englishScore;
    private double average;
    private int totalScore;

    public Student(String id, String name, int koreanScore, int mathScore, int englishScore){
        this.id = id;
        this.password = id;
        this.name = name;
        this.koreanScore = koreanScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.totalScore = koreanScore + mathScore + englishScore;
        this.average = (double) totalScore/3;
    }

    public int getKoreanScore() {
        return koreanScore;
    }
    public int getMathScore() {
        return mathScore;
    }
    public int getEnglishScore() {
        return englishScore;
    }

    @Override
    public String getInfo(){
        return String.format("Number : %s | Name : %s | KoreanScore : %3d | MathScore : %3d | EnglishScore : %3d | Average : %.1f | TotalScore : %3d"
                , id, name, koreanScore, mathScore, englishScore,average,totalScore);
    }

    public int getTotal(){
        return totalScore;
    }
    public double getAverage(){return average;}
    public void setKoreanScore(int koreanScore){
        this.koreanScore = koreanScore;
        this.totalScore = koreanScore + mathScore + englishScore;
        this.average = (double) totalScore/3;
    }
    public void setMathScore(int mathScore){
        this.mathScore = mathScore;
        this.totalScore = koreanScore + mathScore + englishScore;
        this.average = (double) totalScore/3;
    }
    public void setEnglishScore(int englishScore){
        this.englishScore = englishScore;
        this.totalScore = koreanScore + mathScore + englishScore;
        this.average = (double) totalScore/3;
    }
}
