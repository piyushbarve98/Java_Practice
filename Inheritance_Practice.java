
class School {
    
    int fees;
    int no_of_students;
    int no_of_subjects;
    String name ;
    int cutoffmarks = 80;
    boolean subjectAvailaibilty = false;
    protected String[] subjects = {"Cs", "arts","commerce", "History"};
    boolean getAdmission( int m ){
        if(m>= cutoffmarks) return true;
        else return false;
    }
    
    boolean isSubjectAvailaible(String s){
        for(String i : subjects){
            if(i == s) return true;
        }
        return false;
    }
    
    void setSubjects(String[] arr){
        subjects = arr;
    }
    void showSubjects(){
        for( String i : subjects) System.out.println(i);
    }
}


class MathSchool extends School {
    
    String[] arr = {"Math","cs"};
    void MathSchool(){
    super.setSubjects(arr);
    }
    void showSubject(){
        for(String i: subjects) System.out.println(i);
    }
    
    void display(){
        System.out.println(super.subjects[1]);
    }
    
}

class Inheritance_Practice {
    
    public static void main(String[] args){
        
        MathSchool ms = new MathSchool();
        if(ms.isSubjectAvailaible("Math")) System.out.println("Yes your subject is availaible");
        else System.out.println("Sorry your subject is not availaible");
        
        ms.showSubject();
        ms.display();
    }
}