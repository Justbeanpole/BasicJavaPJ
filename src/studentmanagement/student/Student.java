package studentmanagement.student;

public class Student {
    int studentNumber;
    String studentName;
    int koreanScore;
    int mathScore;
    int englishScore;
    double average;
    int totalScore;

    public Student(int studentNumber, String studentName, int koreanScore, int mathScore, int englishScore){
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.koreanScore = koreanScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.totalScore = koreanScore + mathScore + englishScore;
        this.average = (double) totalScore/3;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public int getTotal(){
        return totalScore;
    }

    public void printStudentInfo(){
        System.out.printf("Number: %3d / Name: %s / KoreanScore: %3d / MathScore: %3d / EnglishScore: %3d / Average: %.2f / Total Score: %3d\n",studentNumber,studentName,koreanScore,mathScore,englishScore,average,totalScore);
    }

    public void setName(String studentName){
        this.studentName = studentName;
    }
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
