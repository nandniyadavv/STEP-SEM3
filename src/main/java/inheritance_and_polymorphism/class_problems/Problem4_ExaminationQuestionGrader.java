import java.util.*;

public class Problem4_ExaminationQuestionGrader {
    static abstract class Question {
        String type, text, correct, student; double points;
        Question(String t,String q,String c,String s,double p){type=t;text=q;correct=c;student=s;points=p;}
        abstract double score();
    }
    static class MCQ extends Question { MCQ(String t,String q,String c,String s,double p){super(t,q,c,s,p);} double score(){return student.equalsIgnoreCase(correct)?points:0;} }
    static class TF extends Question { TF(String t,String q,String c,String s,double p){super(t,q,c,s,p);} double score(){return student.equalsIgnoreCase(correct)?points:0;} }
    static class Essay extends Question {
        Essay(String t,String q,String c,String s,double p){super(t,q,c,s,p);}
        double score(){
            String answer=student.toLowerCase(); int found=0;
            for(String key:correct.split(",")) if(answer.contains(key.trim().toLowerCase())) found++;
            if(found>=2)return points*0.75; if(found==1)return points*0.50; return 0;
        }
    }
    static String[] quotedFields(String line){
        List<String> out=new ArrayList<>(); boolean quote=false; StringBuilder b=new StringBuilder();
        for(char ch:line.toCharArray()){
            if(ch=='\\\"'){quote=!quote; continue;}
            if(ch==' '&&!quote){if(b.length()>0){out.add(b.toString());b.setLength(0);}}
            else b.append(ch);
        }
        if(b.length()>0)out.add(b.toString()); return out.toArray(new String[0]);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=sc.nextInt(); sc.nextLine(); double total=0;
        for(int i=0;i<n;i++){
            String[] f=quotedFields(sc.nextLine());
            Question q;
            if(f[0].equals("MCQ"))q=new MCQ(f[0],f[1],f[2],f[3],Double.parseDouble(f[4]));
            else if(f[0].equals("TF"))q=new TF(f[0],f[1],f[2],f[3],Double.parseDouble(f[4]));
            else q=new Essay(f[0],f[1],f[2],f[3],Double.parseDouble(f[4]));
            double s=q.score(); total+=s; System.out.printf("%s: %.2f%n",q.type,s);
        }
        System.out.printf("Total Score: %.2f%n",total);
    }
}